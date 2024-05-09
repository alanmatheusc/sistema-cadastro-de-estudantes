package com.br.projeto.escola.cadastrodealunos.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CadastroDeAlunoRepository {
    public static Properties getProp() throws IOException {
        Properties props = new Properties();

        FileInputStream file = new FileInputStream(
                "C:\\Users\\oi\\Desktop\\Estudo\\src\\main\\resources\\database.properties");
        props.load(file);
        return props;
    }

    public  Connection conectarNoBancoDeDados() throws IOException, SQLException {
        Properties prop = getProp();
        String url = prop.getProperty("db.url");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        try{
            return DriverManager.getConnection(url, username, password);
        }catch(SQLException  e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
