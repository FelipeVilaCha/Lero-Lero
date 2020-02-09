package br.uff.model;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class PlanoEstudos {
    protected int id_matricula;
    protected String data_matricula;
    protected String nome_professor;
    protected String nome_curso;
    protected int carga_horaria;
    protected double nota;
    protected String data_inicio;
    protected String data_final;

    public PlanoEstudos(int id_matricula, String data_matricula, String nome_professor, String nome_curso, int carga_horaria, double nota, String data_inicio, String data_final) {
        this.id_matricula = id_matricula;
        this.data_matricula = data_matricula;
        this.nome_professor = nome_professor;
        this.nome_curso = nome_curso;
        this.carga_horaria = carga_horaria;
        this.nota = nota;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public String getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getNome_professor() {
        return nome_professor;
    }

    public void setNome_professor(String nome_professor) {
        this.nome_professor = nome_professor;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

}
