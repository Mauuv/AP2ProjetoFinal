package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BigBom","root","");
            System.out.println("Conectado com sucesso");
            return con;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
