package pe.edu.utp.dentalservice.models;

/**
 * Created by Rodrigo on 24/02/2017.
 */
public class Country {

    private int idCountry;
    private String descriptionCountry;

    public Country(int idCountry, String descriptionCountry) {
        this.idCountry = idCountry;
        this.descriptionCountry = descriptionCountry;
    }

    public Country() {
    }

    public int getIdCountry() {
        return idCountry;
    }

    public Country setIdCountry(int idCountry) {
        this.idCountry = idCountry;
        return this;
    }

    public String getDescriptionCountry() {
        return descriptionCountry;
    }

    public Country setDescriptionCountry(String descriptionCountry) {
        this.descriptionCountry = descriptionCountry;
        return this;
    }
}
