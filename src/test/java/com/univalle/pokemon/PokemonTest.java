package com.univalle.pokemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void testPokemonConstructorAndGetters() {
        Pokemon p = new Pokemon("Pikachu", "Electric", "N/A", "Static", 320, 35, 55, 40, 50, 50, 90, 1, false);
        assertEquals("Pikachu", p.getName());
        assertEquals("Electric", p.getType1());
        assertEquals("N/A", p.getType2());
        assertEquals("Static", p.getAbility());
        assertEquals(320, p.getTotal());
        assertEquals(35, p.getHp());
        assertEquals(55, p.getAttack());
        assertEquals(40, p.getDefense());
        assertEquals(50, p.getSpAttack());
        assertEquals(50, p.getSpDefense());
        assertEquals(90, p.getSpeed());
        assertEquals(1, p.getGeneration());
        assertFalse(p.isLegendary());
    }

    @Test
    void testToString() {
        Pokemon p = new Pokemon("Bulbasaur", "Grass", "Poison", "Overgrow", 318, 45, 49, 49, 65, 65, 45, 1, false);
        String result = p.toString();
        assertTrue(result.contains("Bulbasaur"));
        assertTrue(result.contains("Grass"));
        assertTrue(result.contains("Poison"));
    }
}
