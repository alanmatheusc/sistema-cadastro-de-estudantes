package com.br.projeto.escola.cadastrodealunos;


import com.br.projeto.escola.cadastrodealunos.controller.AlunoController;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.infra.PostgresDatabase;
import com.br.projeto.escola.cadastrodealunos.repository.AlunoRepository;
import com.br.projeto.escola.cadastrodealunos.service.AlunoService;

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
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        List<Aluno > aluno = new ArrayList<Aluno>();
//        int port = 8080;
//        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(port), 0);
//        server.createContext("/alunos", controler);
//        server.start();
//        System.out.println("Server started on port " + port);

        //Para simular a entrada de dados  irei utilizar o Scanner, e para melhorar a simulação vou adicionar os dados em uma lista e mandar uma lista para
        // o Controller, afinal não sabemos quais dados iremos receber do front, e para poder usar o DTO.
        System.out.println(controler.listarTodosAlunos());
//        System.out.println("Qual serviço deseja acessar:");
//        System.out.println("Digite: 1 para cadastrar um Aluno");
//        System.out.println("Digite: 2 para buscar todos os Alunos");
//        int valorServico = sc.nextInt();
//        if (valorServico == 1) {
//            System.out.println("Digite o nome do Aluno: ");
//            String nome = scString.next();
//            System.out.println("Digite o CPF do Aluno: ");
//            String cpf = scString.next();
//            System.out.println("Digite a idade do Aluno: ");
//            int idade = sc.nextInt();
//            System.out.println("Digite o RG do Aluno: ");
//            String rg = scString.next();
//            System.out.println("Digite o nome da Mãe do Aluno: ");
//            String nomeMae = scString.next();
//            System.out.println("Digite o nome do Pai do Aluno: ");
//            String nomePai = sc.next();
//            Aluno alunoEntity = new Aluno(nome,idade,cpf,rg,nomeMae,nomePai,null);
//            controler = new AlunoController(alunoService,alunoEntity);
//            controler.adicionarAluno();
//        }else{
//            sc.close();
//        }

    }
}
