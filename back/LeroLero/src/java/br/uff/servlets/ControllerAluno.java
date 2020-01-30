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
            out.println("<a href=\"http://localhost:8080/LeroLero/InformacoesAluno\"> Informações </a>");
            out.println("<a href=\"http://localhost:8080/LeroLero/PlanoEstudos\"> Plano de estudos </a>");
            out.println("<a href=\"http://localhost:8080/LeroLero/HistoricoAluno\"> Histórico </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}