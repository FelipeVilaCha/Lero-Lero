package br.uff.dominio;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class Instrutores {
    protected int id;
    protected String nome;
    protected String email;
    protected int valor_hora;
    protected String login;
    protected String senha;
    protected String experiencia;

    public Instrutores(int id, String nome, String email, int valor_hora, String login, String senha, String experiencia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.valor_hora = valor_hora;
        this.login = login;
        this.senha = senha;
        this.experiencia = experiencia;
    }
    
    public Instrutores(String nome, String email, int valor_hora, String login, String senha, String experiencia) {
        this.nome = nome;
        this.email = email;
        this.valor_hora = valor_hora;
        this.login = login;
        this.senha = senha;
        this.experiencia = experiencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    
}


