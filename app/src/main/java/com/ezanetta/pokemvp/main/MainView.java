package com.ezanetta.pokemvp.main;

import java.util.List;

/**
 * Created by ezequielzanetta on 4/11/16.
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void showPokemons(List<String> pokemons);
}
