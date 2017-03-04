package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Rivas on 04/03/2017.
 */
public class ProfilesEntity extends BaseEntity{

    public ProfilesEntity() {
        super("PROFILE");
    }

    public List<Profile> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Profile> findByCriteria(String sql) {
        List<Profile> profiles = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Profile profile = Profile.build(rs);
                profiles.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    public Profile findById(int id) {
        String statement = "SELECT * FROM PROFILES WHERE id = " +
                String.valueOf(id);
        List<Profile> profiles = findByCriteria(statement);
        return profiles != null ? profiles.get(0) : null;
    }

    public Profile findByName(String name) {
        String statement = "SELECT * FROM PROFILES WHERE dscription = '" +
                name + "'";
        List<Profile> profiles = findByCriteria(statement);
        return profiles != null ? profiles.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Profile create(int id, String description, String state, String type, String url) {
        String sql = "INSERT INTO PROFILE(id, description, state, type, url) " +
                "VALUES(" + String.valueOf(id) + ", '" + description + "', '" + state + "', '" + type + "', '" + url + "')";
        return updateByCriteria(sql) > 0 ? new Profile(id, description, state, type, url) : null;
    }

    public boolean update(Profile profile) {
        String sql = "UPDATE PROFILES SET description = '" + profile.getDescription() + "," +
                "state = '" + profile.getState() + "," +
                "type = '" + profile.getType() + "," +
                "url = '" + profile.getUrl() +
                "' WHERE id = " + String.valueOf(profile.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM PROFILES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
