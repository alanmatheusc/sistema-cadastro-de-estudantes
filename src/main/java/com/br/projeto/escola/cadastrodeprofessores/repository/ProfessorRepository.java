package com.br.projeto.escola.cadastrodeprofessores.repository;

import com.br.projeto.escola.cadastrodeprofessores.entity.Professor;

import java.sql.Connection;

public class ProfessorRepository {
   private Connection con;
    public ProfessorRepository(Connection con){
        if(con == null){
            throw new Error("Need connection");
        }
        this.con = con;
    }

    public void salvar(Professor professor){

    }

}
