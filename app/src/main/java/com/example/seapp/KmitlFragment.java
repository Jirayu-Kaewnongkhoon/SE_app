package com.example.seapp;

import android.content.Intent;
import android.os.Bundle;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KmitlFragment extends Fragment {
    private Button commit;
    private EditText fname,lname,email,password,confirmpass;
    private RadioGroup radioGroup;
    public FirebaseDatabase database;
    public DatabaseReference myRef;
    private String userId;
    private FirebaseAuth mAuth;
    private String userType ="Kmitl";
    private String inType;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.kmitl_fragment, container,false);
        setComponent(v);



        //database = FirebaseDatabase.getInstance();
        //mAuth = FirebaseAuth.getInstance();
        //myRef = database.getReference("User");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case 0: // first button
                        inType="นักศึกษา";
                        break;
                    case 1: // secondbutton
                        inType="บุคลากร";
                        break;
                }
            }
        }); //Check index in radioGroup for define In Kmitl Type


        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commit.setText("Hi");
                if(fname.getText().toString().trim().isEmpty() || lname.getText().toString().trim().isEmpty()
                        || email.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()
                        || confirmpass.getText().toString().trim().isEmpty())
                    Toast.makeText(getActivity(), "กรุณากรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_SHORT).show();
                else {
                    if (isValidNameFormat()) {
                        //Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "ชื่อไม่ตรงตามรูปแบบ", Toast.LENGTH_SHORT).show();
                    }
                }


                if(!(password.getText().toString().trim()).equals(confirmpass.getText().toString().trim())){
                    Toast.makeText(getActivity(), "พาสเวิร์ดไม่ตรงกัน", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getActivity(), register2.class);
                intent.putExtra("fname",fname.getText().toString().trim());
                intent.putExtra("lname",lname.getText().toString().trim());
                intent.putExtra("email",email.getText().toString().trim());
                intent.putExtra("password",password.getText().toString().trim());
                intent.putExtra("userType",userType);
                intent.putExtra("userType",inType);
                startActivity(intent);


            }//OnClick



        });

        return v;
    } //OncreateView


//    @Override
//    public void onStart() {
//        super.onStart();
//        if(mAuth.getCurrentUser() != null){
//
//        }
//
//    }


    public void setComponent(View v){
        commit = (Button)getActivity().findViewById(R.id.cmt2_btn);
        fname = (EditText)v.findViewById(R.id.Fname);
        lname =(EditText)v.findViewById(R.id.Fname);
        email =(EditText)v.findViewById(R.id.email);
        password =(EditText)v.findViewById(R.id.password);
        confirmpass=(EditText)v.findViewById(R.id.comfirm);
        radioGroup = (RadioGroup)v.findViewById(R.id.radioGroup);
    }

    public boolean isValidNameFormat() {
        Pattern pattern;
        Matcher matcher;
        final String Name_PATTERN = "^[ก-๙a-zA-Z]*$";
        pattern = Pattern.compile(Name_PATTERN);
        matcher = pattern.matcher(fname.getText().toString().trim());
        matcher = pattern.matcher(lname.getText().toString().trim());
        return matcher.matches();
    }

//   public boolean isValidEmailFormat(){
//    Pattern pattern;
//    Matcher matcher;
//    final String Name_PATTERN = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
//
//    pattern = Pattern.compile(Name_PATTERN);
//    matcher = pattern.matcher(email.getText().toString().trim());
//    return matcher.matches();
//    }




}
