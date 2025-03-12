package com.univalle.pokemon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PokemonFactory {
    public static Map<String, Pokemon> getMap(int option) {
        switch (option) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                return new HashMap<>();
        }
    }
}
