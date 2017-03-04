package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA GOMEZ on 04/03/2017.
 */
public class BloodType {
    private int id;
    private String description;

    public BloodType(){}

    public BloodType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public BloodType setId(int id){
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BloodType setDescription(String description) {
        this.description = description;
        return this;
    }

    public static BloodType build(ResultSet resultSet) {
        try {
            return new BloodType(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
