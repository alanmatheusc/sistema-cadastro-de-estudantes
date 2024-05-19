package com.br.projeto.escola.usuario.entity.model;


public abstract class   Usuario {
    private String nome;
    private int idade;
    private String cpf;
    private String rg;
    private String nomeDaMae;
    private String nomeDoPai;
    private DadosComplementares dados;

    public Usuario(String nome, int idade, String cpf, String rg, String nomeDoPai, String nomeDaMae, DadosComplementares dados) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.dados = dados;
    }

    public Usuario() {

    }

    protected abstract void funcao();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public DadosComplementares getDadosComplementares() {
        return dados;
    }

    public void setDadosComplementares(DadosComplementares dadosComplementares) {
        this.dados = dadosComplementares;
    }

    public boolean validadorDeCpf(int cpf){
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", rg=" + rg +
                ", nomeDaMae='" + nomeDaMae + '\'' +
                ", nomeDoPai='" + nomeDoPai + '\'' +
                ", dadosComplementares=" + dados +
                '}';
    }
}
