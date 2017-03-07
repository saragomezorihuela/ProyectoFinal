package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DE LA CRUZ on 06/03/2017.
 */
public class MedicalEspecialitiesEntity extends BaseEntity{

    public MedicalEspecialitiesEntity() {
        super("MEDICALESPECIALITIES");
    }

    public List<MedicalEspeciality> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<MedicalEspeciality> findByCriteria(String sql) {
        List<MedicalEspeciality> medicalEspecialities = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                MedicalEspeciality country = MedicalEspeciality.build(rs);
                medicalEspecialities.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalEspecialities;
    }


    public MedicalEspeciality findById(int id) {
        String statement = "SELECT * FROM MEDICALESPECIALITIES WHERE id = " +
                String.valueOf(id);
        List<MedicalEspeciality> medicalEspecialities = findByCriteria(statement);
        return medicalEspecialities != null ? medicalEspecialities.get(0) : null;
    }

    public MedicalEspeciality findByName(String name) {
        String statement = "SELECT * FROM MEDICALESPECIALITIES WHERE description = '" +
                name + "'";
        List<MedicalEspeciality> medicalEspecialities = findByCriteria(statement);
        return medicalEspecialities != null ? medicalEspecialities.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public MedicalEspeciality create(int id, String description) {
        String sql = "INSERT INTO COUNTRIES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new MedicalEspeciality(id, description) : null;
    }

    public boolean update(MedicalEspeciality medicalEspeciality) {
        String sql = "UPDATE COUNTRIES SET description = '" + medicalEspeciality.getDescription() + "," +
                "' WHERE id = " + String.valueOf(medicalEspeciality.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM COUNTRIES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
