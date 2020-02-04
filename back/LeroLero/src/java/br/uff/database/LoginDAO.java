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
    private final Conexao conexaoDB;
    private final AlunosDAO alunos;
    private final InstrutoresDAO instrutores;
    private final AdministradorDAO admin;
    
    public LoginDAO(Conexao conexaoDB) {
        this.conexaoDB = conexaoDB;
        this.alunos = new AlunosDAO(conexaoDB);
        this.instrutores = new InstrutoresDAO(conexaoDB);
        this.admin = new AdministradorDAO(conexaoDB);
    }
    
    public int getConexaoID(String user, String senha, String permissao) throws SQLException{
        int id = 0;
        String sql = "";
        
        if(permissao.equals("alunos")){
            sql = "SELECT id FROM lerolero." + permissao + " WHERE login = ? and senha = ? and aprovado != \"P\"";
        } else {
            sql = "SELECT id FROM lerolero." + permissao + " WHERE login = ? and senha = ?";
        }
        
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comando = db.prepareStatement(sql);
        comando.setString(1, user);
        comando.setString(2, senha);
         
        ResultSet resultado = comando.executeQuery();
         
        if(resultado.next()){
            id = Integer.parseInt(resultado.getString("id").replace("!",""));
        }
        return id;
    }
    
    public boolean validaLogin(String login, String senha, String permissao) throws SQLException {
        boolean status;
        String sql = "";
        
        if(permissao.equals("alunos")){
            sql = "SELECT * FROM lerolero." + permissao + " WHERE login = ? and senha = ? and aprovado != \"P\"";
        } else {
            sql = "SELECT * FROM lerolero." + permissao + " WHERE login = ? and senha = ?";
        }
         
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
    
    public boolean validaLoginAdmin(String login, String senha) throws SQLException {
        boolean status;
        String sql = "SELECT * FROM lerolero.administrador WHERE login = ? and senha = ?";
         
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