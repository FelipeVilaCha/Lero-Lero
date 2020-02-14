
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.TurmasDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Felipe Vila Chã
 */
public class DeletaTurma extends HttpServlet {

    private TurmasDAO turmasDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        turmasDAO = new TurmasDAO(conexaoDB);    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean status = false;
        
        int turmaID = Integer.parseInt(request.getParameter("turmaID"));
        
        try {
            status = turmasDAO.deletaTurmas(turmaID);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
        
        if(status){
            request.getRequestDispatcher("/ListaTurmas").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/turmas-table.jsp");
        }    
    }
}