package com.example.foodmates;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentProfile extends Fragment {


   ViewPager viewPager;
   PageAdapter pageAdapter;
   TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


     View result = inflater.inflate(R.layout.fragment_profile, container,false);

     pageAdapter = new PageAdapter(getFragmentManager());


     viewPager = result.findViewById(R.id.pager_profile_fragment);
     viewPager.setAdapter(pageAdapter);

     tabLayout = result.findViewById(R.id.tabs_profile_fragment);
     tabLayout.setupWithViewPager(viewPager);

     //Setto l'immaginie profilo rotonda
     ImageView profileImg = result.findViewById(R.id.img_profile);

     Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.macarons);

     RoundedBitmapDrawable mDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
     mDrawable.setCircular(true);
     profileImg.setImageDrawable(mDrawable);


        return result;
    }


    public static class PageAdapter extends FragmentPagerAdapter {


        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i){

                case 0: RicetteProfileFragment fragmentRicette = new RicetteProfileFragment();
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
                case 0: return "Le mie Ricette";
                case 1: return "I miei Canali";
                default: return "";
            }
        }
    }
}