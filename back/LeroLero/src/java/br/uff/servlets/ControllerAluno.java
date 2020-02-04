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
public class ControllerAluno extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Aluno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Aluno </h1>");  
            out.println("<a href=\"http://localhost:8080/LeroLero/InformacoesAluno\"> Informações </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/MontaPlanoDeEstudos\"> Plano de estudos </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/CursosDisponiveis\"> Realizar Matricula </a> </br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
