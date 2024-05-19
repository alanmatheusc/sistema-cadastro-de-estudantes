package com.br.projeto.escola.cadastrodeprofessores.service;

import com.br.projeto.escola.cadastrodeprofessores.controller.dto.SaveProfessorDto;
import com.br.projeto.escola.cadastrodeprofessores.entity.Professor;
import com.br.projeto.escola.cadastrodeprofessores.repository.ProfessorRepository;

public class ProfessorService {

    private ProfessorRepository repository;
    public ProfessorService(ProfessorRepository repo){
        this.repository = repo;
    }


    public void cadastrarProfessor(SaveProfessorDto professorDto){
        if(professorDto.getNome() == ""){
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        if(professorDto.getCpf() == ""){
            throw new IllegalArgumentException("CPF não pode estar vazio.");
        }
        if(professorDto.getNomeDaMae() == ""){
            throw new IllegalArgumentException("Nome da mãe nao pode estar vazio.");
        }
        if(professorDto.getRg() == ""){
            throw new IllegalArgumentException("RG nao pode estar vazio.");
        }
        Professor prof = new Professor(professorDto.getNome(), professorDto.getIdade(),professorDto.getCpf(),professorDto.getRg(),professorDto.getNomeDoPai(),professorDto.getNomeDaMae(),null);

        repository.salvar(prof);
    }

}
