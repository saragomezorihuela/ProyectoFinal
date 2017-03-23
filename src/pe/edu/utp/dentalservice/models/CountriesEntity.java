package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Aguilar on 04/03/2017.
 */
public class CountriesEntity extends BaseEntity{

    public List<Country> findAll() {

        String sql = "SELECT * FROM dbdentalservice.countries";
        ResultSet resultSet = null;
        List<Country> turns = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                turns.add(new Country(resultSet.getInt("id"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turns;

    }

    public int getCountriesCount() {

        String sql = "SELECT COUNT(*) AS countries_count FROM dbdentalservice.countries";
        int countriesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) countriesCount = resultSet.getInt("countries_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countriesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Country country) {
        String sql = "INSERT INTO dbdentalservice.countries(description) " +
                "VALUES('" + country.getDescription() + "')";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Country country) {
        String sql = "UPDATE dbdentalservice.countries SET description = '" + country.getDescription() + "'" +
                " WHERE id = " + String.valueOf(country.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.countries WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
