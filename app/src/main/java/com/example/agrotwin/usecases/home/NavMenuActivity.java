package com.example.agrotwin.usecases.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.agrotwin.R;
import com.example.agrotwin.databinding.ActivityNavMenuBinding;
import com.example.agrotwin.usecases.auth.Login;
import com.example.agrotwin.usecases.home.pages.HomeFragment;
import com.example.agrotwin.usecases.home.pages.SettingsFragment;

/**
 * Actividad principal que muestra el menú de navegación y gestiona los fragmentos.
 * @author Adolfo Pérez-Gascón Valls
 */
public class NavMenuActivity extends AppCompatActivity {

    private ActivityNavMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navHome) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.navSettings) {
                replaceFragment(new SettingsFragment());
            } else {
                Intent it = new Intent(this, Login.class);
                startActivity(it);
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                this.finish();
            }
            return true;
        });
    }

    /**
     * Reemplaza el fragmento actual con el fragmento proporcionado.
     *
     * @param fragment El fragmento a ser reemplazado.
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layoutNav, fragment);
        fragmentTransaction.commit();
    }
}