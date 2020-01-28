
package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.AlunosDAO;
import br.uff.dominio.Alunos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Felipe Vila Chã
 */
public class CadastraAluno extends HttpServlet {

    private AlunosDAO alunosDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        String jdbcURL = "jdbc:derby://localhost:1527/LeroLero";
        String jdbcUsername = "felipe";
        String jdbcPassword = "";
        
        conexaoDB = new Conexao(jdbcURL, jdbcUsername, jdbcPassword);
        alunosDAO = new AlunosDAO(conexaoDB);
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        
        Alunos aluno = new Alunos(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep);
        
        
        try {
            alunosDAO.insertAluno(aluno);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        request.getRequestDispatcher("/LeroLero").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
   
}
