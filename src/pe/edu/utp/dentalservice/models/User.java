package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rodrigo Rivas on 24/02/2017.
 */
public class User {

    private int id;
    private String name;
    private String password;
    private String state;

    private Profile profile;
    private Person person;

    public User(int id, String name, String password, String state, Profile profile) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.state = state;

        //this.person = person;
        this.profile = profile;

    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getState() {
        return state;
    }

    public User setSate(String state) {
        this.state = state;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public static User build(ResultSet resultSet, ProfilesEntity profileEntity) {
        try {
            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("state"),
                    profileEntity.findById(resultSet.getInt("profile_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
