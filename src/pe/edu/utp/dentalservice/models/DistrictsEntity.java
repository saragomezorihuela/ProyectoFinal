package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Aguilar  on 06/03/2017.
 */
public class DistrictsEntity extends BaseEntity {
/*
    private ProvincesEntity provincesEntity;

    public DistrictsEntity() {
        super("DISTRICTS");
    }

    public List<District> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<District> findByCriteria(String sql) {
        List<District> districts = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                District district = District.build(rs, getProvincesEntity());
                districts.add(district);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return districts;
    }

    public District findById(int id) {
        String statement = "SELECT * FROM DISTRICTS WHERE id = " +
                String.valueOf(id);
        List<District> districts = findByCriteria(statement);
        return districts != null ? districts.get(0) : null;
    }

    public District findByName(String name) {
        String statement = "SELECT * FROM DISTRICTS WHERE description = '" +
                name + "'";
        List<District> districts = findByCriteria(statement);
        return districts != null ? districts.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public District create(int id, String description, int province_id) {
        String sql = "INSERT INTO DISTRICTS(id, province_id, description) " +
                "VALUES(" + String.valueOf(id) + ", " + String.valueOf(province_id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new District(id, description, getProvincesEntity().findById(province_id)) : null;
    }

    public boolean update(District district) {
        String sql = "UPDATE DISTRICTS SET description = '" + district.getDescription() + "," +
                "' WHERE id = " + String.valueOf(district.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM DISTRICTS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public ProvincesEntity getProvincesEntity() {
        return provincesEntity;
    }

    public void setProvincesEntity(ProvincesEntity provincesEntity) {
        this.provincesEntity = provincesEntity;
    }
*/
}
