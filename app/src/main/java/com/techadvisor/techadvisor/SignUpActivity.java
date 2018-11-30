package com.techadvisor.techadvisor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techadvisor.techadvisor.POJO.User;

public class SignUpActivity extends AppCompatActivity {


    EditText etEmail,etName,etPass,etconfPass;
    Button btnSignUp;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Users");

        btnSignUp = (Button)findViewById(R.id.signUpBtnId);
        etEmail = (EditText)findViewById(R.id.emailSignUpField);
        etPass = (EditText)findViewById(R.id.passwordSignUpField1Id);
        etconfPass = (EditText)findViewById(R.id.passwordSignUpField2Id);
        etName = (EditText)findViewById(R.id.displayNameFieldId);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFields())
                {
                    String email,pass;
                    email = etEmail.getText().toString();
                    pass = etPass.getText().toString();
                    firebaseAuth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        Log.d("check_1", "onComplete: " + firebaseAuth.getCurrentUser().getUid() + "\t" + firebaseAuth.getCurrentUser().getEmail());
                                        User thisUser = new User(etName.getText().toString(),etEmail.getText().toString());
                                        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(thisUser);
                                        Toast.makeText(SignUpActivity.this, "Welcome "+ etName.getText().toString(), Toast.LENGTH_SHORT).show();
                                        Intent thisIntent = new Intent(SignUpActivity.this,MainActivity.class);
                                        startActivity(thisIntent);
//                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<Void> task) {
//                                                        if(task.isSuccessful())
//                                                        {
//                                                            Log.d("check_2", "onComplete: ");
//                                                            Toast.makeText(SignUpActivity.this, "Welcome "+ etName.getText().toString(), Toast.LENGTH_SHORT).show();
//                                                            Intent thisIntent = new Intent(SignUpActivity.this,MainActivity.class);
//                                                            startActivity(thisIntent);
//                                                        }
//                                                        else
//                                                        {
//                                                            Toast.makeText(SignUpActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
//                                                        }
//                                                    }
//                                                });
                                    }
                                    else
                                    {
                                        Toast.makeText(SignUpActivity.this, "Registration Failed! Please Try Again...", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    }


    boolean checkFields()
    {
        if(etName.getText().toString().isEmpty()||etEmail.getText().toString().isEmpty()||
                etconfPass.getText().toString().isEmpty()||etPass.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please Provode all details!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!etEmail.getText().toString().contains("@"))
        {
            Toast.makeText(this, "Please provide correct email!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!etconfPass.getText().toString().equals(etPass.getText().toString()))
        {
            Toast.makeText(this, "Password does not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return true;
        }
    }
}
