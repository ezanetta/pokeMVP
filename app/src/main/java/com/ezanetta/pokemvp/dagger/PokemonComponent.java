package com.ezanetta.pokemvp.dagger;

import com.ezanetta.pokemvp.pokemon.PokemonActivity;

import dagger.Component;

/**
 * Created by ezequielzanetta on 4/17/16.
 */

@ActivityScope
@Component(
        dependencies = { ApplicationComponent.class },
        modules = { PokemonModule.class }
)
public interface PokemonComponent {

    void inject(PokemonActivity target);
}
