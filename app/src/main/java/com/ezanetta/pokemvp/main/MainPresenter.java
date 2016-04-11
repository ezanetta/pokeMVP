package com.ezanetta.pokemvp.main;

/**
 * Created by ezequielzanetta on 4/11/16.
 */
public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
