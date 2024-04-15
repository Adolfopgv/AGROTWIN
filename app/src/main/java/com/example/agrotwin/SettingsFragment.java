package com.example.agrotwin;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import java.util.Locale;

public class SettingsFragment extends Fragment {

    Spinner spinner;
    public static final String[] languages = {"Select language", "English", "Español"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        spinner = view.findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();

                if (selectedLang.equals("English")) {
                    setLocal("en");

                } else if (selectedLang.equals("Español")) {
                    setLocal("es");
                    //requireActivity().recreate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public void setLocal(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}


//        switchMode = view.findViewById(R.id.switchMode);
//
//        sharedPreferences = requireActivity().getSharedPreferences("MODE", Context.MODE_PRIVATE);
//        nightMode = sharedPreferences.getBoolean("nightMode", false);
//
//        switchMode.setChecked(nightMode);

//        switchMode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (switchMode.isChecked()) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    editor = sharedPreferences.edit();
//                    editor.putBoolean("nightMode", true);
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    editor = sharedPreferences.edit();
//                    editor.putBoolean("nightMode", false);
//                }
//                nightMode = switchMode.isChecked(); // Update nightMode variable
//                editor.apply();
//            }
//        });
