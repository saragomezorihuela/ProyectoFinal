package pe.edu.utp.dentalservice.models;

import com.sun.javafx.geom.transform.Identity;

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
    private District district;

    public Person(int id, String dni, String firstname, String lastname, Date birthdate, String phone, String cellphone, String email,
                  Hospital hospital, Gender gender, BloodType bloodType, IdentityCard identityCard, District district) {

        this.id = id;
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;

        this.hospital = hospital;
        this.gender = gender;
        this.bloodType = bloodType;
        this.identityCard = identityCard;
        this.district = district;

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
    // ENLACE CON LAS CLASE RELACIONADAS
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }


    public static Person build(ResultSet resultSet, HospitalsEntity hospitalsEntity, BloodTypesEntity bloodTypesEntity,
                               IdentityCardsEntity  identityCardsEntity, DistrictsEntity districtsEntity, GendersEntity gendersEntity) {
        try {
            return new Person(resultSet.getInt("id"),
                    resultSet.getString("dni"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birth_date"),
                    resultSet.getString("phone"),
                    resultSet.getString("cellphone"),
                    resultSet.getString("email"),
                    hospitalsEntity.findById(resultSet.getInt("hospital_id")),
                    gendersEntity.findById(resultSet.getInt("gender_id")),
                    bloodTypesEntity.findById(resultSet.getInt("rblood_type_id")),
                    identityCardsEntity.findById(resultSet.getInt("identity_card_id")),
                    districtsEntity.findById(resultSet.getInt("distrit_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}