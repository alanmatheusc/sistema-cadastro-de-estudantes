package com.br.projeto.escola.cadastrodealunos.model;

public class CadastroDeAlunoModel {
    private String nome;
    private int idade;
    private int cpf;
    private int rg;
    private String nomeDaMae;
    private String nomeDoPai;
    private CadastroDeDadosComplementares dadosComplementares;


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

    public CadastroDeDadosComplementares getDadosComplementares() {
        return dadosComplementares;
    }

    public void setDadosComplementares(CadastroDeDadosComplementares dadosComplementares) {
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
