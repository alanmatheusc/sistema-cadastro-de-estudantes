package com.br.projeto.escola.cadastrodeprofessores.repository;

import com.br.projeto.escola.cadastrodeprofessores.entity.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorRepository {
   private Connection con;

    public ProfessorRepository(Connection con){
        if(con == null){
            throw new Error("Need connection");
        }
        this.con = con;
    }


    public void salvar(Professor professor){
        String sql = "INSERT INTO professor(nome,idade,cpf,rg,nome_da_mae,nome_do_pai) values (?,?,?,?,?,?)";
        PreparedStatement psd = null;

        try{
            psd = this.con.prepareStatement(sql);
            psd.setString(1,professor.getNome());
            psd.setInt(2,professor.getIdade());
            psd.setString(3,professor.getCpf());
            psd.setString(4,professor.getRg());
            psd.setString(5,professor.getNomeDaMae());
            psd.setString(6,professor.getNomeDoPai());
            psd.execute();
            System.out.println("Professor criado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
