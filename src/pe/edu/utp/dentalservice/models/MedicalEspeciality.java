package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DE LA CRUZ on 06/03/2017.
 */

@ManagedBean
@RequestScoped
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

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
