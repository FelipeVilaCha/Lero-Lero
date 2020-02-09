package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
import br.uff.dao.MatriculasDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Instrutores;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        int cursoID =  (Integer) session.getAttribute("cursoEscolhidoID");
        
        try {
            List<Turmas> turmasDisponiveis = turmasDAO.listarTurmasDisponiveis(cursoID);
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