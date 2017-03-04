package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by DE LA CRUZ on 04/03/2017.
 */
public class TreatmentType {

    private int id;
    private String description;

    public TreatmentType(){}

    public TreatmentType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public TreatmentType setId(int id){
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TreatmentType setDescription(String description) {
        this.description = description;
        return this;
    }

    public static TreatmentType build(ResultSet resultSet) {
        try {
            return new TreatmentType(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
