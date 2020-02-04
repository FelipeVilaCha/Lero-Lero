package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.LoginDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author FelipeVilaChadosSant
 */
public class ProcessaLogin extends HttpServlet {
    
    private LoginDAO login;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        login = new LoginDAO(conexaoDB);
    }
 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession();
            
            String user = request.getParameter("login");
            String senha = request.getParameter("senha");
            String permissao = request.getParameter("permissao");
            
            boolean adminUser = login.validaLoginAdmin(user, senha);
            
            int id = login.getConexaoID(user, senha, permissao);
            session.setAttribute("id", id);
            
            if(adminUser){
                request.getRequestDispatcher("/ControllerAdmin").include(request, response);
            }
            
            boolean status = login.validaLogin(user, senha, permissao);
            
            if(status) {
                session.setAttribute("permissao", permissao);
                String nivel = "";
                
                switch (permissao) {
                    case "alunos":
                        nivel = "Aluno"; 
                        break;
                    case "instrutores":
                        nivel = "Instrutores"; 
                        break;
                }
                
                request.getRequestDispatcher("/Controller" + nivel).include(request, response);
            } else {
                request.getRequestDispatcher("/index.html").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
    }
}
