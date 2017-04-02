package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.*;
import pe.edu.utp.dentalservice.service.DsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sara Sheena on 19/03/2017.
 */
@ManagedBean(name = "employeeBean", eager = true)
@SessionScoped
public class DsEmployeeBean {

    private DsService service;

    private Employee employee = new Employee();
    private People people = new People();

    public DsEmployeeBean() {
        try {
            InitialContext ctx = new InitialContext();
            Connection connection = ((DataSource) ctx
                    .lookup("jdbc/MySQLDataSourceDs"))
                    .getConnection();
            service = new DsService();
            service.setConnection(connection);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int getPatientsCount() {
        return service.getPatientsCount();
    }

    public List<Patient> getPatients(String user) { return service.findAllPatients(user); }

    public String add(People people, Employee employee, IdentityCard identityCard, Gender gender, Hospital hospital) {

        service.addEmployee(people, employee, identityCard, gender, hospital);
        return "EmployeeList";
    }

    public String update(Employee employee) {
         service.updateEmployee(employee);
         return "EmployeeList";
    }

    public boolean delete(Employee employee) { return service.deleteEmployee(employee); }

    public String showEmployeesCount() {
        if(getPatientsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Employee getSelectedEmployee() {
        return employee;
    }

    public String edit(Employee employee) {
        this.employee = employee;
        return "EmployeeEdit";
    }

    public String listEmployees() {
        return "success";
    }

}
