package com.example.playpal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MakePostFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_added_make_post, container, false);

        // TODO: SEND DATA IN ON CLICK AND CLOSE THE ACTIVITY
//        view.findViewById(R.id.).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                container.finish();
//            }
//        });

        return view;
    }
}