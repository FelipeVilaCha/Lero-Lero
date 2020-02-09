package br.uff.servlets;

import br.uff.dao.AlunosDAO;
import br.uff.dao.Conexao;
import br.uff.model.Alunos;
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
public class ViewInformacoesAluno extends HttpServlet {
    private AlunosDAO alunosDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        alunosDAO = new AlunosDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        Alunos alunoLogado = (Alunos) session.getAttribute("alunoLogado");
        int userID = (Integer) session.getAttribute("userID");
        boolean sair = true;
        request.setAttribute("sair", sair);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Informações </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Informações </h1>");
            out.println("<p1> Aluno: " + alunoLogado.getNome() + "</p1> <br />");
            out.println("<p2> CPF: " + alunoLogado.getCpf() + "</p2> <br />");
            out.println("<p3> Email: " + alunoLogado.getEmail()+ "</p3> <br />");
            out.println("<p4> Celular: " + alunoLogado.getCelular() + "</p4> <br />");
            out.println("<p5> Cidade: " + alunoLogado.getCidade() + "</p5> <br />");
            out.println("<p6> Bairro: " + alunoLogado.getBairro() + "</p6> <br />");
            out.println("<p7> CEP: " + alunoLogado.getCep()+ "</p7>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}