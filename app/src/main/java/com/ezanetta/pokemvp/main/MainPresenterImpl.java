package com.ezanetta.pokemvp.main;

import com.ezanetta.pokemvp.api.PokemonEntries;

import java.util.List;

/**
 * Created by ezequielzanetta on 4/11/16.
 */
public class MainPresenterImpl implements MainPresenter, FindPokemonsInteractor.OnFinishedListener{

    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private MainView mMainView;
    private FindPokemonsInteractor mFindPokemonsInteractor;

    public MainPresenterImpl(MainView main){
        this.mMainView = main;
        mFindPokemonsInteractor = new FindPokemonsInteractorImpl();
    }

    @Override
    public void onResume() {
        if(mMainView != null){
            mMainView.showProgress();
        }

        mFindPokemonsInteractor.findPokemons(this);
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onFinished(List<PokemonEntries.PokemonEntry> pokemons) {
        if(mMainView != null){
            mMainView.setPokemons(pokemons);
            mMainView.hideProgress();
        }
    }
}
