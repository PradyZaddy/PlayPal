package com.example.playpal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.playpal.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity
{
    Button addSpinnerButton;
    ImageView backButton;
    LinearLayout dynamicSpinnerContainer;

    Spinner gymSpinner, tennisSpinner, pingPongSpinner;
    Spinner experienceSpinner1, experienceSpinner2, experienceSpinner3;

    ArrayAdapter<String> sportAdapter;
    ArrayAdapter<String> experienceAdapter;

    int spinnerRowCount = 0;
    final int MAX_SPINNER_ROWS = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        addSpinnerButton = findViewById(R.id.addSpinnerButton);
        dynamicSpinnerContainer = findViewById(R.id.dynamicSpinnerContainer1);

        gymSpinner = findViewById(R.id.gymSpinner);
        tennisSpinner = findViewById(R.id.tennisSpinner);
        pingPongSpinner = findViewById(R.id.pingPongSpinner);

        experienceSpinner1 = findViewById(R.id.experienceSpinner1);
        experienceSpinner2 = findViewById(R.id.experienceSpinner2);
        experienceSpinner3 = findViewById(R.id.experienceSpinner3);

        // Shared data
        String[] sports = {"Football", "Basketball", "Volleyball"};
        String[] experience = {"Beginner", "Intermediate", "Advanced"};

        // Create shared adapters
        sportAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sports);
        sportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        experienceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, experience);
        experienceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Assign adapters to default spinners
        gymSpinner.setAdapter(sportAdapter);
        tennisSpinner.setAdapter(sportAdapter);
        pingPongSpinner.setAdapter(sportAdapter);

        experienceSpinner1.setAdapter(experienceAdapter);
        experienceSpinner2.setAdapter(experienceAdapter);
        experienceSpinner3.setAdapter(experienceAdapter);

        // Add dynamic rows on click
        addSpinnerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (spinnerRowCount < MAX_SPINNER_ROWS)
                {
                    dynamicSpinnerContainer.addView(createSpinnerRow());
                    spinnerRowCount++;
                }
                else
                {
                    Toast.makeText(EditProfileActivity.this, "You can only add up to 8 more interests.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    private LinearLayout createSpinnerRow()
    {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, 0, 0, 24);
        row.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        Spinner sportSpinner = new Spinner(this);
        LinearLayout.LayoutParams sportParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        sportParams.setMargins(0, 0, 8, 0);
        sportSpinner.setLayoutParams(sportParams);
        sportSpinner.setBackgroundResource(R.drawable.spinner_layout);
        sportSpinner.setAdapter(sportAdapter);

        Spinner experienceSpinner = new Spinner(this);
        LinearLayout.LayoutParams expParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        experienceSpinner.setLayoutParams(expParams);
        experienceSpinner.setBackgroundResource(R.drawable.spinner_layout);
        experienceSpinner.setAdapter(experienceAdapter);

        row.addView(sportSpinner);
        row.addView(experienceSpinner);

        return row;
    }


}
