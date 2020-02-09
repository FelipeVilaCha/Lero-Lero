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
public class ViewAtribuiNota extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Atribuir nota </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Nota </h1>");
            out.println("<form action=\"http://localhost:8080/LeroLero/ProcessaNota\" method=\"POST\">");
            out.println("ID: <input type=\"text\" name=\"alunoID\" /> <br />");
            out.println("Nota: <input type=\"text\" name=\"NotaAluno\" /> <br />");
            out.println("<input type=\"submit\" value=\"Finalizar\" />");
            out.println("</body>");
            out.println("</html>");
        }
    }
}