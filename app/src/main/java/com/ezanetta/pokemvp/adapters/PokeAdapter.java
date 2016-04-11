package com.ezanetta.pokemvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ezanetta.pokemvp.R;
import com.ezanetta.pokemvp.api.PokemonEntries;

import java.util.List;

/**
 * Created by ezanetta on 4/11/16.
 */
public class PokeAdapter extends BaseAdapter {

    private Context mContext;
    private List<PokemonEntries.PokemonEntry> mPokemons;

    public PokeAdapter(Context context, List<PokemonEntries.PokemonEntry> pokemons){
        this.mContext = context;
        this.mPokemons = pokemons;
    }

    @Override
    public int getCount() {
        return mPokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return mPokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.pokemon_item, null);
            viewHolder = new ViewHolder();
            viewHolder.pokemonTitle = (TextView)convertView.findViewById(R.id.pokemonTitle);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        String title = mPokemons.get(position).getPokemon().getName();
        viewHolder.pokemonTitle.setText(title);

        return convertView;
    }

    public static class ViewHolder{
        TextView pokemonTitle;
    }
}
