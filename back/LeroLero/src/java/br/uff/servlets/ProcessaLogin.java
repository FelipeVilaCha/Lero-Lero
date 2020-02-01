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
            String user = request.getParameter("username");
            String senha = request.getParameter("senha");
            String permissao = request.getParameter("permissao");
            
            boolean status = login.validaLogin(user, senha, permissao);
            /*int id = login.getConexaoID(user, senha, permissao);*/
            
            if(status == true){
                request.setAttribute("permissao", permissao);
                request.setAttribute("status", status);
                /*request.setAttribute("id", id);*/
                String nivel = "";
                
                switch (permissao) {
                    case "alunos":
                        nivel = "Aluno"; 
                        break;
                    case "administrador":
                        nivel = "Admin"; 
                        break;
                    case "instrutores":
                        nivel = "Instrutores"; 
                        break;
                }
                
                request.getRequestDispatcher("/Controller" + nivel).forward(request, response);
            } else {
                request.getRequestDispatcher("/RealizaLogin").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
    }
}
