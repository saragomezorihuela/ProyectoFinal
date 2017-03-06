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

    public District(int id, String description) {
        this.id = id;
        this.description = description;
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

    public static District build(ResultSet resultSet) {
        try {
            return new District(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
