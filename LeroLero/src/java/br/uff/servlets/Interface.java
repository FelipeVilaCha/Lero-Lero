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
        
        String user = request.getParameter("username");
        String senha = request.getParameter("senha");
        
        request.setAttribute("username", user);
        request.setAttribute("username", senha);
        
        request.getRequestDispatcher("/Login").forward(request, response);
    }
}