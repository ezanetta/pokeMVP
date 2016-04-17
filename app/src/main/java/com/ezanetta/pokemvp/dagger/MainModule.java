package com.ezanetta.pokemvp.dagger;

import com.ezanetta.pokemvp.api.RestClient;
import com.ezanetta.pokemvp.main.FindPokemonsInteractor;
import com.ezanetta.pokemvp.main.FindPokemonsInteractorImpl;
import com.ezanetta.pokemvp.main.MainPresenter;
import com.ezanetta.pokemvp.main.MainPresenterImpl;
import com.ezanetta.pokemvp.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ezequielzanetta on 4/17/16.
 */

@Module
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    public MainView provideMainView(){
        return view;
    }

    @Provides
    public FindPokemonsInteractor provideFindPokemonInteractor(RestClient client){
        return new FindPokemonsInteractorImpl(client);
    }

    @Provides
    public MainPresenter provideMainPresenter(MainView view, FindPokemonsInteractor interactor){
        return new MainPresenterImpl(view, interactor);
    }

}
