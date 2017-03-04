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
    private TreatmentTypesEntity treatmentTypesEntity;
    private StatesToothEntity statesToothEntity;
    private CountriesEntity countriesEntity;
    private ProfilesEntity profilesEntity;

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

    protected TreatmentTypesEntity getTreatmentTypesEntity() {
        if(connection != null) {
            if(treatmentTypesEntity == null) {
                treatmentTypesEntity = new TreatmentTypesEntity();
                treatmentTypesEntity.setConnection(getConnection());
            }
        }
        return treatmentTypesEntity;
    }

    protected void setTreatmentTypesEntity(TreatmentTypesEntity treatmentTypesEntity) {
        this.bloodTypesEntity = bloodTypesEntity;
    }

    protected StatesToothEntity getStatesToothEntity() {
        if(connection != null) {
            if(statesToothEntity == null) {
                statesToothEntity = new StatesToothEntity();
                statesToothEntity.setConnection(getConnection());
            }
        }
        return statesToothEntity;
    }

    protected void setStatesToothEntity(StatesToothEntity statesToothEntity) {
        this.statesToothEntity = statesToothEntity;
    }

    protected CountriesEntity getCountriesEntity() {
        if(connection != null) {
            if(countriesEntity == null) {
                countriesEntity = new CountriesEntity();
                countriesEntity.setConnection(getConnection());
            }
        }
        return countriesEntity;
    }

    protected void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }

    protected ProfilesEntity getProfilesEntity() {
        if(connection != null) {
            if(profilesEntity == null) {
                profilesEntity = new ProfilesEntity();
                profilesEntity.setConnection(getConnection());
            }
        }
        return profilesEntity;
    }

    protected void setProfilesEntity(ProfilesEntity profilesEntity) {
        this.profilesEntity = profilesEntity;
    }

}
