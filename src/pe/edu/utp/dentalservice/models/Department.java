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

    public Department(int id, String description, Country country) {
        this.id = id;
        this.description = description;

        this.country = country;
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

    public static Department build(ResultSet resultSet, CountriesEntity countriesEntity) {
        try {
            return new Department(resultSet.getInt("id"),
                    resultSet.getString("description"),
                    countriesEntity.findById(resultSet.getInt("country_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
