package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Aguilar on 06/03/2017.
 */
public class DepartmentsEntity extends BaseEntity{

    //private CountriesEntity countriesEntity;

    public List<Department> findAll() {

        String sql = "SELECT id, description FROM dbdentalservice.departaments WHERE country_id = 1";
        ResultSet resultSet = null;
        List<Department> departments = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                departments.add(new Department(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;

    }

    public int getDepartmentsCount() {

        String sql = "SELECT COUNT(*) AS turns_count FROM dbdentalservice.departaments";
        int departmentsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) departmentsCount = resultSet.getInt("departments_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentsCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Department department, Country country) {
        String sql = "INSERT INTO dbdentalservice.departaments(description, country_id) " +
                "VALUES('" + department.getDescription() + "'," + String.valueOf(country.getId()) + ")";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Department department) {
        String sql = "UPDATE dbdentalservice.departaments SET description = '" + department.getDescription() + "'" +
                " WHERE id = " + String.valueOf(department.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.departaments WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
