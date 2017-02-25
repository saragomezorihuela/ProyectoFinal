package pe.edu.utp.dentalservice.models;

/**
 * Created by De la Cruz on 25/02/2017.
 */
public class Tooth {

    private int idTooth;
    private String descriptionTooth;

    public Tooth(int idTooth, String descripcionTooth) {
        this.idTooth = idTooth;
        this.descriptionTooth = descriptionTooth;
    }

    public Tooth() {
    }

    public int getIdTooth() {
        return idTooth;
    }

    public Tooth setTooth(int idTooth) {
        this.idTooth = idTooth;
        return this;
    }

    public String getDescripcionTreatment() {
        return descriptionTooth;
    }

    public Tooth setDescripcionTypeTreatment(String descripcionTooth) {
        this.descriptionTooth = descripcionTooth;
        return this;
    }
    
}
