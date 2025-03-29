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
import com.google.firebase.database.DatabaseReference;
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
        Query postsQuery = FirebaseDatabase.getInstance().getReference().child("posts");
        postsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postList.clear(); // Clear old data to avoid duplicates

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    if (post == null) continue;

                    String userId = post.getUserId();

                    // Fetching user info from users
                    DatabaseReference userRef = FirebaseDatabase.getInstance()
                            .getReference("userList")
                            .child(userId);

                    userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot userSnapshot) {
                            String name = userSnapshot.child("firstName").getValue(String.class);
                            String userName = userSnapshot.child("username").getValue(String.class);

                            // Create a PostModel with user info and post data
                            PostModel postModel = new PostModel(
                                    userId,
                                    post.getSportType(),
                                    post.getMeetingDateTime(),
                                    post.getMeetingLocation(),
                                    name != null ? name : "Unknown",
                                    userName != null ? userName : "@anonymous"
                            );

                            postList.add(postModel);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // Handle error if needed
                        }
                    });
                }

                // Set adapter only once
                adapter = new PostAdapter(getContext(), postList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(requireContext(), "Could not fetch posts.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}