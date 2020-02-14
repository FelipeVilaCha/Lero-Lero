/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.CursosDAO;
import br.uff.dao.MatriculasDAO;
import br.uff.dao.TurmasDAO;
import br.uff.model.Cursos;
import br.uff.model.Matriculas;
import br.uff.model.Turmas;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
public class ListagemInstrutor extends HttpServlet {
    
    private Conexao conexaoDB;
    private TurmasDAO turmasDAO;
    private CursosDAO cursosDAO;
    private MatriculasDAO matriculasDAO;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        turmasDAO = new TurmasDAO(conexaoDB);
        cursosDAO = new CursosDAO(conexaoDB);
        matriculasDAO = new MatriculasDAO(conexaoDB);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        int userID = (Integer) session.getAttribute("userID");
        
        try {
            List<Turmas> turmasInstrutor = turmasDAO.listarTurmasPorInstrutor(userID);
            List<Cursos> cursosInstrutor = cursosDAO.listarCursosPorInstrutor(userID);
            List<Matriculas> matriculasInstrutor = matriculasDAO.listarMatriculasPorTurmaDeInstrutor(userID);
            
            session.setAttribute("turmasInstrutor", turmasInstrutor);
            session.setAttribute("cursosInstrutor", cursosInstrutor);
            session.setAttribute("matriculasInstrutor", matriculasInstrutor);
            
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ListagemInstrutor.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        response.sendRedirect("http://localhost:8080/LeroLero/modules/instrutor/index.jsp");
    }
}