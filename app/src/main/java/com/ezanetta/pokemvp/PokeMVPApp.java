package com.ezanetta.pokemvp;

import android.app.Application;
import android.content.Context;

import com.ezanetta.pokemvp.dagger.ApplicationComponent;
import com.ezanetta.pokemvp.dagger.ApplicationModule;
import com.ezanetta.pokemvp.dagger.DaggerApplicationComponent;

/**
 * Created by ezequielzanetta on 4/17/16.
 */
public class PokeMVPApp extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }

    public static PokeMVPApp getApp(Context context){
        return (PokeMVPApp) context.getApplicationContext();
    }
}
