package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DE LA CRUZ on 12/03/2017.
 */
public class MedicalSpecialitiesEntity extends BaseEntity{

    public MedicalSpecialitiesEntity() {
        super("MEDICALSPECIALITIES");
    }

    public List<MedicalSpeciality> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<MedicalSpeciality> findByCriteria(String sql) {
        List<MedicalSpeciality> medicalSpecialities = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                MedicalSpeciality medicalSpeciality = MedicalSpeciality.build(rs);
                medicalSpecialities.add(medicalSpeciality);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalSpecialities;
    }

    public MedicalSpeciality findById(int id) {
        String statement = "SELECT * FROM MEDICALSPECIALITIES WHERE id = " +
                String.valueOf(id);
        List<MedicalSpeciality> medicalSpecialities = findByCriteria(statement);
        return medicalSpecialities != null ? medicalSpecialities.get(0) : null;
    }

    public MedicalSpeciality findByName(String name) {
        String statement = "SELECT * FROM MEDICALSPECIALITIES WHERE description = '" +
                name + "'";
        List<MedicalSpeciality> medicalSpecialities = findByCriteria(statement);
        return medicalSpecialities != null ? medicalSpecialities.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public MedicalSpeciality create(int id, String description) {
        String sql = "INSERT INTO MEDICALSPECIALITIES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new MedicalSpeciality(id, description) : null;
    }

    public boolean update(MedicalSpeciality medicalSpeciality) {
        String sql = "UPDATE MEDICALSPECIALITIES SET description = '" + medicalSpeciality.getDescription() + "," +
                "' WHERE id = " + String.valueOf(medicalSpeciality.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TREATMENT_TYPES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
