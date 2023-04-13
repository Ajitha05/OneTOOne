package com.example.onetoone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddingDetails extends AppCompatActivity {

    EditText name,cusid;
    Button savebtn;
    DaoSession daoSession;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_listadd);

        daoSession= ((MyApplication) getApplication()).getDaoSession();

        name = findViewById(R.id.editTextTextPersonName2);
        cusid = findViewById(R.id.editTextTextPersonName);

        savebtn=findViewById(R.id.button);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String customerIdString = cusid.getText().toString();
                long customerIdLong = Long.parseLong(customerIdString);
                String namestring = name.getText().toString();
                Customer customer = new Customer(customerIdLong, namestring);

                daoSession.getCustomerDao().insert(customer);



                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);









            }
    });
}
    }
