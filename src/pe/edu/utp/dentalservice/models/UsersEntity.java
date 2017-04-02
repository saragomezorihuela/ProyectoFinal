package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Rivas on 07/03/2017.
 */
public class UsersEntity extends BaseEntity{

    public List<User> findAll() {

        String sql = "SELECT * FROM dbdentalservice.users";
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                        resultSet.getString("usuario"),
                        resultSet.getString("clave"),
                        resultSet.getString("state")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }
/*
    public int getTurnsCount() {

        String sql = "SELECT COUNT(*) AS turns_count FROM dbdentalservice.users";
        int turnsCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) turnsCount = resultSet.getInt("turns_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turnsCount;

    }
*/
    public int getLogin(User user) {

        String sql = "SELECT COUNT(*) AS login_Count FROM dbdentalservice.users WHERE usuario = '" + user.getName() + "'" +
                    " AND clave = '" + user.getPassword() + "'" ;
        int loginCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            //if (resultSet.next()) loginCount = resultSet.getInt("login_Count");
            //loginCount = resultSet.next() ? resultSet.getInt("login_Count") : 0;
            if (resultSet.next()){
                loginCount = resultSet.getInt("login_Count");
            }
            else{
                loginCount = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginCount;

    }

    public int getIdProfile(User user) {

        String sql = "SELECT profile_id FROM dbdentalservice.users WHERE usuario = '" + user.getName() + "'";
        int ProfileId = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            //if (resultSet.next()) ProfileId = resultSet.getInt("profile_id");
            ProfileId = resultSet.next() ? resultSet.getInt("profile_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ProfileId;

    }
    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(User user,People people,int perfilId) {
        String sql = "INSERT INTO dbdentalservice.users(usuario,clave,state,person_id,profile_id) " +
                "VALUES('" + user.getName() + "','" + user.getPassword() + "','ACTIVO'," + String.valueOf(people.getId()) + "," + String.valueOf(perfilId) + ")";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(User user) {
        String sql = "UPDATE dbdentalservice.users SET usuario = '" + user.getName() + "','" +
                " clave = '" + user.getPassword() + "' " +
                " WHERE id = " + String.valueOf(user.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.users WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
