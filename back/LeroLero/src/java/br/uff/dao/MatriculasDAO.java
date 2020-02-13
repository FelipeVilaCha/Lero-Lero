package br.uff.dao;

import br.uff.model.Matriculas;
import br.uff.model.PlanoEstudos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class MatriculasDAO {
    private final Conexao conexaoDB;
    
    public MatriculasDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertMatricula(Matriculas matricula) throws SQLException {
        String sql = "INSERT INTO escola.matriculas (turmas_id, alunos_id, data_matricula, nota) VALUES (?, ?, ?, ?)";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, matricula.getTurmas_id());
        comando.setInt(2, matricula.getAlunos_id());
        
        //converte o tipo de data
        java.util.Date dataUtil = matricula.getData_matricula();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        
        comando.setDate(3, dataSql);
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
            Date data_matricula = resultado.getDate("data_matricula");
            double nota = resultado.getDouble("nota");
             
            Matriculas matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula, nota);
            listaMatriculas.add(matricula);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaMatriculas;
    }
     
    public boolean deletaMatricula(Matriculas matricula) throws SQLException {
        String sql = "DELETE FROM escola.matriculas where id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, matricula.getId());
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroDeletado;     
    }
     
    public boolean atualizaMatricula(Matriculas matricula) throws SQLException {
        String sql = "UPDATE matriculas SET turmas_id = ?, alunos_id = ?, data_matricula = ?, nota = ?";
        sql += " WHERE id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, matricula.getTurmas_id());
        comando.setInt(2, matricula.getAlunos_id());
        comando.setDate(3, (java.sql.Date) matricula.getData_matricula());
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
            Date data_matricula = resultado.getDate("data_matricula");
            double nota = resultado.getDouble("nota");
             
            matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula, nota);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return matricula;
    }
    
    public List<PlanoEstudos> listarPlanoDeEstudos(int alunos_id) throws SQLException, ParseException {
        List<PlanoEstudos> plano = new ArrayList<>();
        
        String sql = "SELECT m.id, m.data_matricula, i.nome as nome_instrutor, c.nome as nome_curso, c.carga_horaria, m.nota, t.data_inicio, t.data_final\n" +
                     "FROM escola.matriculas m, escola.cursos c, escola.turmas t, escola.instrutores i\n" +
                     "WHERE m.turmas_id = t.id and t.cursos_id = c.id and m.alunos_id = " + alunos_id;
         
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
    
    public boolean validaMatricula(int turmas_id, int user_id) throws SQLException {
        boolean status;
        
        String sql = "SELECT * FROM escola.matriculas WHERE turmas_id = ? and alunos_id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, turmas_id);
        comando.setInt(2, user_id);
         
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
            Date data_matricula = resultado.getDate("data_matricula");
            double nota = resultado.getDouble("nota");
             
            Matriculas matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula, nota);
            listaMatriculas.add(matricula);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaMatriculas;
    }
}
