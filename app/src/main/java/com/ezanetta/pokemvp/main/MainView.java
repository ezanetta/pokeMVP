package com.ezanetta.pokemvp.main;

import com.ezanetta.pokemvp.api.PokemonEntries;

import java.util.List;

/**
 * Created by ezequielzanetta on 4/11/16.
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void setPokemons(List<PokemonEntries.PokemonEntry> pokemons);
}
