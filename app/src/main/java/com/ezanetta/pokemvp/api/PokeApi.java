package com.ezanetta.pokemvp.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ezequielzanetta on 4/11/16.
 */
public interface PokeApi {

    @GET("/api/v2/pokedex/kanto/")
    Call<PokemonEntries> getPokemons();
}
