package com.example.seapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SearchFriend extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private TextView displayName,friendName;
    private ImageView userPic,friendPic;
    private EditText searchId;
    private ConstraintLayout friend_layout;
    private DatabaseReference friendRef;

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
        friend_layout = (ConstraintLayout)findViewById(R.id.friendLayout);
        searchId = (EditText)findViewById(R.id.searchFriend_Id);
        friendPic = (ImageView)findViewById(R.id.friendPic);
        friendName = (TextView)findViewById(R.id.friendName);

        //friendRef = database.getReference("User");
        searchId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                friendRef = database.getReference("User").child(searchId.getText().toString().trim());
                //friendRef = database.getReference("User").child("xnOXekSffTXECPFNVP0VPU8lnfH2");

                friendRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (!dataSnapshot.hasChild("username")) {
                            //Toast.makeText(SearchFriend.this, "ID นี้ไม่มีอยู่ในระบบ", Toast.LENGTH_SHORT).show();
                            friend_layout.setVisibility(View.INVISIBLE);
                        } else {
                            friend_layout.setVisibility(View.VISIBLE);
                            friendName.setText(dataSnapshot.child("username").getValue().toString());

                           String userType =(dataSnapshot.child("inType").getValue().toString());

                            if(userType.equals("บุคลภายนอก")){
                                String pic = dataSnapshot.child("pic").getValue().toString();
                                if(pic.equals("Boy")){
                                    friendPic.setImageResource(R.drawable.boy);
                                }
                                else{
                                    friendPic.setImageResource(R.drawable.girl);
                                }
                            }
                            else{
                                String pic = dataSnapshot.child("pic").getValue().toString();
                                if(pic.equals("Boy")){
                                    friendPic.setImageResource(R.drawable.boycs);
                                }
                                else{
                                    friendPic.setImageResource(R.drawable.girlcs);
                                }
                            }
                        }//Outer else

                    }//OnDataChange

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });













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


    }//OnCreate Method




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
