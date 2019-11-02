package com.example.seapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Register extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        FragmentA fragment = new FragmentA();
//        transaction.add(R.id.frame,fragment);
//        transaction.addToBackStack("fragmentA");
//        transaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new KmitlFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectFragment = null;

            switch (menuItem.getItemId()){
                case R.id.KMITL:
                    selectFragment = new KmitlFragment();
                    break;
                case R.id.guest:
                    selectFragment = new GuestFragment();
                    break;
            }//switch
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectFragment).commit();

            return  true;
        }//OnNavigation
    };
}
