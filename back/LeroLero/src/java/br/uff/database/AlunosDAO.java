package br.uff.database;

import br.uff.dominio.Alunos;
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
public class AlunosDAO {
    private final Conexao conexaoDB;
    
    public AlunosDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertAluno(Alunos aluno) throws SQLException {
        
        String sql = "INSERT INTO lerolero.alunos (cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection db = conexaoDB.conectar();

        boolean registroInserido;
        try (PreparedStatement comando = db.prepareStatement(sql)) {
            comando.setString(1, aluno.getCpf());
            comando.setString(2, aluno.getNome());
            comando.setString(3, aluno.getEmail());
            comando.setString(4, aluno.getCelular());
            comando.setString(5, aluno.getLogin());
            comando.setString(6, aluno.getSenha());
            comando.setString(7, aluno.getEndereco());
            comando.setString(8, aluno.getCidade());
            comando.setString(9, aluno.getBairro());
            comando.setString(10, aluno.getCep());
            registroInserido = comando.executeUpdate() > 0;
        }
        conexaoDB.desconectar();
        return registroInserido;
        
    }
     
    public List<Alunos> listarAlunos() throws SQLException {
        List<Alunos> listaAlunos = new ArrayList<>();
         
        String sql = "SELECT * FROM lerolero.alunos";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String cpf = resultado.getString("cpf");
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");
            String celular = resultado.getString("celular");
            String login = resultado.getString("login");
            String senha = resultado.getString("senha");
            String endereco = resultado.getString("endereco");
            String cidade = resultado.getString("cidade");
            String bairro = resultado.getString("bairro");
            String cep = resultado.getString("cep");
             
            Alunos aluno = new Alunos(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep);
            listaAlunos.add(aluno);
        }
         
        resultado.close();
        comando.close();
         
        conexaoDB.desconectar();
         
        return listaAlunos;
    }
     
    public boolean deletaAluno(Alunos aluno) throws SQLException {
        String sql = "DELETE FROM alunos where id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, aluno.getId());
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroDeletado;     
    }
     
    public boolean atualizaAluno(Alunos aluno) throws SQLException {
        String sql = "UPDATE alunos SET cpf = ?, nome = ?, email = ?, celular = ?, login = ?, senha = ?, endereco = ?, cidade = ?, bairro = ?, cep = ?";
        sql += " WHERE id = ?";
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, aluno.getCpf());
        comando.setString(2, aluno.getNome());
        comando.setString(3, aluno.getEmail());
        comando.setString(4, aluno.getCelular());
        comando.setString(5, aluno.getLogin());
        comando.setString(6, aluno.getSenha());
        comando.setString(7, aluno.getEndereco());
        comando.setString(8, aluno.getCidade());
        comando.setString(9, aluno.getBairro());
        comando.setString(10, aluno.getCep());
        comando.setInt(11, aluno.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroAtualizado;     
    }
     
    public Alunos getAluno(int id) throws SQLException {
        Alunos aluno = null;
        String sql = "SELECT * FROM alunos WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            String cpf = resultado.getString("cpf");
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");
            String celular = resultado.getString("celular");
            String login = resultado.getString("login");
            String senha = resultado.getString("senha");
            String endereco = resultado.getString("endereco");
            String cidade = resultado.getString("cidade");
            String bairro = resultado.getString("bairro");
            String cep = resultado.getString("cep");
             
            aluno = new Alunos(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return aluno;
    }
    
    public boolean verificaAluno(Alunos aluno) throws SQLException {
        String verifica = "SELECT count(*) as count FROM lerolero.alunos WHERE cpf = ?";
        boolean registroExiste = false;
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comando = db.prepareStatement(verifica);
        comando.setString(1, aluno.getCpf());
 
        ResultSet resultado = comando.executeQuery();
        if (resultado.next()) {
            if(resultado.getString("count").contains("1")){
                registroExiste = true;
            }
        }
       
        comando.close();
        conexaoDB.desconectar();
        return registroExiste;
    }
}
