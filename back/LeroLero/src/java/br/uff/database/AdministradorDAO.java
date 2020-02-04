package br.uff.database;

import br.uff.dominio.Administrador;
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
public class AdministradorDAO {
    private final Conexao conexaoDB;
     
    public AdministradorDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
     
    public boolean insertAdmin(Administrador admin) throws SQLException {
        String sql = "INSERT INTO administrador (nome, login, senha) VALUES (?, ?, ?)";
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, admin.getNome());
        comando.setString(2, admin.getLogin());
        comando.setString(3, admin.getSenha());
        
        boolean registroInserido = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroInserido;
    }
     
    public List<Administrador> listarAdmin() throws SQLException {
        List<Administrador> listaAdministrador = new ArrayList<>();
         
        String sql = "SELECT * FROM administrador";
         
        Connection db = conexaoDB.conectar();
         
        Statement comando = db.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
         
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            String login = resultado.getString("login");
            String senha = resultado.getString("senha");
             
            Administrador admin = new Administrador(id, nome, login, senha);
            listaAdministrador.add(admin);
        }
         
        resultado.close();
        comando.close();
         
        conexaoDB.desconectar();
        
        return listaAdministrador;
    }
     
    public boolean deletaAdmin(Administrador admin) throws SQLException {
        String sql = "DELETE FROM administrador where id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, admin.getId());
         
        boolean registroDeletado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroDeletado;     
    }
     
    public boolean atualizaAdmin(Administrador admin) throws SQLException {
        String sql = "UPDATE administrador SET nome = ?, login = ?, senha = ?";
        sql += " WHERE id = ?";
        
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, admin.getNome());
        comando.setString(2, admin.getLogin());
        comando.setString(3, admin.getSenha());
        comando.setInt(4, admin.getId());
         
        boolean registroAtualizado = comando.executeUpdate() > 0;
        comando.close();
        conexaoDB.desconectar();
        return registroAtualizado;     
    }
     
    public Administrador getAdmin(int id) throws SQLException {
        Administrador admin = null;
        String sql = "SELECT * FROM administrador WHERE id = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setInt(1, id);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");
            String senha = resultado.getString("senha");
             
            admin = new Administrador(id, nome, email, senha);
        }
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
        
        return admin;
    }
}
