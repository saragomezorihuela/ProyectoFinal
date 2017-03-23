package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class GendersEntity extends BaseEntity{

    public List<Gender> findAll() {

        String sql = "SELECT * FROM dbdentalservice.genders";
        ResultSet resultSet = null;
        List<Gender> genders = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                genders.add(new Gender(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genders;

    }

    public int getGendersCount() {

        String sql = "SELECT COUNT(*) AS genders_count FROM dbdentalservice.genders";
        int regionsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) regionsCount = resultSet.getInt("genders_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regionsCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Gender gender) {
        String sql = "INSERT INTO dbdentalservice.genders(description) " +
                "VALUES('" + gender.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Gender gender) {
        String sql = "UPDATE dbdentalservice.genders SET description = '" + gender.getDescription() + "'" +
                " WHERE id = " + String.valueOf(gender.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.genders WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
