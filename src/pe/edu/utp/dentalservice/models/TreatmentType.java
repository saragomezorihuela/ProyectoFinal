package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by DE LA CRUZ on 04/03/2017.
 */
@ManagedBean
@RequestScoped
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

    public void setId(int id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
