package br.uff.dao;

import br.uff.model.Turmas;
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
public class TurmasDAO {
     private final Conexao conexaoDB;
     
    public TurmasDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertTurmas(Turmas turma) throws SQLException, ParseException {
        String sql = "INSERT INTO escola.turmas (instrutores_id, cursos_id, data_inicio, data_final, carga_horaria) VALUES (?, ?, ?, ?, ?)";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, turma.getInstrutores_id());
        comando.setInt(2, turma.getCursos_id());
        comando.setDate(3, ConversorData.convertToSQL(turma.getData_inicio()));
        comando.setDate(4, ConversorData.convertToSQL(turma.getData_final()));
        comando.setInt(5, turma.getCarga_horaria());
         
        boolean registroInserido = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroInserido;
    }
     
    public List<Turmas> listarTurmas() throws SQLException {
        List<Turmas> listaTurmas = new ArrayList<>();
         
        String sql = "SELECT * FROM escola.turmas";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            int instrutores_id = resultado.getInt("instrutores_id");
            int cursos_id = resultado.getInt("cursos_id");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            int carga_horaria = resultado.getInt("carga_horaria");
            
            java.util.Date data_inicio_formatada = null;
            try {
                data_inicio_formatada = ConversorData.convertToUtil(data_inicio);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        
            java.util.Date data_final_formatada = null;
            try {
                data_final_formatada = ConversorData.convertToUtil(data_final);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            Turmas turma = new Turmas(id, instrutores_id, cursos_id, data_inicio_formatada, data_final_formatada, carga_horaria);
            listaTurmas.add(turma);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaTurmas;
    }
     
    public boolean deletaTurmas(int turmaID) throws SQLException {
        String sql = "DELETE FROM escola.turmas where id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, turmaID);
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroDeletado;     
    }
     
    public boolean atualizaTurmas(Turmas turma) throws SQLException, ParseException {
        String sql = "UPDATE escola.turmas SET instrutores_id = ?, cursos_id = ?, data_inicio = ?, data_final = ?, carga_horaria = ?";
        sql += " WHERE id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, turma.getInstrutores_id());
        comando.setInt(2, turma.getCursos_id());
        comando.setDate(3, ConversorData.convertToSQL(turma.getData_inicio()));
        comando.setDate(4, ConversorData.convertToSQL(turma.getData_final()));
        comando.setInt(5, turma.getCarga_horaria());
        comando.setInt(6, turma.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroAtualizado;     
    }
     
    public Turmas getTurmas(int id) throws SQLException {
        Turmas turma = null;
        String sql = "SELECT * FROM turmas WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            int instrutores_id = resultado.getInt("instrutores_id");
            int cursos_id = resultado.getInt("cursos_id");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            int carga_horaria = resultado.getInt("carga_horaria");
            
            java.util.Date data_inicio_formatada = null;
            try {
                data_inicio_formatada = ConversorData.convertToUtil(data_inicio);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        
            java.util.Date data_final_formatada = null;
            try {
                data_final_formatada = ConversorData.convertToUtil(data_final);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            turma = new Turmas(id, instrutores_id, cursos_id, data_inicio_formatada, data_final_formatada, carga_horaria);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
        
        return turma;
    }
    
    public List<Turmas> listarTurmasPorInstrutor(int instrutorID) throws SQLException, ParseException {
        List<Turmas> listaTurmas = new ArrayList<>();
         
        String sql = "SELECT id, cursos_id, data_inicio, data_final, carga_horaria "
                    +   "FROM escola.turmas "
                    +   "WHERE CURDATE() BETWEEN data_inicio and data_final and instrutores_id = " + instrutorID;
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            int cursos_id = resultado.getInt("cursos_id");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            int carga_horaria = resultado.getInt("carga_horaria");
            
            java.util.Date data_inicio_formatada = null;
            try {
                data_inicio_formatada = ConversorData.convertToUtil(data_inicio);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        
            java.util.Date data_final_formatada = null;
            try {
                data_final_formatada = ConversorData.convertToUtil(data_final);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            
            Turmas turmas = new Turmas(id, instrutorID, cursos_id, data_inicio_formatada, data_final_formatada, carga_horaria);
            listaTurmas.add(turmas);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaTurmas;
    }
    
    public List<Turmas> listarTurmasAbertas() throws SQLException, ParseException {
        List<Turmas> listaTurmas = new ArrayList<>();
         
        String sql = "SELECT id, instrutores_id, cursos_id, data_inicio, data_final, carga_horaria "
                   + " FROM escola.turmas"
                   + " WHERE CURDATE() <= data_inicio";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            int instrutores_id = resultado.getInt("instrutores_id");
            int cursos_id = resultado.getInt("cursos_id");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            int carga_horaria = resultado.getInt("carga_horaria");
            
            java.util.Date data_inicio_formatada = null;
            try {
                data_inicio_formatada = ConversorData.convertToUtil(data_inicio);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        
            java.util.Date data_final_formatada = null;
            try {
                data_final_formatada = ConversorData.convertToUtil(data_final);
            } catch (ParseException ex) {
                Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            Turmas turmas = new Turmas(id, instrutores_id, cursos_id, data_inicio_formatada, data_final_formatada, carga_horaria);
            listaTurmas.add(turmas);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaTurmas;
    }
    
    public boolean validaTurmaCurso(int cursoID) throws SQLException {
        String verificaCurso = "SELECT count(*) as count FROM escola.cursos where id = ?";
        
        boolean registroValido = false;
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comandoCurso = db.prepareStatement(verificaCurso);
        comandoCurso.setInt(1, cursoID);

        ResultSet resultadoCurso = comandoCurso.executeQuery();
       
        if (resultadoCurso.next()) {
            if(resultadoCurso.getString("count").contains("1")){
                registroValido = true;
            }
        }
       
        comandoCurso.close();
        conexaoDB.desconectar();
        return registroValido;
    }
    
    public boolean validaTurmaInstrutor(int instrutorID) throws SQLException {
        String verificaInstrutor = "SELECT count(*) as count FROM escola.instrutores where id = ?";
        
        boolean registroValido = false;
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comandoInstrutor = db.prepareStatement(verificaInstrutor);
        comandoInstrutor.setInt(1, instrutorID);

        ResultSet resultadoInstrutor = comandoInstrutor.executeQuery();
        
        if (resultadoInstrutor.next()) {
            if(resultadoInstrutor.getString("count").contains("1")){
                registroValido = true;
            }
        }
       
        comandoInstrutor.close();
        conexaoDB.desconectar();
        return registroValido;
    }
}