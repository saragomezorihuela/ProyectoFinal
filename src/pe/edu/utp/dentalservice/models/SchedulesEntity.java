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

    private TurnsEntity turnsEntity;

    public SchedulesEntity() {
        super("SCHEDULES");
    }

    public List<Schedule> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Schedule> findByCriteria(String sql) {
        List<Schedule> schedules = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Schedule schedule = Schedule.build(rs, getTurnsEntity());
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public Schedule findById(int id) {
        String statement = "SELECT * FROM SCHEDULES WHERE id = " +
                String.valueOf(id);
        List<Schedule> schedules = findByCriteria(statement);
        return schedules != null ? schedules.get(0) : null;
    }

    public Schedule findByName(String name) {
        String statement = "SELECT * FROM SCHEDULES WHERE observation = '" +
                name + "'";
        List<Schedule> schedules = findByCriteria(statement);
        return schedules != null ? schedules.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Schedule create(int id, Date start, Date finish, int turn_id) {
        String sql = "INSERT INTO SCHEDULES(id, turn_id, start, finish) " +
                "VALUES(" + String.valueOf(id) + ", " + String.valueOf(turn_id) + ", '" + start + "', '" + finish + "')";
        return updateByCriteria(sql) > 0 ? new Schedule(id, start, finish, getTurnsEntity().findById(turn_id)) : null;
    }

    public boolean update(Schedule schedule) {
        String sql = "UPDATE SCHEDULES SET start = '" + schedule.getStart() + "," +
                    "finish = '" + schedule.getFinish() +
                "' WHERE id = " + String.valueOf(schedule.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM SCHEDULES WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

    public TurnsEntity getTurnsEntity() {
        return turnsEntity;
    }

    public void setTurnsEntity(TurnsEntity turnsEntity) {
        this.turnsEntity = turnsEntity;
    }

}
