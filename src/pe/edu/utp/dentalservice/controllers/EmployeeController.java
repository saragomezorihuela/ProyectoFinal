package pe.edu.utp.dentalservice.controllers;

import pe.edu.utp.dentalservice.models.Employee;

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
 * Created by Sara Sheena on 24/02/2017.
 */
@WebServlet(name = "EmployeeController", urlPatterns = "/employee")
public class EmployeeController  extends HttpServlet{

}
