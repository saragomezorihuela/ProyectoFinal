package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class Hospital
{

    public int id;
    public String ruc;
    public String businessName;
    public String address;
    public String phone;
    public String email;

    public Hospital(int id, String ruc, String businessName, String address, String phone, String email){

        this.id =id;
        this.ruc = ruc;
        this.businessName = businessName;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }


    public Hospital(){}

    public int getId(){
        return id;
    }

    public Hospital setId(int id){
        this.id = id;
        return this;
    }

    public String getBusinessName() {
        return businessName;
    }

    public Hospital setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

}
