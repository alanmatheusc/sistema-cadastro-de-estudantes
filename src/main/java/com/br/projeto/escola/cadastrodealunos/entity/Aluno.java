package com.br.projeto.escola.cadastrodealunos.entity;

public class Aluno {
    private String nome;
    private int idade;
    private int cpf;
    private int rg;
    private String nomeDaMae;
    private String nomeDoPai;
    private DadosComplementares dadosComplementares;

    public Aluno(String nome, int idade, int cpf, int rg, String nomeDoPai, String nomeDaMae, DadosComplementares dadosComplementares) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.dadosComplementares = dadosComplementares;
    }

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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
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
        return dadosComplementares;
    }

    public void setDadosComplementares(DadosComplementares dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public boolean validadorDeCpf(int cpf){
        return true;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", rg=" + rg +
                ", nomeDaMae='" + nomeDaMae + '\'' +
                ", nomeDoPai='" + nomeDoPai + '\'' +
                ", dadosComplementares=" + dadosComplementares +
                '}';
    }
}
