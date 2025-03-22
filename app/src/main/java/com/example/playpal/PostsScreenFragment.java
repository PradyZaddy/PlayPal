package com.example.playpal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PostsScreenFragment extends Fragment {

    HomeActivity homeActivity;
    public PostsScreenFragment(HomeActivity mainActivity) {
        this.homeActivity = mainActivity;
    }
    ArrayList<PostModel> arrayList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println(">>>creating posts screen view");
        View view =  inflater.inflate(R.layout.fragment_posts_screen, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView1);

        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));
        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));
        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));
        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));
        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));
        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));
        arrayList.add(new PostModel(R.drawable.test_profile_icon, R.drawable.button_layouts, "Oleh", "@bigO", "some dude...", "Tennis", "5 Mar, 7:30 PM (Monday)", "TCC", "Some description Some description Some description Some description Some description Some description"));

        PostAdapter adapter=new PostAdapter(homeActivity, arrayList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(homeActivity, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}