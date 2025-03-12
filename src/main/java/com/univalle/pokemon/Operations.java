package com.univalle.pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Operations {

    public static String agregarPokemon(UserCollection userCollection, Map<String, Pokemon> pokemonMap, String nombre) {
        if (!pokemonMap.containsKey(nombre)) {
            return "Error: El pokemon no existe en los datos.";
        }
        if (userCollection.contains(nombre)) {
            return "El pokemon ya se encuentra en la colección.";
        }
        Pokemon pokemon = pokemonMap.get(nombre);
        userCollection.addPokemon(pokemon);
        return "Pokemon agregado exitosamente.";
    }

    public static String mostrarDatosPokemon(Map<String, Pokemon> pokemonMap, String nombre) {
        if (!pokemonMap.containsKey(nombre)) {
            return "Error: El pokemon no existe en los datos.";
        }
        Pokemon pokemon = pokemonMap.get(nombre);
        return pokemon.toString();
    }

    public static String mostrarColeccionOrdenada(UserCollection userCollection) {
        List<Pokemon> lista = new ArrayList<>(userCollection.getCollection());
        lista.sort(Comparator.comparing(Pokemon::getType1));
        StringBuilder sb = new StringBuilder();
        for (Pokemon p : lista) {
            sb.append(p.getName()).append(" - ").append(p.getType1()).append("\n");
        }
        return sb.toString();
    }

    public static String mostrarTodosOrdenados(Map<String, Pokemon> pokemonMap) {
        List<Pokemon> lista = new ArrayList<>(pokemonMap.values());
        lista.sort(Comparator.comparing(Pokemon::getType1));
        StringBuilder sb = new StringBuilder();
        for (Pokemon p : lista) {
            sb.append(p.getName()).append(" - ").append(p.getType1()).append("\n");
        }
        return sb.toString();
    }

    public static String mostrarPorHabilidad(Map<String, Pokemon> pokemonMap, String habilidad) {
        List<Pokemon> lista = new ArrayList<>();
        for (Pokemon p : pokemonMap.values()) {
            if (p.getAbility() != null && p.getAbility().equalsIgnoreCase(habilidad)) {
                lista.add(p);
            }
        }
        if (lista.isEmpty()) {
            return "No se encontró ningún pokemon con la habilidad: " + habilidad;
        }
        StringBuilder sb = new StringBuilder();
        for (Pokemon p : lista) {
            sb.append(p.getName()).append("\n");
        }
        return sb.toString();
    }
}
