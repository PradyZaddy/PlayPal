package com.example.playpal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PostScreenFragment extends Fragment {

    RecyclerView recyclerView;
    PostAdapter adapter;
    ArrayList<PostModel> postList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        postList = new ArrayList<>();

        populateListWithPosts();
        adapter = new PostAdapter(getContext(), postList);
        recyclerView.setAdapter(adapter);

        return view;
    }


    public synchronized void populateListWithPosts() {
        // Fetching all posts
        Query postsQuery = FirebaseDatabase.getInstance().getReference().child("posts");
        postsQuery.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for(DataSnapshot postSnapshot : snapshot.getChildren())
                {
                    Post post = postSnapshot.getValue(Post.class);
                    System.out.println("post id: " + post.getPostId());
                    postList.add(new PostModel(post.getSportType(), post.getMeetingDateTime(), post.getMeetingLocation()));
                    // Firebase data fetching is an asynchronous action, so even though populateListWithPosts() is set to sync, it still doesn't fix the problem, so the empty list is assigned to recycler view before it is populated.
                    // When populateListWithPosts() is called, it immediately returns, and Firebase starts fetching data in the background async.

                }
                adapter = new PostAdapter(getContext(), postList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(requireContext(), "Could not fetch posts. ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}