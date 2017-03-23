package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
@ManagedBean
@RequestScoped
public class Patient extends People {

    private int id;
    private String relativename;
    private String relativephone;

    public Patient(int id, String nroDocumento, String firstname, String lastname, Date birthdate,
                   String phone, String cellphone, String email, String relativename, String relativephone) {

        this.id = id;
        this.nroDocumento = nroDocumento;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.relativename = relativename;
        this.relativephone = relativephone;
    }

    public Patient() {
    }

    public String getRelativename() {
        return relativename;
    }

    public void setRelativename(String relativename) {
        this.relativename = relativename;
    }

    public String getRelativephone() {
        return relativephone;
    }

    public void setRelativephone(String relativephone) {
        this.relativephone = relativephone;
    }

}
