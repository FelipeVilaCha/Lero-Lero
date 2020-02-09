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
public class ViewPagamentoInstrutor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        Double valorTotal = (Double) session.getAttribute("valorTotal");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Pagamento </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Pagamento </h1>");
            out.println("<p1> Valor: R$" + valorTotal + " </p1> <br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}