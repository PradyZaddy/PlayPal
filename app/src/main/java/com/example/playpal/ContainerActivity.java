package com.example.playpal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.playpal.databinding.ActivityContainerBinding;

public class ContainerActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    AddedEditProfileFragment addedEditProfileFragment;
    AddedMakePostFragment addedMakePostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        Intent receivingIntent = getIntent();
        String fragmentType = receivingIntent.getStringExtra("fragmentType");

        addedEditProfileFragment = new AddedEditProfileFragment();
        addedMakePostFragment = new AddedMakePostFragment();

        frameLayout = findViewById(R.id.fragmentFramelayout);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        if ("editProfileFragment".equals(fragmentType)) {
            ft.replace(R.id.fragmentFramelayout, addedEditProfileFragment);
            ft.commit();
        }

        else if ("makePostFragment".equals(fragmentType))
        {
            ft.replace(R.id.fragmentFramelayout, addedMakePostFragment);
            ft.commit();
        }
    }

}