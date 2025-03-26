package com.example.playpal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.playpal.datatypes.Post;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MakePostFragment extends Fragment {

    final String POSTS_COLLECTION = "posts";

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
        EditText sportType = view.findViewById(R.id.sportTypeEditText);
        EditText proficiency = view.findViewById(R.id.proficiencyEditText);
        EditText time = view.findViewById(R.id.timeInput);
        EditText place = view.findViewById(R.id.meetingPlaceInput);
        EditText description = view.findViewById(R.id.sportsDescriptionInput);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        Button button = view.findViewById(R.id.createPostButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("BEFORE");

                Post post = new Post (
                        // TODO: Bad way to generate an id, but we lack time. Needs to be reimplemented.
                        String.valueOf( (int) (Math.random() * 1000) ),
                        sportType.getText().toString(),
                        proficiency.getText().toString(),
                        time.getText().toString(),
                        place.getText().toString(),
                        description.getText().toString()
                );

                System.out.println("CREATING A POST");
                databaseReference.child(POSTS_COLLECTION).child(post.getPostId()).setValue(post);
            }
        });
        return view;
    }
}