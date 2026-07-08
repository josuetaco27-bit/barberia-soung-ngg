package com.barberia.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.barberia.controller.GestorReservas;
import com.barberia.model.Reserva;

public class GestorReservasTest {
    private GestorReservas gestor;

    @BeforeEach
    public void setUp() {
        gestor = new GestorReservas();
    }

    @Test
    public void testCrearReservaExitoso() {
        Reserva r1 = new Reserva("1", "Gael", "Renato", "2026-07-15", 10, "Corte");
        String resultado = gestor.crearReserva(r1);
        assertEquals("OK: Reserva confirmada con éxito.", resultado);
    }

    @Test
    public void testCrearReservaHorarioInvalido() {
        Reserva rFuera = new Reserva("2", "Pedro", "Renato", "2026-07-15", 22, "Barba");
        String resultado = gestor.crearReserva(rFuera);
        assertTrue(resultado.contains("ERROR: Horario fuera de rango"));
    }

    @Test
    public void testCrearReservaCruceHorario() {
        Reserva r1 = new Reserva("3", "Gael", "Renato", "2026-07-15", 14, "Corte");
        Reserva r2 = new Reserva("4", "Lucas", "Renato", "2026-07-15", 14, "Combo");
        gestor.crearReserva(r1);
        String resultadoCruce = gestor.crearReserva(r2);
        assertTrue(resultadoCruce.contains("ERROR: El barbero ya tiene una cita asignada"));
    }
}
