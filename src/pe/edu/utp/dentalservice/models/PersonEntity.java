package pe.edu.utp.dentalservice.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 * Created by Sara Sheena on 25/02/2017.
 */
public class PersonEntity extends BaseEntity{

    private HospitalsEntity hospitalsEntity;
    private GendersEntity gendersEntity;
    private BloodTypesEntity bloodTypesEntity;
    private IdentityCardsEntity identityCardsEntity;
    private DistrictsEntity districtsEntity;

    public PersonEntity() {
        super("person");
    }


    public List<Person> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Person> findByCriteria(String sql) {
        List<Person> persons = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Person person = Person.build(rs, getHospitalsEntity(), getBloodTypesEntity(), getIdentityCardsEntity(), getDistrictsEntity(), getGendersEntity());
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public Person findById(int id) {
        String statement = "SELECT * FROM people WHERE id = " +
                String.valueOf(id);
        List<Person> persons = findByCriteria(statement);
        return persons != null ? persons.get(0) : null;
    }

    public Person findByDNI(String dni) {
        String statement = "SELECT * FROM people WHERE dni = '" +
                dni + "'";
        List<Person> persons = findByCriteria(statement);
        return persons != null ? persons.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Person create(int id, String dni, String first_name, String last_name, Date birth_date,
                         String phone, String cellphone,String email, int hospital_id, int blood_type_id,
                         int identity_card_id, int distrit_id, int gender_id) {
        String sql = "INSERT INTO people(id, dni, first_name, last_name, birth_date, phone, cellphone, email, " +
                    "hospital_id, blood_type_id, identity_card_id, distrit_id, gender_id) " +
                "VALUES(" + String.valueOf(id) + ", '" + dni + "', '" + first_name + "', '" + last_name + "', '" +
                            birth_date + "','" + phone + "','" + cellphone + "','" + email + "','" + String.valueOf(hospital_id) + "', '" +
                            String.valueOf(gender_id) + "', '" + String.valueOf(blood_type_id) + "', '" +
                            String.valueOf(identity_card_id) + "', '" + String.valueOf(distrit_id) + "')";
        return updateByCriteria(sql) > 0 ? new Person(id, dni, first_name, last_name, birth_date, phone, cellphone, email,
                 getHospitalsEntity().findById(hospital_id),getGendersEntity().findById(gender_id),
                 getBloodTypesEntity().findById(blood_type_id),getIdentityCardsEntity().findById(identity_card_id),
                getDistrictsEntity().findById(distrit_id)) : null;
    }

    public boolean update(Person person) {
        String sql = "UPDATE people SET dni = '" + person.getDni() +
                "' WHERE id = " + String.valueOf(person.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM people WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }


    public HospitalsEntity getHospitalsEntity() {
        return hospitalsEntity;
    }

    public void setHospitalsEntity(HospitalsEntity hospitalsEntity) {
        this.hospitalsEntity = hospitalsEntity;
    }

    public GendersEntity getGendersEntity() {
        return gendersEntity;
    }

    public void setGendersEntity(GendersEntity gendersEntity) {
        this.gendersEntity = gendersEntity;
    }


    public BloodTypesEntity getBloodTypesEntity() {
        return bloodTypesEntity;
    }

    public void setBloodTypesEntity(BloodTypesEntity bloodTypesEntity) {
        this.bloodTypesEntity = bloodTypesEntity;
    }

    public IdentityCardsEntity getIdentityCardsEntity() {
        return identityCardsEntity;
    }

    public void setIdentityCardsEntity(IdentityCardsEntity identityCardsEntity) {
        this.identityCardsEntity = identityCardsEntity;
    }

    public DistrictsEntity getDistrictsEntity() {
        return districtsEntity;
    }

    public void setDistrictsEntity(DistrictsEntity districtsEntity) {
        this.districtsEntity = districtsEntity;
    }
}
