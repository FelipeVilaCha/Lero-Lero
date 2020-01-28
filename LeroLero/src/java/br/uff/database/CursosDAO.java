package br.uff.database;

import br.uff.dominio.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class CursosDAO {
    private final Conexao conexaoDB;
     
    public CursosDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertCurso(Cursos curso) throws SQLException {
        String sql = "INSERT INTO alunos (nome, requisito, ementa, carga_horaria, preco) VALUES (?, ?, ?, ?, ?)";
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, curso.getNome());
        comando.setString(2, curso.getRequisito());
        comando.setString(3, curso.getEmenta());
        comando.setInt(4, curso.getCarga_horaria());
        comando.setDouble(5, curso.getPreco());
         
        boolean registroInserido = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroInserido;
    }
     
    public List<Cursos> listarCursos() throws SQLException {
        List<Cursos> listaCursos = new ArrayList<>();
         
        String sql = "SELECT * FROM cursos";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            String requisito = resultado.getString("requisito");
            String ementa = resultado.getString("ementa");
            int carga_horaria = resultado.getInt("carga_horaria");
            Double preco = resultado.getDouble("preco");
             
            Cursos curso = new Cursos(id, nome, requisito, ementa, carga_horaria, preco);
            listaCursos.add(curso);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return listaCursos;
    }
     
    public boolean deletaCurso(Cursos curso) throws SQLException {
        String sql = "DELETE FROM cursos where id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, curso.getId());
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroDeletado;     
    }
     
    public boolean atualizaCurso(Cursos curso) throws SQLException {
        String sql = "UPDATE cursos SET nome = ?, requisito = ?, ementa = ?, carga_horaria = ?, preco = ?";
        sql += " WHERE id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, curso.getNome());
        comando.setString(2, curso.getRequisito());
        comando.setString(3, curso.getEmenta());
        comando.setInt(4, curso.getCarga_horaria());
        comando.setDouble(5, curso.getPreco());
        comando.setInt(6, curso.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroAtualizado;     
    }
     
    public Cursos getCurso(int id) throws SQLException {
        Cursos curso = null;
        String sql = "SELECT * FROM cursos WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            String requisito = resultado.getString("requisito");
            String ementa = resultado.getString("ementa");
            int carga_horaria = resultado.getInt("carga_horaria");
            Double preco = resultado.getDouble("preco");
             
            curso = new Cursos(id, nome, requisito, ementa, carga_horaria, preco);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return curso;
    }
}
