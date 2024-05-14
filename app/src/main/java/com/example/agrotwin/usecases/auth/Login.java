package com.example.agrotwin.usecases.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agrotwin.model.session.User;
import com.example.agrotwin.usecases.home.NavMenuActivity;
import com.example.agrotwin.R;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<EditText> editTexts;
    private final LoginViewModel DATA = new LoginViewModel();
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTexts = new ArrayList<>();
        editTexts.add(findViewById(R.id.userEditTextLogin));
        editTexts.add(findViewById(R.id.passwdEditTextLogin));

        Button loginBtn = findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(this);
    }

    public void login(View view) {
        Intent it = new Intent(this, NavMenuActivity.class);
        startActivity(it);
        Toast.makeText(getApplicationContext(), DATA.getLoggedIn(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String username = editTexts.get(0).getText().toString().trim();
        String password = editTexts.get(1).getText().toString().trim();

        user = new User();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), DATA.getProvideUserPass(), Toast.LENGTH_SHORT).show();
            login(v);
            this.finish();
        }
//        } else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//            login(v);
//            this.finish();
//        } else {
//            Toast.makeText(getApplicationContext(), DATA.getInvalidUserPass(), Toast.LENGTH_SHORT).show();
//        }
    }
}
