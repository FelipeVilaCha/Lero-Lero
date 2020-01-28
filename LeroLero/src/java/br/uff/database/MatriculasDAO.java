package br.uff.database;

import br.uff.dominio.Matriculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "INSERT INTO alunos (turmas_id, alunos_id, data_matricula, nota) VALUES (?, ?, ?, ?)";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, matricula.getTurmas_id());
        comando.setInt(2, matricula.getAlunos_id());
        comando.setDate(3, (java.sql.Date) matricula.getData_matricula());
        comando.setFloat(4, matricula.getNota());
         
        boolean registroInserido = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroInserido;
    }
     
    public List<Matriculas> listarMatriculas() throws SQLException {
        List<Matriculas> listaMatriculas = new ArrayList<>();
         
        String sql = "SELECT * FROM matriculas";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            int turmas_id = resultado.getInt("turmas_id");
            int alunos_id = resultado.getInt("alunos_id");
            Date data_matricula = resultado.getDate("data_matricula");
            Float nota = resultado.getFloat("nota");
             
            Matriculas matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula, nota);
            listaMatriculas.add(matricula);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaMatriculas;
    }
     
    public boolean deletaMatricula(Matriculas matricula) throws SQLException {
        String sql = "DELETE FROM matriculas where id = ?";
         
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
        comando.setFloat(4, matricula.getNota());
        comando.setInt(5, matricula.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroAtualizado;     
    }
     
    public Matriculas getMatricula(int id) throws SQLException {
        Matriculas matricula = null;
        String sql = "SELECT * FROM matriculas WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            int turmas_id = resultado.getInt("turmas_id");
            int alunos_id = resultado.getInt("alunos_id");
            Date data_matricula = resultado.getDate("data_matricula");
            Float nota = resultado.getFloat("nota");
             
            matricula = new Matriculas(id, turmas_id, alunos_id, data_matricula, nota);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return matricula;
    }
}
