package com.example.agrotwin;

public class DataClass {

    private String dataTitle;
    private int dataDesc;
    private String dataLang;

    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public String getDataLang() {
        return dataLang;
    }

    public DataClass(String dataTitle, int dataDesc, String dataLang) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
    }
}