package br.uff.servlets;

import br.uff.database.InstrutoresDAO;
import br.uff.database.Conexao;
import br.uff.dominio.Instrutores;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DadosInstrutores extends HttpServlet {
    private InstrutoresDAO instrutoresDAO;
    private Conexao conexaoDB;
    
    @Override
    public void init() {
        conexaoDB = new Conexao();
        instrutoresDAO = new InstrutoresDAO(conexaoDB);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Instrutores instrutorLogado = null;
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        
        try {
            instrutorLogado = instrutoresDAO.getInstrutor(id);
        } catch (SQLException ex) {
            Logger.getLogger(DadosInstrutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Informações </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Informações </h1>");
            out.println("<p1> Aluno: " + instrutorLogado.getNome() + "</p1> <br />");
            out.println("<p2> Email: " + instrutorLogado.getEmail() + "</p2> <br />");
            out.println("<p3> Valor por hora(reais): " + instrutorLogado.getValor_hora() + "</p3> <br />");
            out.println("<p4> Experiencia(anos): " + instrutorLogado.getExperiencia() + "</p4> <br />");
            out.println("</body>");
            out.println("</html>");
        }
    }
}