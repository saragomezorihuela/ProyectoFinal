package pe.edu.utp.dentalservice.service;

import pe.edu.utp.dentalservice.models.*;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Sara Sheena on 28/02/2017.
 */
public class HrService {

    private Connection connection;
    private PersonEntity personEntity;
    private HospitalsEntity hospitalsEntity;
    private GendersEntity gendersEntity;
    private IdentityCardsEntity identityCardsEntity;
    private BloodTypesEntity bloodTypesEntity;

    public HrService() {
    }

    public HrService(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected PersonEntity getPersonEntity() {
        if(connection != null) {
            if(personEntity == null) {
                personEntity = new PersonEntity();
                personEntity.setConnection(getConnection());
            }
        }
        return personEntity;
    }

    protected HospitalsEntity getHospitalsEntity() {
        if(connection != null) {
            if(hospitalsEntity == null) {
                hospitalsEntity = new HospitalsEntity();
                hospitalsEntity.setConnection(getConnection());
            }
        }
        return hospitalsEntity;
    }

    protected void setHospitalsEntity(HospitalsEntity hospitalsEntity) {
        this.hospitalsEntity = hospitalsEntity;
    }

    protected GendersEntity getGendersEntity() {
        if(connection != null) {
            if(gendersEntity == null) {
                gendersEntity = new GendersEntity();
                gendersEntity.setConnection(getConnection());
            }
        }
        return gendersEntity;
    }

    protected void setGendersEntity(GendersEntity gendersEntity) {
        this.gendersEntity = gendersEntity;
    }
    protected IdentityCardsEntity getIdentityCardsEntity() {
        if(connection != null) {
            if(identityCardsEntity == null) {
                identityCardsEntity = new IdentityCardsEntity();
                identityCardsEntity.setConnection(getConnection());
            }
        }
        return identityCardsEntity;
    }

    protected void setIdentityCardsEntity(IdentityCardsEntity identityCardsEntity) {
        this.identityCardsEntity = identityCardsEntity;
    }

    protected BloodTypesEntity getBloodTypesEntity() {
        if(connection != null) {
            if(bloodTypesEntity == null) {
                bloodTypesEntity = new BloodTypesEntity();
                bloodTypesEntity.setConnection(getConnection());
            }
        }
        return bloodTypesEntity;
    }

    protected void setBloodTypesEntity(BloodTypesEntity bloodTypesEntity) {
        this.bloodTypesEntity = bloodTypesEntity;
    }

}
