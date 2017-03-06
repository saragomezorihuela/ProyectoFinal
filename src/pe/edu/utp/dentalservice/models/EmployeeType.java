package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Alex Aguilar on 06/03/2017.
 */
public class EmployeeType {

    private int id;
    private String description;

    public EmployeeType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public EmployeeType() {
    }

    public int getId() {
        return id;
    }

    public EmployeeType setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EmployeeType setDescription(String description) {
        this.description = description;
        return this;
    }

    public static EmployeeType build(ResultSet resultSet) {
        try {
            return new EmployeeType(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
