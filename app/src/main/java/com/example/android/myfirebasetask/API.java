package com.example.android.myfirebasetask;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("rest/v2/all?fbclid=IwAR3i0uAWmWC3FiAMSGtZt9Y1J-bhBykbzy4BtOGX3s4to9I08Wg4Tbzyark")
    Call<ArrayList<Countries>> getCountries();
}
