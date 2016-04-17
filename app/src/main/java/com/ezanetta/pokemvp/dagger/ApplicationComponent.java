package com.ezanetta.pokemvp.dagger;

import com.ezanetta.pokemvp.api.RestClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ezequielzanetta on 4/17/16.
 */

@Singleton
@Component(
        modules = { ApplicationModule.class }
)
public interface ApplicationComponent {

    RestClient restClient();
}
