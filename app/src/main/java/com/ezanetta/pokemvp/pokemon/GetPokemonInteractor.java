package com.ezanetta.pokemvp.pokemon;

import com.ezanetta.pokemvp.api.Pokemon;

/**
 * Created by ezanetta on 4/11/16.
 */
public interface GetPokemonInteractor {

    interface onFinishedListener{
        void onFinished(Pokemon pokemon);
    }

    void findPokemon(onFinishedListener listener);
}
