package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DE LA CRUZ on 14/03/2017.
 */
public class TreatmentsEntity extends BaseEntity{

    private TreatmentTypesEntity treatmentTypesEntity;

    public TreatmentsEntity() {
        super("TREATMENTS");
    }

    public List<Treatment> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Treatment> findByCriteria(String sql) {
        List<Treatment> treatments = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Treatment treatment = Treatment.build(rs, getTreatmentTypesEntity());
                treatments.add(treatment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatments;
    }

    public Treatment findById(int id) {
        String statement = "SELECT * FROM TREATMENTS WHERE id = " +
                String.valueOf(id);
        List<Treatment> treatments = findByCriteria(statement);
        return treatments != null ? treatments.get(0) : null;
    }

    public Treatment findByName(String name) {
        String statement = "SELECT * FROM TREATMENTS WHERE description = '" +
                name + "'";
        List<Treatment> treatments = findByCriteria(statement);
        return treatments != null ? treatments.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Treatment create(int id, String description, float cost, int sessionCount, int type_treatment_Id) {
        String sql = "INSERT INTO TREATMENTS(id, description, cost, sessionCount, profileId) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "," + cost + "," + sessionCount + "," + String.valueOf(type_treatment_Id) + "')";
        return updateByCriteria(sql) > 0 ? new Treatment(id, description, cost, sessionCount, getTreatmentTypesEntity().findById(type_treatment_Id)) : null;
    }

    public boolean update(Treatment treatment) {
        String sql = "UPDATE TREATMENTS SET description = '" + treatment.getDescription() + "," +
                "cost = '" + treatment.getCost() + "," +
                "sessionCount = '" + treatment.getSessionCount() +
                "' WHERE id = " + String.valueOf(treatment.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TREATMENTS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public TreatmentTypesEntity getTreatmentTypesEntity() {
        return treatmentTypesEntity;
    }

    public void setTreatmentTypesEntity(TreatmentTypesEntity treatmentTypesEntity) {
        this.treatmentTypesEntity = treatmentTypesEntity;
    }

}
