package com.br.projeto.escola.cadastrodealunos.service;

import com.br.projeto.escola.cadastrodealunos.controller.dto.SaveAlunoDto;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(SaveAlunoDto saveAlunoDto) {
        if (saveAlunoDto.getNome() == ""){
            throw new IllegalArgumentException("Nome do aluno nao pode estar vazio.");
        }
        if (saveAlunoDto.getIdade() < 10) {
            throw new IllegalArgumentException("Aluno muito novo.");
        }
        if (!this.ValidaCPF(saveAlunoDto.getCpf())){
            throw new IllegalArgumentException("CPF Invalido");
        }
        Aluno aluno = new Aluno(saveAlunoDto.getNome(), saveAlunoDto.getIdade(), saveAlunoDto.getCpf(), saveAlunoDto.getRg(), saveAlunoDto.getNomeDoPai(), saveAlunoDto.getNomeDaMae(),null);
        this.repository.Salvar(aluno);
    }

    public List<Aluno> listarTodos( ) {
        return this.repository.ListarTodos();
    }

    private boolean ValidaCPF(int cpf) {
        return true;
    }


}
