package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Hospital;
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
 * Created by SARA SHEENA on 18/03/2017.
 */

@ManagedBean(name = "hospitalBean", eager = true)
@SessionScoped
public class DsHospitalBean {

    private DsService service;

    private Hospital selectedHospital = new Hospital();

    public DsHospitalBean() {

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

    public int getHospitalsCount() {
        return service.getTurnsCount();
    }

    public List<Hospital> getHospitals() {
        return service.findAllHospitals();
    }

    public String add(Hospital hospital) {
        service.addHospital(hospital);
        return "HospitalList";
    }

    public String update(Hospital hospital) {
        service.updateHospital(hospital);
        return "HospitalList";
    }

    public boolean delete(Hospital hospital) { return service.deleteHospital(hospital); }

    public String showHospitalsCount() {
        if(getHospitalsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Hospital getSelectedHospital() {
        return selectedHospital;
    }

    public String edit(Hospital hospital) {
        this.selectedHospital = hospital;
        return "HospitalEdit";
    }

    public String listHospitals() {
        return "success";
    }

}
