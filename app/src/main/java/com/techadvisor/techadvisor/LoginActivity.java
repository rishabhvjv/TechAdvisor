package com.techadvisor.techadvisor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailString;
    private EditText passwordString;
    private Button loginButton;
    private Button signUpButton;
    private ProgressBar spinner;

    public String userEmail;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        emailString = (EditText) findViewById(R.id.emailFieldId);
        passwordString = (EditText) findViewById(R.id.passwordFieldId);
        loginButton = (Button) findViewById(R.id.loginButtonId);
        signUpButton = (Button) findViewById(R.id.signUpButtonId);

        spinner = (ProgressBar) findViewById(R.id.progressSpinnerId);
        spinner.setVisibility(spinner.GONE);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            Toast.makeText(LoginActivity.this, "Signed IN", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "currently Not signed In", Toast.LENGTH_SHORT).show();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(emailString.getText().toString()) && !TextUtils.isEmpty(passwordString.getText().toString())) {
                    String email = emailString.getText().toString();
                    userEmail = email;
                    String password = passwordString.getText().toString();
                    Login(email, password);
                    spinner.setVisibility(spinner.VISIBLE);
                } else {
                    //do nothing
                }

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    private void Login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(LoginActivity.this , "successfully signed In",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this , MainActivity.class));
                    spinner.setVisibility(spinner.GONE);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this , "sign In failed!!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
