package com.br.projeto.escola.cadastrodealunos.entity;

import com.br.projeto.escola.usuario.entity.model.Usuario;

public class Aluno extends Usuario {
    public Aluno(String nome, int idade, String cpf, String rg, String nomeDoPai, String nomeDaMae, ComplementoDeDados dadosComplementares) {
        super(nome, idade, cpf, rg, nomeDoPai, nomeDaMae, dadosComplementares);
    }

    @Override
    public void funcao() {
        System.out.println("Estudar e aprender");
    }
}
