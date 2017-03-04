package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rodrigo Rivas on 24/02/2017.
 */
public class Profile {

    private int id;
    private String description;
    private String state;
    private String type;
    private String url;

    public Profile(int id, String description, String state, String type, String url) {

        this.id = id;
        this.description = description;
        this.state = state;
        this.type = type;
        this.url = url;

    }

    public Profile() {
    }

    public int getId() {
        return id;
    }

    public Profile setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Profile setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getState() {
        return state;
    }

    public Profile setState(String state) {
        this.state = state;
        return this;
    }

    public String getType() {
        return type;
    }

    public Profile setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Profile setUrl(String url) {
        this.url = url;
        return this;
    }

    public static Profile build(ResultSet resultSet) {
        try {
            return new Profile(resultSet.getInt("id"),
                    resultSet.getString("description"),
                    resultSet.getString("state"),
                    resultSet.getString("type"),
                    resultSet.getString("url"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
