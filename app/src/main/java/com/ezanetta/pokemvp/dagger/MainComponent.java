package com.ezanetta.pokemvp.dagger;

import com.ezanetta.pokemvp.main.MainActivity;

import dagger.Component;

/**
 * Created by ezequielzanetta on 4/17/16.
 */

@ActivityScope
@Component(
        dependencies = { ApplicationComponent.class },
        modules = { MainModule.class }
)
public interface MainComponent {

    void inject(MainActivity target);
}
