package com.example.foodmates;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

//Test

public class MainActivity extends AppCompatActivity {

     Fragment fragmentHome = new Fragment_home();
     Fragment fragmentFav = new Fragment_favorites();
    FragmentManager fm = getSupportFragmentManager();

    Fragment active = fragmentHome;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.fragment_display, fragmentFav, "2").hide(fragmentFav).commit();
        fm.beginTransaction().add(R.id.fragment_display,fragmentHome, "1").commit();

        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        
                        fm.beginTransaction().hide(active).show(fragmentHome).commit();
                        active = fragmentHome;
                        return true;
                    case R.id.action_search:
                        Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_add:
                        Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_favorites:
                        fm.beginTransaction().hide(active).show(fragmentFav).commit();
                        active = fragmentFav;
                        return true;
                    case R.id.action_profile:
                        Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
