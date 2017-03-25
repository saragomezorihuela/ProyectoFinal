package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Aguilar on 06/03/2017.
 */
public class ProvincesEntity extends BaseEntity{

    Department department;

    public List<Province> findAll(int departmentId) {

        String sql = "SELECT id, description FROM dbdentalservice.provinces WHERE department_id = " + String.valueOf(departmentId);
        ResultSet resultSet = null;
        List<Province> provinces = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                provinces.add(new Province(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinces;

    }

    public int getProvincesCount() {

        String sql = "SELECT COUNT(*) AS turns_count FROM dbdentalservice.provinces WHERE department_id = " + String.valueOf(department.getId());
        int provincesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) provincesCount = resultSet.getInt("provinces_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provincesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Province province) {
        String sql = "INSERT INTO dbdentalservice.provinces(description, department_id) " +
                "VALUES('" + department.getDescription() + "'," + String.valueOf(province.getId()) + ")";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Province province) {
        String sql = "UPDATE dbdentalservice.provinces SET description = '" + province.getDescription() + "'" +
                " WHERE id = " + String.valueOf(province.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.provinces WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
