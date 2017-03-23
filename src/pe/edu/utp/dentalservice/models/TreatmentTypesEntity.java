package pe.edu.utp.dentalservice.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DE LA CRUZ on 04/03/2017.
 */

public class TreatmentTypesEntity extends BaseEntity{

    public List<TreatmentType> findAll() {

        String sql = "SELECT * FROM dbdentalservice.treatment_types";
        ResultSet resultSet = null;
        List<TreatmentType> treatmentTypes = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                treatmentTypes.add(new TreatmentType(resultSet.getInt("id"),
                                                    resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatmentTypes;

    }

    public int getTreatmentTypesCount() {

        String sql = "SELECT COUNT(*) AS treatmentTypes_count FROM dbdentalservice.treatment_types";
        int treatmentTypesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) treatmentTypesCount = resultSet.getInt("treatmentTypes_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatmentTypesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(TreatmentType treatmentType) {
        String sql = "INSERT INTO dbdentalservice.treatment_types(description) " +
                "VALUES('" + treatmentType.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }

    public boolean update(TreatmentType treatmentType) {
        String sql = "UPDATE dbdentalservice.treatment_types SET description = '" + treatmentType.getDescription() + "'" +
                " WHERE id = " + String.valueOf(treatmentType.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.treatment_types WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
