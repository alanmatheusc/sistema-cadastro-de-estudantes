package com.br.projeto.escola.cadastrodealunos.service;

import com.br.projeto.escola.cadastrodealunos.model.CadastroDeAlunoModel;
import com.br.projeto.escola.cadastrodealunos.repository.CadastroDeAlunoRepository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<CadastroDeAlunoModel> listarAlunos(){
        CadastroDeAlunoRepository repository = new CadastroDeAlunoRepository();
        String sql = "SELECT * FROM estudante";
        Connection conexaoBancoDeDados =null;
        PreparedStatement preparInjecaoSql = null;
        List<CadastroDeAlunoModel> alunos = new ArrayList<CadastroDeAlunoModel>();

        try{
            conexaoBancoDeDados = repository.conectarNoBancoDeDados();
            preparInjecaoSql = conexaoBancoDeDados.prepareStatement(sql);
            ResultSet reset = preparInjecaoSql.executeQuery();

            while(reset.next()){
                CadastroDeAlunoModel aluno = new CadastroDeAlunoModel();

                aluno.setNome(reset.getString("nome"));
                aluno.setIdade(reset.getInt("idade"));
                aluno.setNomeDoPai(reset.getString("nomedopai"));
                aluno.setNomeDaMae(reset.getString("nomedamae"));
                aluno.setRg(reset.getInt("rg"));
                aluno.setCpf(reset.getInt("cpf"));
                alunos.add(aluno);
                System.out.println(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

    public void deletarAlunoPeloId(int id){
        String sql = "DELETE FROM estudante WHERE id="+id;
        PreparedStatement injetarSql = null;
        Connection conexaoBancoDeDados = null;
        CadastroDeAlunoRepository alunoRepository = new CadastroDeAlunoRepository();
        try{
            conexaoBancoDeDados = alunoRepository.conectarNoBancoDeDados();
            injetarSql = conexaoBancoDeDados.prepareStatement(sql);

            if(conexaoBancoDeDados != null){
                injetarSql.executeQuery();
                System.out.println("Aluno deletado com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
