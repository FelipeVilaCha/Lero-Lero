package br.uff.servlets;

import br.uff.dao.Conexao;
import br.uff.dao.InstrutoresDAO;
import br.uff.model.Instrutores;
import br.uff.util.Encriptador;
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
 * @author Felipe Vila Chã
 */
public class AtualizaInstrutor extends HttpServlet {

    private InstrutoresDAO instrutoresDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutoresDAO = new InstrutoresDAO(conexaoDB);    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean status = false;
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        int valor_hora = Integer.parseInt(request.getParameter("valor_hora"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String experiencia = request.getParameter("experiencia");
        
        Instrutores instrutor = new Instrutores(id, nome, email, valor_hora, login, new Encriptador().encripta(senha), experiencia);
        
        try {
            status = instrutoresDAO.atualizaInstrutor(instrutor);
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaInstrutor.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        if(status){
            request.getRequestDispatcher("/ListaInstrutores").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/LeroLero/modules/admin/tables/instrutor-table.jsp");
        }
    }
}