package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rodrigo Rivas on 24/02/2017.
 */
@ManagedBean
@RequestScoped
public class User {

    private int id;
    private String name;
    private String password;
    private String state;

    private Profile profile;
    private People people;

    public User(int id, String name, String password, String state) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.state = state;

    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
