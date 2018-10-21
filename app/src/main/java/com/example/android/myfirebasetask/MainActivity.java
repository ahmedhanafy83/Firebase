package com.example.android.myfirebasetask;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Countries>{

    private static final String TAG = "";
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    private RecyclerView mRecyclerView;
    private CountriesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Countries> countries;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        countries = new ArrayList<>();
        mAdapter = new CountriesAdapter(this,countries);
        mRecyclerView.setAdapter(mAdapter);


        Button button = (Button) findViewById(R.id.buttonLogout);
        mAuth = FirebaseAuth.getInstance();

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();


            }
        });
getCountries();

    }

    private void getCountries() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
    }

    @Override
    public void onResponse(Call<Countries> call, Response<Countries> response) {
        List<Countries> features = response.body().getCountries();
        Log.d(TAG, "Data successfully downloaded");

        // Data is returned here
        for (Countries f: countries) {
            Log.d("feature", String.valueOf(f)); // for example
        }
    }

    @Override
    public void onFailure(Call<Countries> call, Throwable t) {

    }
}


