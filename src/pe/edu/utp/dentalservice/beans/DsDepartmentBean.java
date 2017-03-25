package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Department;
import pe.edu.utp.dentalservice.models.Country;
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
 * Created by JUAN CARLOS on 19/03/2017.
 */
@ManagedBean(name = "departmentBean", eager = true)
@SessionScoped
public class DsDepartmentBean {

    private DsService service;

    private Country country = new Country();
    private Department department = new Department();

    public DsDepartmentBean() {
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

    public int getDepartmentsCount() {
        return service.getTurnsCount();
    }

    public List<Department> getDepartments() { return service.findAllDepartments(); }

    public String add(Department department,Country country) {
        service.addDepartment(department,country);
        return "DepartmentList";
    }

    public String update(Department department) {
         service.updateDepartment(department);
         return "DepartmentList";
    }

    public boolean delete(Department department) { return service.deleteDepartment(department); }

    public String showDepartmentsCount() {
        if(getDepartmentsCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Department getSelectedDepartment() {
        return department;
    }

    public String edit(Department department) {
        this.department = department;
        return "DepartmentEdit";
    }

    public String listDepartments() {
        return "success";
    }

}
