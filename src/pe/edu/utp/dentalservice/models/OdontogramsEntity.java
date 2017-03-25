package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Rojas on 12/03/2017.
 */
public class OdontogramsEntity extends BaseEntity{

    private ToothsEntity toothsEntity;
    private StatesToothEntity statesToothEntity;


    public ToothsEntity getToothsEntity() {
        return toothsEntity;
    }

    public void setToothsEntity(ToothsEntity toothsEntity) {
        this.toothsEntity = toothsEntity;
    }

    public StatesToothEntity getStatesToothEntity() {
        return statesToothEntity;
    }

    public void setStatesToothEntity(StatesToothEntity statesToothEntity) {
        this.statesToothEntity = statesToothEntity;
    }

}
