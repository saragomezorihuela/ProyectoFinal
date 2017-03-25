package pe.edu.utp.dentalservice.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
     * Created by Jonathan Rojas on 07/03/2017.
 */

@ManagedBean
@RequestScoped
public class Schedule {

    private int id;
    private String start;
    private String finish;

    private Turn turn;

    public Schedule(int id, String start, String finish) {
        this.id = id;
        this.start = start;
        this.finish = finish;

    }

    public Schedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getSchedule() {
        return start + " - " + finish;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

}