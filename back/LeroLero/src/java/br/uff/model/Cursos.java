package br.uff.model;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class Cursos {
    protected int id;
    protected String nome;
    protected String requisito;
    protected String ementa;
    protected int carga_horaria;
    protected double preco;

    public int getId() {
        return id;
    }

    public Cursos(int id, String nome, String requisito, String ementa, int carga_horaria, double preco) {
        this.id = id;
        this.nome = nome;
        this.requisito = requisito;
        this.ementa = ementa;
        this.carga_horaria = carga_horaria;
        this.preco = preco;
    }
    
    public Cursos(String nome, String requisito, String ementa, int carga_horaria, double preco) {
        this.nome = nome;
        this.requisito = requisito;
        this.ementa = ementa;
        this.carga_horaria = carga_horaria;
        this.preco = preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getRequisito() {
        return requisito;
    }

    public String getEmenta() {
        return ementa;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public double getPreco() {
        return preco;
    }    
}
