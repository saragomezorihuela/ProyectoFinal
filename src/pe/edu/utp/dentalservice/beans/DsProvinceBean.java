package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Country;
import pe.edu.utp.dentalservice.models.Department;
import pe.edu.utp.dentalservice.models.Province;
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
@ManagedBean(name = "provinceBean", eager = true)
@SessionScoped
public class DsProvinceBean {

    private DsService service;

    private Department department = new Department();
    private Province province = new Province();

    public DsProvinceBean() {
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

    public int getProvincesCount() {
        return service.getProvincesCount();
    }

    public List<Province> getProvinces() { return service.findAllProvinces(department.getId()); }

    public String add() {
        service.addProvince(province);
        return "ProvinceList";
    }

    public String update(Province province) {
         service.updateProvince(province);
         return "ProvinceList";
    }

    public boolean delete(Province province) { return service.deleteProvince(province); }

    public String showProvincesCount() {
        if(getProvincesCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Province getSelectedProvince() {
        return province;
    }

    public String edit(Province province) {
        this.province = province;
        return "ProvinceEdit";
    }

    public String listProvinces() {
        return "success";
    }

}
