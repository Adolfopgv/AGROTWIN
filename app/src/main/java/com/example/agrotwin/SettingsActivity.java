package com.example.agrotwin;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private Spinner spinner;
    public static final String[] languages = {"Select language", "English", "Español"};

    private Button btnSN;

    private static final String CHANNEL_ID = "canal";
    private PendingIntent pendingIntent;


//    MODO OSCURO

    boolean isNightModeOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);

        darkMode();
        spinnerMode();
        notifications();


    }

    private void notifications() {

        btnSN = findViewById(R.id.btnSN);
        btnSN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    //Es true, signifixa que el dispositivo que ejecuta la aplicacion tiene
                   // Android SDK, superior - y se ejecutará el bloque de código dentro de usted "if".
                    showNotification();
                }else{

                    showNewNotification();

                }
            }
        });



    }

    private void showNotification(){
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "NEW", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        showNewNotification();

    }

    private void showNewNotification(){

    }

    private void spinnerMode() {
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();

                if (selectedLang.equals("English")) {
                    setLocale("en");
                } else if (selectedLang.equals("Español")) {
                    setLocale("es");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void darkMode() {

        Button button = findViewById(R.id.btnDarkMode);

        if (AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_NO){
            isNightModeOn = false;
            button.setText("ON");
        }else{
            isNightModeOn = true;
            button.setText("OF");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNightModeOn){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    button.setText("On");
                    isNightModeOn = false;
                }
                else if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES ){
                    isNightModeOn = true;
                    button.setText("Of");
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

            }
        });



    }

    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
