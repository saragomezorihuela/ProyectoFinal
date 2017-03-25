package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jonathan Rojas on 12/03/2017.
 */
public class Odontogram {

    private int id;
    private String observation;

    private Tooth tooth;
    private StateTooth stateTooth;

    public Odontogram(int id, String observation, Tooth tooth, StateTooth stateTooth) {
        this.id = id;
        this.observation = observation;

        this.tooth = tooth;
        this.stateTooth = stateTooth;
    }

    public Odontogram() {
    }

    public int getId() {
        return id;
    }

    public Odontogram setId(int id) {
        this.id = id;
        return this;
    }

    public String getObservation() {
        return observation;
    }

    public Odontogram setObservation(String observation) {
        this.observation = observation;
        return this;
    }

}
