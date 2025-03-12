package com.univalle.pokemon;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Selección de la implementación del Map
        System.out.println("Seleccione la implementación de Map a utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        // Se obtiene el Map de Pokémon según la opción ingresada
        Map<String, Pokemon> pokemonMap = PokemonFactory.getMap(opcion);

        // Se lee el archivo que contiene la información de los Pokémon
        // Se asume que el archivo se llama "pokemons.csv" y está en el directorio raíz
        PokemonRepository.readFile("pokemons.csv", pokemonMap);

        // Se crea la colección personalizada del usuario
        UserCollection userCollection = new UserCollection();

        // Menú principal de la aplicación
        int opcionMenu;
        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Agregar un pokemon a la colección del usuario");
            System.out.println("2. Mostrar los datos de un pokemon");
            System.out.println("3. Mostrar el nombre y tipo1 de los pokemons de la colección del usuario (ordenados por tipo1)");
            System.out.println("4. Mostrar el nombre y tipo1 de todos los pokemons existentes (ordenados por tipo1)");
            System.out.println("5. Mostrar el nombre de los pokemon que poseen una habilidad específica");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1:
                    System.out.print("Ingrese el nombre del pokemon a agregar: ");
                    String nombreAgregar = scanner.nextLine();
                    // El método retorna un mensaje con el resultado de la operación
                    String resultadoAgregar = Operations.agregarPokemon(userCollection, pokemonMap, nombreAgregar);
                    System.out.println(resultadoAgregar);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del pokemon: ");
                    String nombreMostrar = scanner.nextLine();
                    String datosPokemon = Operations.mostrarDatosPokemon(pokemonMap, nombreMostrar);
                    System.out.println(datosPokemon);
                    break;
                case 3:
                    String coleccionOrdenada = Operations.mostrarColeccionOrdenada(userCollection);
                    System.out.println(coleccionOrdenada);
                    break;
                case 4:
                    String todosOrdenados = Operations.mostrarTodosOrdenados(pokemonMap);
                    System.out.println(todosOrdenados);
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String habilidad = scanner.nextLine();
                    String pokemonsConHabilidad = Operations.mostrarPorHabilidad(pokemonMap, habilidad);
                    System.out.println(pokemonsConHabilidad);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcionMenu != 6);

        scanner.close();
    }
}
