package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.TreatmentType;
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
@ManagedBean(name = "treatmentTypeBean", eager = true)
@SessionScoped
public class DsTreatmentTypeBean {

    private DsService service;

    private int id;

    private TreatmentType treatmentType = new TreatmentType();

    public DsTreatmentTypeBean() {
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

    public int getTreatmentTypesCount() {
        return service.getTreatmentTypeCount();
    }

    public List<TreatmentType> getTreatmentTypes() { return service.findAllTreatmentType(); }

    public String add(TreatmentType treatmentType) {
        service.addTreatmentType(treatmentType);
        return "TreatmentTypeList";
    }

    public String update(TreatmentType treatmentType) {
         service.updateTreatmentType(treatmentType);
         return "TreatmentTypeList";
    }

    public boolean delete(TreatmentType treatmentType) { return service.deleteTreatmentType(treatmentType); }

    public String showTurnsCount() {
        if(getTreatmentTypesCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public TreatmentType getSelectedTreatmentType() {
        return treatmentType;
    }

    public String edit(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
        return "TreatmentTypeEdit";
    }

    public String listTurns() {
        return "success";
    }

}
