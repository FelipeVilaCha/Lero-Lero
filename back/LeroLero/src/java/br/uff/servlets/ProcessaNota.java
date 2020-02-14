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
 * @author FelipeVilaChadosSant
 */
public class ProcessaNota extends HttpServlet {
    
    private InstrutoresDAO instrutorDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutorDAO = new InstrutoresDAO(conexaoDB);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int turmaEscolhidaID = Integer.parseInt(request.getParameter("turmaEscolhidaID"));;
        int alunoID =  Integer.parseInt(request.getParameter("alunoID"));
        Double nota = Double.parseDouble(request.getParameter("nota"));
        
        boolean updateNota = false;
        
        try {
            updateNota = instrutorDAO.atribuiNota(alunoID, turmaEscolhidaID, nota);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaNota.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(updateNota){
            response.sendRedirect("http://localhost:8080/LeroLero/modules/instrutor/turmas.jsp");
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/instrutor/turmas.jsp");
        }
    }
}
