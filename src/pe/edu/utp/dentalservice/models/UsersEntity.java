package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Rivas on 07/03/2017.
 */
public class UsersEntity extends BaseEntity{

    private ProfilesEntity profilesEntity;

    public UsersEntity() {
        super("USERS");
    }

    public List<User> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<User> findByCriteria(String sql) {
        List<User> users = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                User user = User.build(rs, getProfilesEntity());
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findById(int id) {
        String statement = "SELECT * FROM USERS WHERE id = " +
                String.valueOf(id);
        List<User> users = findByCriteria(statement);
        return users != null ? users.get(0) : null;
    }

    public User findByName(String name) {
        String statement = "SELECT * FROM USERS WHERE name = '" +
                name + "'";
        List<User> users = findByCriteria(statement);
        return users != null ? users.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User create(int id, String name, String password, String state, int profileId) {
        String sql = "INSERT INTO USERS(id, profileId, name, password, state) " +
                "VALUES(" + String.valueOf(id) + "," + String.valueOf(profileId) + ", '" + name + ", '" + password + ", '" + state + "')";
        return updateByCriteria(sql) > 0 ? new User(id, name, password, state, getProfilesEntity().findById(profileId)) : null;
    }

    public boolean update(User user) {
        String sql = "UPDATE USERS SET name = '" + user.getName() + "," +
                    "password = '" + user.getPassword() + "," +
                    "state = '" + user.getState() +
                "' WHERE id = " + String.valueOf(user.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM USERS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public ProfilesEntity getProfilesEntity() {
        return profilesEntity;
    }

    public void setProfilesEntity(ProfilesEntity profilesEntity) {
        this.profilesEntity = profilesEntity;
    }
}
