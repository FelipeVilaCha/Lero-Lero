
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
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
public class DeletaInstrutor extends HttpServlet {

    private InstrutoresDAO instrutoresDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutoresDAO = new InstrutoresDAO(conexaoDB);    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean status = false;
        
        int instrutorID = Integer.parseInt(request.getParameter("instrutorID"));
        
        try {
            status = instrutoresDAO.deletaInstrutor(instrutorID);
        } catch (SQLException ex) {
            Logger.getLogger(DeletaInstrutor.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(status){
            request.getRequestDispatcher("/ListaInstrutores").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/instrutor-table.jsp");
        }
        
    }
}