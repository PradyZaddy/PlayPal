package com.example.playpal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    //TODO: replace Object with PostModel
    ArrayList<Object> arrayList;
    Context context;
    public PostAdapter(Context context, ArrayList<Object> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.individual_post_layout, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view); 
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class PostViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewProfileAvatar, imageViewSportProficiency;
    TextView textViewProfileName, textViewProfileNickname, textViewProfileBriefDescription, textViewSportType, textViewMeetingTime, textViewMeetingPlace, textViewPostDescription;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        imageViewProfileAvatar = itemView.findViewById(R.id.imageViewProfileAvatar);
        imageViewSportProficiency = itemView.findViewById(R.id.imageViewSportProficiency);

        textViewProfileName = itemView.findViewById(R.id.textViewProfileName);
        textViewProfileNickname = itemView.findViewById(R.id.textViewProfileNickname);
        textViewProfileBriefDescription = itemView.findViewById(R.id.textViewProfileBriefDescription);
        textViewSportType = itemView.findViewById(R.id.textViewSportType);
        textViewMeetingTime = itemView.findViewById(R.id.textViewMeetingTime);
        textViewMeetingPlace = itemView.findViewById(R.id.textViewMeetingPlace);
        textViewPostDescription = itemView.findViewById(R.id.textViewPostDescription);
    }
}

