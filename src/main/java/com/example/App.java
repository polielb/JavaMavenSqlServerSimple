package com.example;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-GMUPP2V\\SQLEXPRESS:64577;databaseName=master;integratedSecurity=true";

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            System.out.println("Conexión exitosa");

            // Obtener la fecha actual de SQL Server
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT GETDATE()");
                if (rs.next()) {
                    System.out.println("Fecha actual de SQL Server: " + rs.getTimestamp(1));
                } else {
                    System.out.println("No se pudo obtener la fecha de SQL Server.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a SQL Server: " + e.getMessage());
        }
    }
}
