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
import javax.servlet.http.HttpSession;


/**
 *
 * @author Felipe Vila Chã
 */
public class ProcessaComentarios extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        int userID = ((Alunos) session.getAttribute("alunoLogado")).getId();
        String comentario = request.getParameter("comentario");
        
        boolean comentarioInserido = false;
        
        try {
            comentarioInserido = alunosDAO.insereComentarios(userID, comentario);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaComentarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(comentarioInserido){
            response.sendRedirect("http://localhost:8080/LeroLero/modules/aluno/plano.jsp");
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/aluno/plano.jsp");
        }
    }
}
