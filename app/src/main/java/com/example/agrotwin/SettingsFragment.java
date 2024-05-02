package com.example.agrotwin;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

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

import org.w3c.dom.Text;

import java.util.Locale;

public class SettingsFragment extends Fragment {

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

        return view;
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

        switchDarkMode.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES);

        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
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