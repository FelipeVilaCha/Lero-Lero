package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.LoginDAO;
import br.uff.model.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProcessaLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String url;
        private LoginDAO login;
        private Conexao conexaoDB;
        
        @Override
        public void init() {
            conexaoDB = new Conexao();
            login = new LoginDAO(conexaoDB);
        }        

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            
            Usuario usuario = null;
            
            String user = request.getParameter("login");
            String senha = request.getParameter("senha");
            String permissao = request.getParameter("permissao");
            
            EncriptaSenha enc = new EncriptaSenha();
            String senhaEncriptada = enc.novaSenha(senha);
            
            try {
                usuario = login.validaLogin(user, senhaEncriptada, permissao);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(usuario != null){
                int userID = usuario.getId();
                session.setAttribute("userID", userID);
                session.setAttribute("permissao", permissao);
            } else {
                String errorMessage = "Error: Unrecognized Username or Password<br>";
                session.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }

	public void logout(HttpSession session) {
            session.invalidate();
	}
}
