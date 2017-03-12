package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Jonathan Rojas on 12/03/2017.
 */
public class Appoinment {

    private int id;
    private Date date;

    private Doctor doctor;
    private Patient patient;

    public Appoinment(int id, Date date) {
        this.id = id;
        this.date = date;

        //this.doctor = doctor;
        //this.patient = patient;
    }

    public Appoinment() {
    }

    public int getId() {
        return id;
    }

    public Appoinment setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Appoinment setDate(Date date) {
        this.date = date;
        return this;
    }

    public static Appoinment build(ResultSet resultSet) {
        try {
            return new Appoinment(resultSet.getInt("id"),
                    resultSet.getDate("date"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
