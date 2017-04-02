package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.*;
import pe.edu.utp.dentalservice.models.User;
import pe.edu.utp.dentalservice.service.DsService;
import pe.edu.utp.dentalservice.beans.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 * Created by Jonathan Rojas on 19/03/2017.
 */
@ManagedBean(name = "userBean", eager = true)
@SessionScoped
public class DsUserBean {

    private DsService service;
    private DsPatientBean BeanPatient;

    private User user = new User();
    //private People people = new People();

    public DsUserBean() {
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

    public People getSelectedPeople(String user) {
        return service.findPeople(user);
    }

    public String login(User user) {

        int i;
        String fulname = "";
        String hospitalname = "";
        String url = "";
        People people;
        i = service.loginUser(user);
        fulname = service.GetFullName(user);
        hospitalname = service.GetHospitalName(user);
        //people = service.findPeople(user.getName());

        HttpSession session = SessionUtils.getSession();
        session.setAttribute("id", user.getName());
        HttpSession session1 = SessionUtils.getSession();
        session1.setAttribute("username", fulname);
        HttpSession session2 = SessionUtils.getSession();
        session2.setAttribute("hospitalname", hospitalname);

        if(i==0){

            url = "NoLogin";
        }
        else {

            int p=0;
            p = service.profileUser(user);

            if(p==4){

                url = "HospitalList";
            }
            else if(p==1){

                url = "DoctorList";
            }
            else if(p==3){
                //this.people = getSelectedPeople(user.getName());
                url = "DatosPersonales";//BeanPatient.GetPeople(user.getName());
            }

        }

        return url;
    }

}
