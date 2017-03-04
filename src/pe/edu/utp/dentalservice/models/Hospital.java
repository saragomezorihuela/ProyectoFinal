package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class Hospital
{

    private int id;
    private String ruc;
    private String businessName;
    private String address;
    private String phone;
    private String email;

    public Hospital(int id, String ruc, String businessName, String address, String phone, String email){

        this.id =id;
        this.ruc = ruc;
        this.businessName = businessName;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }


    public Hospital(){

    }

    public int getId(){
        return id;
    }

    public Hospital setId(int id){
        this.id = id;
        return this;
    }

    public String getRuc() {
        return ruc;
    }

    public Hospital setRuc(String ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getBusinessName() {
        return businessName;
    }

    public Hospital setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Hospital setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Hospital setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Hospital setEmail(String email) {
        this.email = email;
        return this;
    }


    public static Hospital build(ResultSet resultSet) {
        try {
            return new Hospital(resultSet.getInt("id"),
                                resultSet.getString("ruc"),
                                resultSet.getString("business_name"),
                                resultSet.getString("address"),
                                resultSet.getString("phone"),
                                resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
