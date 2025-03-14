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

    ArrayList<PostModel> arrayList;
    Context context;
    public PostAdapter(Context context, ArrayList<PostModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.individual_post_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel post = arrayList.get(position);

        // Set profile image
        holder.imageViewProfileAvatar.setImageResource(post.getProfileImage());

        // Set profile name and nickname
        holder.textViewProfileName.setText(post.getProfileName());
        holder.textViewProfileNickname.setText(post.getProfileNickname());

        // Set profile brief description
        holder.textViewProfileBriefDescription.setText(post.getProfileBriefDescription());

        // Set sport type and proficiency image
        holder.textViewSportType.setText(post.getSportType());
        holder.imageViewSportProficiency.setImageResource(post.getSportProficiencyImage());

        // Set meeting time and place
        holder.textViewMeetingTime.setText(post.getMeetingTime());
        holder.textViewMeetingPlace.setText(post.getMeetingPlace());

        // Set post description
        holder.textViewPostDescription.setText(post.getPostDescription());
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

