package com.example.playpal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<PostModel> postList;

    public PostAdapter(Context context, ArrayList<PostModel> postList)
    {
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
        holder.yesButton.setImageResource(R.drawable.checkmark);

        holder.yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // used for debugging whether its working or not
                //Log.e("Clicking?", "Click has been registered");
                String senderId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                String postOwnerId = post.getUserId();

                DatabaseReference notifRef = FirebaseDatabase.getInstance()
                        .getReference("postResponseList")
                        .child(postOwnerId)
                        .push(); // creates a unique key

                Map<String, Object> data = new HashMap<>();
                data.put("senderId", senderId);
                notifRef.setValue(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView name, userName, userDescription, gameTitle, gameDate, gameLocation;
        ImageView profilePicture, closeButton;
        ImageButton yesButton;

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
            yesButton = itemView.findViewById(R.id.yesButton);
        }
    }

}
