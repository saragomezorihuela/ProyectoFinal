package pe.edu.utp.dentalservice.models;

import java.util.Date;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
public class Person {

    private int idPerson;
    private String dni;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String phone;
    private String cellphone;
    private String email;

    public Person(int idPerson, String dni, String firstname, String lastname, Date birthdate, String phone, String cellphone, String email) {

        this.idPerson = idPerson;
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;

    }

    public Person() {
    }

    public int getIdPerson() {
        return idPerson;
    }

    public Person setIdPersona(int idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Person setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Person setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Person setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Person setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Person setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

}
