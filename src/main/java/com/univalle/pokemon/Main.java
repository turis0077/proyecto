package com.univalle.pokemon;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando la ejecución...");

        // Creación de instancias
        Controlador controlador = new Controlador();

        // Llamada a algún método del controlador
        controlador.ejecutar();

        System.out.println("Ejecución finalizada.");
    }
}
