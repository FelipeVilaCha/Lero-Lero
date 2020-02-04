package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.CursosDAO;
import br.uff.database.InstrutoresDAO;
import br.uff.database.MatriculasDAO;
import br.uff.database.TurmasDAO;
import br.uff.dominio.Cursos;
import br.uff.dominio.Instrutores;
import br.uff.dominio.Turmas;
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
public class TurmasDisponiveis extends HttpServlet {
    
    private Conexao conexaoDB;
    private MatriculasDAO matriculasDAO;
    private TurmasDAO turmasDAO;
    private InstrutoresDAO instrutoresDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        matriculasDAO = new MatriculasDAO(conexaoDB);
        turmasDAO = new TurmasDAO(conexaoDB);
        instrutoresDAO = new InstrutoresDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        int curso_id =  (Integer) session.getAttribute("cursoEscolhidoId");
        
        try {
            List<Turmas> turmasDisponiveis = turmasDAO.listarTurmasDisponiveis(curso_id);
            List<Instrutores> instrutores = instrutoresDAO.listarInstrutores();
            
            session.setAttribute("turmasDisponiveis", turmasDisponiveis);
            session.setAttribute("instrutores", instrutores);
            
            request.getRequestDispatcher("/ViewTurmasDisponiveis").forward(request, response);         
        } catch (SQLException ex) {
            Logger.getLogger(MontaPlanoDeEstudos.class.getName()).log(Level.SEVERE, ex.getMessage());
            /*request.getRequestDispatcher("/planoVazio.jsp").forward(request, response);*/
        } catch (ParseException ex) {
            Logger.getLogger(TurmasDisponiveis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}