package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.MedicalEspeciality;
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
 * Created by Jonathan Rojas on 19/03/2017.
 */
@ManagedBean(name = "medicalEspecialityBean", eager = true)
@SessionScoped
public class DsMedicalEspecialityBean {

    private DsService service;

    private MedicalEspeciality medicalEspeciality = new MedicalEspeciality();

    public DsMedicalEspecialityBean() {
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

    public int getMedicalEspecialitiesCount() {
        return service.getMedicalEspecialitiesCount();
    }

    public List<MedicalEspeciality> getMedicalEspecialities() { return service.findAllMedicalEspecialities(); }

    public String add(MedicalEspeciality medicalEspeciality) {
        service.addMedicalEspeciality(medicalEspeciality);
        return "MedicalEspecialityList";
    }

    public String update(MedicalEspeciality medicalEspeciality) {
         service.updateMedicalEspeciality(medicalEspeciality);
         return "MedicalEspecialityList";
    }

    public boolean delete(MedicalEspeciality medicalEspeciality) { return service.deleteMedicalEspeciality(medicalEspeciality); }

    public String showMedicalEspecialitiesCount() {
        if(getMedicalEspecialitiesCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public MedicalEspeciality getSelectedMedicalEspeciality() {
        return medicalEspeciality;
    }

    public String edit(MedicalEspeciality medicalEspeciality) {
        this.medicalEspeciality = medicalEspeciality;
        return "MedicalEspecialityEdit";
    }

    public String listMedicalEspecialities() {
        return "success";
    }

}
