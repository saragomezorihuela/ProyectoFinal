package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Schedule;
import pe.edu.utp.dentalservice.models.Turn;
import pe.edu.utp.dentalservice.service.DsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jonathan Rojas on 19/03/2017.
 */
@ManagedBean(name = "scheduleBean", eager = true)
@SessionScoped
public class DsScheduleBean {

    private DsService service;

    private int id;

    private Schedule schedule = new Schedule();

    public DsScheduleBean() {
        try {
            InitialContext ctx = new InitialContext();
            Connection connection = ((DataSource) ctx
                    .lookup("jdbc/MySQLDataSourceDs"))
                    .getConnection();
            service = new DsService();
            service.setConnection(connection);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSchedulesCount() {
        return service.getSchedulesCount();
    }

    public List<Schedule> getSchedules() { return service.findAllSchedules(); }

    public String add(Schedule schedule, Turn turn) {
        service.addSchedule(schedule, turn);
        return "ScheduleList";
    }

    public String update(Schedule schedule) {
         service.updateSchedule(schedule);
         return "ScheduleList";
    }

    public boolean delete(Schedule turn) { return service.deleteSchedule(schedule); }

    public String showSchedulesCount() {
        if(getSchedulesCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Schedule getSelectedSchedule() {
        return schedule;
    }

    public String edit(Schedule schedule) {
        this.schedule = schedule;
        return "ScheduleEdit";
    }

    public String listSchedules() {
        return "success";
    }

}
