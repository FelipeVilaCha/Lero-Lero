package br.uff.servlets;

import br.uff.model.Instrutores;
import br.uff.model.Turmas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class ViewTurmasDisponiveis extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        List<Turmas> turmasDisponiveis = (List<Turmas>) session.getAttribute("turmasDisponiveis");
        List<Instrutores> instrutores = (List<Instrutores>) session.getAttribute("instrutores");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Matricula </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Matricula </h1>");
            out.println("<p1> Data inicio: " + turmasDisponiveis.get(0).getData_inicio()+ " </p1> <br>");
            out.println("<p2> Professor: " + instrutores.get(0).getNome() + " </p2> <br>");
            out.println("<p3> Data final: " + turmasDisponiveis.get(0).getData_final() + " </p3> <br>");
            out.println("<p4> Carga horaria: " + turmasDisponiveis.get(0).getCarga_horaria() + " </p4> <br>");
            session.setAttribute("turmaEscolhidaID", turmasDisponiveis.get(0).getId());
            out.println("<button onclick=\"window.location.href = 'http://localhost:8080/LeroLero/ProcessaMatricula';\"> Matricular </button>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
