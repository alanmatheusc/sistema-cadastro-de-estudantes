package com.br.projeto.escola.cadastrodealunos.controller.dto;

public class GetAlunoDto {
    private String nome;
    private int idade;
    private String nomeDaMae;
    private String nomeDoPai;
    private String logradouro;
    private int cep;
    private int numero;
    private String pontoDeReferencia;

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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }


    @Override
    public String toString() {
        return "GetAlunoDto{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nomeDaMae='" + nomeDaMae + '\'' +
                ", nomeDoPai='" + nomeDoPai + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cep=" + cep +
                ", numero=" + numero +
                ", pontoDeReferencia='" + pontoDeReferencia + '\'' +
                '}';
    }
}
