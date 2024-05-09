package com.br.projeto.escola.cadastrodealunos.service;

import com.br.projeto.escola.cadastrodealunos.model.CadastroDeAlunoModel;
import com.br.projeto.escola.cadastrodealunos.repository.CadastroDeAlunoRepository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDeAlunoService {

    public void cadastrarAluno(CadastroDeAlunoModel aluno) throws SQLException, IOException {
        CadastroDeAlunoRepository repository = new CadastroDeAlunoRepository();
        String sql = "INSERT INTO estudante(nome,idade,cpf,rg,nomeDaMae,nomeDoPai) values (?,?,?,?,?,?)";
        Connection conexaoBancoDeDados =null;
        PreparedStatement preparInjecaoSql = null;

        try {
         conexaoBancoDeDados = repository.conectarNoBancoDeDados();
         preparInjecaoSql = conexaoBancoDeDados.prepareStatement(sql);
         if(conexaoBancoDeDados != null){
             preparInjecaoSql.setString(1,aluno.getNome());
             preparInjecaoSql.setInt(2,aluno.getIdade());
             preparInjecaoSql.setInt(3,aluno.getCpf());
             preparInjecaoSql.setInt(4,aluno.getRg());
             preparInjecaoSql.setString(5,aluno.getNomeDaMae());
             preparInjecaoSql.setString(6,aluno.getNomeDoPai());

             preparInjecaoSql.execute();
             System.out.println("Aluno criado com Sucesso!");
         }
        }catch(IOException e){
            System.out.println(e);
        }

    }

}
