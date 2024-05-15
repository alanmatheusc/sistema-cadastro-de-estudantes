package com.br.projeto.escola.cadastrodealunos.repository;

import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.infra.PostgresDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AlunoRepository {
    private Connection db;

    public AlunoRepository(Connection connection) {
        if (connection == null) {
            throw new Error("Need Connection with database");
        }
        this.db = connection;
    }

    public void Salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome,idade,cpf,rg,nome_da_mae,nome_do_pai) values (?,?,?,?,?,?)";
        PreparedStatement preparInjecaoSql = null;
        try {
            preparInjecaoSql = this.db.prepareStatement(sql);
            preparInjecaoSql.setString(1, aluno.getNome());
            preparInjecaoSql.setInt(2, aluno.getIdade());
            preparInjecaoSql.setString(3, aluno.getCpf());
            preparInjecaoSql.setString(4, aluno.getRg());
            preparInjecaoSql.setString(5, aluno.getNomeDaMae());
            preparInjecaoSql.setString(6, aluno.getNomeDoPai());
            preparInjecaoSql.execute();
            System.out.println("Aluno criado com Sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno ListarTodos() {
        String sql = "SELECT * FROM aluno";
        PreparedStatement preparInjecaoSql = null;
        Aluno aluno =  null;

        try {
            preparInjecaoSql = this.db.prepareStatement(sql);
            ResultSet reset = preparInjecaoSql.executeQuery();

            while (reset.next()) {
                String nome = (reset.getString("nome"));
               Integer idade = (reset.getInt("idade"));
               String nomePai = (reset.getString("nome_do_pai"));
                String nomeMae = (reset.getString("nome_da_mae"));
                String rg = (reset.getString("rg"));
                String cpf = (reset.getString("cpf"));
                aluno = new Aluno(nome,idade,cpf,rg,nomePai,nomeMae,null);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }

    public void Deletar(int id) {
        String sql = "DELETE FROM aluno WHERE id=" + id;
        PreparedStatement injetarSql = null;
        try {
            injetarSql = this.db.prepareStatement(sql);
            injetarSql.executeQuery();
            System.out.println("Aluno deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
