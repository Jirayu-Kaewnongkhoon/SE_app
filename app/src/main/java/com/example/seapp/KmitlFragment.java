package com.example.seapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KmitlFragment extends Fragment {
    private Button commit;
    private EditText fname,lname;
    public FirebaseDatabase database;
    public DatabaseReference myRef;
    private String userId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.kmitl_fragment, container,false);

//        commit = (Button)getActivity().findViewById(R.id.cmt2_btn);
//
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("User");
//        userId = myRef.push().getKey();
//
//        commit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                add(fname.getText().toString().trim(),lname.getText().toString().trim());
//            }
//        });

        return v;
    }

    public void add(String fname,String lname){
        myRef.child(userId).setValue(fname,lname);
    }
}
