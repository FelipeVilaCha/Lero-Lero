package br.uff.servlets;

import br.uff.dao.AlunosDAO;
import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.dao.MatriculasDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Alunos;
import br.uff.model.Cursos;
import br.uff.model.Matriculas;
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
public class ListaNotasAlunos extends HttpServlet {
    
    private Conexao conexaoDB;
    private CursosDAO cursosDAO;
    private TurmasDAO turmasDAO;
    private MatriculasDAO matriculasDAO;
    private AlunosDAO alunosDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        cursosDAO = new CursosDAO(conexaoDB);
        turmasDAO = new TurmasDAO(conexaoDB);
        matriculasDAO = new MatriculasDAO(conexaoDB);
        alunosDAO = new AlunosDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            List<Cursos> listaCursos = cursosDAO.listarCursos();
            session.setAttribute("listaCursos", listaCursos);
            
            List<Turmas> listaTurmas = turmasDAO.listarTurmas();
            session.setAttribute("listaTurmas", listaTurmas);
            
            List<Matriculas> listaMatriculas = matriculasDAO.listarMatriculas();
            session.setAttribute("listaMatriculas", listaMatriculas);
            
            List<Alunos> listaAlunos = alunosDAO.listarAlunos();
            session.setAttribute("listaAlunos", listaAlunos);
            
        } catch (SQLException ex) {
            Logger.getLogger(CursosTurmasDisponiveis.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/aluno-cursos-table.jsp");
    }
}