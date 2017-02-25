package pe.edu.utp.dentalservice.models;

/**
 * Created by Rodrigo on 24/02/2017.
 */
public class Department {

    private int idDepartment;
    private String descriptionDepartment;


    public Department(int idDepartment, String descriptionDepartment) {
        this.idDepartment = idDepartment;
        this.descriptionDepartment = descriptionDepartment;
    }

    public Department() {
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public Department setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
        return this;
    }

    public String getDescriptionDepartment() {
        return descriptionDepartment;
    }

    public Department setDescriptionDepartment(String descriptionDepartment) {
        this.descriptionDepartment = descriptionDepartment;
        return this;
    }

}
