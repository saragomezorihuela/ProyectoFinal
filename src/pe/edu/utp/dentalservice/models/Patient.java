package pe.edu.utp.dentalservice.models;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
public class Patient extends Person {

    private int idPatient;
    private String relativename;
    private String relativephone;

    public Patient(int idPatient, String relativename, String relativephone) {
        this.idPatient = idPatient;
        this.relativename = relativename;
        this.relativephone = relativephone;
    }

    public Patient() {
    }

    public int getIdPatient() {
        return idPatient;
    }

    public Patient setIdPatient(int idPatient) {
        this.idPatient = idPatient;
        return this;
    }

    public String getRelativename() {
        return relativename;
    }

    public Patient setRelativename(String relativename) {
        this.relativename = relativename;
        return this;
    }

    public String getRelativephone() {
        return relativephone;
    }

    public Patient setRelativephone(String relativephone) {
        this.relativephone = relativephone;
        return this;
    }
}
