package com.barberia.model;

public class Reserva {
    // 1. Atributos/Variables (Arriba)
    private String cliente;
    private String fechaHora;
    // ... otros atributos

    // 2. Constructor original (El de 6 parámetros que ya tienes)
    public Reserva(String param1, String param2, String param3, String param4, int param5, String param6) {
        // ... tu código actual
    }

    // 3. NUEVO CONSTRUCTOR (Agrégalo aquí, antes de los Getters y Setters)
    public Reserva(String cliente, String fechaHora, String servicio) {
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        // Inicializa lo que necesites
    }

    // 4. Getters y Setters (Asegúrate de que existan estos dos)
    public String getCliente() {
        return this.cliente;
    }

    public String getFechaHora() {
        return this.fechaHora;
    }

    // ... el resto de tus métodos getters y setters
} // <-- Esta es la última llave del archivo. El código va antes de esta llave.
