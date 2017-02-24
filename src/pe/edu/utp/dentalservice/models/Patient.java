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


}
