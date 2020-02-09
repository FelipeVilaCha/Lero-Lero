package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
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
/**
 *
 * @author FelipeVilaChadosSant
 */
public class ProcessaPagamento extends HttpServlet {
    
    private InstrutoresDAO instrutorDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutorDAO = new InstrutoresDAO(conexaoDB);
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        Map<String, String> mensagens = new HashMap<>();
        
        try {
            Double valorTotal = instrutorDAO.calculaPagamento(userID);
            session.setAttribute("valorTotal", valorTotal);
            
            request.getRequestDispatcher("/ViewPagamentoInstrutor").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
