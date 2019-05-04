package com.example.foodmates;

import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Test

public class FavoritesActivity extends AppCompatActivity {

    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        viewPager = (ViewPager) findViewById(R.id.pager_favorites);
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs_favorites);
        tabLayout.setupWithViewPager(viewPager);

        Typeface typeface = ResourcesCompat.getFont(FavoritesActivity.this, R.font.nunito_regular);
    }


    public static class PageAdapter extends FragmentPagerAdapter{


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
           // return "Section" + (position + 1);
        }
    }

}