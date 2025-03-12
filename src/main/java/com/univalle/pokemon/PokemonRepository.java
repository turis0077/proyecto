package com.univalle.pokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class PokemonRepository {

    public static void readFile(String fileName, Map<String, Pokemon> pokemonMap) {
        InputStream is = PokemonRepository.class.getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new RuntimeException("Error al leer el archivo: " + fileName);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = br.readLine(); // se lee la cabecera
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 13) continue;

                // Se asume el siguiente orden de columnas:
                // Number, Name, Type1, Type2, Total, HP, Attack, Defense, Sp. Atk, Sp. Def, Speed, Generation, Legendary
                // Se eliminan las comillas que pudieran envolver los campos.
                String number = cleanToken(tokens[0]); // no se usa
                String name = cleanToken(tokens[1]);
                String type1 = cleanToken(tokens[2]);
                String type2 = cleanToken(tokens[3]);
                // No existe columna "Ability" en este CSV, se asigna un valor predeterminado.
                String ability = "N/A";
                int total = Integer.parseInt(cleanToken(tokens[4]));
                int hp = Integer.parseInt(cleanToken(tokens[5]));
                int attack = Integer.parseInt(cleanToken(tokens[6]));
                int defense = Integer.parseInt(cleanToken(tokens[7]));
                int spAttack = Integer.parseInt(cleanToken(tokens[8]));
                int spDefense = Integer.parseInt(cleanToken(tokens[9]));
                int speed = Integer.parseInt(cleanToken(tokens[10]));
                int generation = Integer.parseInt(cleanToken(tokens[11]));
                boolean legendary = Boolean.parseBoolean(cleanToken(tokens[12]));

                Pokemon pokemon = new Pokemon(name, type1, type2, ability, total, hp, attack, defense, spAttack, spDefense, speed, generation, legendary);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + fileName, e);
        }
    }

    private static String cleanToken(String token) {
        return token.trim().replaceAll("^\"|\"$", "");
    }
}
