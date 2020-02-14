package br.uff.servlets;

import br.uff.dao.AdministradorDAO;
import br.uff.dao.Conexao;
import br.uff.model.Administrador;
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
public class ControllerAdmin extends HttpServlet {
    
    private AdministradorDAO adminDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        adminDAO = new AdministradorDAO(conexaoDB);    
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        
        Administrador adminLogado = null;
        
        try {
            adminLogado = adminDAO.getAdmin(userID);
            session.setAttribute("adminLogadoLogado", adminLogado);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/index.jsp");
    }
}