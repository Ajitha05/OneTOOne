package com.example.onetoone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.OrderView> {

    ArrayList<Order> ordersList = new ArrayList<>();

    public DetailsAdapter(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    @NonNull
    @Override
    public OrderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent,false);
        return new OrderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderView holder, int position) {

        Order order = ordersList.get(position);
        holder.orderid.setText(String.valueOf((Math.toIntExact(order.getId()))));
        holder.orderdetails.setText(order.getDetails());



    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    public  class  OrderView extends  RecyclerView.ViewHolder {
        TextView orderid, orderdetails;
         public OrderView(@NonNull View itemView) {
             super(itemView);

             orderid = (TextView)itemView.findViewById(R.id.order_id);
             orderdetails = (TextView)itemView.findViewById(R.id.details);
         }
     }
}
