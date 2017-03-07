package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by De la Cruz on 25/02/2017.
 */
public class Tooth {

    private int id;
    private int number;
    private String description;

    public Tooth(int id, int number, String description) {
        this.id = id;
        this.description = description;
        this.number = number;
    }

    public Tooth() {
    }

    public int getId() {
        return id;
    }

    public Tooth setId(int id) {
        this.id = id;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Tooth setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Tooth setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Tooth build(ResultSet resultSet) {
        try {
            return new Tooth(resultSet.getInt("id"),
                    resultSet.getInt("number"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
