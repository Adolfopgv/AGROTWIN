package com.example.agrotwin.usecases.home.pages.homecardadapter;

import android.widget.Button;

public class DataClass {

    // Clase para los datos de las tarjetas
    private String dataTitle;

    public DataClass(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public String getDataTitle() {
        return dataTitle;
    }

}