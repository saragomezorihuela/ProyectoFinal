package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Rojas on 07/03/2017.
 */
public class SchedulesEntity extends BaseEntity{

    public List<Schedule> findAll() {

        String sql = "SELECT * FROM dbdentalservice.schedules";
        ResultSet resultSet = null;
        List<Schedule> schedules = new ArrayList<>();
        try {
            resultSet = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                schedules.add(new Schedule(resultSet.getInt("id"),
                        resultSet.getString("start"),
                        resultSet.getString("finish")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;

    }

    public int getSchedulesCount() {

        String sql = "SELECT COUNT(*) AS schedules_count FROM dbdentalservice.schedules";
        int schedulesCount = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next()) schedulesCount = resultSet.getInt("schedules_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedulesCount;

    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Schedule schedule, Turn turn) {
        String sql = "INSERT INTO dbdentalservice.schedules(start,finish,idTurn) " +
                "VALUES('" + schedule.getStart() + "','" + schedule.getFinish() + "'," + String.valueOf(turn.getId()) + ")";
        return updateByCriteria(sql) > 0;

    }
    public boolean update(Schedule schedule) {
        String sql = "UPDATE dbdentalservice.schedules SET start = '" + schedule.getStart() + "','" +
                "finish = '" + schedule.getFinish() + "'" +
                " WHERE id = " + String.valueOf(schedule.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM dbdentalservice.schedules WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

}
