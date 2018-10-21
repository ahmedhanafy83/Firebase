package com.example.android.myfirebasetask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Countries {


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("capital")
    @Expose
    private String capital;

    public Countries(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }


    public List<Countries> getCountries() {
        return getCountries();
    }
}





