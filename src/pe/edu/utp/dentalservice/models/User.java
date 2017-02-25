package pe.edu.utp.dentalservice.models;

/**
 * Created by Alex Aguillar on 24/02/2017.
 */
public class User {

    private int idUser;
    private String descriptionUser;

    public User(int idUser, String descriptionUser) {

        this.idUser = idUser;
        this.descriptionUser = descriptionUser;

    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public User setIdUser(int idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getDescriptionUser() {
        return descriptionUser;
    }

    public User setDescriptionUser(String descriptionUser) {
        this.descriptionUser = descriptionUser;
        return this;
    }

}
