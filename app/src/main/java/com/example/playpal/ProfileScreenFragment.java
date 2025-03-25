package com.example.playpal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileScreenFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_screen, container, false);

        view.findViewById(R.id.editProfileButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent (getContext(), ContainerActivity.class);
                intent.putExtra("fragmentType", "editProfileFragment");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.makePostButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (getContext(), ContainerActivity.class);
                intent.putExtra("fragmentType", "makePostFragment");
                startActivity(intent);
            }
        });

        return view;
    }
}