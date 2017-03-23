package pe.edu.utp.dentalservice.models;

/**
 * Created by JUAN CARLOS on 23/03/2017.
 */
public class PeoplesEntity extends BaseEntity{
    private HospitalsEntity hospitalsEntity;
    private GendersEntity gendersEntity;
    private BloodTypesEntity bloodTypesEntity;
    private IdentityCardsEntity identityCardsEntity;
    private DistrictsEntity districtsEntity;

    public PeoplesEntity() {
        super("person");
    }

}
