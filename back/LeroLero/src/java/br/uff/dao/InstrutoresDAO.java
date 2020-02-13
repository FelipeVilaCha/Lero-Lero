package br.uff.dao;

import br.uff.model.Instrutores;
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
public class InstrutoresDAO {
    private final Conexao conexaoDB;
     
    public InstrutoresDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertInstrutor(Instrutores instrutor) throws SQLException {
        String sql = "INSERT INTO instrutores (nome, email, valor_hora, login, senha, experiencia) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, instrutor.getNome());
        comando.setString(2, instrutor.getEmail());
        comando.setInt(3, instrutor.getValor_hora());
        comando.setString(4, instrutor.getLogin());
        comando.setString(5, instrutor.getSenha());
        comando.setString(6, instrutor.getExperiencia());
         
        boolean registroInserido = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroInserido;
    }
     
    public List<Instrutores> listarInstrutores() throws SQLException {
        List<Instrutores> listaInstrutores = new ArrayList<>();
         
        String sql = "SELECT * FROM instrutores";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");
            int valor_hora = resultado.getInt("valor_hora");
            String login = resultado.getString("login");
            String senha = resultado.getString("senha");
            String experiencia = resultado.getString("experiencia");
             
            Instrutores instrutor = new Instrutores(id, nome, email, valor_hora, login, senha, experiencia);
            listaInstrutores.add(instrutor);
        }
         
        resultado.close();
        comando.close();
         
        conexaoDB.desconectar();
         
        return listaInstrutores;
    }
     
    public boolean deletaInstrutor(Instrutores instrutor) throws SQLException {
        String sql = "DELETE FROM instrutores where id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, instrutor.getId());
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroDeletado;     
    }
     
    public boolean atualizaInstrutor(Instrutores instrutor) throws SQLException {
        String sql = "UPDATE instrutores SET nome = ?, email = ?, valor_hora = ?, login = ?, senha = ?";
        sql += " WHERE id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, instrutor.getNome());
        comando.setString(2, instrutor.getEmail());
        comando.setInt(3, instrutor.getValor_hora());
        comando.setString(4, instrutor.getLogin());
        comando.setString(5, instrutor.getSenha());
        comando.setString(6, instrutor.getExperiencia());
        comando.setInt(7, instrutor.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroAtualizado;     
    }
     
    public Instrutores getInstrutor(int id) throws SQLException {
        Instrutores instrutor = null;
        String sql = "SELECT * FROM escola.instrutores WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");
            int valor_hora = resultado.getInt("valor_hora");
            String login = resultado.getString("login");
            String senha = resultado.getString("senha");
            String experiencia = resultado.getString("experiencia");
            
            instrutor = new Instrutores(id, nome, email, valor_hora, login, senha, experiencia);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return instrutor;
    }
    
    public Double calculaPagamentoPorTurma(int instrutorID, int turmaID) throws SQLException {
        Double calculoPorTurma = null;
        String sql = "SELECT i.valor_hora as valor, t.carga_horaria as horas "
                + "FROM turmas t, instrutores i "
                + "WHERE t.instrutores_id = " + instrutorID + " AND t.id = " + turmaID 
                + " AND CURDATE() BETWEEN t.data_inicio AND t.data_final";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            Double valorHora = resultado.getDouble("valor");
            int horas = resultado.getInt("horas");
            
            calculoPorTurma = valorHora * horas; 
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
        
        return calculoPorTurma;
    }
    
    public boolean atribuiNota(int alunoID, int turmaID, Double nota) throws SQLException {
        String sql = "UPDATE escola.matriculas SET nota = ?";
        sql += " WHERE alunos_id = ? and turmas_id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setDouble(1, nota);
        comando.setInt(2, alunoID);
        comando.setInt(3, turmaID);
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        
        return registroAtualizado;     
    }
}
