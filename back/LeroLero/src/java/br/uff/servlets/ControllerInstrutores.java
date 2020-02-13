/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.dao.InstrutoresDAO;
import br.uff.dao.MatriculasDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Instrutores;
import java.io.IOException;
import java.sql.SQLException;
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
public class ControllerInstrutores extends HttpServlet {
    
    private Conexao conexaoDB;
    private InstrutoresDAO instrutoresDAO;
    private TurmasDAO turmasDAO;
    private CursosDAO cursosDAO;
    private MatriculasDAO matriculasDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        turmasDAO = new TurmasDAO(conexaoDB);
        cursosDAO = new CursosDAO(conexaoDB);
        matriculasDAO = new MatriculasDAO(conexaoDB);
        instrutoresDAO = new InstrutoresDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        int userID = (Integer) session.getAttribute("userID");
        
        Instrutores instrutorLogado = null;
        
        try {
            instrutorLogado = instrutoresDAO.getInstrutor(userID);
            session.setAttribute("instrutorLogado", instrutorLogado);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAluno.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        session.setAttribute("instrutorLogado", instrutorLogado);
        request.getRequestDispatcher("/ListagemInstrutor").forward(request, response);
    }
}