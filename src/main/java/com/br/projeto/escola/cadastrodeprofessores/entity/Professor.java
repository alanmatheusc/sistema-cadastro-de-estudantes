package com.br.projeto.escola.cadastrodeprofessores.entity;

import com.br.projeto.escola.usuario.entity.model.Usuario;

public class Professor extends Usuario {
    public Professor(String nome, int idade, String cpf, String rg, String nomeDoPai, String nomeDaMae, DadosComplementar dadosComplementares) {
        super(nome, idade, cpf, rg, nomeDoPai, nomeDaMae, dadosComplementares);
    }
    public Professor(){}
}
