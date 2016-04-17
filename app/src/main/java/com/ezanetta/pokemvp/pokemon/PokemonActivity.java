package com.ezanetta.pokemvp.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ezanetta.pokemvp.PokeMVPApp;
import com.ezanetta.pokemvp.R;
import com.ezanetta.pokemvp.api.Pokemon;
import com.ezanetta.pokemvp.dagger.DaggerPokemonComponent;
import com.ezanetta.pokemvp.dagger.PokemonModule;
import com.ezanetta.pokemvp.utils.Constants;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PokemonActivity extends AppCompatActivity implements PokemonView {

    private static final String TAG = PokemonActivity.class.getSimpleName();
    @Bind(R.id.progress) ProgressBar mProgressBar;
    @Bind(R.id.pokeContent) RelativeLayout mPokeContent;
    @Bind(R.id.pokemonImage) ImageView mPokemonImage;
    @Bind(R.id.heightValue) TextView mHeight;
    @Bind(R.id.weigthValue) TextView mWeight;
    @Bind(R.id.baseExperienceValue) TextView mBaseExperience;

    @Inject PokemonPresenter mPokemonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra(Constants.POKEMON_NAME);

        setupCompontent();
        mPokemonPresenter.setPokemonName(pokemonName);
        setTitle(pokemonName);
    }

    private void setupCompontent(){
        DaggerPokemonComponent.builder()
                .applicationComponent(PokeMVPApp.getApp(this).getComponent())
                .pokemonModule(new PokemonModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPokemonPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPokemonPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mPokeContent.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mPokeContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPokemon(Pokemon pokemon) {
        Picasso.with(this).load(pokemon.getSprites().getFront_default()).into(mPokemonImage);
        mBaseExperience.setText(Integer.toString(pokemon.getBase_experience()));
        mHeight.setText(Integer.toString(pokemon.getHeight()));
        mWeight.setText(Integer.toString(pokemon.getWeight()));
    }

}
