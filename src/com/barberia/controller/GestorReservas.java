package com.barberia.controller;

import com.barberia.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private String urlConnection = "jdbc:sqlite:barberia.db";

    public GestorReservas() {
        // Inicializar la base de datos y crear la tabla si no existe
        try (Connection conn = DriverManager.getConnection(urlConnection);
            Statement stmt = conn.createStatement()) {
            
            String sql = "CREATE TABLE IF NOT EXISTS reservas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "cliente TEXT NOT NULL, " +
                        "barbero TEXT NOT NULL, " +
                        "fechaHora TEXT NOT NULL)";
            stmt.execute(sql);
            System.out.println("Base de datos SQLite inicializada correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    // Método para guardar una reserva en la base de datos
    public boolean agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas(cliente, barbero, fechaHora) VALUES(?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(urlConnection);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, reserva.getCliente());
            pstmt.setString(2, reserva.getBarbero());
            pstmt.setString(3, reserva.getFechaHora());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar reserva: " + e.getMessage());
            return false;
        }
    }

    // Método para listar todas las reservas guardadas
    public List<Reserva> obtenerReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT cliente, barbero, fechaHora FROM reservas";
        
        try (Connection conn = DriverManager.getConnection(urlConnection);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                lista.add(new Reserva(
                    rs.getString("cliente"),
                    rs.getString("barbero"),
                    rs.getString("fechaHora")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar reservas: " + e.getMessage());
        }
        return lista;
    }
}
