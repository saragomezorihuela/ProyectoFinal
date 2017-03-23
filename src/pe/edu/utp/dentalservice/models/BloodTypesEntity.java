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

    public List<BloodType> findAll() {

        String sql = "SELECT * FROM dbdentalservice.blood_types";
        ResultSet resultSet = null;
        List<BloodType> bloodTypes = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                bloodTypes.add(new BloodType(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodTypes;

    }

    public int getBloodTypesCount() {

        String sql = "SELECT COUNT(*) AS turns_count FROM dbdentalservice.blood_types";
        int bloodTypesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) bloodTypesCount = resultSet.getInt("bloodTypes_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodTypesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(BloodType bloodType) {
        String sql = "INSERT INTO dbdentalservice.blood_types(description) " +
                "VALUES('" + bloodType.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(BloodType bloodType) {
        String sql = "UPDATE dbdentalservice.blood_types SET description = '" + bloodType.getDescription() + "'" +
                " WHERE id = " + String.valueOf(bloodType.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.blood_types WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
