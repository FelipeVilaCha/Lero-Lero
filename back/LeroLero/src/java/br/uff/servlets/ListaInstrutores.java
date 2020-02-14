package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
import br.uff.model.Instrutores;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
public class ListaInstrutores extends HttpServlet {
    
    private Conexao conexaoDB;
    private InstrutoresDAO instrutoresDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutoresDAO = new InstrutoresDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            List<Instrutores> listaInstrutores = instrutoresDAO.listarInstrutores();
            session.setAttribute("listaInstrutores", listaInstrutores);
        } catch (SQLException ex) {
            Logger.getLogger(ListaInstrutores.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/instrutor-table.jsp");
    }
}