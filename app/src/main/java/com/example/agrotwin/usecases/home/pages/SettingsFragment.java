package com.example.agrotwin.usecases.home.pages;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.agrotwin.model.domain.FontSizeManager;
import com.example.agrotwin.R;

import java.util.Locale;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private Spinner spinner;
    private static final String[] LANGUAGE = {"Select language", "English", "Español"};

    public SettingsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        FontSizeManager fontSizeManager = FontSizeManager.getInstance();

        final TextView[] texts = TextSizes(view, fontSizeManager);

        SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        int progress = preferences.getInt("textSizeProgress", 18);

        darkMode(view);
        spinnerMode(view);
        SeekBarTexts(view, progress, fontSizeManager, texts);
        aboutUs(view);

        return view;
    }

    private void aboutUs(View view) {
        Button aboutUs = view.findViewById(R.id.aboutUs);
        aboutUs.setOnClickListener(this);
    }

    @NonNull
    private static TextView[] TextSizes(View view, FontSizeManager fontSizeManager) {
        TextView[] texts = { view.findViewById(R.id.settingsTopText),
                view.findViewById(R.id.darkModeText),
                view.findViewById(R.id.notificationsText) };

        for (TextView text : texts) {
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeManager.getTextSize());
        }
        return texts;
    }

    private void SeekBarTexts(View view, int progress, FontSizeManager fontSizeManager, TextView[] texts) {
        SeekBar seekBar = view.findViewById(R.id.seekBar);
        seekBar.setProgress(progress);
        seekBar.setMin(18);
        seekBar.setMax(26);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (TextView text : texts) {
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeManager.getTextSize());
                }
                fontSizeManager.setTextSize(progress);
                SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("textSizeProgress", progress);
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                for (TextView text : texts) {
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeManager.getTextSize());
                }
            }
        });
    }

    private void spinnerMode(View view) {
        spinner = view.findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, LANGUAGE);
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

    private void darkMode(View view) {
        Switch switchDarkMode = view.findViewById(R.id.btnDarkMode);

        // Establecer el estado del Switch basado en el modo actual
        switchDarkMode.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES);

        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Cambiar el modo según el estado del switch
                if (isChecked) {
                    // Cambiar al modo noche
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    // Reiniciar la actividad para que los cambios se apliquen
//                    recreate();
                } else {
                    // Cambiar al modo día
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    // Reiniciar la actividad para que los cambios se apliquen
//                    recreate();
                }
            }
        });
    }

    // Método para reiniciar la actividad y aplicar los cambios de tema
//    private void recreate() {
//
//        Intent it = new Intent(getContext(), SettingsFragment.class);
//        startActivity(it);
//    }
//


    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.principalLinearLayoutSettings, new AboutFragment());
        ft.commit();

    }
}