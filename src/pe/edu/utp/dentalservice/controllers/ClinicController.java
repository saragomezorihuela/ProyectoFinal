package pe.edu.utp.dentalservice.controllers;

import pe.edu.utp.dentalservice.models.Clinic;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex Aguillar  on 24/02/2017.
 */
@WebServlet(name = "ClinicController", urlPatterns = "/clinic")
public class ClinicController extends HttpServlet{

    private void processRequest(String httpMethod,
                                HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "index.jsp";

        if(httpMethod == "Get" && action == null) action = "index";
        if(httpMethod == "Post" && action == null) action = "create";
        if(httpMethod == "Post" && action != "create") return;
        if(httpMethod == "Get" && action == "create") return;
        if(action.equalsIgnoreCase("index")) {
            try {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
                Connection con = ds.getConnection();

                HttpSession session = request.getSession(true);


            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action.equalsIgnoreCase("show")) {
            try {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
                Connection con = ds.getConnection();


            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);

    }
}
