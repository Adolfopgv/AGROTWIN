package com.example.agrotwin;

public class DataClass {

    private String dataTitle;

    private String dataLang;


    public String getDataTitle() {
        return dataTitle;
    }



    public String getDataLang() {
        return dataLang;
    }



    public DataClass(String dataTitle, String dataLang) {
        this.dataTitle = dataTitle;

        this.dataLang = dataLang;

    }
}