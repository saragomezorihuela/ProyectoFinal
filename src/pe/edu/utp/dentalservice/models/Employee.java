package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
@ManagedBean
@RequestScoped
public class Employee extends People {

    private int id_employee;

    public Employee(int id, String nroDocumento, String firstname, String lastname,
                    String birthdate, String phone, String cellphone, String email) {

        this.id = id;
        this.nroDocumento = nroDocumento;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;

    }

    public Employee() {
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

}
