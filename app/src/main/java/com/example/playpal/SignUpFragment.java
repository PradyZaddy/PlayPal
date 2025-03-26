package com.example.playpal;

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

import com.example.playpal.datatypes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpFragment extends Fragment
{
    private DatabaseReference databaseReference;
    LoginFragment loginFragment;
    TextView logInOptionText;
    FirebaseAuth mAuth;
    EditText firstNameText, lastNameText, nickname, emailText, passwordText, confirmPasswordText;
    Button signUpButton;
    CheckBox checkBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        logInOptionText = view.findViewById(R.id.logInOptionText);
        loginFragment = new LoginFragment();

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        firstNameText = view.findViewById(R.id.firstNameInput);
        lastNameText = view.findViewById(R.id.lastNameInput);
        nickname = view.findViewById(R.id.nicknameInput);
        emailText = view.findViewById(R.id.emailInput);
        passwordText = view.findViewById(R.id.passwordInput);
        confirmPasswordText = view.findViewById(R.id.confirmPasswordInput);
        signUpButton = view.findViewById(R.id.signUpButton);
        checkBox = view.findViewById(R.id.checkBox);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpWithEmailAndPassword(emailText.getText().toString(), passwordText.getText().toString());
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
                            saveUserDataInDatabase();
                            Intent intent = new Intent(getContext(), HomeActivity.class);
                            startActivity(intent);
                        } else
                        {
                            Toast.makeText(getContext(), "Authentication failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                            System.out.println(emailText.toString());
                            System.out.println(task.getException());
                        }
                    }
                });
    }

    // TODO: Need to move this method to entity (for better architecture practice).
    private void saveUserDataInDatabase() {
        User user = new User(nickname.getText().toString(), firstNameText.getText().toString(), lastNameText.getText().toString());
        //databaseReference.child("users").child(user.getNickname()).setValue(user);
        System.out.println(databaseReference.child("users").child("john2000").get());
    }
}
