package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
import br.uff.model.Instrutores;
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
public class ControllerInstrutores extends HttpServlet {
    
    private Conexao conexaoDB;
    private InstrutoresDAO instrutoresDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutoresDAO = new InstrutoresDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        int userID = (Integer) session.getAttribute("userID");
        
        Instrutores instrutorLogado = null;
        
        try {
            instrutorLogado = instrutoresDAO.getInstrutor(userID);
            session.setAttribute("instrutorLogado", instrutorLogado);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerInstrutores.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        session.setAttribute("instrutorLogado", instrutorLogado);
        request.getRequestDispatcher("/ListagemInstrutor").forward(request, response);
    }
}