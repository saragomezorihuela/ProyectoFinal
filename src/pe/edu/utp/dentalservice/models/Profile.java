package pe.edu.utp.dentalservice.models;

/**
 * Created by Alex Aguillar  on 24/02/2017.
 */
public class Profile {

    private int idProfile;
    private String descriptionProfile;

    public Profile(int idProfile, String descriptionProfile) {

        this.idProfile = idProfile;
        this.descriptionProfile = descriptionProfile;

    }

    public Profile() {
    }

    public int getIdProfile() {
        return idProfile;
    }

    public Profile setIdProfile(int idProfile) {
        this.idProfile = idProfile;
        return this;
    }

    public String getDescriptionProfile() {
        return descriptionProfile;
    }

    public Profile setDescriptionProfile(String descriptionProfile) {
        this.descriptionProfile = descriptionProfile;
        return this;
    }

}
