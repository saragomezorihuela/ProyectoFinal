package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.IdentityCard;
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
 * Created by ..... on 21/03/2017.
 */
@ManagedBean(name = "identityCardBean", eager = true)
@SessionScoped
public class DsIdentityCardBean {

    private DsService service;

    private IdentityCard identityCard = new IdentityCard();

    public DsIdentityCardBean() {
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

    public int getIdentityCardsCount() {
        return service.getIdentityCardsCount();
    }

    public List<IdentityCard> getIdentityCards() { return service.findAllIdentityCards(); }

    public String add() {
        service.addIdentityCard(identityCard);
        return "IdentityCardList";
    }

    public String update(IdentityCard identityCard) {
        service.updateIdentityCard(identityCard);
        return "IdentityCardList";
    }

    public boolean delete(IdentityCard identityCard) { return service.deleteIdentityCard(identityCard); }

    public String showTurnsCount() {
        if(getIdentityCardsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public IdentityCard getSelectedIdentityCard() {
        return identityCard;
    }

    public String edit(IdentityCard identityCard) {
        this.identityCard = identityCard;
        return "IdentityCardEdit";
    }

}
