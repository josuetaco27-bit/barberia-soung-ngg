package com.barberia.model;

public class Reserva {
    private String id;
    private String cliente;
    private String barbero;
    private String fecha; 
    private int hora;     
    private String servicio;

    public Reserva(String id, String cliente, String barbero, String fecha, int hora, String servicio) {
        this.id = id;
        this.cliente = cliente;
        this.barbero = barbero;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
    }

    public String getBarbero() { return barbero; }
    public String getFecha() { return fecha; }
    public int getHora() { return hora; }
}
