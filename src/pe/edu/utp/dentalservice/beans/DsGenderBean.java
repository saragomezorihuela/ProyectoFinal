package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Gender;
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
 * Created by JUAN CARLOS on 19/03/2017.
 */
@ManagedBean(name = "genderBean", eager = true)
@SessionScoped
public class DsGenderBean {

    private DsService service;

    private Gender gender = new Gender();

    public DsGenderBean() {
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

    public int getGendersCount() {
        return service.getGendersCount();
    }

    public List<Gender> getGenders() { return service.findAllGenders(); }

    public String add(Gender gender) {
        service.addGender(gender);
        return "TurnList";
    }

    public String update(Gender gender) {
         service.updateGender(gender);
         return "TurnList";
    }

    public boolean delete(Gender gender) { return service.deleteGender(gender); }

    public String showTurnsCount() {
        if(getGendersCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public String edit(Gender gender) {
        this.gender = gender;
        return "GenderEdit";
    }

    public String listGenders() {
        return "success";
    }

}
