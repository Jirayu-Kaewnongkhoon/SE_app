package com.example.seapp.ui.profile;

import android.os.Bundle;
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

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private Button commit;
    private TextView nameTxt;
    private TextView nameLength;
    private TextView statusLength;
    private EditText name;
    private EditText status;



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



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            name.setBackgroundResource(R.drawable.border);
            status.setBackgroundResource(R.drawable.border);
            nameTxt.setText("ชื่อผู้ใช้ (ห้ามตั้งชื่อที่เข้าข่ายลามกอนาจาร)");
            name.setFocusableInTouchMode(true);
            status.setFocusableInTouchMode(true);

            }
        });

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.edittext_grey);
                status.setBackgroundResource(R.drawable.edittext_grey);
                nameTxt.setText("ชื่อผู้ใช้");
                name.setFocusableInTouchMode(false);
                status.setFocusableInTouchMode(false);
                //Toast.makeText(getContext(),"บันทึกสำเร็จ",1000).show();
            }
        });



        return root;
    }
}