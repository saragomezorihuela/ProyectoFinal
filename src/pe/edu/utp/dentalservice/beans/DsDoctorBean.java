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
@ManagedBean(name = "doctorBean", eager = true)
@SessionScoped
public class DsDoctorBean {

    private DsService service;

    private Doctor doctor = new Doctor();
    private People people = new People();

    public DsDoctorBean() {
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

    public int getDoctorsCount() {
        return service.getDoctorsCount();
    }

    public List<Doctor> getDoctors() { return service.findAllDoctors(); }

    public String add(People people, Doctor doctor, IdentityCard identityCard, Gender gender, MedicalEspeciality medicalEspeciality) {
        service.addDoctor(people, doctor, identityCard, gender, medicalEspeciality);
        return "DoctorList";
    }

    public String update(Doctor doctor) {
         service.updateDoctor(doctor);
         return "DoctorList";
    }

    public boolean delete(Doctor doctor) { return service.deleteDoctor(doctor); }

    public String showTurnsCount() {
        if(getDoctorsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Doctor getSelectedDoctor() {
        return doctor;
    }

    public String edit(Doctor doctor) {
        this.doctor = doctor;
        return "DoctorEdit";
    }

    public String listDoctors() {
        return "success";
    }

}
