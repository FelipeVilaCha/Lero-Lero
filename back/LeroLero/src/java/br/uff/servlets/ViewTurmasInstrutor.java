package br.uff.servlets;

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
public class ViewTurmasInstrutor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        List<Turmas> turmasInstrutor = (List<Turmas>) session.getAttribute("turmasInstrutor");
        session.setAttribute("turmaEscolhida", turmasInstrutor.get(0));
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Visualizar turmas </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Turmas </h1>");
            int cont = 0;
            for(int i = 0; i < turmasInstrutor.size(); i++){
                out.println("<p" + (cont += 1) + "> ID turma: " + turmasInstrutor.get(i).getId() + " </p1> <br>");
                out.println("<p" + (cont += 1) + "> Curso: " + turmasInstrutor.get(i).getCursos_id() + " </p1> <br>");
                out.println("<p" + (cont += 1) + "> Data inicio: " + turmasInstrutor.get(i).getData_inicio() + " </p1> <br>");
                out.println("<p" + (cont += 1) + "> Data final: " + turmasInstrutor.get(i).getData_final() + " </p1> <br>");
                out.println("<p" + (cont += 1) + "> Carga horaria: " + turmasInstrutor.get(i).getCarga_horaria() + " </p1> <br>");
                out.println("<button onclick=\"window.location.href = 'http://localhost:8080/LeroLero/ViewAtribuiNota';\"> Cadastrar </button>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}