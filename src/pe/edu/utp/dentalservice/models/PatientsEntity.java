package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara Sheena on 23/03/2017.
 */
public class PatientsEntity extends BaseEntity{

    public List<Patient> findAll(Hospital hospital) {

        String sql = "SELECT id,nroDocumento,first_name,last_name,birth_date,phone,cellphone,email,relative_name,relative_phone " +
                "FROM dbdentalservice.people INNER JOIN dbdentalservice.patients ON " +
                " people.id = patients.id_patient WHERE people.hospital_id = " + String.valueOf(hospital.getId()) + "";
        ResultSet resultSet = null;
        List<Patient> patients = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                patients.add(new Patient(resultSet.getInt("id"),
                        resultSet.getString("nroDocumento"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("phone"),
                        resultSet.getString("cellphone"),
                        resultSet.getString("email"),
                        resultSet.getString("relative_name"),
                        resultSet.getString("relative_phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;

    }

    public List<Patient> findAllExt(People people) {

        String sql = "SELECT id,nroDocumento,first_name,last_name,birth_date,phone,cellphone,email,relative_name,relative_phone " +
                "FROM dbdentalservice.people INNER JOIN dbdentalservice.patients ON " +
                " people.id = patients.id_patient WHERE nroDocumento = '" + people.getNroDocumento() + "'";
        ResultSet resultSet1 = null;
        List<Patient> patientsExt = new ArrayList<>();
        try {
            resultSet1 = getConnection().createStatement().executeQuery(sql);
            while(resultSet1.next()) {
                patientsExt.add(new Patient(resultSet1.getInt("id"),
                        resultSet1.getString("nroDocumento"),
                        resultSet1.getString("first_name"),
                        resultSet1.getString("last_name"),
                        resultSet1.getString("birth_date"),
                        resultSet1.getString("phone"),
                        resultSet1.getString("cellphone"),
                        resultSet1.getString("email"),
                        resultSet1.getString("relative_name"),
                        resultSet1.getString("relative_phone")));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return patientsExt;

    }

    public int getPatientsCount() {

        String sql = "SELECT COUNT(*) AS patients_count FROM dbdentalservice.patients";
        int patientsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) patientsCount = resultSet.getInt("patients_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientsCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Patient patient) {
        String sql = "INSERT INTO dbdentalservice.patients(id_patient,relative_name,relative_phone) " +
                //"VALUES(3,'" +  patient.getRelativename() + "','" +  patient.getRelativephone() + "')";
                "VALUES("  + String.valueOf(patient.getId()) + ",'" +  patient.getRelativename() + "','" +  patient.getRelativephone() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Patient patient) {
        String sql = "UPDATE dbdentalservice.patients SET relative_name = '" + patient.getRelativename() + "','" +
                "relative_phone = '" + patient.getRelativephone() + "'" +
                " WHERE id = " + String.valueOf(patient.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.patients WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
