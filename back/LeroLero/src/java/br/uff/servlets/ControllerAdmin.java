package br.uff.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class ControllerAdmin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Administrador </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Administrador </h1>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Solicitacoes\"> Listagem </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Alteracoes\"> Inclusão </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Cadastro\"> Atualizar </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Cancelamentos\"> Exclusão </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Cursos\"> Cursos </a> </br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
