package pe.edu.utp.dentalservice.models;

/**
 * Created by De la Cruz on 25/02/2017.
 */
public class TypeTreatment {

    private int idTypeTreatment;
    private String descripcionTypeTreatment;

    public TypeTreatment(int idTypeTreatment, String descripcionTypeTreatment) {
        this.idTypeTreatment = idTypeTreatment;
        this.descripcionTypeTreatment = descripcionTypeTreatment;
    }

    public TypeTreatment() {
    }

    public int getIdTreatment() {
        return idTypeTreatment;
    }

    public TypeTreatment setIdTreatment(int idTypeTreatment) {
        this.idTypeTreatment = idTypeTreatment;
        return this;
    }

    public String getDescripcionTypeTreatment() {
        return descripcionTypeTreatment;
    }

    public TypeTreatment setDescripcionTypeTreatment(String descripcionTypeTreatment) {
        this.descripcionTypeTreatment = descripcionTypeTreatment;
        return this;
    }

}
