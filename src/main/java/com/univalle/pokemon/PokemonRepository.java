package com.univalle.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class PokemonRepository {

    public static void readFile(String fileName, Map<String, Pokemon> pokemonMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Se lee la cabecera del archivo
            String line = br.readLine();
            // Se procesan las líneas restantes
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                // Se espera que el archivo tenga 13 columnas en el siguiente orden:
                // Name, Type1, Type2, Ability, Total, HP, Attack, Defense, Sp. Atk, Sp. Def, Speed, Generation, Legendary
                if (tokens.length < 13) continue;
                String name = tokens[0].trim();
                String type1 = tokens[1].trim();
                String type2 = tokens[2].trim();
                String ability = tokens[3].trim();
                int total = Integer.parseInt(tokens[4].trim());
                int hp = Integer.parseInt(tokens[5].trim());
                int attack = Integer.parseInt(tokens[6].trim());
                int defense = Integer.parseInt(tokens[7].trim());
                int spAttack = Integer.parseInt(tokens[8].trim());
                int spDefense = Integer.parseInt(tokens[9].trim());
                int speed = Integer.parseInt(tokens[10].trim());
                int generation = Integer.parseInt(tokens[11].trim());
                boolean legendary = Boolean.parseBoolean(tokens[12].trim());
                Pokemon pokemon = new Pokemon(name, type1, type2, ability, total, hp, attack, defense, spAttack, spDefense, speed, generation, legendary);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + fileName, e);
        }
    }
}
