package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.dao.InstrutoresDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Cursos;
import br.uff.model.Instrutores;
import br.uff.model.Turmas;
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
public class ListaCursosInstrutor extends HttpServlet {
    
    private Conexao conexaoDB;
    private CursosDAO cursosDAO;
    private InstrutoresDAO instrutoresDAO;
    private TurmasDAO turmasDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        cursosDAO = new CursosDAO(conexaoDB);
        conexaoDB = new Conexao();
        instrutoresDAO = new InstrutoresDAO(conexaoDB);
        turmasDAO = new TurmasDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            List<Cursos> listaCursos = cursosDAO.listarCursos();
            session.setAttribute("listaCursos", listaCursos);
            
            List<Instrutores> listaInstrutores = instrutoresDAO.listarInstrutores();
            session.setAttribute("listaInstrutores", listaInstrutores);
            
            List<Turmas> listaTurmas = turmasDAO.listarTurmas();
            session.setAttribute("listaTurmas", listaTurmas);
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaCursosInstrutor.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/cursos-instrutores-table.jsp");
    }
}