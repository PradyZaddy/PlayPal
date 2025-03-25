package com.example.playpal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginFragment extends Fragment
{

    EditText emailInput;
    EditText passwordInput;
    Button logInButton;
    TextView signUpOptionText;
    SignUpFragment signUpFragment;
    FirebaseAuth mAuth;
    View frameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        signUpOptionText = view.findViewById(R.id.signupOptionText);
        frameLayout = requireActivity().findViewById(R.id.frameLayout);

        resetFrameLayoutSize();

        emailInput = view.findViewById(R.id.emailInput);
        passwordInput = view.findViewById(R.id.passwordInput);
        logInButton = view.findViewById(R.id.logInButton);
        mAuth = FirebaseAuth.getInstance();


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                System.out.println(databaseReference.child("users").child("john2000"));

                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);

//                if (!email.isEmpty() && !password.isEmpty())
//                {
//                    logInWithEmailAndPassword(email, password);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Log In Failed!", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        signUpOptionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resizeFrameLayout();

                signUpFragment = new SignUpFragment();
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, signUpFragment);
                ft.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
                ft.addToBackStack("backStack");
                ft.commit();
            }
        });

        return view;
    }

    private void resizeFrameLayout() {
        if (frameLayout != null) {
            ViewGroup.LayoutParams params = frameLayout.getLayoutParams();
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            frameLayout.setLayoutParams(params);
        }
    }

    private void resetFrameLayoutSize() {
        if (frameLayout != null) {
            ViewGroup.LayoutParams params = frameLayout.getLayoutParams();
            params.height = 1800;
            frameLayout.setLayoutParams(params);
        }
    }

    private void logInWithEmailAndPassword(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(getContext(), "Log In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Authentication failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

