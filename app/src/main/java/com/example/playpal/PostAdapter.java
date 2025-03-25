package com.example.playpal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<PostModel> postList;

    public PostAdapter(Context context, List<PostModel> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_row, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel post = postList.get(position);

        // Set text data
        holder.name.setText(post.getName());
        holder.userName.setText(post.getUserName());
        holder.userDescription.setText(post.getUserDescription());
        holder.gameTitle.setText(post.getGameTitle());
        holder.gameDate.setText(post.getGameDate());
        holder.gameLocation.setText(post.getGameLocation());

        // Set image resources
        holder.profilePicture.setImageResource(post.getProfilePictureImageId());
        holder.closeButton.setImageResource(post.getCloseButtonImageId());
        holder.saveButton.setImageResource(post.getSaveButtonImageId());
        holder.yesButton.setImageResource(post.getYesButtonImageId());

        // need to put button handler in here
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView name, userName, userDescription, gameTitle, gameDate, gameLocation;
        ImageView profilePicture, closeButton, saveButton, yesButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.userName);
            userDescription = itemView.findViewById(R.id.userDescription);
            gameTitle = itemView.findViewById(R.id.gameTitle);
            gameDate = itemView.findViewById(R.id.gameTime);
            gameLocation = itemView.findViewById(R.id.gameLocation);

            profilePicture = itemView.findViewById(R.id.imageView);
            closeButton = itemView.findViewById(R.id.closeButton);
            saveButton = itemView.findViewById(R.id.createPostButton);
            yesButton = itemView.findViewById(R.id.yesButton);
        }
    }

}
