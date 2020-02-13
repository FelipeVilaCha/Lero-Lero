package br.uff.servlets;

import br.uff.dao.AlunosDAO;
import br.uff.dao.Conexao;
import br.uff.model.Alunos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
public class ListaComentarios extends HttpServlet {
    
    private Conexao conexaoDB;
    private AlunosDAO alunosDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        alunosDAO = new AlunosDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<Alunos> comentariosAlunos = alunosDAO.listarComentarios();
            request.setAttribute("comentariosAlunos", comentariosAlunos);
        } catch (SQLException ex) {
            Logger.getLogger(ListaComentarios.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        request.getRequestDispatcher("/coments.jsp").forward(request, response);
    }
}