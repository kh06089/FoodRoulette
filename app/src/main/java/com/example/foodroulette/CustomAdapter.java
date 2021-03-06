package com.example.foodroulette;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.recyclerview.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    // declaring some fields.
    private ArrayList<Restaurant> arrayList = new ArrayList<>();
    public ArrayList<String> selected =  new ArrayList<>();

    public CustomAdapter(ArrayList<Restaurant> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Log.v("CreateViewHolder", "in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_layout,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.v("BindViewHolder", "in onBindViewHolder");
        Restaurant contact = arrayList.get(position);
        holder.name.setText(contact.getmName());
        holder.description.setText(contact.getmDescription());

        if(holder.checkBox.isChecked()){
            selected.add(holder.name.getText().toString());
        }
        else if(holder.checkBox.isChecked()){
            selected.add(holder.name.getText().toString());
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        CheckBox checkBox;
        public MyViewHolder(View itemView) {
            super(itemView);
            Log.v("ViewHolder","in View Holder");
            name = itemView.findViewById(R.id.textView);
            description = itemView.findViewById(R.id.textView2);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}