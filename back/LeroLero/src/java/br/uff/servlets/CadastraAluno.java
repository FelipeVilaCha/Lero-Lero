
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.AlunosDAO;
import br.uff.model.Alunos;
import br.uff.util.Encriptador;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Encriptador enc = new Encriptador();
        
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String login = request.getParameter("login");
        String senha = enc.encripta(request.getParameter("senha"));
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String comentario = null;
        String aprovado = "N";
        
        try {
            Alunos aluno = new Alunos(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
            boolean existe = alunosDAO.verificaAluno(aluno);
            
            if(!existe){
                boolean status = alunosDAO.insertAluno(aluno);
                
                if(status){
                    response.sendRedirect("/LeroLero/index.jsp");
                } else {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("/index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
