package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class GendersEntity extends BaseEntity{

    public GendersEntity() {
        super("genders");
    }

    public List<Gender> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Gender> findByCriteria(String sql) {
        List<Gender> genders = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Gender gender = Gender.build(rs);
                genders.add(gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genders;
    }

    public Gender findById(int id) {
        String statement = "SELECT * FROM genders WHERE id = " +
                String.valueOf(id);
        List<Gender> genders = findByCriteria(statement);
        return genders != null ? genders.get(0) : null;
    }

    public Gender findByName(String name) {
        String statement = "SELECT * FROM genders WHERE description = '" +
                name + "'";
        List<Gender> genders = findByCriteria(statement);
        return genders != null ? genders.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Gender create(int id, String description) {
        String sql = "INSERT INTO genders(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new Gender(id, description) : null;
    }

    public boolean update(Gender gender) {
        String sql = "UPDATE genders SET description = '" + gender.getDescription() + "," +
                "' WHERE id = " + String.valueOf(gender.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM genders WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
