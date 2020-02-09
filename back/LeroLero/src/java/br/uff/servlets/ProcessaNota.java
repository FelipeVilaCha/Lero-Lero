package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
import br.uff.model.Turmas;
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
public class ProcessaNota extends HttpServlet {
    
    private InstrutoresDAO instrutorDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutorDAO = new InstrutoresDAO(conexaoDB);
    }
 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        Turmas turma = (Turmas) session.getAttribute("turmaEscolhida");
        int alunoID =  Integer.parseInt(request.getParameter("alunoID"));
        Double nota = Double.parseDouble(request.getParameter("NotaAluno"));
        Map<String, String> mensagens = new HashMap<>();
        
        try {
            boolean updateNota = instrutorDAO.atribuiNota(alunoID, turma.getId(), nota);
            
            if(updateNota){
                request.getRequestDispatcher("/ViewAtribuiNota").forward(request, response);
            } else {
                request.getRequestDispatcher("/ViewAtribuiNota").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
