package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Jonathan Rojas on 06/03/2017.
 */
@ManagedBean
@RequestScoped
public class Turn {

    private int id;
    private String description;

    public Turn(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Turn() {
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
