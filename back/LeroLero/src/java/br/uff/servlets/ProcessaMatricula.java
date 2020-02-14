package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.MatriculasDAO;
import br.uff.model.Matriculas;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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
public class ProcessaMatricula extends HttpServlet {
    
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
        
        int turmaID = Integer.parseInt(request.getParameter("turmaEscolhidaID"));
        int cursoID = Integer.parseInt(request.getParameter("cursoEscolhidoID"));
        int userID = (Integer) session.getAttribute("userID");
        
        Date data_matricula = new Date();
        Double nota = 0.0;
        
        Matriculas matricula = new Matriculas(turmaID, userID, data_matricula, nota);
        
        boolean existe = false;
        
        try {
            existe = matriculasDAO.validaMatricula(userID, cursoID);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaMatricula.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(!existe){
            try {
                matriculasDAO.insertMatricula(matricula);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaMatricula.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            request.getRequestDispatcher("/MontaPlanoDeEstudos").forward(request, response);
        } else
            request.getRequestDispatcher("/CursosTurmasDisponiveis").forward(request, response);
        }
    }