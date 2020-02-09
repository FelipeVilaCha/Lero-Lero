package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.AlunosDAO;
import br.uff.model.Alunos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * @author Felipe Vila Chã
 */
public class ProcessaComentarios extends HttpServlet {

    private AlunosDAO alunosDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        alunosDAO = new AlunosDAO(conexaoDB);    
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, String> mensagens = new HashMap<>();
        HttpSession session = request.getSession();
        List<Alunos> comentariosAlunos = new ArrayList<>();
        
        try {
            comentariosAlunos = alunosDAO.listarComentarios();
            session.setAttribute("comentariosAlunos", comentariosAlunos);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaComentarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("/coments.html").include(request, response);
    }
}
