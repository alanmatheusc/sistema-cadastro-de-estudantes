package com.br.projeto.escola.cadastrodeprofessores.controller;

import com.br.projeto.escola.cadastrodeprofessores.controller.dto.GetProfessorDto;
import com.br.projeto.escola.cadastrodeprofessores.controller.dto.SaveProfessorDto;
import com.br.projeto.escola.cadastrodeprofessores.entity.Professor;
import com.br.projeto.escola.cadastrodeprofessores.service.ProfessorService;

public class ProfessorController {
    private ProfessorService professorService;
    private Professor professorList;

    public ProfessorController(ProfessorService service, Professor professor) {
        this.professorService = service;
        this.professorList = professor;
    }
    public ProfessorController(ProfessorService service) {
        this.professorService = service;
    }

    public void adicionarProfessor(){
        SaveProfessorDto professorDto = new SaveProfessorDto(professorList.getNome(),professorList.getIdade(),professorList.getCpf(),professorList.getRg(),professorList.getNomeDaMae(),professorList.getNomeDoPai());

    }

}
