package br.uff.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class LoginDAO {
    private String jdbcURL;
    private String jdbcUser;
    private String jdbcSenha;
    private Connection jdbcConexao;
    
    
    public LoginDAO(String jdbcURL, String jdbcUser, String jdbcSenha) {
        this.jdbcURL = jdbcURL;
        this.jdbcUser = jdbcUser;
        this.jdbcSenha = jdbcSenha;
    }
    
    protected void conectar() throws SQLException {
        if (jdbcConexao == null || jdbcConexao.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConexao = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcSenha);
        }
    }
    
    protected void desconectar() throws SQLException {
        if (jdbcConexao != null && !jdbcConexao.isClosed()) {
            jdbcConexao.close();
        }
    }
    
    public boolean validaLogin(String login, String senha, String permissao) throws SQLException {
        boolean status = false;
        String sql = "SELECT * FROM " + permissao + " WHERE login = ? and senha = ?";
         
        conectar();
         
        PreparedStatement comando = jdbcConexao.prepareStatement(sql);
        comando.setString(1, login);
        comando.setString(2, senha);
         
        ResultSet resultado = comando.executeQuery();
         
        if (resultado.next()) {
            status = true;
        } else {
            status = false;
        }
         
        resultado.close();
        comando.close();
        return status;
    }
}