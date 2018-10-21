package com.example.android.myfirebasetask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCountries {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://restcountries.eu/";

    public static Retrofit getApiCountries() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}