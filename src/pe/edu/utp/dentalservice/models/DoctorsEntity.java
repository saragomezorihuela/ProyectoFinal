package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara Sheena on 28/02/2017.
 */
public class DoctorsEntity  extends BaseEntity{

    public List<Doctor> findAll() {

        String sql = "SELECT id,nroDocumento,cco,first_name,last_name,birth_date,phone,cellphone,email " +
                "FROM dbdentalservice.people INNER JOIN dbdentalservice.doctors ON " +
                " people.id = doctors.id_doctor";
        ResultSet resultSet = null;
        List<Doctor> doctors = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                doctors.add(new Doctor(resultSet.getInt("id"),
                        resultSet.getString("nroDocumento"),
                        resultSet.getString("cco"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("phone"),
                        resultSet.getString("cellphone"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;

    }

    public int getDoctorsCount() {

        String sql = "SELECT COUNT(*) AS doctors_count FROM dbdentalservice.doctors";
        int doctorsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) doctorsCount = resultSet.getInt("doctorsCount_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorsCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Doctor doctor, MedicalEspeciality medicalEspeciality) {
        String sql = "INSERT INTO dbdentalservice.doctors(id_doctor, CCO, medical_id) " +
                "VALUES("  + String.valueOf(doctor.getId()) + ",'" +  doctor.getCCO() + "'," + String.valueOf(medicalEspeciality.getId()) + ")";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Doctor doctor) {
        String sql = "UPDATE dbdentalservice.doctors SET CCO = '" + doctor.getCCO() + "'" +
                " WHERE id = " + String.valueOf(doctor.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.doctors WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
