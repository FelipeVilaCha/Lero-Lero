package br.uff.servlets;

import br.uff.database.LoginDAO;
import br.uff.database.TurmasDAO;
import br.uff.database.CursosDAO;
import br.uff.database.AdministradorDAO;
import br.uff.database.InstrutoresDAO;
import br.uff.database.MatriculasDAO;
import br.uff.database.AlunosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class LeroLero extends HttpServlet {
    
    private AlunosDAO alunos;
    private CursosDAO cursos;
    private InstrutoresDAO instrutores;
    private MatriculasDAO matriculas;
    private TurmasDAO turmas;
    private AdministradorDAO admin;
    
    @Override
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        alunos = new AlunosDAO(jdbcURL, jdbcUsername, jdbcPassword);
        cursos = new CursosDAO(jdbcURL, jdbcUsername, jdbcPassword);
        instrutores = new InstrutoresDAO(jdbcURL, jdbcUsername, jdbcPassword);
        matriculas = new MatriculasDAO(jdbcURL, jdbcUsername, jdbcPassword);
        turmas = new TurmasDAO(jdbcURL, jdbcUsername, jdbcPassword);
        admin = new AdministradorDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/Login":
                request.getRequestDispatcher("/Login").include(request, response);
        }
    }
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            
            switch (action) {
                case "/cadastroAluno":
                    cadastrarAluno(request, response);
                    break;
                case "/cadastroCurso":
                    cadastrarCurso(request, response);
                    break;
                case "/informacoesCurso":
                    mostrarInformacoesCurso(request, response);
                    break;
                case "/cadastroInstrutores":
                    cadastrarInstrutores(request, response);
                    break;
                case "/realizarMatricula":
                    realizarMatricula(request, response);
                    break;
                case "/visualizarTurmas":
                    visualizarTurmas(request, response);
                    break;
                default:
                    home(request, response);
                    break;
            }
            processRequest(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
*/
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
