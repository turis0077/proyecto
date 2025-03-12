package com.univalle.pokemon;

public class Utils {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static String formatPokemonData(Pokemon pokemon) {
        if (pokemon == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(pokemon.getName()).append("\n");
        sb.append("Tipo primario: ").append(pokemon.getType1()).append("\n");
        sb.append("Tipo secundario: ").append(pokemon.getType2()).append("\n");
        sb.append("Habilidad: ").append(pokemon.getAbility()).append("\n");
        sb.append("Total: ").append(pokemon.getTotal()).append("\n");
        sb.append("HP: ").append(pokemon.getHp()).append("\n");
        sb.append("Ataque: ").append(pokemon.getAttack()).append("\n");
        sb.append("Defensa: ").append(pokemon.getDefense()).append("\n");
        sb.append("Ataque especial: ").append(pokemon.getSpAttack()).append("\n");
        sb.append("Defensa especial: ").append(pokemon.getSpDefense()).append("\n");
        sb.append("Velocidad: ").append(pokemon.getSpeed()).append("\n");
        sb.append("Generación: ").append(pokemon.getGeneration()).append("\n");
        sb.append("Legendario: ").append(pokemon.isLegendary() ? "Sí" : "No");
        return sb.toString();
    }
}
