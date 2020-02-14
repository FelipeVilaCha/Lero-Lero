
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
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
public class DeletaCurso extends HttpServlet {

    private CursosDAO cursosDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        cursosDAO = new CursosDAO(conexaoDB);    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean status = false;
        
        int cursoID = Integer.parseInt(request.getParameter("cursoID"));
        
        try {
            status = cursosDAO.deletaCurso(cursoID);
        } catch (SQLException ex) {
            Logger.getLogger(DeletaCurso.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(status){
            request.getRequestDispatcher("/ListaCursos").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/cursos-table.jsp");
        }
        
    }
}