package com.barberia.controller;

import com.barberia.model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Reserva> baseDatosReservas;

    public GestorReservas() {
        this.baseDatosReservas = new ArrayList<>();
    }

    public String crearReserva(Reserva nuevaReserva) {
        if (nuevaReserva.getHora() < 9 || nuevaReserva.getHora() >= 20) {
            return "ERROR: Horario fuera de rango comercial (09:00 - 20:00).";
        }

        for (Reserva r : baseDatosReservas) {
            if (r.getBarbero().equalsIgnoreCase(nuevaReserva.getBarbero()) &&
                r.getFecha().equals(nuevaReserva.getFecha()) &&
                r.getHora() == nuevaReserva.getHora()) {
                return "ERROR: El barbero ya tiene una cita asignada en ese horario.";
            }
        }

        baseDatosReservas.add(nuevaReserva);
        return "OK: Reserva confirmada con éxito.";
    }

    public List<Reserva> getReservas() {
        return baseDatosReservas;
    }
} 
