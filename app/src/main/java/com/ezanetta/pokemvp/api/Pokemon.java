package com.ezanetta.pokemvp.api;

/**
 * Created by ezanetta on 4/11/16.
 */
public class Pokemon {

    public int id;
    public String name;
    public int base_experience;
    public int height;
    public int weight;
    public Sprites sprites;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Sprites getSprites() {
        return sprites;
    }


    public class Sprites{
        public String front_default;
        public String back_default;
        public String front_shiny;

        public String getFront_default() {
            return front_default;
        }

        public String getBack_default() {
            return back_default;
        }

        public String getFront_shiny() {
            return front_shiny;
        }
    }
}
