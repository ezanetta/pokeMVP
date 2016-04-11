package com.ezanetta.pokemvp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ezanetta on 4/11/16.
 */
public class RestClient {

    private PokeApi pokeApi;
    private static final String BASE_URL = "http://pokeapi.co";

    public RestClient(){

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokeApi = client.create(PokeApi.class);
    }

    public PokeApi getApiService(){
        return pokeApi;
    }


}
