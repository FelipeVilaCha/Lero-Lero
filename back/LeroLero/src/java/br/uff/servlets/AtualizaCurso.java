package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.model.Cursos;
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
public class AtualizaCurso extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String requisito = request.getParameter("requisito");
        String ementa = request.getParameter("ementa");
        int carga_horaria = Integer.parseInt(request.getParameter("carga_horaria"));
        Double preco = Double.parseDouble(request.getParameter("preco"));
        
        Cursos curso = new Cursos(id, nome, requisito, ementa, carga_horaria, preco);
        
        try {
            status = cursosDAO.atualizaCurso(curso);
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaCurso.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(status){
            request.getRequestDispatcher("/ListaCursos").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/cursos-table.jsp");
        }
    }
}
