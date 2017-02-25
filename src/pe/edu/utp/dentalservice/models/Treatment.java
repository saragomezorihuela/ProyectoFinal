package pe.edu.utp.dentalservice.models;

/**
 * Created by De la Cruz on 25/02/2017.
 */
public class Treatment {

    private int idTreatment;
    private String descriptionTreatment;

    public Treatment(int idTreatment, String descripcionTreatment) {
        this.idTreatment = idTreatment;
        this.descriptionTreatment = descriptionTreatment;
    }

    public Treatment() {
    }

    public int getIdTreatment() {
        return idTreatment;
    }

    public Treatment setIdTreatment(int idTreatment) {
        this.idTreatment = idTreatment;
        return this;
    }

    public String getDescripcionTreatment() {
        return descriptionTreatment;
    }

    public Treatment setDescripcionTypeTreatment(String descripcionTreatment) {
        this.descriptionTreatment = descripcionTreatment;
        return this;
    }
}
