package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara Sheena on 23/03/2017.
 */
public class EmployeesEntity extends BaseEntity{

    public List<Employee> findAll() {

        String sql = "SELECT id,nroDocumento,first_name,last_name,birth_date,phone,cellphone,email " +
                "FROM dbdentalservice.people INNER JOIN dbdentalservice.employees ON " +
                " people.id = employees.id_employee";
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                employees.add(new Employee(resultSet.getInt("id"),
                        resultSet.getString("nroDocumento"),
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
        return employees;

    }

    public int getEmployeesCount() {

        String sql = "SELECT COUNT(*) AS employees_count FROM dbdentalservice.employees";
        int employeesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) employeesCount = resultSet.getInt("employees_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Employee employee) {
        String sql = "INSERT INTO dbdentalservice.employees(id_employee,schedule_id,employee_type_id) " +
                "VALUES("  + String.valueOf(employee.getId()) + ",1,1)";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Employee employee) {
        String sql = "UPDATE dbdentalservice.patients SET schedule_id = 1," +
                "employee_type_id = 1" +
                " WHERE id = " + String.valueOf(employee.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.patients WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
