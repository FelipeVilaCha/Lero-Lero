package br.uff.model;

import java.util.Date;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class Turmas {
    protected int id;
    protected int instrutores_id;
    protected int cursos_id;
    protected Date data_inicio;
    protected Date data_final;
    protected int carga_horaria;

    public Turmas(int id, int instrutores_id, int cursos_id, Date data_inicio, Date data_final, int carga_horaria) {
        this.id = id;
        this.instrutores_id = instrutores_id;
        this.cursos_id = cursos_id;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.carga_horaria = carga_horaria;
    }
    
    public Turmas(int instrutores_id, int cursos_id, Date data_inicio, Date data_final, int carga_horaria) {
        this.instrutores_id = instrutores_id;
        this.cursos_id = cursos_id;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.carga_horaria = carga_horaria;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstrutores_id() {
        return instrutores_id;
    }

    public void setInstrutores_id(int instrutores_id) {
        this.instrutores_id = instrutores_id;
    }

    public int getCursos_id() {
        return cursos_id;
    }

    public void setCursos_id(int cursos_id) {
        this.cursos_id = cursos_id;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
    
    
}
