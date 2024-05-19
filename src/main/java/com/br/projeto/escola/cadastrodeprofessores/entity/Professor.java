package com.br.projeto.escola.cadastrodeprofessores.entity;

import com.br.projeto.escola.usuario.entity.model.DadosComplementares;
import com.br.projeto.escola.usuario.entity.model.Usuario;

public class Professor extends Usuario {
    public Professor(String nome, int idade, String cpf, String rg, String nomeDoPai, String nomeDaMae, DadosComplementar dadosComplementares) {
        super(nome, idade, cpf, rg, nomeDoPai, nomeDaMae, dadosComplementares);
    }

    @Override
    public void funcao() {
        System.out.println("Ensinar e corrigir.");
    }
}
