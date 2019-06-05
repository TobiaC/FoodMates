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


public class CanaliFavoritesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Qui si fa riferimento all'xml
        View result =  inflater.inflate(R.layout.fragment_canali_favorites, container,false);


        ArrayList<Canale> canali = new ArrayList<>();


       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));
       canali.add(new Canale("Ricette gustose", "Macaroon sweet lollipop jelly gummi bears pie. Cookie jujubes ice cream gingerbread. Cake cheesecake gummies chocolate cheesecake."));



        CanaleAdapter recipesAdapter = new CanaleAdapter(getActivity(), canali);

        ListView listView = result.findViewById(R.id.canali_list);

        listView.setAdapter(recipesAdapter);

        return result;

    }

}
