package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
public class Doctor extends Person {

    private String CCO;

    public Doctor() {
        super();
    }

    private MedicalEspeciality medicalEspeciality;

    public Doctor(int id, String CCO, MedicalEspeciality medicalEspeciality) {

        this.CCO = CCO;

        this.medicalEspeciality = medicalEspeciality;
    }

    public String getCCO() {
        return CCO;
    }

    public Doctor setCCO(String CCO) {
        this.CCO = CCO;
        return this;
    }

    public MedicalEspeciality getMedicalEspeciality() {
        return medicalEspeciality;
    }

    public void setMedicalEspeciality(MedicalEspeciality medicalEspeciality) {
        this.medicalEspeciality = medicalEspeciality;
    }
    public static Doctor build(ResultSet resultSet, MedicalEspecialitiesEntity medicalEspecialitiesEntity) {
        try {
            return new Doctor(resultSet.getInt("id"),
                            resultSet.getString("CCO"),
                    medicalEspecialitiesEntity.findById(resultSet.getInt("medical_id"))
                    );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
