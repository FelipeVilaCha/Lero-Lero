package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.MatriculasDAO;
import br.uff.dominio.PlanoEstudos;
import java.io.IOException;
import java.io.PrintWriter;
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
public class MontaPlanoDeEstudos extends HttpServlet {
    
    private Conexao conexaoDB;
    private MatriculasDAO matriculasDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        matriculasDAO = new MatriculasDAO(conexaoDB);
    }
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        
        List<PlanoEstudos> plano;
        
        try {
            plano = matriculasDAO.listarPlanoDeEstudos(id);
            session.setAttribute("plano", plano);
            request.getRequestDispatcher("/ViewPlanoDeEstudos").forward(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(MontaPlanoDeEstudos.class.getName()).log(Level.SEVERE, ex.getMessage());
            /*request.getRequestDispatcher("/planoVazio.jsp").forward(request, response);*/
        }
    }
}
