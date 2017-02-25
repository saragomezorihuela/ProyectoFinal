package pe.edu.utp.dentalservice.models;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
public class Doctor extends Person {

    private String CCO;

    public Doctor(String CCO) {
        this.CCO = CCO;
    }

    public Doctor() {
        
    }

    public String getCCO() {
        return CCO;
    }

    public Doctor setCCO(String CCO) {
        this.CCO = CCO;
        return this;
    }

}
