package br.uff.servlets;

import br.uff.database.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class Login extends HttpServlet {
    
    private LoginDAO login;
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        login = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String user = request.getParameter("login");
            String senha = request.getParameter("senha");
            String permissao = request.getParameter("permissao");
            
            Boolean status = login.validaLogin(user, senha, permissao);
            
            if(status == true){
                request.getRequestDispatcher("/home.html").include(request, response);
            } else {
                request.getRequestDispatcher("/LeroLero").forward(request, response);
            }
        } catch (SQLException ex) {
            request.getRequestDispatcher("/Erro").forward(request, response);
        }
    }
}
