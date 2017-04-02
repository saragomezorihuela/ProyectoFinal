package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.*;
import pe.edu.utp.dentalservice.service.DsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sara Sheena on 19/03/2017.
 */
@ManagedBean(name = "patientBean", eager = true)
@SessionScoped
public class DsPatientBean {

    private DsService service;

    private Patient patient = new Patient();
    private People people = new People();

    public DsPatientBean() {
        try {
            InitialContext ctx = new InitialContext();
            Connection connection = ((DataSource) ctx
                    .lookup("jdbc/MySQLDataSourceDs"))
                    .getConnection();
            service = new DsService();
            service.setConnection(connection);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void onload(String user) {

        this.people = service.findPeople("jcurillo");

    }
    public int getPatientsCount() {
        return service.getPatientsCount();
    }

    public List<Patient> getPatients(String user) { return service.findAllPatients(user); }

    public List<Patient> getPatientsExt(People people) { return service.findAllPatientsExt(people); }

    public String add(People people, Patient patient, IdentityCard identityCard, Gender gender, Hospital hospital,String user) {

        service.addPatient(people, patient, identityCard, gender, hospital, user);
        return "PatientList";
    }

    public String update(Patient patient) {
         service.updatePatient(patient);
         return "PatientList";
    }

    public boolean delete(Patient doctor) { return service.deletePatient(patient); }

    public String showPatientsCount() {
        if(getPatientsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Patient getSelectedPatient() {
        return patient;
    }

    public People getSelectedPeople() {
        return people;
    }

    public String edit(Patient patient) {
        this.patient = patient;
        return "PatientEdit";
    }

    public String GetPeople(String  user) {
        //this.people = service.findPeople("jcurillo");

        return "DatosPersonales";
    }

    public String listPatients() {
        return "success";
    }

    public void setDatosPersonales(String user) {
        this.people = service.findPeople("jcurillo");
    }

    public People getDatosPersonales()  {
        // Do your stuff here.
        return people;
    }
}
