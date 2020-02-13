
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.AlunosDAO;
import br.uff.model.Alunos;
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
public class AtualizaAluno extends HttpServlet {

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
        
        boolean status = false;
        EncriptaSenha enc = new EncriptaSenha();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String login = request.getParameter("login");
        String senha = enc.novaSenha(request.getParameter("senha"));
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String comentario = null;
        String aprovado = "S";
        
        Alunos aluno = new Alunos(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
        
        try {
            status = alunosDAO.atualizaAluno(aluno);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(status){
            response.sendRedirect("http://localhost:8080/LeroLero/admin/alunos-table.jsp");
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/admin/alunos-table.jsp");
        }
        
    }
}