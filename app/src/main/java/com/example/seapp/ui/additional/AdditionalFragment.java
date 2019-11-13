package com.example.seapp.ui.additional;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.seapp.LoginActivity;
import com.example.seapp.MainActivity;
import com.example.seapp.R;
import com.example.seapp.ui.announcement.AnnouncementActivity;
import com.example.seapp.ui.home.HomeFragment;

public class AdditionalFragment extends Fragment {

    private AdditionalViewModel additionalViewModel;
    private CardView card_History, card_Reply, card_Guide, card_Advertise, card_Contact, card_Logout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Set title name in actionbar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_additional));

        additionalViewModel =
                ViewModelProviders.of(this).get(AdditionalViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_additional, container, false);

        // On click cardView history post
        card_History = root.findViewById(R.id.cardHistory);
        card_History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // On click cardView reply
        card_Reply = root.findViewById(R.id.cardReply);
        card_Reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // On click cardView guide
        card_Guide = root.findViewById(R.id.cardGuide);
        card_Guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), GuideActivity.class);
                startActivity(intent);
            }
        });

        // On click cardView advertise
        card_Advertise = root.findViewById(R.id.cardAdvertise);
        card_Advertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,new AnnouncementFragment()).commit();*/
                Intent intent = new Intent(root.getContext(), AnnouncementActivity.class);
                startActivity(intent);
            }
        });

        // On click cardView contact
        card_Contact = root.findViewById(R.id.cardContact);
        card_Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        // On click cardView logout
        card_Logout = root.findViewById(R.id.cardLogout);
        card_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(root.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

}