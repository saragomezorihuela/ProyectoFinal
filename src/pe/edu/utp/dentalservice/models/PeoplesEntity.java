package pe.edu.utp.dentalservice.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JUAN CARLOS on 23/03/2017.
 */
public class PeoplesEntity extends BaseEntity{

    public List<People> findAll() {

        String sql = "SELECT * FROM dbdentalservice.people";
        ResultSet resultSet = null;
        List<People> peoples = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                peoples.add(new People(resultSet.getInt("id"),
                        resultSet.getString("nroDocumento"),
                        resultSet.getString("firs_tname"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("phone"),
                        resultSet.getString("cellphone"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;

    }

    public People findPeople(String user) {

        String sql = "SELECT p.* FROM dbdentalservice.people p INNER JOIN dbdentalservice.users u ON p.id = u.person_id WHERE u.usuario = 'jcurillo'";

        People people = new People();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) { new People(resultSet.getInt("id"),
                    resultSet.getString("nroDocumento"),
                    resultSet.getString("firs_tname"),
                    resultSet.getString("last_name"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("phone"),
                    resultSet.getString("cellphone"),
                    resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) { new People(resultSet.getInt("id"),
                        resultSet.getString("nroDocumento"),
                        resultSet.getString("firs_tname"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("phone"),
                        resultSet.getString("cellphone"),
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
        return people;

    }

    public int getPeoplesCount() {

        String sql = "SELECT COUNT(*) AS peoples_count FROM dbdentalservice.people";
        int peoplesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) peoplesCount = resultSet.getInt("peoples_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoplesCount;

    }

    public int getPeopleId() {

        String sql = "SELECT MAX(id) AS peopleId FROM dbdentalservice.people";
        int peopleId = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) peopleId = resultSet.getInt("peopleId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleId;

    }

    public String getPeopleName(User user) {

        String sql = "SELECT CONCAT(first_name , ' ',last_name) AS NombreCompleto FROM dbdentalservice.people p INNER JOIN dbdentalservice.users u ON p.id = u.person_id WHERE u.usuario = '" + user.getName() + "'";
        String Nombre = "";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) Nombre = resultSet.getString("NombreCompleto");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Nombre;

    }

    public int getIdHospital(String user) {

        String sql = "SELECT p.hospital_id as IdHospital FROM dbdentalservice.people p INNER JOIN dbdentalservice.users u ON p.id = u.person_id WHERE u.usuario = '" + user + "'";
        int id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) id = resultSet.getInt("IdHospital");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(People people, IdentityCard identityCard, Gender gender, Hospital hospital) {
        String sql = "INSERT INTO dbdentalservice.people(nroDocumento, first_name, last_name, birth_date, phone," +
                                                        "cellphone, email, hospital_id, blood_type_id, identity_card_id, " +
                                                        "distrit_id, gender_id) " +
                "VALUES('" + people.getNroDocumento() + "','" + people.getFirstname() + "','" + people.getLastname() +
                        "','1980-02-01','" + people.getPhone() + "','" + people.getCellphone() + "','" +  people.getEmail() +
                        "'," + hospital.getId() + ",1," + identityCard.getId() + ",1," + gender.getId() + ")";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(People people) {
        String sql = "UPDATE dbdentalservice.people SET nroDocumento = '" + people.getNroDocumento() + "'" +
                " WHERE id = " + String.valueOf(people.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.people WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
