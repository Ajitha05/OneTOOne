package com.example.onetoone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


import android.content.Intent;

import android.os.Bundle;
import java.util.List;

import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    CustomerDao customerDao;
    List<Customer> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession= ((MyApplication) getApplication()).getDaoSession();
        CustomerDao customerDao= daoSession.getCustomerDao();


        final RecyclerView rvItems= findViewById(R.id.recyclerView);

        customerList = customerDao.queryBuilder().list();
        Toast.makeText(this,"Length = "+customerList.size(),Toast.LENGTH_LONG).show();

        Adapterview todoItemAdapter=new Adapterview(customerList);
        rvItems.setAdapter(todoItemAdapter);

        rvItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        btn = findViewById(R.id.addbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AddingDetails.class));

            }
        });
    }
    }
