package br.uff.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe Vila Chã
 */
public class Conexao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/lerolero?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private final String jdbcUser = "root";
    private final String jdbcSenha = "1234";
    private Connection jdbcConexao;
     
    public Conexao(){};
     
    protected Connection conectar() throws SQLException {
        if (jdbcConexao == null || jdbcConexao.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConexao = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcSenha);
        }
        
        return jdbcConexao;
    }

    public Connection getJdbcConexao() {
        return jdbcConexao;
    }
 
    protected void desconectar() throws SQLException {
        if (jdbcConexao != null && !jdbcConexao.isClosed()) {
            jdbcConexao.close();
        }
    }
}
