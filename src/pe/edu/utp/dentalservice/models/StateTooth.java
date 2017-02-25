package pe.edu.utp.dentalservice.models;

/**
 * Created by De la Cruz on 25/02/2017.
 */
public class StateTooth {

    private int idStateTooth;
    private String descriptionTreatment;

    public StateTooth(int idStateTooth, String descripcionState) {
        this.idStateTooth = idStateTooth;
        this.descriptionTreatment = descriptionTreatment;
    }

    public StateTooth() {
    }

    public int getidStateTooth() {
        return idStateTooth;
    }

    public StateTooth setidStateTooth(int idStateTooth) {
        this.idStateTooth = idStateTooth;
        return this;
    }

    public String getdescripcionState() {
        return descriptionTreatment;
    }

    public StateTooth setDescripcionTypeTreatment(String descripcionState) {
        this.descriptionTreatment = descripcionState;
        return this;
    }

}
