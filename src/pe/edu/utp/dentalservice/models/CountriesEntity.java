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

    public CountriesEntity() {
        super("COUNTRIES");
    }

    public List<Country> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Country> findByCriteria(String sql) {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Country country = Country.build(rs);
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }


    public Country findById(int id) {
        String statement = "SELECT * FROM COUNTRIES WHERE id = " +
                String.valueOf(id);
        List<Country> countries = findByCriteria(statement);
        return countries != null ? countries.get(0) : null;
    }

    public Country findByName(String name) {
        String statement = "SELECT * FROM COUNTRIES WHERE description = '" +
                name + "'";
        List<Country> countries = findByCriteria(statement);
        return countries != null ? countries.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Country create(int id, String description) {
        String sql = "INSERT INTO COUNTRIES(id, description) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "')";
        return updateByCriteria(sql) > 0 ? new Country(id, description) : null;
    }

    public boolean update(Country country) {
        String sql = "UPDATE COUNTRIES SET description = '" + country.getDescription() + "," +
                "' WHERE id = " + String.valueOf(country.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM COUNTRIES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
