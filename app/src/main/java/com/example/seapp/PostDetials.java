package com.example.seapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PostDetials extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private String id,detail,username;
    private int picture;
    private EditText comment_box;
    private ImageView send;
    CommentAdapter mCommentAdapter;
    RecyclerView commentRecyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mDBR;
    List<Comment> commentsList;
    String postID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detials);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){

                }
            }
        };
        intitalData();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
                DatabaseReference mRef = database.getReference("User").child(mUser.getUid());
                Comment comment = new Comment(mUser.getUid(), comment_box.getText().toString().trim(),username,picture);
                addComment(comment);

            }
        });

    }




    private void addComment(Comment comment){
         //postID = getIntent().getExtras().getString("PostKey");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mRef_addComment = firebaseDatabase.getReference("Posts").child(postID).child("Comments").push();

        String key = mRef_addComment.getKey();
        DatabaseReference userPostinUser = firebaseDatabase.getReference("User").child(id).child("Post").child(postID).child("Comments").child(key);

        comment.setPostKey(key);
        userPostinUser.setValue(comment);

        mRef_addComment.setValue(comment).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(PostDetials.this, "คอมเม้นสำเร็จ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }

    public void intitalData(){

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        comment_box = (EditText)findViewById(R.id.commet_box);
        send = (ImageView)findViewById(R.id.send);
        commentRecyclerView = findViewById(R.id.comment);
        //Manage RecycleView set it visible
        LinearLayoutManager layoutManager = new LinearLayoutManager(PostDetials.this);
        commentRecyclerView.setLayoutManager(layoutManager);

        //Intital User Data
        if (user != null) {
            id = user.getUid();
            final DatabaseReference myRef = database.getReference("User").child(id);
            //myRef.child(id);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    username = dataSnapshot.child("username").getValue().toString();

                    // if user isn't KMITL People
                    String type = dataSnapshot.child("inType").getValue().toString();
                    if (type.equals("บุคลภายนอก")) {
                        String pic = dataSnapshot.child("pic").getValue().toString();
                        if (pic.equals("Boy")) {
                            picture = R.drawable.boy;
                        } else {
                            picture = R.drawable.girl;
                        }
                    }
                    //KMITL GUYS
                    else {
                        String pic = dataSnapshot.child("pic").getValue().toString();
                        if (pic.equals("Boy")) {
                            picture = R.drawable.boycs;
                        } else {
                            picture = R.drawable.girlcs;
                        }
                    }

                }//OnDataChange

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
        // Get List Posts from database
        postID = getIntent().getExtras().getString("PostKey");
        mDBR = database.getReference().child("Posts").child(postID).child("Comments");
        mDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commentsList = new ArrayList<>();
                for(DataSnapshot postsnap : dataSnapshot.getChildren()){
                    Comment comment = postsnap.getValue(Comment.class);
                    commentsList.add(comment);
                }

                mCommentAdapter = new CommentAdapter(PostDetials.this,commentsList);
                commentRecyclerView.setAdapter(mCommentAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
