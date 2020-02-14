package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.MatriculasDAO;
import br.uff.model.PlanoEstudos;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
public class MontaPlanoDeEstudos extends HttpServlet {
    
    private Conexao conexaoDB;
    private MatriculasDAO matriculasDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        matriculasDAO = new MatriculasDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        
        List<PlanoEstudos> planoEstudos = new ArrayList<>();
        List<PlanoEstudos> historico = new ArrayList<>();
        
        try {
            planoEstudos = matriculasDAO.listarPlanoDeEstudosAtual(userID);
            historico = matriculasDAO.listarHistorico(userID);
            
            session.setAttribute("planoEstudos", planoEstudos);
            session.setAttribute("historico", historico);
            
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(MontaPlanoDeEstudos.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        response.sendRedirect("http://localhost:8080/LeroLero/modules/aluno/plano.jsp");
    }
}
