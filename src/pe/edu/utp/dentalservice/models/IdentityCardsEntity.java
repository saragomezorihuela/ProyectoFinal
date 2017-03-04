package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class IdentityCardsEntity extends BaseEntity{

    public IdentityCardsEntity() {
        super("identitycards");
    }

    public List<IdentityCard> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<IdentityCard> findByCriteria(String sql) {
        List<IdentityCard> identityCards = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                IdentityCard identityCard = IdentityCard.build(rs);
                identityCards.add(identityCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return identityCards;
    }


    public IdentityCard findById(int id) {
        String statement = "SELECT * FROM IDENTITY_CARDS WHERE id = " +
                String.valueOf(id);
        List<IdentityCard> identityCards = findByCriteria(statement);
        return identityCards != null ? identityCards.get(0) : null;
    }

    public IdentityCard findByName(String name) {
        String statement = "SELECT * FROM IDENTITY_CARDS WHERE description = '" +
                name + "'";
        List<IdentityCard> identityCards = findByCriteria(statement);
        return identityCards != null ? identityCards.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public IdentityCard create(int id, String description) {
        String sql = "INSERT INTO IDENTITY_CARDS(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new IdentityCard(id, description) : null;
    }

    public boolean update(IdentityCard identityCard) {
        String sql = "UPDATE IDENTITY_CARDS SET description = '" + identityCard.getDescription() + "," +
                "' WHERE id = " + String.valueOf(identityCard.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM IDENTITY_CARDS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
