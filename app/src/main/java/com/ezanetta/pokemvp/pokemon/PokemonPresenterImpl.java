package com.ezanetta.pokemvp.pokemon;

import com.ezanetta.pokemvp.api.Pokemon;

/**
 * Created by ezanetta on 4/11/16.
 */
public class PokemonPresenterImpl implements PokemonPresenter, GetPokemonInteractorImpl.onFinishedListener {

    private PokemonView mPokemonView;
    private GetPokemonInteractorImpl mGetPokemonInteractor;
    private String pokemonName;

    public PokemonPresenterImpl(PokemonView pokemonView){
        mPokemonView = pokemonView;
        mGetPokemonInteractor = new GetPokemonInteractorImpl();
    }

    @Override
    public void onResume() {
        if(mPokemonView != null){
            mPokemonView.showProgress();
        }

        mGetPokemonInteractor.findPokemon(pokemonName, this);
    }

    @Override
    public void onDestroy() {
        mPokemonView = null;
    }

    @Override
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    @Override
    public void onFinished(Pokemon pokemon) {
        if(mPokemonView != null){
            mPokemonView.setPokemon(pokemon);
            mPokemonView.hideProgress();
        }
    }
}
