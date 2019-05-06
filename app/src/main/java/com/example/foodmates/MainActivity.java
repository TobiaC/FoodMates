package com.example.foodmates;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

//Test

public class MainActivity extends AppCompatActivity {
    

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Al momento solo la home apre una nuova activity
                Fragment selectedFragment = null;

                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        selectedFragment = new Fragment_favorites();
                        break;
                    case R.id.action_search:
                        selectedFragment = new Fragment_favorites();
                        break;
                    case R.id.action_add:
                        selectedFragment = new Fragment_favorites();
                        break;
                    case R.id.action_favorites:
                        selectedFragment = new Fragment_favorites();
                        break;
                    case R.id.action_profile:
                        selectedFragment = new Fragment_favorites();
                        break;
                    default:
                        selectedFragment = new Fragment_favorites();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_display,selectedFragment).commit();

                return true;
            }
        });
    }
}
