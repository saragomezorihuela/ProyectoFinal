package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Aguilar on 11/03/2017.
 */
public class EmployeesTypeEntity extends BaseEntity{

    public EmployeesTypeEntity() {
        super("EMPLOYEE_TYPES");
    }

    public List<EmployeeType> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<EmployeeType> findByCriteria(String sql) {
        List<EmployeeType> employeeTypes = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                EmployeeType employeeType = EmployeeType.build(rs);
                employeeTypes.add(employeeType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeTypes;
    }


    public EmployeeType findById(int id) {
        String statement = "SELECT * FROM EMPLOYEE_TYPES WHERE id = " +
                String.valueOf(id);
        List<EmployeeType> employeeTypes = findByCriteria(statement);
        return employeeTypes != null ? employeeTypes.get(0) : null;
    }

    public EmployeeType findByName(String name) {
        String statement = "SELECT * FROM EMPLOYEE_TYPES WHERE description = '" +
                name + "'";
        List<EmployeeType> employeeTypes = findByCriteria(statement);
        return employeeTypes != null ? employeeTypes.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public EmployeeType create(int id, String description) {
        String sql = "INSERT INTO EMPLOYEE_TYPES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new EmployeeType(id, description) : null;
    }

    public boolean update(EmployeeType employeeType) {
        String sql = "UPDATE EMPLOYEE_TYPES SET description = '" + employeeType.getDescription() + "," +
                "' WHERE id = " + String.valueOf(employeeType.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM EMPLOYEE_TYPES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
