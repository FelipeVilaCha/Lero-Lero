package br.uff.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felipe Vila Chã
 */
public class Interface extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String path = request.getServletPath();
        String user;
        if("/ProcessaLogin".equals(path)){
            user = (String) request.getAttribute("user");
        } else {
            user = (String) request.getAttribute("login");
        }
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title> WELCOME! </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> WELCOME! " + user + "</h1>");
        out.println("<a href=\"http://localhost:8080/LeroLero/ControllerAluno\"> ALUNO </a>");
        out.println("</body>");
        out.println("</html>");
    }
}