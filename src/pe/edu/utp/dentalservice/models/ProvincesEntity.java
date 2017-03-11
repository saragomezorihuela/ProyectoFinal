package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Aguilar on 06/03/2017.
 */
public class ProvincesEntity extends BaseEntity{

    private DepartmentsEntity departmentsEntity;

    public ProvincesEntity() {
        super("PROVINCES");
    }

    public List<Province> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Province> findByCriteria(String sql) {
        List<Province> provinces = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Province province = Province.build(rs, getDepartmentsEntity());
                provinces.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinces;
    }

    public Province findById(int id) {
        String statement = "SELECT * FROM PROVINCES WHERE id = " +
                String.valueOf(id);
        List<Province> provinces = findByCriteria(statement);
        return provinces != null ? provinces.get(0) : null;
    }

    public Province findByName(String name) {
        String statement = "SELECT * FROM PROVINCES WHERE description = '" +
                name + "'";
        List<Province> provinces = findByCriteria(statement);
        return provinces != null ? provinces.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Province create(int id, String description, int department_id) {
        String sql = "INSERT INTO PROVINCES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new Province(id, description, getDepartmentsEntity().findById(department_id)) : null;
    }

    public boolean update(Province province) {
        String sql = "UPDATE PROVINCES SET description = '" + province.getDescription() + "," +
                "' WHERE id = " + String.valueOf(province.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM PROVINCES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public DepartmentsEntity getDepartmentsEntity() {
        return departmentsEntity;
    }

    public void setDepartmentsEntity(DepartmentsEntity departmentsEntity) {
        this.departmentsEntity = departmentsEntity;
    }

}
