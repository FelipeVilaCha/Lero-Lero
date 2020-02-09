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
public class AceitaSolicitacao extends HttpServlet {
    
    private AlunosDAO alunosDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        alunosDAO = new AlunosDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        int solicitacaoAceitaID = (Integer) session.getAttribute("solicitacaoAceita");
        Map<String, String> mensagens = new HashMap<>();
        boolean status = false;
        
        try {
            status = alunosDAO.aceitarSolicitacao(solicitacaoAceitaID);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaSolicitacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(status){
            request.getRequestDispatcher("/ViewSolicitacoes").forward(request, response);
        } else {
            mensagens.put("solicitacao", "Falha na requisição, tente novamente!");
        }
        request.setAttribute("mensagens", mensagens);
        request.getRequestDispatcher("/ViewSolicitacoes").forward(request, response);
    }
}
