package com.example.foodmates;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

//Test

public class MainActivity extends AppCompatActivity {

    static boolean login = false;

    static Fragment fragmentLogin = new LoginFragment();
    static Fragment fragmentHome = new FragmentHome();
    static Fragment fragmentFav = new FragmentFavorites();
    static Fragment fragmentProfile = new FragmentProfile();
    public FragmentManager fm = getSupportFragmentManager();

    static Fragment active = fragmentHome;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm.beginTransaction().add(R.id.fragment_display, fragmentFav, "2").hide(fragmentFav).commit();
        fm.beginTransaction().add(R.id.fragment_display, fragmentProfile, "2").hide(fragmentProfile).commit();
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
                        if(!login){
                            DialogFragment dialog = new FireMissilesDialogFragment();
                            dialog.show(getSupportFragmentManager(), "missiles");
                            return true;
                        }
                    case R.id.action_add:
                        if(!login){
                            DialogFragment dialog = new FireMissilesDialogFragment();
                            dialog.show(getSupportFragmentManager(), "missiles");
                            return true;
                        }
                    case R.id.action_favorites:
                        if(!login){
                            DialogFragment dialog = new FireMissilesDialogFragment();
                            dialog.show(getSupportFragmentManager(), "missiles");
                            return true;
                        }else{
                        fm.beginTransaction().hide(active).show(fragmentFav).commit();
                        active = fragmentFav;
                        return true;
                        }
                    case R.id.action_profile:
                        if(!login){
                            DialogFragment dialog = new FireMissilesDialogFragment();
                            dialog.show(getSupportFragmentManager(), "missiles");
                            return true;
                        }else{
                            fm.beginTransaction().hide(active).show(fragmentProfile).commit();
                            active = fragmentProfile;
                            return true;
                        }
                    default:
                        return false;
                }
            }
        });

    }





    public static class FireMissilesDialogFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Get the layout inflater
            LayoutInflater inflater = requireActivity().getLayoutInflater();

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.login_dialog, null))
                    // Add action buttons
                    .setPositiveButton("login", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            login = true;
                        }
                    })
                    .setNeutralButton("register", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            DialogFragment dialog1 = new FireMissilesDialogFragment2();
                            dialog1.show(getFragmentManager(), "missiles");
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
            return builder.create();
        }
    }

    public static class FireMissilesDialogFragment2 extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Get the layout inflater
            LayoutInflater inflater = requireActivity().getLayoutInflater();

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.register_dialog, null))
                    // Add action buttons
                    .setPositiveButton("register", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            login = true;
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
            return builder.create();
        }
    }

}
