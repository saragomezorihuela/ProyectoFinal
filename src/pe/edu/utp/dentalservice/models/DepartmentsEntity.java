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

    private CountriesEntity countriesEntity;

    public DepartmentsEntity() {
        super("DEPARTMENTS");
    }

    public List<Department> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Department> findByCriteria(String sql) {
        List<Department> departments = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Department department = Department.build(rs, getCountriesEntity());
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public Department findById(int id) {
        String statement = "SELECT * FROM DEPARTMENTS WHERE id = " +
                String.valueOf(id);
        List<Department> departments = findByCriteria(statement);
        return departments != null ? departments.get(0) : null;
    }

    public Department findByName(String name) {
        String statement = "SELECT * FROM COUNTRIES WHERE description = '" +
                name + "'";
        List<Department> departments = findByCriteria(statement);
        return departments != null ? departments.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Department create(int id, String description, int countryId) {
        String sql = "INSERT INTO DEPARTMENTS(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new Department(id, description, getCountriesEntity().findById(countryId)) : null;
    }

    public boolean update(Department department) {
        String sql = "UPDATE DEPARTMENTS SET description = '" + department.getDescription() + "," +
                "' WHERE id = " + String.valueOf(department.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM DEPARTMENTS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public CountriesEntity getCountriesEntity() {
        return countriesEntity;
    }

    public void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }
}
