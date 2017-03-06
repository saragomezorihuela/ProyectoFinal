package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex Aguilar on 24/02/2017.
 */
public class Department {

    private int id;
    private String description;

    private Country country;

    public Department(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public Department setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Department setDescription(String description) {
        this.description = description;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static Department build(ResultSet resultSet) {
        try {
            return new Department(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
