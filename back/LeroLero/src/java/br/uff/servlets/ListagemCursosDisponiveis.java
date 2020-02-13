package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Cursos;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
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
public class ListagemCursosDisponiveis extends HttpServlet {
    
    private Conexao conexaoDB;
    private CursosDAO cursosDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        cursosDAO = new CursosDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<Cursos> cursosDisponiveis = cursosDAO.listarCursosComTurmas();
            request.setAttribute("cursosDisponiveis", cursosDisponiveis);
            
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ListagemCursosDisponiveis.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        request.getRequestDispatcher("/courses.jsp").forward(request, response);
    }
}