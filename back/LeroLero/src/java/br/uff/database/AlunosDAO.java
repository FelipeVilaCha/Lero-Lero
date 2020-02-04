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
        
        String sql = "INSERT INTO lerolero.alunos (cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            comando.setString(11, aluno.getComentario());
            comando.setString(12, aluno.getAprovado());
            registroInserido = comando.executeUpdate() > 0;
        }
        conexaoDB.desconectar();
        return registroInserido;
        
    }
     
    public List<Alunos> listarAlunos() throws SQLException {
        List<Alunos> listaAlunos = new ArrayList<>();
         
        String sql = "SELECT * FROM lerolero.alunos WHERE aprovado != \"P\"";
         
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
            String comentario = resultado.getString("comentario");
            String aprovado = resultado.getString("aprovado");
             
            Alunos aluno = new Alunos(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
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
        String sql = "UPDATE alunos SET cpf = ?, nome = ?, email = ?, celular = ?, login = ?, senha = ?, endereco = ?, cidade = ?, bairro = ?, cep = ?, comentario = ?, aprovado = ?";
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
        comando.setString(11, aluno.getComentario());
        comando.setString(12, aluno.getAprovado());
        comando.setInt(13, aluno.getId());
         
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
            String comentario = resultado.getString("comentario");
            String aprovado = resultado.getString("aprovado");
            
            aluno = new Alunos(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
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
    
    public List<Alunos> listarSolicitacoes() throws SQLException {
        List<Alunos> listaAlunos = new ArrayList<>();
        Connection db = conexaoDB.conectar();
        
        String solicitacoes = "SELECT * FROM lerolero.alunos WHERE aprovado = ?";
        boolean registroExiste = false;
        
        PreparedStatement comando = db.prepareStatement(solicitacoes);
        comando.setString(1, "P");
        
        ResultSet resultado = comando.executeQuery();
        
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
            String comentario = resultado.getString("comentario");
            String aprovado = resultado.getString("aprovado");
             
            Alunos aluno = new Alunos(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
            listaAlunos.add(aluno);
        }
       
        comando.close();
        conexaoDB.desconectar();
        return listaAlunos;
    }
    
    public boolean aceitarSolicitacao(Alunos aluno) throws SQLException {
        List<Alunos> listaAlunos = new ArrayList<>();
        Connection db = conexaoDB.conectar();
        
        String sql = "UPDATE alunos SET cpf = ?, nome = ?, email = ?, celular = ?, login = ?, senha = ?, endereco = ?, cidade = ?, bairro = ?, cep = ?, comentario = ?, aprovado = ?";
        sql += " WHERE id = ?";
         
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
        comando.setString(11, aluno.getComentario());
        comando.setString(12, "N");
        comando.setInt(13, aluno.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroAtualizado;
    }
}
