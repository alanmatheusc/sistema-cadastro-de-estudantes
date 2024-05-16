package com.br.projeto.escola.cadastrodeprofessores.controller.dto;

public class SaveProfessorDto {
        private String nome;
        private int idade;
        private String cpf;
        private String rg;
        private String nomeDaMae;
        private String nomeDoPai;
        private String logradouro;
        private int cep;
        private int numero;
        private String pontoDeReferencia;

    public SaveProfessorDto(String nome, int idade, String cpf, String rg, String nomeDaMae, String nomeDoPai) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
    }

    public SaveProfessorDto(){}

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
    }


