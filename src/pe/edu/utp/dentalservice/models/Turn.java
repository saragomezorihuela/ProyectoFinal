package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jonathan Rojas on 06/03/2017.
 */
public class Turn {

    private int id;
    private String description;

    public Turn(int id, String descriptionCountry) {
        this.id = id;
        this.description = description;
    }

    public Turn() {
    }

    public int getId() {
        return id;
    }

    public Turn setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Turn setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Turn build(ResultSet resultSet) {
        try {
            return new Turn(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
