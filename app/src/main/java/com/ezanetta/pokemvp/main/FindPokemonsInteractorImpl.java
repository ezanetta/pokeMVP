package com.ezanetta.pokemvp.main;

import android.util.Log;

import com.ezanetta.pokemvp.api.PokemonEntries;
import com.ezanetta.pokemvp.api.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ezanetta on 4/11/16.
 */
public class FindPokemonsInteractorImpl implements FindPokemonsInteractor {

    private RestClient client;

    public FindPokemonsInteractorImpl(RestClient client) {
        this.client = client;
    }

    public static final String TAG = FindPokemonsInteractorImpl.class.getSimpleName();

    @Override
    public void findPokemons(final OnFinishedListener listener) {

        Call<PokemonEntries> call = client.getApiService().getPokemons();

        call.enqueue(new Callback<PokemonEntries>() {
            @Override
            public void onResponse(Call<PokemonEntries> call, Response<PokemonEntries> response) {

                List<PokemonEntries.PokemonEntry> pokemons = response.body().pokemon_entries;
                listener.onFinished(pokemons);
            }

            @Override
            public void onFailure(Call<PokemonEntries> call, Throwable t) {
                Log.d(TAG, "Error retrofit: " + t.getMessage());
            }
        });
    }
}
