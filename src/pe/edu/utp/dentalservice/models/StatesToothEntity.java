package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Rojas on 04/03/2017.
 */
public class StatesToothEntity extends BaseEntity{

    public StatesToothEntity() {
        super("STATES_TEETHS");
    }

    public List<StateTooth> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<StateTooth> findByCriteria(String sql) {
        List<StateTooth> statesTooth = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                StateTooth treatmentType = StateTooth.build(rs);
                statesTooth.add(treatmentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statesTooth;
    }

    public StateTooth findById(int id) {
        String statement = "SELECT * FROM STATES_TEETHS WHERE id = " +
                String.valueOf(id);
        List<StateTooth> statesTooth = findByCriteria(statement);
        return statesTooth != null ? statesTooth.get(0) : null;
    }

    public StateTooth findByName(String name) {
        String statement = "SELECT * FROM STATES_TEETHS WHERE description = '" +
                name + "'";
        List<StateTooth> statesTooth = findByCriteria(statement);
        return statesTooth != null ? statesTooth.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public StateTooth create(int id, String description) {
        String sql = "INSERT INTO STATES_TEETHS(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new StateTooth(id, description) : null;
    }

    public boolean update(StateTooth statesTooth) {
        String sql = "UPDATE STATES_TEETHS SET description = '" + statesTooth.getDescription() + "," +
                "' WHERE id = " + String.valueOf(statesTooth.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM STATES_TEETHS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
