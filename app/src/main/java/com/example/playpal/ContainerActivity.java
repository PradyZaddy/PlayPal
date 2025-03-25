package com.example.playpal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ContainerActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    EditProfileFragment addedEditProfileFragment;
    MakePostFragment addedMakePostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        Intent receivingIntent = getIntent();
        String fragmentType = receivingIntent.getStringExtra("fragmentType");

        addedEditProfileFragment = new EditProfileFragment();
        addedMakePostFragment = new MakePostFragment();

        frameLayout = findViewById(R.id.fragmentFramelayout);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        if ("editProfileFragment".equals(fragmentType)) {
            changeHeaderText("Edit profile");
            ft.replace(R.id.fragmentFramelayout, addedEditProfileFragment);
            ft.commit();
        }

        else if ("makePostFragment".equals(fragmentType))
        {
            changeHeaderText("Make post");
            ft.replace(R.id.fragmentFramelayout, addedMakePostFragment);
            ft.commit();
        }

        findViewById(R.id.arrowButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void changeHeaderText(String text) {
        TextView headerText = findViewById(R.id.headerText);
        headerText.setText(text);
    }

}