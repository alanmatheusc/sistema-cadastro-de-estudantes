package com.br.projeto.escola.cadastrodealunos.controller;

import com.br.projeto.escola.cadastrodealunos.controller.dto.SaveAlunoDto;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.service.AlunoService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AlunoController implements HttpHandler {


    private final AlunoService service;

    public AlunoController(AlunoService alunoService) {
        this.service = alunoService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();

                // Dados de texto enviados do POSTMAN/Front para o Controller
                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                String requestBody = reader.lines().collect(Collectors.joining("\n"));
                reader.close();

                // Utiliza Biblioteca ObjectMapper para mapear o texto enviado para a classe do tipo SaveAlunoDto
                SaveAlunoDto saveAlunoDto = objectMapper.readValue(requestBody, SaveAlunoDto.class);

                // Tenta salvar
                this.service.cadastrar(saveAlunoDto);

                //Response status code 201(Created) e nao envia nada
                exchange.sendResponseHeaders(201, 0);
                OutputStream os = exchange.getResponseBody();
                os.close();
            }catch (RuntimeException e){
                //Caso aconteça erro, ele envia um status code 500 com o erro
                System.out.println("Error: " + e.getMessage()); // Print the exception message
                String errorMessage = "Internal Server Error: " + e.getMessage();
                exchange.sendResponseHeaders(500, errorMessage.getBytes().length); // Internal server error

                OutputStream os = exchange.getResponseBody();
                os.write(errorMessage.getBytes());
                os.close();
            }

        } else if (exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            List<Aluno> alunos = this.service.listarTodos();
            String response = alunos.toString();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }else{// Respond with 405 Method Not Allowed for non-POST requests
            exchange.sendResponseHeaders(405, -1);
        }
    }
}