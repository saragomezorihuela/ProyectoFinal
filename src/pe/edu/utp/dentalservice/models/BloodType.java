package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA GOMEZ on 04/03/2017.
 */
@ManagedBean
@RequestScoped
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
