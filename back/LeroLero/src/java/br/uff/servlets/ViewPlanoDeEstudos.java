package br.uff.servlets;

import br.uff.dominio.PlanoEstudos;
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
public class ViewPlanoDeEstudos extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        List<PlanoEstudos> plano = (List<PlanoEstudos>) session.getAttribute("plano");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Plano de Estudos </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Plano de Estudos </h1>");
            out.println("<p1> Data da Matricula: " + plano.get(0).getData_matricula() + " </p1> <br>");
            out.println("<p2> Professor: " + plano.get(0).getNome_professor() + " </p2> <br>");
            out.println("<p3> Curso: " + plano.get(0).getNome_curso() + " </p3> <br>");
            out.println("<p4> Carga horaria: " + plano.get(0).getCarga_horaria() + " </p4> <br>");
            out.println("<p5> Nota: " + plano.get(0).getNota() + " </p5> <br>");
            out.println("<p6> Data inicio: " + plano.get(0).getData_inicio() + " </p6> <br>");
            out.println("<p7> Data final: " + plano.get(0).getData_final() + " </p7> <br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
