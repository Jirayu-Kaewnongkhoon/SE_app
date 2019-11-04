package com.example.seapp.ui.additional;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.seapp.MainActivity;
import com.example.seapp.R;

public class AdditionalFragment extends Fragment {

    private AdditionalViewModel additionalViewModel;
    private CardView mCardView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Set title name in actionbar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_additional));

        additionalViewModel =
                ViewModelProviders.of(this).get(AdditionalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_additional, container, false);

        return root;
    }
}