
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.AlunosDAO;
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
public class DeletaAluno extends HttpServlet {

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
        
        int alunoID = Integer.parseInt(request.getParameter("id"));
        
        try {
            status = alunosDAO.deletaAluno(alunoID);
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