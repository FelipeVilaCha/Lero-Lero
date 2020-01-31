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
public class RealizaLogin extends HttpServlet {
 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login! </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Login! </h1>");
        out.println("<form method=\"POST\" action=\"http://localhost:8080/LeroLero/ProcessaLogin\">");
        out.println("Email:<input type=\"text\" name=\"username\" /> <br />");
        out.println("Senha: <input type=\"password\" name=\"senha\" /> <br />");
        out.println("<input type=\"radio\" name=\"permissao\" value=\"administradores\"> Administrador");
        out.println("<input type=\"radio\" name=\"permissao\" value=\"alunos\"> Aluno");
        out.println("<input type=\"radio\" name=\"permissao\" value=\"instrutores\"> Instrutor <br />");
        out.println("<input type=\"submit\" value=\"LOGIN\">");
        out.println("</body>");
        out.println("</html>");
    }
}
