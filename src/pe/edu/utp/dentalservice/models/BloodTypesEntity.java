package pe.edu.utp.dentalservice.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SARA GOMEZ on 04/03/2017.
 */
public class BloodTypesEntity extends BaseEntity {

    public BloodTypesEntity() {
        super("BLOOD_TYPES");
    }

    public List<BloodType> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<BloodType> findByCriteria(String sql) {
        List<BloodType> bloodTypes = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                BloodType bloodType = BloodType.build(rs);
                bloodTypes.add(bloodType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodTypes;
    }


    public BloodType findById(int id) {
        String statement = "SELECT * FROM BLOOD_TYPES WHERE id = " +
                String.valueOf(id);
        List<BloodType> bloodTypes = findByCriteria(statement);
        return bloodTypes != null ? bloodTypes.get(0) : null;
    }

    public BloodType findByName(String name) {
        String statement = "SELECT * FROM BLOOD_TYPES WHERE description = '" +
                name + "'";
        List<BloodType> bloodTypes = findByCriteria(statement);
        return bloodTypes != null ? bloodTypes.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public BloodType create(int id, String description) {
        String sql = "INSERT INTO BLOOD_TYPES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new BloodType(id, description) : null;
    }

    public boolean update(BloodType bloodType) {
        String sql = "UPDATE BLOOD_TYPES SET description = '" + bloodType.getDescription() + "," +
                "' WHERE id = " + String.valueOf(bloodType.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM BLOODTYPES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
