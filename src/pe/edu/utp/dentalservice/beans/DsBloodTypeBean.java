package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.BloodType;
import pe.edu.utp.dentalservice.models.Turn;
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
@ManagedBean(name = "bloodTypeBean", eager = true)
@SessionScoped
public class DsBloodTypeBean {

    private DsService service;

    private BloodType bloodType = new BloodType();

    public DsBloodTypeBean() {
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

    public int getBloodTypesCount() {
        return service.getBloodTypesCount();
    }

    public List<BloodType> getBloodTypes() { return service.findAllBloodTypes(); }

    public String add(BloodType bloodType) {
        service.addBloodType(bloodType);
        return "BloodTypeList";
    }

    public String update(BloodType bloodType) {
         service.updateBloodType(bloodType);
         return "BloodTypeList";
    }

    public boolean delete(BloodType bloodType) { return service.deleteBloodType(bloodType); }

    public String showTurnsCount() {
        if(getBloodTypesCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public BloodType getSelectedBloodType() {
        return bloodType;
    }

    public String edit(BloodType bloodType) {
        this.bloodType = bloodType;
        return "BloodTypeEdit";
    }

    public String listBloodTypes() {
        return "success";
    }

}
