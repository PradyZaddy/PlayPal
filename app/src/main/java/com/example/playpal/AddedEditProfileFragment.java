package com.example.playpal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class AddedEditProfileFragment extends Fragment {

    private Button addSpinnerButton;
    private LinearLayout dynamicSpinnerContainer;

    // Default static spinners from XML
    private Spinner gymSpinner, tennisSpinner, pingPongSpinner;
    private Spinner experienceSpinner1, experienceSpinner2, experienceSpinner3;

    // Shared adapters
    private ArrayAdapter<String> sportAdapter;
    private ArrayAdapter<String> experienceAdapter;

    private int spinnerRowCount = 0;
    private final int MAX_SPINNER_ROWS = 8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_added_edit_profile, container, false);

        // Initialize views
        addSpinnerButton = view.findViewById(R.id.addSpinnerButton);
        dynamicSpinnerContainer = view.findViewById(R.id.dynamicSpinnerContainer1);

        gymSpinner = view.findViewById(R.id.gymSpinner);
        tennisSpinner = view.findViewById(R.id.tennisSpinner);
        pingPongSpinner = view.findViewById(R.id.pingPongSpinner);

        experienceSpinner1 = view.findViewById(R.id.experienceSpinner1);
        experienceSpinner2 = view.findViewById(R.id.experienceSpinner2);
        experienceSpinner3 = view.findViewById(R.id.experienceSpinner3);

        // Shared data
        String[] sports = {"Football", "Basketball", "Volleyball"};
        String[] experience = {"Beginner", "Intermediate", "Advanced"};

        // Create shared adapters
        sportAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, sports);
        sportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        experienceAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, experience);
        experienceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Assign adapters to default spinners
        gymSpinner.setAdapter(sportAdapter);
        tennisSpinner.setAdapter(sportAdapter);
        pingPongSpinner.setAdapter(sportAdapter);

        experienceSpinner1.setAdapter(experienceAdapter);
        experienceSpinner2.setAdapter(experienceAdapter);
        experienceSpinner3.setAdapter(experienceAdapter);

        // Add dynamic rows on click
        addSpinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerRowCount < MAX_SPINNER_ROWS) {
                    dynamicSpinnerContainer.addView(createSpinnerRow());
                    spinnerRowCount++;
                } else {
                    Toast.makeText(requireContext(), "You can only add up to 8 more interests.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    // Creates one row with two spinners
    private LinearLayout createSpinnerRow() {
        LinearLayout row = new LinearLayout(requireContext());
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, 0, 0, 24);
        row.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        Spinner sportSpinner = new Spinner(requireContext());
        LinearLayout.LayoutParams sportParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        sportParams.setMargins(0, 0, 8, 0);
        sportSpinner.setLayoutParams(sportParams);
        sportSpinner.setBackgroundResource(R.drawable.spinner_layout);
        sportSpinner.setAdapter(sportAdapter); // ✅ reuse shared adapter

        Spinner experienceSpinner = new Spinner(requireContext());
        LinearLayout.LayoutParams expParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        experienceSpinner.setLayoutParams(expParams);
        experienceSpinner.setBackgroundResource(R.drawable.spinner_layout);
        experienceSpinner.setAdapter(experienceAdapter); // ✅ reuse shared adapter

        row.addView(sportSpinner);
        row.addView(experienceSpinner);

        return row;
    }
}
