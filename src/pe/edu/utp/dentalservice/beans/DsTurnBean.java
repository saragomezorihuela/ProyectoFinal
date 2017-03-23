package pe.edu.utp.dentalservice.beans;

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
 * Created by Jonathan Rojas on 19/03/2017.
 */
@ManagedBean(name = "turnBean", eager = true)
@SessionScoped
public class DsTurnBean {

    private DsService service;

    private int id;

    private Turn selectedTurn = new Turn();

    public DsTurnBean() {
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

    public int getTurnsCount() {
        return service.getTurnsCount();
    }

    public List<Turn> getTurns() { return service.findAllTurns(); }

    public String add(Turn turn) {
        service.addTurn(turn);
        return "TurnList";
    }

    public String update(Turn turn) {
         service.updateTurn(turn);
         return "TurnList";
    }

    public boolean delete(Turn turn) { return service.deleteTurn(turn); }

    public String showTurnsCount() {
        if(getTurnsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Turn getSelectedTurn() {
        return selectedTurn;
    }

    public String edit(Turn turn) {
        this.selectedTurn = turn;
        return "TurnEdit";
    }

    public String listTurns() {
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
