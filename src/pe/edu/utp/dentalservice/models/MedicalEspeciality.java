package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DE LA CRUZ on 06/03/2017.
 */
public class MedicalEspeciality {

    private int id;
    private String description;

    public MedicalEspeciality(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public MedicalEspeciality() {
    }

    public int getId() {
        return id;
    }

    public MedicalEspeciality setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MedicalEspeciality setDescription(String description) {
        this.description = description;
        return this;
    }

    public static MedicalEspeciality build(ResultSet resultSet) {
        try {
            return new MedicalEspeciality(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
