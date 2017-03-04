package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Jonathan Rojas on 25/02/2017.
 */
public class StateTooth {

    private int id;
    private String description;

    public StateTooth(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public StateTooth() {
    }

    public int getId() {
        return id;
    }

    public StateTooth setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StateTooth setDescription(String description) {
        this.description = description;
        return this;
    }

    public static StateTooth build(ResultSet resultSet) {
        try {
            return new StateTooth(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
