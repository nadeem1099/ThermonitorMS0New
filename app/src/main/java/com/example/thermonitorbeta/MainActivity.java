package com.example.thermonitorbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public Toolbar toolbar;
    public EditText email;
    public EditText password;

    public void activateButton()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(open);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        button = (Button)findViewById(R.id.button1);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        activateButton();
    }
}
