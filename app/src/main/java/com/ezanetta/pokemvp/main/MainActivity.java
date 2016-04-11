package com.ezanetta.pokemvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ezanetta.pokemvp.R;
import com.ezanetta.pokemvp.adapters.PokeAdapter;
import com.ezanetta.pokemvp.api.PokemonEntries;
import com.ezanetta.pokemvp.pokemon.PokemonActivity;
import com.ezanetta.pokemvp.utils.Constants;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.list) ListView mListView;
    @Bind(R.id.progress) ProgressBar mProgressBar;
    private MainPresenter mPresenter;
    public PokeAdapter mPokeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mPresenter = new MainPresenterImpl(this);
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPokemons(List<PokemonEntries.PokemonEntry> pokemons) {
        mPokeAdapter = new PokeAdapter(this, pokemons);
        mListView.setAdapter(mPokeAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PokemonEntries.PokemonEntry pokeEntry = (PokemonEntries.PokemonEntry) mPokeAdapter.getItem(position);
        Intent intent = new Intent(this, PokemonActivity.class);
        intent.putExtra(Constants.POKEMON_NAME, pokeEntry.getPokemon().getName());
        startActivity(intent);
    }
}
