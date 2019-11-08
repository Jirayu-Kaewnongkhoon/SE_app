package com.example.seapp.ui.profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.seapp.MainActivity;
import com.example.seapp.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileFragment extends Fragment  {

    private ProfileViewModel profileViewModel;
    private Button commit;
    private TextView nameTxt;
    private TextView nameLength;
    private TextView statusLength;
    private EditText name;
    private EditText status;
    final int maxlength = 20;
    private  int lengthName;
    private  int remainNameLength;
    private  int lengthStatus;
    private  int remainStatusLength;
    private  TextView expression;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        // Set title name in actionbar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_profile));

        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final Button edit = root.findViewById(R.id.edit_btn);
        nameTxt =(TextView)root.findViewById(R.id.nameText);
        name =(EditText)root.findViewById(R.id.nameEdit);
        status =(EditText)root.findViewById(R.id.statusEdit);
        nameLength=(TextView)root.findViewById(R.id.nameLength);
        statusLength=(TextView)root.findViewById(R.id.statusLength);
        commit = (Button)root.findViewById(R.id.commit_btn);
        expression =(TextView)root.findViewById(R.id.Expression_text);
//        int lengthName = name.lengthName();
//        int remainNameLength = maxlength-lengthName;
//        String convert = String.valueOf(remainNameLength);
//        nameLength.setText(convert);





        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.border);
                status.setBackgroundResource(R.drawable.border);
                nameTxt.setText("ชื่อผู้ใช้ (ห้ามตั้งชื่อที่เข้าข่ายลามกอนาจาร)");
                name.setFocusable(true);
                name.setFocusableInTouchMode(true);
                status.setFocusable(true);
                status.setFocusableInTouchMode(true);
                commit.setVisibility(View.VISIBLE);
                nameLength.setVisibility(View.VISIBLE);
                statusLength.setVisibility(View.VISIBLE);

                //Intitial Count Text
                lengthName = name.length();
                remainNameLength = maxlength- lengthName;
                String name_Remain = String.valueOf(remainNameLength);
                nameLength.setText(name_Remain);

                lengthStatus = status.length();
                remainStatusLength = maxlength - lengthStatus;
                String status_Remain = String.valueOf(remainStatusLength);
                statusLength.setText(status_Remain);



                //Realtime Count Name Text
                name.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        lengthName = name.length();
                        remainNameLength = maxlength- lengthName;
                        String convert = String.valueOf(remainNameLength);
                        nameLength.setText(convert);
                    }
                });

            }
        });


        //Realtime Count Status Text
        status.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                lengthStatus = status.length();
                remainStatusLength = maxlength - lengthStatus;
                String status_Remain = String.valueOf(remainStatusLength);
                statusLength.setText(status_Remain);
            }
        });




        // Click Commit Buttton
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidFormat(name.getText().toString().trim())) {
                    name.setBackgroundResource(R.drawable.edittext_grey);
                    status.setBackgroundResource(R.drawable.edittext_grey);
                    nameTxt.setText("ชื่อผู้ใช้");
                    name.setFocusable(false);
                    name.setFocusableInTouchMode(false);
                    status.setFocusable(false);
                    status.setFocusableInTouchMode(false);
                    Toast.makeText(getActivity(), "แก้ไขเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                    commit.setVisibility(View.INVISIBLE);
                    nameLength.setVisibility(View.INVISIBLE);
                    statusLength.setVisibility(View.INVISIBLE);
                    expression.setVisibility(View.INVISIBLE);
                } else {
                    name.setBackgroundResource(R.drawable.red_border);
                    expression.setVisibility(View.VISIBLE);

                }
//                name.setBackgroundResource(R.drawable.edittext_grey);
//                status.setBackgroundResource(R.drawable.edittext_grey);
//                nameTxt.setText("ชื่อผู้ใช้");
//                name.setFocusable(false);
//                name.setFocusableInTouchMode(false);
//                status.setFocusable(false);
//                status.setFocusableInTouchMode(false);
//                Toast.makeText(getActivity(), "แก้ไขเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
//                commit.setVisibility(View.INVISIBLE);
//                nameLength.setVisibility(View.INVISIBLE);
//                statusLength.setVisibility(View.INVISIBLE);



            }
        });



        return root;
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