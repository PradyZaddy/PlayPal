package com.example.playpal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoginFragment extends Fragment {
    TextView signUpOptionText;
    SignUpFragment signUpFragment;
    View frameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        signUpOptionText = view.findViewById(R.id.signupOptionText);
        frameLayout = requireActivity().findViewById(R.id.frameLayout);

        resetFrameLayoutSize();

        signUpOptionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resizeFrameLayout();

                signUpFragment = new SignUpFragment();
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, signUpFragment);
                ft.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
                ft.addToBackStack("backStack");
                ft.commit();
            }
        });

        return view;
    }

    private void resizeFrameLayout() {
        if (frameLayout != null) {
            ViewGroup.LayoutParams params = frameLayout.getLayoutParams();
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            frameLayout.setLayoutParams(params);
        }
    }

    private void resetFrameLayoutSize() {
        if (frameLayout != null) {
            ViewGroup.LayoutParams params = frameLayout.getLayoutParams();
            params.height = 1800;
            frameLayout.setLayoutParams(params);
        }
    }
}

