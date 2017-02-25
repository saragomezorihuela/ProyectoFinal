package pe.edu.utp.dentalservice.models;

/**
 * Created by De la Cruz on 25/02/2017.
 */
public class StateTooth {

    private int idStateTooth;
    private String descriptionState;

    public StateTooth(int idStateTooth, String descripcionState) {
        this.idStateTooth = idStateTooth;
        this.descriptionState = descriptionState;
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
        return descriptionState;
    }

    public StateTooth setDescripcionTypeTreatment(String descripcionState) {
        this.descriptionState = descripcionState;
        return this;
    }

}
