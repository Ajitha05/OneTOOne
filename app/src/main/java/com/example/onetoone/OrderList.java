package com.example.onetoone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {
    ListView lst;
    TextView detail;
    private ArrayAdapter<String> adapter;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        lst = findViewById(R.id.list1);
        detail = findViewById(R.id.textView);


        OrderDao orderDao = ((MyApplication) getApplication()).getDaoSession().getOrderDao();

    }
}