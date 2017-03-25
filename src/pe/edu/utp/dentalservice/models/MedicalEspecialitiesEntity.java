package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DE LA CRUZ on 06/03/2017.
 */
public class MedicalEspecialitiesEntity extends BaseEntity{

    public List<MedicalEspeciality> findAll() {

        String sql = "SELECT * FROM dbdentalservice.medical_especialities";
        ResultSet resultSet = null;
        List<MedicalEspeciality> turns = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                turns.add(new MedicalEspeciality(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turns;

    }

    public int getMedicalEspecialitiesCount() {

        String sql = "SELECT COUNT(*) AS medicalEspecialities_count FROM dbdentalservice.medical_especialities";
        int medicalEspecialitiesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) medicalEspecialitiesCount = resultSet.getInt("medicalEspecialities_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalEspecialitiesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(MedicalEspeciality medicalEspeciality) {
        String sql = "INSERT INTO dbdentalservice.medical_especialities(description) " +
                "VALUES('" + medicalEspeciality.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(MedicalEspeciality medicalEspeciality) {
        String sql = "UPDATE dbdentalservice.medical_especialities SET description = '" + medicalEspeciality.getDescription() + "'" +
                " WHERE id = " + String.valueOf(medicalEspeciality.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.medical_especialities WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
