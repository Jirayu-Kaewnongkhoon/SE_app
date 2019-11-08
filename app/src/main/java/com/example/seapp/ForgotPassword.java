package com.example.seapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {

    Dialog dlReset;
    private Button confirm;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.etEmailForgotPass);

        dlReset = new Dialog(this);
    }
    public void ShowPopup(View v){

        dlReset.setContentView(R.layout.activity_password_sent);
        confirm = dlReset.findViewById(R.id.btnSendEmailForgotPass);

        dlReset.show();

        dlReset.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });
    }
}
