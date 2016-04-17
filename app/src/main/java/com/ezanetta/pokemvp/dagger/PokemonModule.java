package com.ezanetta.pokemvp.dagger;

import com.ezanetta.pokemvp.api.RestClient;
import com.ezanetta.pokemvp.pokemon.GetPokemonInteractor;
import com.ezanetta.pokemvp.pokemon.GetPokemonInteractorImpl;
import com.ezanetta.pokemvp.pokemon.PokemonPresenter;
import com.ezanetta.pokemvp.pokemon.PokemonPresenterImpl;
import com.ezanetta.pokemvp.pokemon.PokemonView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ezequielzanetta on 4/17/16.
 */

@Module
public class PokemonModule {

    private PokemonView view;

    public PokemonModule(PokemonView view) {
        this.view = view;
    }

    @Provides
    public PokemonView providePokemonView(){
        return view;
    }

    @Provides
    public GetPokemonInteractor providePokemonInteractor(RestClient client){
        return new GetPokemonInteractorImpl(client);
    }

    @Provides
    public PokemonPresenter providePokemonPresenter(PokemonView view, GetPokemonInteractor interactor){
        return new PokemonPresenterImpl(view, interactor);
    }
}
