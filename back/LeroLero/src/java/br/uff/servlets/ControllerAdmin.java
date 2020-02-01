package br.uff.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class ControllerAdmin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Administrador </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Administrador </h1>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Listagem\"> Listagem </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Inclusao\"> Inclusão </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Atualizar\"> Atualizar </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Excluir\"> Exclusão </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Cursos\"> Cursos </a> </br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
