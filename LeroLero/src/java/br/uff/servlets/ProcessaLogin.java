package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.LoginDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author FelipeVilaChadosSant
 */
public class ProcessaLogin extends HttpServlet {
    
    private LoginDAO login;
    private Conexao conexaoDB;
    
    public void init() {
        String jdbcURL = "jdbc:derby://localhost:1527/LeroLero";
        String jdbcUsername = "felipe";
        String jdbcPassword = "";
        
        conexaoDB = new Conexao(jdbcURL, jdbcUsername, jdbcPassword);
        login = new LoginDAO(conexaoDB);
    }
 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            /*String user = (String) request.getAttribute("username");
            String senha = (String) request.getAttribute("senha");*/
            String user = request.getParameter("username");
            String senha = request.getParameter("senha");
            String permissao = "alunos";
            
            Boolean status = login.validaLogin(user, senha, permissao);
            
            if(status == true){
                request.getRequestDispatcher("/LeroLero/home.html").forward(request, response);
            } else {
                request.getRequestDispatcher("/LeroLero").include(request, response);
            }
        } catch (SQLException ex) {
            request.getRequestDispatcher("/LeroLero/home.html").forward(request, response);
        }
    }
}
