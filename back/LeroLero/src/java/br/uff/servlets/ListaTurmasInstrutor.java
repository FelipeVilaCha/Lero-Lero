package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.TurmasDAO;
import br.uff.model.Turmas;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ListaTurmasInstrutor extends HttpServlet {
    
    private TurmasDAO turmasDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        turmasDAO = new TurmasDAO(conexaoDB);
    }
 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        Map<String, String> mensagens = new HashMap<>();
        
        try {
            List<Turmas> turmasInstrutor = turmasDAO.listarTurmasPorInstrutor(userID);
            session.setAttribute("turmasInstrutor", turmasInstrutor);
            
            request.getRequestDispatcher("/ViewTurmasInstrutor").forward(request, response);
        } catch (SQLException | ParseException ex ) {
            Logger.getLogger(ListaTurmasInstrutor.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
