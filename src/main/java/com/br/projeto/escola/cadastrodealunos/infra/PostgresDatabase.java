package com.br.projeto.escola.cadastrodealunos.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresDatabase {
    static Connection connection;

    public static Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream input = null;
        input = new FileInputStream("src/main/resources/database.properties");

        prop.load(input);
        return prop;
    }

    public Connection getConnection() {
        return connection;
    }

    public PostgresDatabase() throws IOException, SQLException {
        Properties prop = getProp();
        String url = prop.getProperty("db.url");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        try{
            this.connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException  e){
            throw e;
        }
    }
}
