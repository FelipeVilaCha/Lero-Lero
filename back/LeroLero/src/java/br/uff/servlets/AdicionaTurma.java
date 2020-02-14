
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.TurmasDAO;
import br.uff.model.Turmas;
import br.uff.util.ConversorData;
import java.io.IOException;
import java.sql.Date;
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
public class AdicionaTurma extends HttpServlet {

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
        
        int instrutores_id = Integer.parseInt(request.getParameter("instrutores_id"));
        int cursos_id = Integer.parseInt(request.getParameter("cursos_id"));
        Date data_inicio = Date.valueOf(request.getParameter("data_inicio"));
        Date data_final = Date.valueOf(request.getParameter("data_final"));
        int carga_horaria = Integer.parseInt(request.getParameter("carga_horaria"));
        
        Turmas turma = new Turmas(instrutores_id, cursos_id, data_inicio, data_final, carga_horaria);
        
        try {
            
            boolean status = turmasDAO.insertTurmas(turma);
                
            if(status){
                request.getRequestDispatcher("/ListaTurmas").forward(request, response);
            } else {
                response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/turmas-table.jsp");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdicionaTurma.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
