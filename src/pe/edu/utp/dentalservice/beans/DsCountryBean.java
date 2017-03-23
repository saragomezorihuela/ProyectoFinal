package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Country;
import pe.edu.utp.dentalservice.service.DsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex Aguilar on 19/03/2017.
 */
@ManagedBean(name = "countryBean", eager = true)
@SessionScoped
public class DsCountryBean {

    private DsService service;

    private Country country = new Country();

    public DsCountryBean() {
        try {
            InitialContext ctx = new InitialContext();
            Connection connection = ((DataSource) ctx
                    .lookup("jdbc/MySQLDataSourceDs"))
                    .getConnection();
            service = new DsService();
            service.setConnection(connection);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCountriesCount() {
        return service.getCountriesCount();
    }

    public List<Country> getCountries() { return service.findAllCountries(); }

    public String add(Country country) {
        service.addCountry(country);
        return "CountryList";
    }

    public String update(Country country) {
         service.updateCountry(country);
         return "CountryList";
    }

    public boolean delete(Country country) { return service.deleteCountry(country); }

    public String showCountriesCount() {
        if(getCountriesCount() > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    public Country getSelectedCountry() {
        return country;
    }

    public String edit(Country country) {
        this.country = country;
        return "CountryEdit";
    }

    public String listCountries() {
        return "success";
    }

}
