package com.example.android.myfirebasetask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder>{

    private Context context ;
    private ArrayList<Countries> countries;

    public CountriesAdapter(Context context, ArrayList<Countries> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("test","In On Create View Holder");
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_country, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("test", "In On Bind");
        holder.countries = countries.get(position);
        holder.tvName.setText(countries.get(position).getName());
        holder.tvCapital.setText(countries.get(position).getCapital());

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCapital;
        public Countries countries;

        public ViewHolder(View View) {
            super(View);
            tvName =(TextView) View.findViewById(R.id.text_name);
            tvCapital =(TextView) View.findViewById(R.id.text_capital);
        }
    }
}

