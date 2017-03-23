package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Rojas on 06/03/2017.
 */
public class TurnsEntity extends BaseEntity {

    public List<Turn> findAll() {

        String sql = "SELECT * FROM dbdentalservice.turns";
        ResultSet resultSet = null;
        List<Turn> turns = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                turns.add(new Turn(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turns;

    }

    public int getTurnsCount() {

        String sql = "SELECT COUNT(*) AS turns_count FROM dbdentalservice.turns";
        int turnsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) turnsCount = resultSet.getInt("turns_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turnsCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Turn turn) {
        String sql = "INSERT INTO dbdentalservice.turns(description) " +
                "VALUES('" + turn.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Turn turn) {
        String sql = "UPDATE dbdentalservice.turns SET description = '" + turn.getDescription() + "'" +
                " WHERE id = " + String.valueOf(turn.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.turns WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
