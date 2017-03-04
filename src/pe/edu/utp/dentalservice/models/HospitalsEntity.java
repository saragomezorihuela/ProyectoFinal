package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class HospitalsEntity extends BaseEntity{

    public HospitalsEntity() {
        super("hospitals");
    }

    public List<Hospital> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Hospital> findByCriteria(String sql) {
        List<Hospital> hospitals = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Hospital hospital = Hospital.build(rs);
                hospitals.add(hospital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitals;
    }

    public Hospital findById(int id) {
        String statement = "SELECT * FROM hospitals WHERE id = " +
                String.valueOf(id);
        List<Hospital> hospitals = findByCriteria(statement);
        return hospitals != null ? hospitals.get(0) : null;
    }

    public Hospital findByName(String name) {
        String statement = "SELECT * FROM hospitals WHERE business_name = '" +
                name + "'";
        List<Hospital> hospitals = findByCriteria(statement);
        return hospitals != null ? hospitals.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Hospital create(int id, String ruc, String businessName, String address, String phone, String email) {
        String sql = "INSERT INTO hospitals(id, ruc, business_name, address, phone, email) " +
                "VALUES(" + String.valueOf(id) + ", '" + ruc + "', '" + businessName + "', '" + address + "', '" + phone + "', '" + email + "')";
        return updateByCriteria(sql) > 0 ? new Hospital(id, ruc,businessName,address,phone,email) : null;
    }

    public boolean update(Hospital hospital) {
        String sql = "UPDATE hospitals SET ruc = '" + hospital.getRuc() + "," +
                            "business_name = '" + hospital.getBusinessName() + "," +
                            "address = '" + hospital.getAddress() + "," +
                            "phone = '" + hospital.getPhone() + ","+
                            "email = '" + hospital.getEmail() +
                "' WHERE id = " + String.valueOf(hospital.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM hospitals WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
