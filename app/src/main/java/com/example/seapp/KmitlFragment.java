package com.example.seapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class KmitlFragment extends Fragment {
    private Button commit;
    private EditText fname,lname,email,password,confirmpass;
    private RadioGroup radioGroup;
    public FirebaseDatabase database;
    public DatabaseReference myRef;
    private String userId;
    private FirebaseAuth mAuth;
    private String userType ="1";
    private String inType;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.kmitl_fragment, container,false);
        setComponent(v);



        //database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        //myRef = database.getReference("User");







        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commit.setText("Hi");
                if(fname.length()>0 && lname.length()>0) {
                    if (isValidNameFormat(fname.getText().toString().trim(), lname.getText().toString().trim())) {
                        Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getActivity(), "FirstName and LastName cannot be null", Toast.LENGTH_SHORT).show();
                }


                if(!(password.getText().toString().trim()).equals(confirmpass.getText().toString().trim())){
                    Toast.makeText(getActivity(), "Password is not equals", Toast.LENGTH_SHORT).show();
                }


            }






        });

        return v;
    }//OncreateView


    @Override
    public void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() != null){

        }

    }


//    public  void Registation(final String fname, final String lname){
//        mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
//                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            User users = new User(fname,lname);
//
//                            //myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(users);
//                            FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if(task.isSuccessful()){
//                                        Toast.makeText(getActivity(),"Successs",Toast.LENGTH_LONG).show();
//
//                                    }
//                                    else{
//                                        //
//                                        Toast.makeText(getActivity(),"Failed",Toast.LENGTH_LONG).show();
//                                    }
//                                }
//                            });
//
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(getActivity(), "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                        // ...
//                    }
//
//
//                });
//
//    }

    public void setComponent(View v){
        commit = (Button)getActivity().findViewById(R.id.cmt2_btn);
        fname = (EditText)v.findViewById(R.id.Fname);
        lname =(EditText)v.findViewById(R.id.Lname);
        email =(EditText)v.findViewById(R.id.email);
        password =(EditText)v.findViewById(R.id.password);
        confirmpass=(EditText)v.findViewById(R.id.comfirm);
        radioGroup = (RadioGroup)v.findViewById(R.id.radioGroup);

    }

    public boolean isValidNameFormat(final String fname,final  String lname) {

        Pattern pattern;
        Matcher matcher;

        final String Name_PATTERN = "^[ก-๙]*$";
        pattern = Pattern.compile(Name_PATTERN);
        matcher = pattern.matcher(fname);
        matcher = pattern.matcher(lname);
        return matcher.matches();

    }



}
