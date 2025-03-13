package com.example.playpal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class SignUpFragment extends Fragment
{
    LoginFragment loginFragment;
    TextView logInOptionText;
    FirebaseAuth mAuth;
    EditText firstNameText, lastNameText, emailText, passwordText, confirmPasswordText;
    Button signUpButton;
    CheckBox checkBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        logInOptionText = view.findViewById(R.id.logInOptionText);
        loginFragment = new LoginFragment();

        mAuth = FirebaseAuth.getInstance();
        firstNameText = view.findViewById(R.id.firstNameInput);
        lastNameText = view.findViewById(R.id.lastNameInput);
        emailText = view.findViewById(R.id.emailInput);
        passwordText = view.findViewById(R.id.passwordInput);
        confirmPasswordText = view.findViewById(R.id.confirmPasswordInput);
        signUpButton = view.findViewById(R.id.signUpButton);
        checkBox = view.findViewById(R.id.checkBox);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                String confirmPassword = confirmPasswordText.getText().toString();

                if (!email.isEmpty() && !password.isEmpty() && password.equals(confirmPassword) && checkBox.isChecked())
                {
                    signUpWithEmailAndPassword(email, password);
                } else {
                    Toast.makeText(getContext(), "Please enter all the values", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logInOptionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.frameLayout, loginFragment);
                ft.addToBackStack("backStack");
                ft.commit();
            }
        });


        return view;
    }

    private void signUpWithEmailAndPassword(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getContext(), HomeActivity.class);
                            startActivity(intent);
                        }


                        else
                        {
                            Toast.makeText(getContext(), "Authentication failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}