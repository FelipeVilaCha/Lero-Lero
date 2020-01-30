package br.uff.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class LoginDAO {
    private Conexao conexaoDB;
    
    public LoginDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
    }
    
    public boolean validaLogin(String login, String senha, String permissao) throws SQLException {
        boolean status;
        String sql = "SELECT * FROM " + permissao + " WHERE login = ? and senha = ?";
         
        Connection db = conexaoDB.conectar();
         
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, login);
        comando.setString(2, senha);
         
        ResultSet resultado = comando.executeQuery();
         
        status = resultado.next();
         
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
        
        return status;
    }
}