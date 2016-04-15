package com.ezanetta.pokemvp.pokemon;

import com.ezanetta.pokemvp.api.Pokemon;

/**
 * Created by ezanetta on 4/11/16.
 */
public interface PokemonView {

    void showProgress();
    void hideProgress();
    void setPokemon(Pokemon pokemon);

}
