package com.ezanetta.pokemvp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ezequielzanetta on 4/11/16.
 */
public interface PokeApi {

    @GET("/api/v2/pokedex/kanto/")
    Call<PokemonEntries> getPokemons();

    @GET("/api/v2/pokemon/{pokemon}")
    Call<Pokemon> getPokemon(@Path("pokemon") String pokemon);

}
