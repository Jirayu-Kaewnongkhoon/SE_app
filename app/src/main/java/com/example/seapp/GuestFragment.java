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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuestFragment extends Fragment {
//    private Button commit;
//    private EditText fname,lname,email,password,confirmpass;
//    public FirebaseDatabase database;
//    public DatabaseReference myRef;
//    private String userId;
//    private FirebaseAuth mAuth;
//    private String userType ="guest";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.guest_fragment, container,false);

        //setComponent(v);

        return  v;
    }


//    public void setComponent(View v){
//        commit = (Button)getActivity().findViewById(R.id.cmt2_btn);
//        fname = (EditText)v.findViewById(R.id.Fname);
//        lname =(EditText)v.findViewById(R.id.lname);
//        email =(EditText)v.findViewById(R.id.email);
//        password =(EditText)v.findViewById(R.id.password);
//        confirmpass=(EditText)v.findViewById(R.id.comfirm);
//
//    }
}
