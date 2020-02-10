package br.uff.servlets;

import br.uff.dao.AlunosDAO;
import br.uff.dao.Conexao;
import br.uff.model.Alunos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class ControllerAluno extends HttpServlet {
    
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
        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        
        Alunos alunoLogado = null;
        
        try {
            alunoLogado = alunosDAO.getAluno(userID);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("alunoLogado", alunoLogado);
        request.getRequestDispatcher("/modules/aluno/index.jsp").forward(request, response);
    }
}