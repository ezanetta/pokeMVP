package com.ezanetta.pokemvp.pokemon;

import android.util.Log;

import com.ezanetta.pokemvp.api.Pokemon;
import com.ezanetta.pokemvp.api.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ezanetta on 4/11/16.
 */
public class GetPokemonInteractorImpl implements GetPokemonInteractor {

    private static final String TAG = GetPokemonInteractorImpl.class.getSimpleName();

    @Override
    public void findPokemon(String pokemonName, final onFinishedListener listener) {
        RestClient client = new RestClient();

        Call<Pokemon> call = client.getApiService().getPokemon(pokemonName);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();
                Log.d(TAG, "POKEMON: " + pokemon.getName());
                listener.onFinished(pokemon);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.d(TAG, "Error Retrofit: " + t.getMessage());
            }
        });
    }
}
