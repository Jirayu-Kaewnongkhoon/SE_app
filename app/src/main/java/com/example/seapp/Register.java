package com.example.seapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Register extends AppCompatActivity  {
    private Button commit;

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

        commit = (Button)findViewById(R.id.cmt2_btn);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), register2.class);
                startActivity(intent);
                //finish();

            }
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectFragment = null;
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();





            switch (menuItem.getItemId()){
                case R.id.KMITL:
                    transaction.setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_rigth);
                    selectFragment = new KmitlFragment();
                    break;
                case R.id.guest:
                    transaction.setCustomAnimations(R.anim.enter_rigth_to_left, R.anim.exit_right_to_left);
                    selectFragment = new GuestFragment();
                    break;
            }//switch
            transaction.replace(R.id.frame,selectFragment).commit();



//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.frame,selectFragment)
                      //.setCustomAnimations(R.anim.enter_rigth_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_rigth)
//                    .commit();

            return  true;
        }//OnNavigation
    };
}
