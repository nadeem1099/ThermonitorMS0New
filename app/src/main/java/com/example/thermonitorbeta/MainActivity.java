package com.example.thermonitorbeta;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button button;
    public Toolbar toolbar;
    public EditText email;
    public EditText password;
    public Button noAccButton;
    EditText usernameText;
    EditText passwordText;
    EditText emailText;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button1);
        noAccButton = (Button) findViewById(R.id.noAccountButton);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.noAccountButton).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);

        usernameText = (EditText) findViewById(R.id.userName);
        passwordText = (EditText) findViewById(R.id.passWord);
        emailText = (EditText) findViewById(R.id.eMail);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        userLogin();



    }

    public void userLogin()
    {
        String Username = usernameText.getText().toString().trim();
        String Password = passwordText.getText().toString().trim();
        String Email = emailText.getText().toString().trim();

        if(Username.isEmpty())
        {
            usernameText.setError("Username is required");
            usernameText.requestFocus();
            return;
        }

        if (Password.isEmpty())
        {
            passwordText.setError("Password is required");
            passwordText.requestFocus();
            return;
        }

        if (Email.isEmpty())
        {
            emailText.setError("Email is required");
            emailText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            emailText.setError("The entered email is invalid");
            emailText.requestFocus();
            return;
        }

        if (Password.length()<6)
        {
            passwordText.setError("Password must be at least 6 characters long");
            passwordText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.noAccountButton:
                Intent noAcc = new Intent(this, RegisterActivity.class);
                startActivity(noAcc);
                break;

            case R.id.button1:
                userLogin();
                break;
        }

    }
}
