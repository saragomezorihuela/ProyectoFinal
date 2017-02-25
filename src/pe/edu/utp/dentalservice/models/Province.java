package pe.edu.utp.dentalservice.models;

/**
 * Created by Rodrigo on 24/02/2017.
 */
public class Province {

    private int idProvince;
    private String descriptionProvince;

    public Province(int idProvince, String descriptionProvince) {
        this.idProvince = idProvince;
        this.descriptionProvince = descriptionProvince;
    }

    public Province() {
    }

    public int getIdProvince() {
        return idProvince;
    }

    public Province setIdProvince(int idProvince) {
        this.idProvince = idProvince;
        return this;
    }

    public String getDescriptionProvince() {
        return descriptionProvince;
    }

    public Province setDescriptionProvince(String descriptionProvince) {
        this.descriptionProvince = descriptionProvince;
        return this;
    }

}
