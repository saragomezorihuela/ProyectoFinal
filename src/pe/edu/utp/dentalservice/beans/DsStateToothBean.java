package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.StateTooth;
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
@ManagedBean(name = "stateToohBean", eager = true)
@SessionScoped
public class DsStateToothBean {

    private DsService service;

    private int id;

    private StateTooth stateTooh = new StateTooth();

    public DsStateToothBean() {
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

    public int getStateTeethCount() {
        return service.getTurnsCount();
    }

    public List<StateTooth> getStateTeeth() { return service.findAllStateTeeth(); }

    public String add(StateTooth stateTooth) {
        service.addStateTooth(stateTooth);
        return "StateToothList";
    }

    public String update(StateTooth stateTooth) {
         service.updateStateTooth(stateTooth);
         return "StateToothList";
    }

    public boolean delete(StateTooth stateTooth) { return service.deleteStateTooth(stateTooth); }

    public String showStateTeethCount() {
        if(getStateTeethCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public StateTooth getSelectedStateTooth() {
        return stateTooh;
    }

    public String edit(StateTooth stateTooth) {
        this.stateTooh = stateTooth;
        return "StateToothEdit";
    }

    public String listStateTeeth() {
        return "success";
    }

}
