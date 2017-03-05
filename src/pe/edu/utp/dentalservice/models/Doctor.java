package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 24/02/2017.
 */
public class Doctor extends Person {

    private String CCO;

    public Doctor() {
        super();
    }

    public Doctor(int id, String dni, String firstname, String lastname, Date birthdate, String phone, String cellphone, String email, String CCO,
                  Hospital hospital, Gender gender, BloodType bloodType, IdentityCard identityCard) {

        super(id, dni, firstname, lastname, birthdate, phone, cellphone, email, hospital, gender, bloodType, identityCard);
        this.CCO = CCO;

    }

    public String getCCO() {
        return CCO;
    }

    public Doctor setCCO(String CCO) {
        this.CCO = CCO;
        return this;
    }

    public static Doctor build(ResultSet resultSet, HospitalsEntity hospitalEntity, GendersEntity gendersEntity,
                               BloodTypesEntity bloodTypesEntity, IdentityCardsEntity identityCardsEntity) {
        try {
            return new Doctor(resultSet.getInt("id"),
                            resultSet.getString("dni"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birth_date"),
                            resultSet.getString("phone"),
                            resultSet.getString("cellphone"),
                            resultSet.getString("email"),
                            resultSet.getString("CCO"),
                            hospitalEntity.findById(resultSet.getInt("hospital_id")),
                                    gendersEntity.findById(resultSet.getInt("gender_id")),
                                            bloodTypesEntity.findById(resultSet.getInt("blood_type_id")),
                                                    identityCardsEntity.findById(resultSet.getInt("identity_card_id"))
                    );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
