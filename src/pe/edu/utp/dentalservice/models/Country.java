package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex Aguilar on 24/02/2017.
 */
public class Country {

    private int id;
    private String description;

    public Country(int id, String descriptionCountry) {
        this.id = id;
        this.description = description;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public Country setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Country setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Country build(ResultSet resultSet) {
        try {
            return new Country(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
