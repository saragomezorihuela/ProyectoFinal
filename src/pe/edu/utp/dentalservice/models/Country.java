package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex Aguilar on 24/02/2017.
 */

@ManagedBean
@RequestScoped
public class Country {

    private int id;
    private String description;

    public Country(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Country() {
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
