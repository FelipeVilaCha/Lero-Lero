package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.model.Cursos;
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
public class CursosDisponiveis extends HttpServlet {
    
    private Conexao conexaoDB;
    private CursosDAO cursosDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        cursosDAO = new CursosDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        
        try {
            List<Cursos> cursosDisponiveis = cursosDAO.listarCursos();
            session.setAttribute("cursosDisponiveis", cursosDisponiveis);
            request.getRequestDispatcher("/ViewCursosDisponiveis").forward(request, response);         
        } catch (SQLException ex) {
            Logger.getLogger(MontaPlanoDeEstudos.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}