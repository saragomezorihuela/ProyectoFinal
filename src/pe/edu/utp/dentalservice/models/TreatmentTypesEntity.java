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

    public TreatmentTypesEntity() {
        super("TREATMENT_TYPES");
    }

    public List<TreatmentType> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<TreatmentType> findByCriteria(String sql) {
        List<TreatmentType> treatmentTypes = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                TreatmentType treatmentType = TreatmentType.build(rs);
                treatmentTypes.add(treatmentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatmentTypes;
    }

    public TreatmentType findById(int id) {
        String statement = "SELECT * FROM TREATMENT_TYPES WHERE id = " +
                String.valueOf(id);
        List<TreatmentType> treatmentTypes = findByCriteria(statement);
        return treatmentTypes != null ? treatmentTypes.get(0) : null;
    }

    public TreatmentType findByName(String name) {
        String statement = "SELECT * FROM TREATMENT_TYPES WHERE description = '" +
                name + "'";
        List<TreatmentType> treatmentTypes = findByCriteria(statement);
        return treatmentTypes != null ? treatmentTypes.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public TreatmentType create(int id, String description) {
        String sql = "INSERT INTO TREATMENT_TYPES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new TreatmentType(id, description) : null;
    }

    public boolean update(TreatmentType treatmentType) {
        String sql = "UPDATE TREATMENT_TYPES SET description = '" + treatmentType.getDescription() + "," +
                "' WHERE id = " + String.valueOf(treatmentType.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TREATMENT_TYPES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
