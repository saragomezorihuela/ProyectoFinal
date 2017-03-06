package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex Aguilar on 24/02/2017.
 */
public class Province {

    private int id;
    private String description;

    private Department department;

    public Province(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Province() {
    }

    public int getId() {
        return id;
    }

    public Province setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Province setDescription(String description) {
        this.description = description;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static Province build(ResultSet resultSet) {
        try {
            return new Province(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
