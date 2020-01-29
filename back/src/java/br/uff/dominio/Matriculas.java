package br.uff.dominio;

import java.util.Date;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class Matriculas {
    protected int id;
    protected int turmas_id;
    protected int alunos_id;
    protected Date data_matricula;
    protected float nota;

    public Matriculas(int id, int turmas_id, int alunos_id, Date data_matricula, float nota) {
        this.id = id;
        this.turmas_id = turmas_id;
        this.alunos_id = alunos_id;
        this.data_matricula = data_matricula;
        this.nota = nota;
    }
    
    public Matriculas(int turmas_id, int alunos_id, Date data_matricula, float nota) {
        this.turmas_id = turmas_id;
        this.alunos_id = alunos_id;
        this.data_matricula = data_matricula;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurmas_id() {
        return turmas_id;
    }

    public void setTurmas_id(int turmas_id) {
        this.turmas_id = turmas_id;
    }

    public int getAlunos_id() {
        return alunos_id;
    }

    public void setAlunos_id(int alunos_id) {
        this.alunos_id = alunos_id;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    
}
