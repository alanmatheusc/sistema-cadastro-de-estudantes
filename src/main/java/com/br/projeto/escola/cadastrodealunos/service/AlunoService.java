package com.br.projeto.escola.cadastrodealunos.service;

import com.br.projeto.escola.cadastrodealunos.controller.dto.GetAlunoDto;
import com.br.projeto.escola.cadastrodealunos.controller.dto.SaveAlunoDto;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.repository.AlunoRepository;

public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(SaveAlunoDto saveAlunoDto) {
        if (saveAlunoDto.getNome() == ""){
            throw new IllegalArgumentException("Nome do aluno nao pode estar vazio.");
        }
        if (saveAlunoDto.getIdade()  == 0 || saveAlunoDto.getIdade() < 6) {
            throw new IllegalArgumentException("Aluno impossibilitado de ser registrado, idade minima de 6 anos.");
        }
        if (!this.ValidaCPF(saveAlunoDto.getCpf())){
            throw new IllegalArgumentException("CPF Invalido");
        }
        if(saveAlunoDto.getNomeDaMae() == ""){
            throw new IllegalArgumentException("Nome da mãe nao pode estar vazio.");
        }
        if(saveAlunoDto.getNomeDaMae().length() <= 3){
            throw new IllegalArgumentException("Nome da mãe muito pequeno.");
        }
        if(saveAlunoDto.getNomeDaMae() == ""){
            throw new IllegalArgumentException("Nome do Pai nao pode estar vazio.");
        }
        if(saveAlunoDto.getNomeDoPai() == ""){
            saveAlunoDto.setNomeDoPai("Não possui.");
        }

        Aluno aluno = new Aluno(saveAlunoDto.getNome(), saveAlunoDto.getIdade(), saveAlunoDto.getCpf(), saveAlunoDto.getRg(), saveAlunoDto.getNomeDoPai(), saveAlunoDto.getNomeDaMae(),null);
        this.repository.Salvar(aluno);
    }

    public GetAlunoDto listarTodos() {
        GetAlunoDto alunoDto = new GetAlunoDto();
        Aluno alunos = this.repository.ListarTodos();
        alunoDto.setNome(alunos.getNome());
        alunoDto.setIdade(alunos.getIdade());
        alunoDto.setNomeDaMae(alunos.getNomeDaMae());
        alunoDto.setNomeDoPai(alunos.getNomeDoPai());
        return alunoDto;
    }

    private boolean ValidaCPF(String cpf) {
        return true;
    }


}
