package pe.edu.utp.dentalservice.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rodrigo Rivas on 11/03/2017.
 */
public class Option {

    private int id;
    private String description;
    private String state;
    private String icon;
    private String url;
    private int order;
    private boolean enable;
    private int parent_id;

    public Option(int id, String description, String state, String icon, String url, int order, boolean enable, int parent_id) {

        this.id = id;
        this.description = description;
        this.state = state;
        this.icon = icon;
        this.url = url;
        this.order = order;
        this.enable = enable;
        this.parent_id = parent_id;

    }

    public Option() {
    }

    public int getId() {
        return id;
    }

    public Option setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Option setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getState() {
        return state;
    }

    public Option setState(String state) {
        this.state = state;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Option setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Option setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public Option setOrder(int order) {
        this.order = order;
        return this;
    }

    public Boolean getEnable() {
        return enable;
    }

    public Option setEnable(Boolean enable) {
        this.enable = enable;
        return this;
    }

    public int getParentId() {
        return order;
    }

    public Option setParentId(int parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public static Option build(ResultSet resultSet) {
        try {
            return new Option(resultSet.getInt("id"),
                    resultSet.getString("description"),
                    resultSet.getString("state"),
                    resultSet.getString("icon"),
                    resultSet.getString("url"),
                    resultSet.getInt("order"),
                    resultSet.getBoolean("enable"),
                    resultSet.getInt("parent_id")
                    );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
