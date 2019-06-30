package com.example.foodmates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class RicetteProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_ricette_profilo, container,false);

        ArrayList<Recipe> recipes = new ArrayList<>();


        recipes.add(new Recipe("Pollo al miele","30-40 min",1, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pasticcio","30-40 min",1,"Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pizza","30-40 min",2,"Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Torta al cioccolato","30-40 min",1, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Biscotti alle mandorle","30-40 min",2, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pollo al miele","30-40 min",2, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pasticcio","30-40 min", 1, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pizza","30-40 min",3, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Torta al cioccolato","30-40 min",3, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Biscotti alle mandorle","30-40 min",2, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pollo al miele","30-40 min",1, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pasticcio","30-40 min",2, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pizza","30-40 min",3, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Torta al cioccolato","30-40 min",3, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Biscotti alle mandorle","30-40 min",2, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pollo al miele","30-40 min",1, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pasticcio","30-40 min",3, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Pizza","30-40 min",4, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Torta al cioccolato","30-40 min",2, "Ricette gustose", "#fusion #vegano"));
        recipes.add(new Recipe("Biscotti alle mandorle","30-40 min",1, "Ricette gustose", "#fusion #vegano"));


        ProfileRecipeAdapter recipesAdapter = new ProfileRecipeAdapter(getActivity(), recipes);

        ListView listView = result.findViewById(R.id.recipes_profile_list);

        listView.setAdapter(recipesAdapter);

        return result;
    }
}
