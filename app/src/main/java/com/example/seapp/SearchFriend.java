package com.example.seapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SearchFriend extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private TextView displayName;
    private ImageView userPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friend);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setTitle("ค้นหาเพื่อน");
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.child_actionbar);
        final TextView titleView = findViewById(R.id.action_bar_title);
        titleView.setText("ค้นหาเพื่อน");
        ImageView back =(ImageView) findViewById(R.id.actionbar_back);
        displayName = (TextView) findViewById(R.id.displayName);
        userPic  = (ImageView)findViewById(R.id.userPic);
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSupportNavigateUp();
            }
        });



        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){

                }
            }
        };


        //Intital User Data
        if (user != null) {
            String id;
            id = user.getUid();
            final DatabaseReference myRef = database.getReference("User").child(id);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String username = dataSnapshot.child("username").getValue().toString();
                    String userType = dataSnapshot.child("inType").getValue().toString();
                    displayName.setText(username);
                    // if user isn't KMITL People
                    if(userType.equals("บุคลภายนอก")){
                        String pic = dataSnapshot.child("pic").getValue().toString();
                        if(pic.equals("Boy")){
                            userPic.setImageResource(R.drawable.boy);
                        }
                        else{
                            userPic.setImageResource(R.drawable.girl);
                        }
                    }
                    //KMITL GUYS
                    else {
                        String pic = dataSnapshot.child("pic").getValue().toString();
                        if(pic.equals("Boy")){
                            userPic.setImageResource(R.drawable.boycs);
                        }
                        else{
                            userPic.setImageResource(R.drawable.girlcs);
                        }
                    }



                }//OnDataChange
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }

    // Button back before activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
