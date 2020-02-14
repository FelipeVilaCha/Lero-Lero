package br.uff.servlets;

import br.uff.dao.AlunosDAO;
import br.uff.dao.Conexao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class RecusaSolicitacao extends HttpServlet {
    
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
        
        int solicitacaoNegadaID = Integer.parseInt(request.getParameter("solicitacaoNegada"));
        boolean status = false;
        
        try {
            status = alunosDAO.deletaAluno(solicitacaoNegadaID);
        } catch (SQLException ex) {
            Logger.getLogger(RecusaSolicitacao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(status){
            request.getRequestDispatcher("/ListaSolicitacoes").forward(request, response);
        } else {
            request.getRequestDispatcher("/ListaSolicitacoes").forward(request, response);
        }
    }
}
