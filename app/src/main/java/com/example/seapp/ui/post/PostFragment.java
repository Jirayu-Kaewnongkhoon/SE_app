package com.example.seapp.ui.post;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.seapp.MainActivity;
import com.example.seapp.R;

public class PostFragment extends Fragment {

    private PostViewModel postViewModel;
    private LinearLayout layout_post, layout_click_post;
    private EditText edit_Post, edit_post_onClick;
    private TextView count_text;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Set title name in actionbar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_post));

        postViewModel =
                ViewModelProviders.of(this).get(PostViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_post, container, false);

        layout_post = root.findViewById(R.id.layoutPost);
        layout_click_post = root.findViewById(R.id.layoutClickPost);

        edit_Post = root.findViewById(R.id.editPost);
        edit_post_onClick = root.findViewById(R.id.editPostOnClick);

        count_text = root.findViewById(R.id.countText);

        // Set when on focus on count_text
        edit_Post.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                layout_post.setVisibility(View.GONE);
                layout_click_post.setVisibility(View.VISIBLE);

                // Set cursor focus and open keyboard
                edit_post_onClick.requestFocus();
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edit_post_onClick, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        // On write post an calculated count text
        edit_post_onClick.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int tmpCount = 150 - s.length();
                count_text.setText(String.valueOf(tmpCount));

                // Call method in MainActivity for set button post on action bar
                ((MainActivity) getActivity())
                        .setActionBarPost(Integer.valueOf(s.length()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return root;
    }
}