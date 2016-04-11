package com.ezanetta.pokemvp.api;

import java.util.List;

/**
 * Created by ezanetta on 4/11/16.
 */
public class PokemonEntries {

    public List<PokemonEntry> pokemon_entries;

    public class PokemonEntry {
        public PokemonSpecie pokemon_species;
        public PokemonSpecie getPokemon() {
            return pokemon_species;
        }
    }

    public class PokemonSpecie {
        public String name;
        public String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
