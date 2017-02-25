package pe.edu.utp.dentalservice.models;

/**
 * Created by Alex Aguillar  on 24/02/2017.
 */
public class Clinic {

    private int id;
    private String RUC;
    private String businessname;
    private String address;
    private String phone;
    private String email;

    public Clinic(int id, String RUC, String businessname, String address, String phone, String email) {

        this.id = id;
        this.RUC = RUC;
        this.businessname = businessname;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public Clinic() {
    }

    public int getId() {
        return id;
    }

    public Clinic setId(int id) {
        this.id = id;
        return this;
    }

    public String getRUC() {
        return RUC;
    }

    public Clinic setRUC(String RUC) {
        this.RUC = RUC;
        return this;
    }

    public String getBusinessname() {
        return businessname;
    }

    public Clinic setBusinessname(String businessname) {
        this.businessname = businessname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Clinic setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Clinic setPhone(String phone) {
        this.address = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Clinic setEmail(String email) {
        this.address = phone;
        return this;
    }
}
