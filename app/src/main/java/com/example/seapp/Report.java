package com.example.seapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Report extends AppCompatActivity {
    private RadioGroup radio;
    private EditText text;
    private Button commit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        commit = (Button)findViewById(R.id.commit_btn);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"รายงานสำเร็จ",Toast.LENGTH_LONG).show();
                finish();
            }
        });



        text = (EditText)findViewById(R.id.other_textfiled);
        radio = (RadioGroup) findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);
                switch (index) {
                    case 0: // first button
                        text.setVisibility(View.INVISIBLE);
                        break;
                    case 1: // secondbutton
                        text.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        text.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        text.setVisibility(View.INVISIBLE);

                        break;
                    case 4:
                        text.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });//setOncheck
    }//Oncreate
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
