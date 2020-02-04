package br.uff.servlets;

import br.uff.dominio.Cursos;
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
public class ViewCursosDisponiveis extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        
        List<Cursos> cursosDisponiveis = (List<Cursos>) session.getAttribute("cursosDisponiveis");
        session.setAttribute("cursoEscolhidoId", cursosDisponiveis.get(0).getId());
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Cursos </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Cursos disponiveis </h1>");
            out.println("<p1> ID: " + cursosDisponiveis.get(0).getId()+ " </p1> <br>");
            out.println("<p2> Nome: " + cursosDisponiveis.get(0).getNome() + " </p2> <br>");
            out.println("<p3> Ementa: " + cursosDisponiveis.get(0).getEmenta() + " </p3> <br>");
            out.println("<p4> Requisito: " + cursosDisponiveis.get(0).getRequisito() + " </p4> <br>");
            out.println("<p5> Carga horaria: " + cursosDisponiveis.get(0).getCarga_horaria() + " </p5> <br>");
            out.println("<button onclick=\"window.location.href = 'http://localhost:8080/LeroLero/TurmasDisponiveis';\"> Matricular </button>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
