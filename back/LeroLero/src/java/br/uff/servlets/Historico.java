package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.CursosDAO;
import br.uff.database.MatriculasDAO;
import br.uff.database.TurmasDAO;
import br.uff.dominio.Cursos;
import br.uff.dominio.Matriculas;
import br.uff.dominio.Turmas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class Historico extends HttpServlet {
    private TurmasDAO turmasDAO;
    private MatriculasDAO matriculaDAO;
    private Conexao conexaoDB;
    private CursosDAO cursosDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        turmasDAO = new TurmasDAO(conexaoDB);
        matriculaDAO = new MatriculasDAO(conexaoDB);
        cursosDAO = new CursosDAO(conexaoDB);
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Integer> turmas_id = null;
        List<Integer> cursos_id = null;
        List<Cursos> cursos = null;
        int id = 1;
        
        try {
            List<Matriculas> matriculas = matriculaDAO.listarMatriculas();
            List<Turmas> turmas = turmasDAO.listarTurmas();
            
            for(int i = 0; i >= matriculas.size(); i++){
                if(matriculas.get(i).getAlunos_id() == id){
                    turmas_id.add(matriculas.get(i).getTurmas_id());
                }
            }
            
            for(int j = 0; j >= turmas.size(); j++){
                if(turmas_id.contains(turmas.get(j).getId())){
                    cursos_id.add(turmas.get(j).getCursos_id());
                }
            } 
            
            for(int l = 0; l >= cursos_id.size(); l++){
                cursos.add(cursosDAO.getCurso(cursos_id.get(l)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Historico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(turmas_id == null){
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Histórico </title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Você ainda não cursou nenhuma matéria :( </h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Plano de Estudos</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Histórico </h1>");
                for(int l = 0; l >= cursos.size(); l++){
                    out.println("<p" + l + "> Materia: " + cursos.get(l).getNome() + "</p" + l + ">");
                }
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
