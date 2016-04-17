package com.ezanetta.pokemvp.dagger;

import com.ezanetta.pokemvp.api.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ezequielzanetta on 4/17/16.
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public RestClient provideRestClient(){
        return new RestClient();
    }
}
