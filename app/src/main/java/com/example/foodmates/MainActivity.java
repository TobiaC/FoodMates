package com.example.foodmates;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

//Test

public class MainActivity extends AppCompatActivity {

    boolean login = true;
    Fragment fragmentHome = new FragmentHome();
    Fragment fragmentFav = new FragmentFavorites();
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
                        if(login==false){
                            FireMissilesDialogFragment alert = new FireMissilesDialogFragment();
                            alert.show(getSupportFragmentManager(), "missiles");
                            return true;
                        }else{
                            FireMissilesDialogFragment alert = new FireMissilesDialogFragment();
                            alert.show(getSupportFragmentManager(), "missiles");
                            return true;}
                    case R.id.action_favorites:
                        if(login==false){
                            Toast.makeText(getApplicationContext(), "Devi loggarti", Toast.LENGTH_SHORT).show();
                            return true;
                        }else{
                        fm.beginTransaction().hide(active).show(fragmentFav).commit();
                        active = fragmentFav;
                        return true;}
                    case R.id.action_profile:
                        if(login==false){
                            Toast.makeText(getApplicationContext(), "Devi loggarti", Toast.LENGTH_SHORT).show();
                            return true;
                        }else{
                        Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_SHORT).show();
                        return true;}
                    default:
                        return false;
                }
            }
        });

    }

    static public class FireMissilesDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Se vuoi aggiungere una nuova ricetta devi essere iscritto o fare il login")
                    .setPositiveButton("chiudi", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                        }
                    })
                    .setNegativeButton("iscriviti", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    })
            .setNeutralButton("registrati", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
