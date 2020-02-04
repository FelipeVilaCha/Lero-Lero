package br.uff.database;

import br.uff.dominio.Matriculas;
import br.uff.dominio.PlanoEstudos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public List<PlanoEstudos> listarPlanoDeEstudos(int alunos_id) throws SQLException, ParseException {
        List<PlanoEstudos> plano = new ArrayList<>();
        
        String sql = "SELECT m.id, m.data_matricula, i.nome as nome_instrutor, c.nome as nome_curso, c.carga_horaria, m.nota, t.data_inicio, t.data_final "
                + "FROM lerolero.matriculas m, lerolero.cursos c, lerolero.turmas t, lerolero.instrutores i "
                + "WHERE t.instrutores_id = i.id and m.alunos_id = " + alunos_id + " and CURDATE() BETWEEN t.data_inicio and t.data_final";
         
        Connection db = conexaoDB.conectar();
        
        PreparedStatement comando = db.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery(sql);
        
        while (resultado.next()) {
            int id_matricula = resultado.getInt("id");
            String data_matricula = resultado.getString("data_matricula");
            String nome_instrutor = resultado.getString("nome_instrutor");
            String nome_curso = resultado.getString("nome_curso");
            int carga_horaria = resultado.getInt("carga_horaria");
            Float nota = resultado.getFloat("nota");
            String data_inicio = resultado.getString("data_inicio");
            String data_final = resultado.getString("data_final");
            
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            String data_matricula_formatada = sdf.format(sd.parse(data_matricula));
            String data_inicio_formatada = sdf.format(sd.parse(data_inicio));
            String data_final_formatada = sdf.format(sd.parse(data_final));
            
            plano.add(new PlanoEstudos(id_matricula, data_matricula_formatada, nome_instrutor, nome_curso, carga_horaria, nota, data_inicio_formatada, data_final_formatada));
        }
        
        resultado.close();
        comando.close();
        conexaoDB.desconectar();
         
        return plano;
    }
}
