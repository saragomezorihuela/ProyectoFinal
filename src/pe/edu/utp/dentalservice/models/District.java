package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex Aguilar on 25/02/2017.
 */
public class District {

    private int id;
    private String description;

    private Province province;

    public District(int id, String description, Province province) {
        this.id = id;
        this.description = description;

        this.province = province;
    }

    public District() {
    }

    public int getId() {
        return id;
    }

    public District setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public District setDescription(String description) {
        this.description = description;
        return this;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public static District build(ResultSet resultSet, ProvincesEntity provincesEntity) {
        try {
            return new District(resultSet.getInt("id"),
                    resultSet.getString("description"),
                    provincesEntity.findById(resultSet.getInt("province_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
