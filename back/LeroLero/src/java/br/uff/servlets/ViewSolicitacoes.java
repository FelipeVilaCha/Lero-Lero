package br.uff.servlets;

import br.uff.model.Alunos;
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
public class ViewSolicitacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        
        List<Alunos> solicitacoesAlunos = (List<Alunos>) session.getAttribute("solicitacoesAlunos");
        
        if(solicitacoesAlunos.isEmpty()){
             try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Solicitacoes </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Solicitacoes inexistentes </h1>");
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Solicitacoes </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Solicitacoes </h1>");
                out.println("<p1> ID: " + solicitacoesAlunos.get(0).getId()+ " </p1> <br>");
                out.println("<p2> Nome: " + solicitacoesAlunos.get(0).getNome() + " </p2> <br>");
                out.println("<p3> CPF: " + solicitacoesAlunos.get(0).getCpf()+ " </p3> <br>");
                out.println("<button onclick=\"window.location.href = 'http://localhost:8080/LeroLero/AceitaSolicitacao';\"> Aceitar </button>");
                session.setAttribute("solicitacaoAceita", solicitacoesAlunos.get(0).getId());
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}