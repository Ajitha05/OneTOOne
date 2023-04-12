package com.example.onetoone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddingDetails extends AppCompatActivity {

    EditText name,cusid,orderid,details;
    Button savebtn;
    DaoSession daoSession;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_details);

        daoSession= ((MyApplication) getApplication()).getDaoSession();

        name = findViewById(R.id.editTextTextPersonName2);
        cusid = findViewById(R.id.editTextTextPersonName);
        orderid=findViewById(R.id.editTextTextPersonName3);
        details = findViewById(R.id.editTextTextPersonName4);
        savebtn=findViewById(R.id.button);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerIdString = cusid.getText().toString();
                long customerIdLong = Long.parseLong(customerIdString);
                Customer customer = daoSession.getCustomerDao().load(customerIdLong);

                String orderIdString = orderid.getText().toString();
                long orderIdLong = Long.parseLong(orderIdString);
                String detailString =details.getText().toString();
                Order order = new Order(  detailString);

                List<Order> orders = customer.getOrders();
                orders.add(order);
                daoSession.getOrderDao().insert(order);



                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);









            }
    });
}
    }
