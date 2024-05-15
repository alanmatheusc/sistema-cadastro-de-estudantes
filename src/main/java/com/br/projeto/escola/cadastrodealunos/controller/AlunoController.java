package com.br.projeto.escola.cadastrodealunos.controller;

import com.br.projeto.escola.cadastrodealunos.controller.dto.GetAlunoDto;
import com.br.projeto.escola.cadastrodealunos.controller.dto.SaveAlunoDto;
import com.br.projeto.escola.cadastrodealunos.entity.Aluno;
import com.br.projeto.escola.cadastrodealunos.service.AlunoService;

public class AlunoController{

    // Aqui eu quero simular a entrada de Dados, da melhor forma possivel eu tive que usar uma classe AlunoEntity
    // para simular, porque quando o front me envia algo eles já me enviam um object então eu consigo trabalhar
    // então optei por apenas usar o entity no controller mandar pra cá os dados do Scanner e fazer o fluxo normalmente
    // passando paro o DTO e do DTO pro service.
    private  AlunoService service;
    private  Aluno aluno;

    public AlunoController(AlunoService alunoService, Aluno aluno) {
        this.service = alunoService;
        this.aluno = aluno;
    }

    public AlunoController(AlunoService alunoService) {
        this.service = alunoService;
    }

//
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
//            try {
//                ObjectMapper objectMapper = new ObjectMapper();
//
//                // Dados de texto enviados do POSTMAN/Front para o Controller
//                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
//                String requestBody = reader.lines().collect(Collectors.joining("\n"));
//                reader.close();
//
//                // Utiliza Biblioteca ObjectMapper para mapear o texto enviado para a classe do tipo SaveAlunoDto
//                SaveAlunoDto saveAlunoDto = objectMapper.readValue(requestBody, SaveAlunoDto.class);
//
//                // Tenta salvar
//                this.service.cadastrar(saveAlunoDto);
//
//                //Response status code 201(Created) e nao envia nada
//                exchange.sendResponseHeaders(201, 0);
//                OutputStream os = exchange.getResponseBody();
//                os.close();
//            }catch (RuntimeException e){
//                //Caso aconteça erro, ele envia um status code 500 com o erro
//                System.out.println("Error: " + e.getMessage()); // Print the exception message
//                String errorMessage = "Internal Server Error: " + e.getMessage();
//                exchange.sendResponseHeaders(500, errorMessage.getBytes().length); // Internal server error
//
//                OutputStream os = exchange.getResponseBody();
//                os.write(errorMessage.getBytes());
//                os.close();
//            }
//
//        } else if (exchange.getRequestMethod().equalsIgnoreCase("GET")) {
//            List<Aluno> alunos = this.service.listarTodos();
//            String response = alunos.toString();
//            exchange.sendResponseHeaders(200, response.getBytes().length);
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }else{// Respond with 405 Method Not Allowed for non-POST requests
//            exchange.sendResponseHeaders(405, -1);
//        }
//    }

    public  void adicionarAluno() {
        SaveAlunoDto alunoDto = new SaveAlunoDto();
        alunoDto.setNome(aluno.getNome());
        alunoDto.setIdade(aluno.getIdade());
        alunoDto.setCpf(aluno.getCpf());
        alunoDto.setRg(aluno.getRg());
        alunoDto.setNomeDaMae(aluno.getNomeDaMae());
        alunoDto.setNomeDoPai(aluno.getNomeDoPai());

        service.cadastrar(alunoDto);
    }

    public GetAlunoDto listarTodosAlunos(){
        return service.listarTodos();
    }
}