package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Rojas on 07/03/2017.
 */
public class ToothsEntity extends BaseEntity {

    public ToothsEntity() {
        super("TOOTHS");
    }

    public List<Tooth> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Tooth> findByCriteria(String sql) {
        List<Tooth> tooths = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Tooth tooth = Tooth.build(rs);
                tooths.add(tooth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tooths;
    }

    public Tooth findById(int id) {
        String statement = "SELECT * FROM TURNS WHERE id = " +
                String.valueOf(id);
        List<Tooth> tooths = findByCriteria(statement);
        return tooths != null ? tooths.get(0) : null;
    }

    public Tooth findByName(String name) {
        String statement = "SELECT * FROM TOOTHS WHERE description = '" +
                name + "'";
        List<Tooth> tooths = findByCriteria(statement);
        return tooths != null ? tooths.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Tooth create(int id, int number, String description) {
        String sql = "INSERT INTO TOOTHS(id, number, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + String.valueOf(number) + "', '" + description + "')";
        return updateByCriteria(sql) > 0 ? new Tooth(id, number, description) : null;
    }

    public boolean update(Tooth tooth) {
        String sql = "UPDATE TOOTHS SET description = '" + tooth.getDescription() + "','" + tooth.getNumber() + "'" +
                "' WHERE id = " + String.valueOf(tooth.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TOOTHS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
