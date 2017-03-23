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

    public List<Hospital> findAll() {

        String sql = "SELECT * FROM dbdentalservice.hospitals";
        ResultSet resultSet = null;
        List<Hospital> hospitals = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                hospitals.add(new Hospital(resultSet.getInt("id"),
                        resultSet.getString("ruc"),
                        resultSet.getString("business_name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitals;

    }

    public Hospital findById(int id) {

        String sql = "SELECT * FROM dbdentalservice.hospitals WHERE id = " + String.valueOf(id);

        List<Hospital> hospitals = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                hospitals.add(new Hospital(resultSet.getInt("id"),
                        resultSet.getString("ruc"),
                        resultSet.getString("business_name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitals.get(0);

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Hospital hospital) {
        String sql = "INSERT INTO dbdentalservice.hospitals(ruc, business_name, address, phone, email) " +
                "VALUES('" + hospital.getRuc() + "', '" + hospital.getBusinessName() + "', '" +
                hospital.getAddress() + "', '" + hospital.getPhone() + "', '" +
                hospital.getEmail() + "')";
        return updateByCriteria(sql) > 0;
    }

    public boolean update(Hospital hospital) {
        String sql = "UPDATE dbdentalservice.hospitals SET ruc = '" + hospital.getRuc() + "'," +
                "business_name = '" + hospital.getBusinessName() + "'," +
                "address = '" + hospital.getAddress() + "'," +
                "phone = '" + hospital.getPhone() + "',"+
                "email = '" + hospital.getEmail() + "' "+
                "WHERE id = " + String.valueOf(hospital.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.hospitals WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public int getHospitalsCount() {
        String sql = "SELECT COUNT(*) AS hospitals_count FROM dbdentalservice.hospitals";
        int hospitalsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) hospitalsCount = resultSet.getInt("hospitals_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalsCount;
    }

}
