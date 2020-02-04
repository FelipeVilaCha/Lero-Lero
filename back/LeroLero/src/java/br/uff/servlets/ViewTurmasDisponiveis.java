package br.uff.servlets;

import br.uff.dominio.Instrutores;
import br.uff.dominio.Turmas;
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
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        
        List<Turmas> turmasDisponiveis = (List<Turmas>) session.getAttribute("turmasDisponiveis");
        List<Instrutores> instrutores = (List<Instrutores>) session.getAttribute("instrutores");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Plano de Estudos </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Plano de Estudos </h1>");
            out.println("<p1> Data inicio: " + turmasDisponiveis.get(0).getData_inicio()+ " </p1> <br>");
            for(int i = 0; i >= instrutores.size(); i++){
                if(turmasDisponiveis.get(0).getInstrutores_id() == instrutores.get(i).getId()){
                    out.println("<p2> Professor: " + instrutores.get(i).getNome() + " </p2> <br>");
                }
            }
            out.println("<p3> Data final: " + turmasDisponiveis.get(0).getData_inicio() + " </p3> <br>");
            out.println("<p4> Carga horaria: " + turmasDisponiveis.get(0).getCarga_horaria() + " </p4> <br>");
            out.println("<input type=\"button\" onclick=\"http://localhost:8080/LeroLero/ProcessaMatricula\" id=\"turmasDisponiveis.get(0).getId()\" <br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
