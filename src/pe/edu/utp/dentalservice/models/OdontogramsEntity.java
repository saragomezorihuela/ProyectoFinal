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

    public OdontogramsEntity() {
        super("ODONTOGRAMS");
    }

    public List<Odontogram> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Odontogram> findByCriteria(String sql) {
        List<Odontogram> odontograms = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Odontogram odontogram = Odontogram.build(rs, getToothsEntity(),  getStatesToothEntity());
                odontograms.add(odontogram);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontograms;
    }

    public Odontogram findById(int id) {
        String statement = "SELECT * FROM ODONTOGRAMS WHERE id = " +
                String.valueOf(id);
        List<Odontogram> odontograms = findByCriteria(statement);
        return odontograms != null ? odontograms.get(0) : null;
    }

    public Odontogram findByName(String name) {
        String statement = "SELECT * FROM ODONTOGRAMS WHERE observation = '" +
                name + "'";
        List<Odontogram> odontograms = findByCriteria(statement);
        return odontograms != null ? odontograms.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Odontogram create(int id, String observation, int tooth_id, int state_tooth_id) {
        String sql = "INSERT INTO ODONTOGRAMS(id, tooth_id, state_tooth_id, description) " +
                "VALUES(" + String.valueOf(id) + ", " + String.valueOf(tooth_id) + ", '" + ", " + String.valueOf(state_tooth_id) + ", '" + observation + "')";
        return updateByCriteria(sql) > 0 ? new Odontogram(id, observation, getToothsEntity().findById(tooth_id), getStatesToothEntity().findById(state_tooth_id)) : null;
    }

    public boolean update(Odontogram odontogram) {
        String sql = "UPDATE ODONTOGRAMS SET observation = '" + odontogram.getObservation() + "," +
                "' WHERE id = " + String.valueOf(odontogram.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM ODONTOGRAMS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }

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
