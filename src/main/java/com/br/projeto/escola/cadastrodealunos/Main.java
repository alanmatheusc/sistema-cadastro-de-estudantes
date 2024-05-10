package com.br.projeto.escola.cadastrodealunos;


import com.br.projeto.escola.cadastrodealunos.model.CadastroDeAlunoModel;
import com.br.projeto.escola.cadastrodealunos.repository.CadastroDeAlunoRepository;
import com.br.projeto.escola.cadastrodealunos.service.CadastroDeAlunoService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        CadastroDeAlunoModel alunoModel = new CadastroDeAlunoModel();
        CadastroDeAlunoService alunoService = new CadastroDeAlunoService();

//        Scanner sc = new Scanner(System.in);
//        Scanner scannerString = new Scanner(System.in);
//
//
//        System.out.println("Bem vindo ao cadastro de Aluno!");
//        System.out.println("Nome do aluno: ");
//        alunoModel.setNome(scannerString.nextLine());
//        System.out.println("Idade do aluno: ");
//        alunoModel.setIdade(sc.nextInt());
//        System.out.println("CPF do aluno: ");
//        alunoModel.setCpf(sc.nextInt());
//        System.out.println("RG do aluno: ");
//        alunoModel.setRg(sc.nextInt());
//        System.out.println("Nome da mãe: ");
//        alunoModel.setNomeDaMae(scannerString.nextLine());
//        System.out.println("Nome do Pai: ");
//        alunoModel.setNomeDoPai(scannerString.nextLine());
//
//        alunoService.cadastrarAluno(alunoModel);

        alunoService.deletarAlunoPeloId(2);
        alunoService.listarAlunos();


    }

}
