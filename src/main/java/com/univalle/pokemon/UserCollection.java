package com.univalle.pokemon;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class UserCollection {
    private Set<Pokemon> collection;

    public UserCollection() {
        collection = new HashSet<>();
    }

    public boolean contains(String name) {
        for (Pokemon p : collection) {
            if (p.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void addPokemon(Pokemon pokemon) {
        collection.add(pokemon);
    }

    public Set<Pokemon> getCollection() {
        return collection;
    }

    // Guarda la colección en disco mediante serialización.
    // Es necesario que la clase Pokemon implemente Serializable.
    public void saveToDisk(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(collection);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la colección en disco.", e);
        }
    }
}
