package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
     * Created by Jonathan Rojas on 07/03/2017.
 */
public class Schedule {

    private int id;
    private Date start;
    private Date finish;

    private Turn turn;

    public Schedule(int id, Date start, Date finish, Turn turn) {
        this.id = id;
        this.start = start;
        this.finish = finish;

        this.turn = turn;
    }

    public Schedule() {
    }

    public int getId() {
        return id;
    }

    public Schedule setId(int id) {
        this.id = id;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public Schedule setStart(Date start) {
        this.start = start;
        return this;
    }

    public Date getFinish() {
        return finish;
    }

    public Schedule setFinish(Date finish) {
        this.finish = finish;
        return this;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public static Schedule build(ResultSet resultSet, TurnsEntity turnsEntity) {
        try {
            return new Schedule(resultSet.getInt("id"),
                    resultSet.getDate("start"),
                    resultSet.getDate("finish"),
                    turnsEntity.findById(resultSet.getInt("turn_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
