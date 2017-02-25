package pe.edu.utp.dentalservice.models;

/**
 * Created by Rodrigo on 25/02/2017.
 */
public class District {

    private int idDistrict;
    private String descriptionDistrict;

    public District(int idDistrict, String descriptionDistrict) {
        this.idDistrict = idDistrict;
        this.descriptionDistrict = descriptionDistrict;
    }

    public District() {
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public District setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
        return this;
    }

    public String getDescriptionDistrict() {
        return descriptionDistrict;
    }

    public District setDescriptionDistrict(String descriptionDistrict) {
        this.descriptionDistrict = descriptionDistrict;
        return this;
    }

}
