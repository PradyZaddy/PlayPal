package com.example.playpal;

public class PostResponse
{
    String postId, senderId, receiverId;

    public PostResponse(String senderId, String postId, String receiverId) {
        this.senderId = senderId;
        this.postId = postId;
        this.receiverId = receiverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getPostId() {
        return postId;
    }

    public String getReceiverId() {
        return receiverId;
    }
}
