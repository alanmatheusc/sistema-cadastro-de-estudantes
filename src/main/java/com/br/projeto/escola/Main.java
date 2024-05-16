package com.br.projeto.escola;

import com.br.projeto.escola.cadastrodealunos.controller.AlunoController;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.infra.PostgresDatabase;
import com.br.projeto.escola.cadastrodealunos.repository.AlunoRepository;
import com.br.projeto.escola.cadastrodealunos.service.AlunoService;
import com.br.projeto.escola.cadastrodeprofessores.controller.ProfessorController;
import com.br.projeto.escola.cadastrodeprofessores.entity.Professor;
import com.br.projeto.escola.cadastrodeprofessores.repository.ProfessorRepository;
import com.br.projeto.escola.cadastrodeprofessores.service.ProfessorService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        PostgresDatabase database = new PostgresDatabase();
        AlunoRepository repository = new AlunoRepository(database.getConnection());
        AlunoService alunoService = new AlunoService(repository);
        AlunoController controler = new AlunoController(alunoService);

        ProfessorService professorService = new ProfessorService();
        ProfessorRepository professorRepository = new ProfessorRepository(database.getConnection());


        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
////        int port = 8080;
////        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(port), 0);
////        server.createContext("/alunos", controler);
////        server.start();
////        System.out.println("Server started on port " + port);
//
//        //Para simular a entrada de dados  irei utilizar o Scanner, e para melhorar a simulação vou adicionar os dados em uma lista e mandar uma lista para
//        // o Controller, afinal não sabemos quais dados iremos receber do front, e para poder usar o DTO.
        System.out.println(controler.listarTodosAlunos());
        System.out.println("Qual serviço deseja acessar:");
        System.out.println("Digite: 1 para cadastrar um Aluno");
        System.out.println("Digite: 2 para buscar todos os Alunos");
        int valorServico = sc.nextInt();
        if (valorServico == 1) {
            System.out.println("Digite o nome do Aluno: ");
            String nome = scString.next();
            System.out.println("Digite o CPF do Aluno: ");
            String cpf = scString.next();
            System.out.println("Digite a idade do Aluno: ");
            int idade = sc.nextInt();
            System.out.println("Digite o RG do Aluno: ");
            String rg = scString.next();
            System.out.println("Digite o nome da Mãe do Aluno: ");
            String nomeMae = scString.next();
            System.out.println("Digite o nome do Pai do Aluno: ");
            String nomePai = sc.next();
            Aluno alunoEntity = new Aluno(nome,idade,cpf,rg,nomeMae,nomePai,null);
            controler = new AlunoController(alunoService,alunoEntity);
            controler.adicionarAluno();
        }else if(valorServico == 2){
            System.out.println("Digite o nome do Professor: ");
            String nome = scString.next();
            System.out.println("Digite o CPF do Professor: ");
            String cpf = scString.next();
            System.out.println("Digite a idade do Professor: ");
            int idade = sc.nextInt();
            System.out.println("Digite o RG do Professor: ");
            String rg = scString.next();
            System.out.println("Digite o nome da Mãe do Professor: ");
            String nomeMae = scString.next();
            System.out.println("Digite o nome do Pai do Professor: ");
            String nomePai = sc.next();
            Professor professorEntity = new Professor(nome,idade,cpf,rg,nomeMae,nomePai,null);
            ProfessorController professor = new ProfessorController(professorService,professorEntity);
            professor.adicionarProfessor();
        }
    }
}
