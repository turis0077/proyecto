package com.univalle.pokemon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    private Map<String, Pokemon> pokemonMap;
    private UserCollection userCollection;
    private Pokemon pikachu;
    private Pokemon charmander;
    private Pokemon squirtle;

    @BeforeEach
    void setUp() {
        pokemonMap = new HashMap<>();
        pikachu = new Pokemon("Pikachu", "Electric", "N/A", "Static", 320, 35, 55, 40, 50, 50, 90, 1, false);
        charmander = new Pokemon("Charmander", "Fire", "N/A", "Blaze", 309, 39, 52, 43, 60, 50, 65, 1, false);
        squirtle = new Pokemon("Squirtle", "Water", "N/A", "Torrent", 314, 44, 48, 65, 50, 64, 43, 1, false);
        pokemonMap.put(pikachu.getName(), pikachu);
        pokemonMap.put(charmander.getName(), charmander);
        pokemonMap.put(squirtle.getName(), squirtle);
        userCollection = new UserCollection();
    }

    @Test
    void testAgregarPokemonSuccess() {
        String result = Operations.agregarPokemon(userCollection, pokemonMap, "Pikachu");
        assertEquals("Pokemon agregado exitosamente.", result);
        // Verificar que no se permita duplicar
        String duplicateResult = Operations.agregarPokemon(userCollection, pokemonMap, "Pikachu");
        assertEquals("El pokemon ya se encuentra en la colección.", duplicateResult);
    }

    @Test
    void testAgregarPokemonNotFound() {
        String result = Operations.agregarPokemon(userCollection, pokemonMap, "Mewtwo");
        assertEquals("Error: El pokemon no existe en los datos.", result);
    }

    @Test
    void testMostrarDatosPokemon() {
        String data = Operations.mostrarDatosPokemon(pokemonMap, "Charmander");
        assertTrue(data.contains("Charmander"));
        String notFound = Operations.mostrarDatosPokemon(pokemonMap, "Mew");
        assertEquals("Error: El pokemon no existe en los datos.", notFound);
    }

    @Test
    void testMostrarColeccionOrdenada() {
        Operations.agregarPokemon(userCollection, pokemonMap, "Pikachu");    // Electric
        Operations.agregarPokemon(userCollection, pokemonMap, "Charmander"); // Fire
        Operations.agregarPokemon(userCollection, pokemonMap, "Squirtle");   // Water

        String result = Operations.mostrarColeccionOrdenada(userCollection);
        String[] lines = result.split("\n");
        assertEquals(3, lines.length);
        // Orden alfabético por tipo1: Electric, Fire, Water
        assertTrue(lines[0].contains("Pikachu"));
        assertTrue(lines[1].contains("Charmander"));
        assertTrue(lines[2].contains("Squirtle"));
    }

    @Test
    void testMostrarTodosOrdenados() {
        String result = Operations.mostrarTodosOrdenados(pokemonMap);
        String[] lines = result.split("\n");
        assertEquals(3, lines.length);
        // Orden alfabético por tipo1: Electric, Fire, Water
        assertTrue(lines[0].contains("Pikachu"));
        assertTrue(lines[1].contains("Charmander"));
        assertTrue(lines[2].contains("Squirtle"));
    }

    @Test
    void testMostrarPorHabilidad() {
        String result = Operations.mostrarPorHabilidad(pokemonMap, "Static");
        assertTrue(result.contains("Pikachu"));
        String noResult = Operations.mostrarPorHabilidad(pokemonMap, "Overgrow");
        assertEquals("No se encontró ningún pokemon con la habilidad: Overgrow", noResult);
    }
}
