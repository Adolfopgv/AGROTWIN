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

/**
 * Actividad de inicio de sesión para la aplicación AgroTwin.
 * Permite a los usuarios ingresar su nombre de usuario y contraseña para acceder a la aplicación.
 * Utiliza datos por defecto, en producción los cogería de una base de datos.
 * @author Adolfo Pérez-Gascón Valls
 * @author David Pimentel
 */
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

    /**
     * Método para manejar el inicio de sesión.
     *
     * @param view La vista que dispara el evento de inicio de sesión.
     */
    public void login(View view) {
        Intent it = new Intent(this, NavMenuActivity.class);
        startActivity(it);
        Toast.makeText(getApplicationContext(), DATA.getLoggedIn(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Método llamado cuando se hace clic en el botón de inicio de sesión.
     * Verifica las credenciales del usuario y procede con el inicio de sesión si son correctas.
     *
     * @param v La vista que dispara el evento de clic.
     */
    @Override
    public void onClick(View v) {
        String username = editTexts.get(0).getText().toString().trim();
        String password = editTexts.get(1).getText().toString().trim();

        user = new User();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), DATA.getProvideUserPass(), Toast.LENGTH_SHORT).show();
        } else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            login(v);
            this.finish();
        } else {
            Toast.makeText(getApplicationContext(), DATA.getInvalidUserPass(), Toast.LENGTH_SHORT).show();
        }
    }
}
