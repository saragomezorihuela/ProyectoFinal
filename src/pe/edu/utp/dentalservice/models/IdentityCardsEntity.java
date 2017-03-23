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

        String sql = "SELECT * FROM dbdentalservice.identity_cards";
        ResultSet resultSet = null;
        List<IdentityCard> identityCards = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                identityCards.add(new IdentityCard(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return identityCards;

    }

    public int getTurnsCount() {

        String sql = "SELECT COUNT(*) AS identityCards_count FROM dbdentalservice.identity_cards";
        int regionsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) regionsCount = resultSet.getInt("identityCards_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regionsCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(IdentityCard identityCard) {
        String sql = "INSERT INTO dbdentalservice.identity_cards(description) " +
                "VALUES('" + identityCard.getDescription() + "')";
        return updateByCriteria(sql) > 0;
    }

    public boolean update(IdentityCard identityCard) {
        String sql = "UPDATE dbdentalservice.identity_cards SET description = '" + identityCard.getDescription() + "'" +
                "' WHERE id = " + String.valueOf(identityCard.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.identity_cards WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
