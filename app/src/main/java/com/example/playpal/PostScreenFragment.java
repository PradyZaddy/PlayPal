package com.example.playpal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PostScreenFragment extends Fragment {

    RecyclerView recyclerView;
    PostAdapter adapter;
    ArrayList<PostModel> postList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        postList = new ArrayList<>();
        postList.add(new PostModel("Oleh", "@big_0_notation", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));
        postList.add(new PostModel("Oleh2", "@big_0_notation2", "Top Weirdo Canada 2025", "Table Tennis", "30 March, 1:00pm (Sunday)", "Riverside Park", R.drawable.profilepicture, R.drawable.closeicon, R.drawable.save, R.drawable.checkmark));

        adapter = new PostAdapter(getContext(), postList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
