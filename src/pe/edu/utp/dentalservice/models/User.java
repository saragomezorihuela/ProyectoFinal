package pe.edu.utp.dentalservice.models;

/**
 * Created by Rodrigo Rivas on 24/02/2017.
 */
public class User {

    private int id;
    private String description;

    public User(int id, String description) {

        this.id = id;
        this.description = description;

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

    public String getDescription() {
        return description;
    }

    public User setDescription(String description) {
        this.description = description;
        return this;
    }

}
