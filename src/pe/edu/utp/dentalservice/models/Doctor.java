package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
@ManagedBean
@RequestScoped
public class Doctor extends People {

    private int id_doctor;
    private String CCO;

    private MedicalEspeciality medicalEspeciality;

    public Doctor(int id, String nroDocumento, String firstname, String lastname, String birthdate,
                  String phone, String cellphone, String email, String CCO) {

        this.id = id;
        this.nroDocumento = nroDocumento;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.CCO = CCO;
    }

    public Doctor() {
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getCCO() {
        return CCO;
    }

    public void setCCO(String CCO) {
        this.CCO = CCO;
    }

    public MedicalEspeciality getMedicalEspeciality() {
        return medicalEspeciality;
    }

    public void setMedicalEspeciality(MedicalEspeciality medicalEspeciality) {
        this.medicalEspeciality = medicalEspeciality;
    }

}
