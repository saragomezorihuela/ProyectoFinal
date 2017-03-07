package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Rojas on 06/03/2017.
 */
public class TurnsEntity extends BaseEntity {

    public TurnsEntity() {
        super("TURNS");
    }

    public List<Turn> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Turn> findByCriteria(String sql) {
        List<Turn> turns = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Turn turn = Turn.build(rs);
                turns.add(turn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turns;
    }


    public Turn findById(int id) {
        String statement = "SELECT * FROM TURNS WHERE id = " +
                String.valueOf(id);
        List<Turn> turns = findByCriteria(statement);
        return turns != null ? turns.get(0) : null;
    }

    public Turn findByName(String name) {
        String statement = "SELECT * FROM TURNS WHERE description = '" +
                name + "'";
        List<Turn> turns = findByCriteria(statement);
        return turns != null ? turns.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Turn create(int id, String description) {
        String sql = "INSERT INTO TURNS(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new Turn(id, description) : null;
    }

    public boolean update(Country country) {
        String sql = "UPDATE TURNS SET description = '" + country.getDescription() + "," +
                "' WHERE id = " + String.valueOf(country.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TURNS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
