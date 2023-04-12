package com.example.onetoone;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapterview extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Customer> customerList;


    public Adapterview(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Customer user = customerList.get(position);













            }




    @Override
    public int getItemCount() {
        return customerList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public void setName(TextView name) {
            this.name = name;

        }
        public void setId(TextView id) {
            this.id = id;
        }


        public TextView getName() {
            return name;

        }
        public TextView getId() {
            return id;

        }

        private TextView name,id;
        public ConstraintLayout constraintLayout;

        public ViewHolder( View view) {
            super(view);
            this.name=(TextView) view.findViewById(R.id.labelItemName);
            this.id =(TextView) view.findViewById(R.id.useridtv);
            constraintLayout=(ConstraintLayout) view.findViewById(R.id.itemrow);

        }
    }

    }






