package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Cursos;
import br.uff.model.Turmas;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class CursosTurmasDisponiveis extends HttpServlet {
    
    private Conexao conexaoDB;
    private CursosDAO cursosDAO;
    private TurmasDAO turmasDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        cursosDAO = new CursosDAO(conexaoDB);
        turmasDAO = new TurmasDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        
        try {
            List<Cursos> cursosDisponiveis = cursosDAO.listarCursosComTurmas();
            session.setAttribute("cursosDisponiveis", cursosDisponiveis);
            List<Turmas> turmasDisponiveis = turmasDAO.listarTurmasAbertas();
            session.setAttribute("turmasDisponiveis", turmasDisponiveis);
            
            response.sendRedirect("http://localhost:8080/LeroLero/modules/aluno/cursos-disponiveis.jsp");
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(CursosTurmasDisponiveis.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}