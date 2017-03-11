package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Rivas on 11/03/2017.
 */
public class OptionsEntity extends BaseEntity{

    public OptionsEntity() {
        super("OPTIONS");
    }

    public List<Option> findAll() {
        String statement = getDefaultStatement() + getTableName();
        return findByCriteria(statement);
    }

    private List<Option> findByCriteria(String sql) {
        List<Option> options = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
                Option option = Option.build(rs);
                options.add(option);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return options;
    }

    public Option findById(int id) {
        String statement = "SELECT * FROM OPTIONS WHERE id = " +
                String.valueOf(id);
        List<Option> options = findByCriteria(statement);
        return options != null ? options.get(0) : null;
    }

    public Option findByName(String name) {
        String statement = "SELECT * FROM OPTIONS WHERE dscription = '" +
                name + "'";
        List<Option> options = findByCriteria(statement);
        return options != null ? options.get(0) : null;
    }

    private int updateByCriteria(String sql) {
        try {
            return getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Option create(int id, String description, String state, String icon, String url, int order, boolean enable, int parent_id) {
        String sql = "INSERT INTO OPTIONS(id, parent_id, description, state, icon, url, order, enable) " +
                "VALUES(" + String.valueOf(id) + ", " + String.valueOf(parent_id) + ", '" + description + "', '" + state + "', '" + icon + "', '" + url + "', " + String.valueOf(parent_id) + ", " + enable + ", " + String.valueOf(parent_id) + ")";
        return updateByCriteria(sql) > 0 ? new Option(id, description, state, icon, url, order, enable, parent_id) : null;
    }

    public boolean update(Option option) {
        String sql = "UPDATE OPTIONS SET description = '" + option.getDescription() + "," +
                "state = '" + option.getState() + "," +
                "icon = '" + option.getIcon() + "," +
                "url = '" + option.getUrl() + "," +
                "order = '" + option.getOrder() + "," +
                "enable = '" + option.getEnable() + "," +
                "parent_id = '" + option.getParentId() +
                "' WHERE id = " + String.valueOf(option.getId());
        return updateByCriteria(sql) > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM OPTIONS WHERE id = " + String.valueOf(id);
        return updateByCriteria(sql) > 0;
    }
}
