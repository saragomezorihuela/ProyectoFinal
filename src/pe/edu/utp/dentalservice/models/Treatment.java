package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DE LA CRUZ on 14/03/2017.
 */
public class Treatment {

    private int id;
    private String description;
    private float cost;
    private int sessionCount;

    private TreatmentType treatmentType;

    public Treatment(int id, String description, float cost, int sessionCount, TreatmentType treatmentType){

        this.id = id;
        this.description = description;
        this.cost = cost;
        this.sessionCount = sessionCount;

        this.treatmentType = treatmentType;

    }

    public Treatment() {
    }

    public int getId() {
        return id;
    }

    public Treatment setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Treatment setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getCost(){return cost;}

    public Treatment setCost(float cost){
        this.cost = cost;
        return this;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public Treatment setSessionCount(int sessionCount) {
        this.sessionCount = sessionCount;
        return this;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public static Treatment build(ResultSet resultSet, TreatmentTypesEntity treatmentTypesEntity) {
        try {
            return new Treatment(resultSet.getInt("id"),
                    resultSet.getString("description"),
                    resultSet.getFloat("cost"),
                    resultSet.getInt("sessioncount"),
                    treatmentTypesEntity.findById(resultSet.getInt("type_treatment_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
