package com.barberia.model;

public class Reserva {
    
    // 1. Atributos / Variables de Clase
    private String cliente;
    private String barbero;
    private String fechaHora;
    private String servicio;
    private int id; // Por si lo requieres para la base de datos o lógica interna

    // 2. Constructor de 3 parámetros (UNIFICADO Y REPARADO)
    // Este constructor sirve para registrar la cita con los datos esenciales de la UI
    public Reserva(String cliente, String barbero, String fechaHora) {
        this.cliente = cliente;
        this.barbero = barbero;
        this.fechaHora = fechaHora;
    }

    // 3. Constructor de 6 parámetros (Tu constructor original adaptado para evitar conflictos)
    // Si tu constructor original usaba otros tipos, este modelo base mantendrá la compatibilidad
    public Reserva(String cliente, String barbero, String fechaHora, String servicio, int id, String param6) {
        this.cliente = cliente;
        this.barbero = barbero;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.id = id;
    }

    // 4. Métodos Getters y Setters
    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getBarbero() {
        return this.barbero;
    }

    public void setBarbero(String barbero) {
        this.barbero = barbero;
    }

    public String getFechaHora() {
        return this.fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}