package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
public class Person {

    protected int id;
    protected String dni;
    protected String firstname;
    protected String lastname;
    protected Date birthdate;
    protected String phone;
    protected String cellphone;
    protected String email;

    private Hospital hospital;
    private Gender gender;
    private BloodType bloodType;
    private IdentityCard identityCard;

    public Person(int id, String dni, String firstname, String lastname, Date birthdate, String phone, String cellphone, String email,
                  Hospital hospital) {

        this.id = id;
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;

        this.hospital = hospital;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public Person setIdPersona(int id) {
        this.id = id;
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

    //////////////////////////////////////
    // RELACION CON LAS CLASE RELACIONADAS
    //////////////////////////////////////
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

}