package com.example.agrotwin;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<EditText> editTexts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        editTexts = new ArrayList<>();
        editTexts.add(findViewById(R.id.userEditTextLogin));
        editTexts.add(findViewById(R.id.passwdEditTextLogin));
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    public void login(View view) {
        Intent it = new Intent(getApplicationContext(), Home.class);
        startActivity(it);
        Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String username = editTexts.get(0).getText().toString().trim();
        String password = editTexts.get(1).getText().toString().trim();

        if (username.isEmpty() && password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please provide an username and password.", Toast.LENGTH_SHORT).show();
        } else if(username.equals("admin") && password.equals("admin")){
            login(v);
        }
    }
}