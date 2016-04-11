package com.ezanetta.pokemvp.main;

import com.ezanetta.pokemvp.api.PokemonEntries;

import java.util.List;

/**
 * Created by ezanetta on 4/11/16.
 */
public interface FindPokemonsInteractor {

    interface OnFinishedListener{
        void onFinished(List<PokemonEntries.PokemonEntry> pokemons);
    }

    void findPokemons(OnFinishedListener listener);
}
