package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DE LA CRUZ  on 12/03/2017.
 */
public class MedicalSpeciality {

    private int id;
    private String description;

    public MedicalSpeciality(){}

    public MedicalSpeciality(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public MedicalSpeciality setId(int id){
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MedicalSpeciality setDescription(String description) {
        this.description = description;
        return this;
    }

    public static MedicalSpeciality build(ResultSet resultSet) {
        try {
            return new MedicalSpeciality(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
