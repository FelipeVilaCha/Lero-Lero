
package br.uff.servlets;

import br.uff.database.Conexao;
import br.uff.database.AlunosDAO;
import br.uff.dominio.Alunos;
import java.io.IOException;
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
        conexaoDB = new Conexao();
        alunosDAO = new AlunosDAO(conexaoDB);    
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        String comentario = null;
        String aprovado = null;
        
        try {
            Alunos aluno = new Alunos(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
            boolean existe = alunosDAO.verificaAluno(aluno);
            
            if(!existe){
                boolean status = alunosDAO.insertAluno(aluno);
            
                if(status){
                    String permissao = "alunos";
                    request.setAttribute("status", status);
                    request.setAttribute("permissao", permissao);
                    request.getRequestDispatcher("/ControllerAluno").include(request, response);
                } else {
                    request.getRequestDispatcher("/cadastroAluno.html").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/cadastroAluno.html").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
