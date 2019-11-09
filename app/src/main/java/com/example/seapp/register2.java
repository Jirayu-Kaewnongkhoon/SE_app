package com.example.seapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register2 extends AppCompatActivity {
    Button buttonboy,buttongirl;
    private EditText name;
    private ImageView correct;
    private TextView warning;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        buttonboy=(Button)findViewById(R.id.buttonboycs);
        buttongirl=(Button) findViewById(R.id.buttongirlcs);
        name =(EditText)findViewById(R.id.name);
        correct = (ImageView)findViewById(R.id.correctuser);
        warning =(TextView)findViewById(R.id.warning);

        buttonboy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonboy.setBackgroundResource(R.drawable.boycspress);
                buttongirl.setBackgroundResource(R.drawable.girlcs);
            }
        });
        buttongirl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttongirl.setBackgroundResource(R.drawable.girlcspress);
                buttonboy.setBackgroundResource(R.drawable.boycs);
            }
        });






        name.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isValidFormat(name.getText().toString().trim())&&name.length()>0) {
                    correct.setVisibility(View.VISIBLE);
                    name.setBackgroundResource(R.drawable.borderbox);
                    warning.setVisibility(View.INVISIBLE);
                }
                else  {
                    correct.setVisibility(View.INVISIBLE);
                    warning.setVisibility(View.VISIBLE);
                    name.setBackgroundResource(R.drawable.red_border);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

    }





    public boolean isValidFormat(final String name) {

        Pattern pattern;
        Matcher matcher;

        final String Name_PATTERN = "^[ก-๙a-zA-Z0-9. ]*$";
        pattern = Pattern.compile(Name_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();

    }
}
