package pe.edu.utp.dentalservice.models;

import com.sun.org.apache.xpath.internal.operations.String;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by SARA SHEENA on 04/03/2017.
 */
public class Gender {

    private int id;
    private String description;

      public Gender(int id, java.lang.String description){}

    public Gender(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public Gender setId(int id){
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Gender setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Gender build(ResultSet resultSet) {
        try {
            return new Gender(resultSet.getInt("id"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
