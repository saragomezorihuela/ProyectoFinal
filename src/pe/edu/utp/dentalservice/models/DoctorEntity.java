package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara Sheena on 28/02/2017.
 */
public class DoctorEntity  extends BaseEntity{

    private MedicalEspecialitiesEntity medicalEspecialitiesEntity;

    public DoctorEntity() {
        super("doctor");
    }

    public List<Doctor> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Doctor> findByCriteria(String sql) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Doctor doctor = Doctor.build(rs, getMedicalEspecialitiesEntity());
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }


    public Doctor findById(int id) {
        String statement = "SELECT * FROM DOCTORS WHERE id = " +
                String.valueOf(id);
        List<Doctor> doctors = findByCriteria(statement);
        return doctors != null ? doctors.get(0) : null;
    }

    public Doctor findByCCO(String cco) {
        String statement = "SELECT * FROM DOCTORS WHERE CCO = '" +
                cco + "'";
        List<Doctor> doctors = findByCriteria(statement);
        return doctors != null ? doctors.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Doctor create(int id, String CCO, int medical_id) {
        String sql = "INSERT INTO DOCTORS(id, COO, medical_id) " +
                "VALUES(" + String.valueOf(id) + "," + CCO + "','" + String.valueOf(medical_id) + ")";
        return updateByCriteria(sql) > 0 ? new Doctor(id, CCO, getMedicalEspecialitiesEntity().findById(medical_id)) : null;
    }

    public boolean update(Doctor doctor) {
        String sql = "UPDATE DOCTORS SET CCO = '" + doctor.getCCO() + "," +
                "' WHERE id = " + String.valueOf(doctor.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM DOCTORS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
    public MedicalEspecialitiesEntity getMedicalEspecialitiesEntity() {
        return medicalEspecialitiesEntity;
    }

    public void setMedicalEspecialitiesEntity(MedicalEspecialitiesEntity medicalEspecialitiesEntity) {
        this.medicalEspecialitiesEntity = medicalEspecialitiesEntity;
    }
}
