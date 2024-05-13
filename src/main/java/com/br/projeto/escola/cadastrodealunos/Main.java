package com.br.projeto.escola.cadastrodealunos;


import com.br.projeto.escola.cadastrodealunos.controller.AlunoController;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.infra.PostgresDatabase;
import com.br.projeto.escola.cadastrodealunos.repository.AlunoRepository;
import com.br.projeto.escola.cadastrodealunos.service.AlunoService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        PostgresDatabase database = new PostgresDatabase();
        AlunoRepository repository = new AlunoRepository(database.getConnection());
        AlunoService alunoService = new AlunoService(repository);
        AlunoController controler = new AlunoController(alunoService);

        int port = 8080;
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(port), 0);
        server.createContext("/alunos", controler);
        server.start();
        System.out.println("Server started on port " + port);

    }

}
