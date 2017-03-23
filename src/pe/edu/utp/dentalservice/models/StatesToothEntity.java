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

    public List<StateTooth> findAll() {

        String sql = "SELECT * FROM dbdentalservice.states_teeth";
        ResultSet resultSet = null;
        List<StateTooth> stateTeeth = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                stateTeeth.add(new StateTooth(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stateTeeth;

    }

    public int getStateTeethCount() {

        String sql = "SELECT COUNT(*) AS stateTeeth_count FROM dbdentalservice.states_teeth";
        int stateTeethCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) stateTeethCount = resultSet.getInt("stateTeeth_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stateTeethCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(StateTooth stateTooth) {
        String sql = "INSERT INTO dbdentalservice.states_teeth(description) " +
                "VALUES('" + stateTooth.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(StateTooth stateTooth) {
        String sql = "UPDATE dbdentalservice.states_teeth SET description = '" + stateTooth.getDescription() + "'" +
                " WHERE id = " + String.valueOf(stateTooth.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.states_teeth WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
