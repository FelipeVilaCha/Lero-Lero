package br.uff.dao;

import br.uff.model.Matriculas;
import br.uff.model.PlanoEstudos;
import br.uff.util.ConversorData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class MatriculasDAO {
    private final Conexao conexaoDB;
    
    public MatriculasDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertMatricula(Matriculas matricula) throws SQLException, ParseException {
        String sql = "INSERT INTO escola.matriculas (turmas_id, alunos_id, data_matricula, nota) VALUES (?, ?, ?, ?)";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, matricula.getTurmas_id());
        comando.setInt(2, matricula.getAlunos_id());
        comando.setDate(3, ConversorData.convertToSQL(matricula.getData_matricula()));
        comando.setDouble(4, matricula.getNota());
         
        boolean registroInserido = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroInserido;
    }
     
    public List<Matriculas> listarMatriculas() throws SQLException {
        List<Matriculas> listaMatriculas = new ArrayList<>();
         
        String sql = "SELECT * FROM escola.matriculas";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            int turmas_id = resultado.getInt("turmas_id");
            int alunos_id = resultado.getInt("alunos_id");
            String data_matricula = resultado.getString("data_matricula");
            double nota = resultado.getDouble("nota");
            
            java.util.Date data_matricula_formatada = null;
            
            try {
                data_matricula_formatada = ConversorData.convertToUtil(data_matricula);
            } catch (ParseException ex) {
                Logger.getLogger(MatriculasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            Matriculas matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula_formatada, nota);
            listaMatriculas.add(matricula);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaMatriculas;
    }
     
    public boolean deletaMatricula(int alunoID) throws SQLException {
        String sql = "DELETE FROM escola.matriculas where alunos_id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, alunoID);
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroDeletado;     
    }
     
    public boolean atualizaMatricula(Matriculas matricula) throws SQLException, ParseException {
        String sql = "UPDATE matriculas SET turmas_id = ?, alunos_id = ?, data_matricula = ?, nota = ?";
        sql += " WHERE id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, matricula.getTurmas_id());
        comando.setInt(2, matricula.getAlunos_id());
        comando.setDate(3, ConversorData.convertToSQL(matricula.getData_matricula()));
        comando.setDouble(4, matricula.getNota());
        comando.setInt(5, matricula.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroAtualizado;     
    }
     
    public Matriculas getMatricula(int id) throws SQLException {
        Matriculas matricula = null;
        String sql = "SELECT * FROM escola.matriculas WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            int turmas_id = resultado.getInt("turmas_id");
            int alunos_id = resultado.getInt("alunos_id");
            String data_matricula = resultado.getString("data_matricula");
            double nota = resultado.getDouble("nota");
            
            java.util.Date data_matricula_formatada = null;
            
            try {
                data_matricula_formatada = ConversorData.convertToUtil(data_matricula);
            } catch (ParseException ex) {
                Logger.getLogger(MatriculasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula_formatada, nota);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return matricula;
    }
    
    public List<PlanoEstudos> listarPlanoDeEstudosAtual(int alunos_id) throws SQLException, ParseException {
        List<PlanoEstudos> plano = new ArrayList<>();
        
        String sql = "SELECT m.id, m.data_matricula, i.nome as nome_instrutor, c.nome as nome_curso, c.carga_horaria, m.nota, t.data_inicio, t.data_final\n" +
                     "FROM escola.matriculas m, escola.cursos c, escola.turmas t, escola.instrutores i\n" +
                     "WHERE CURDATE() < t.data_final and m.turmas_id = t.id and t.cursos_id = c.id and m.alunos_id = " + alunos_id;
         
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery(sql);
        
        while (resultado.next()) {
            int id_matricula = resultado.getInt("id");
            String data_matricula = resultado.getString("data_matricula");
            String nome_instrutor = resultado.getString("nome_instrutor");
            String nome_curso = resultado.getString("nome_curso");
            int carga_horaria = resultado.getInt("carga_horaria");
            double nota = resultado.getDouble("nota");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            
            plano.add(new PlanoEstudos(id_matricula, data_matricula, nome_instrutor, nome_curso, carga_horaria, nota, data_inicio, data_final));
        }
        
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return plano;
    }
    
    public boolean validaMatricula(int userID, int cursosID) throws SQLException {
        boolean status;
        
        String sql = "SELECT * FROM escola.matriculas m, escola.turmas t WHERE m.turmas_id = t.id and alunos_id = ? and cursos_id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, userID);
        comando.setInt(2, cursosID);
         
        ResultSet resultado = comando.executeQuery();
         
        status = resultado.next();
 
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
        
        return status;
    }
    
    public List<Matriculas> listarMatriculasPorTurmaDeInstrutor(int instrutorID) throws SQLException, ParseException {
        List<Matriculas> listaMatriculas = new ArrayList<>();
         
        String sql = "SELECT m.id, m.turmas_id, m.alunos_id, m.data_matricula, m.nota "
                   + "FROM escola.matriculas m, turmas t "
                   + "WHERE CURDATE() BETWEEN t.data_inicio and t.data_final and t.id = m.turmas_id "
                   + "AND t.instrutores_id = " + instrutorID;
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery(sql);
        
        while (resultado.next()) {
            int id = resultado.getInt("id");
            int turmas_id = resultado.getInt("turmas_id");
            int alunos_id = resultado.getInt("alunos_id");
            String data_matricula = resultado.getString("data_matricula");
            double nota = resultado.getDouble("nota");
            
            java.util.Date data_matricula_formatada = null;
            
            try {
                data_matricula_formatada = ConversorData.convertToUtil(data_matricula);
            } catch (ParseException ex) {
                Logger.getLogger(MatriculasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            Matriculas matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula_formatada, nota);
            listaMatriculas.add(matricula);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaMatriculas;
    }
    
    public List<PlanoEstudos> listarHistorico(int alunos_id) throws SQLException, ParseException {
        List<PlanoEstudos> plano = new ArrayList<>();
        
        String sql = "SELECT m.id, m.data_matricula, i.nome as nome_instrutor, c.nome as nome_curso, c.carga_horaria, m.nota, t.data_inicio, t.data_final\n" +
                     "FROM escola.matriculas m, escola.cursos c, escola.turmas t, escola.instrutores i\n" +
                     "WHERE CURDATE() > t.data_final and m.turmas_id = t.id and t.cursos_id = c.id and m.alunos_id = " + alunos_id;
         
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery(sql);
        
        while (resultado.next()) {
            int id_matricula = resultado.getInt("id");
            String data_matricula = resultado.getString("data_matricula");
            String nome_instrutor = resultado.getString("nome_instrutor");
            String nome_curso = resultado.getString("nome_curso");
            int carga_horaria = resultado.getInt("carga_horaria");
            double nota = resultado.getDouble("nota");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            
            plano.add(new PlanoEstudos(id_matricula, data_matricula, nome_instrutor, nome_curso, carga_horaria, nota, data_inicio, data_final));
        }
        
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return plano;
    }
}
