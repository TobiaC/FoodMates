package com.example.foodmates;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**

 */
public class Fragment_favorites extends Fragment {



    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Qui si fa riferimento all'xml
        return inflater.inflate(R.layout.fragment_ricette_favorites, container,false);
        viewPager = (ViewPager) findViewById(R.id.pager_favorites);
        pageAdapter = new FavoritesActivity.PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs_favorites);
        tabLayout.setupWithViewPager(viewPager);


        Typeface typeface = ResourcesCompat.getFont(FavoritesActivity.this, R.font.nunito_regular);
    }


    public static class PageAdapter extends FragmentPagerAdapter {


        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i){

                case 0: RicetteFavoritesFragment fragmentRicette = new RicetteFavoritesFragment();
                    return fragmentRicette;
                case 1: CanaliFavoritesFragment fragmentCanali = new CanaliFavoritesFragment();
                    return fragmentCanali;
                default: return null;


            }
        }


        //Ritorna il numero di pagine
        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override

        //Permette di definire automaticamente il testo delle linguette
        public CharSequence getPageTitle(int position) {

            //Non sono riuscita ad estrarre le stringhe :/
            switch (position){
                case 0: return "Ricette";
                case 1: return "Canali";
                default: return "";
            }
        }
    }




}