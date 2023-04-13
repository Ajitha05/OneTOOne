package com.example.onetoone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.List;

public class ListAdd extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    Button btnadd;
    Button submitbtn;
    EditText name,cusid;
    Button savebtn;
    DaoSession daoSession;

    List<String> list = new ArrayList<>();
    ArrayList<Order> customerlist = new ArrayList<Order>();


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.id_listadd);

        linearLayout = findViewById(R.id.layout_list);
        btnadd = findViewById(R.id.btn);
        submitbtn = findViewById(R.id.button);
        daoSession= ((MyApplication) getApplication()).getDaoSession();




        btnadd.setOnClickListener(this);
        submitbtn.setOnClickListener(this);

        list.add("order");
        list.add("laptop");
        list.add("tab");
        list.add("computer");
        list.add("phone");

    }


    @Override
    public void onClick(View v) {



        switch (v.getId()) {

            case R.id.btn:

                break;
            case  R.id.button:
                if(checkIfValidAndRead()){

                    Intent intent = new Intent(ListAdd.this,OrderList.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list",customerlist);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                break;
        }


        addView();

    }

    private boolean checkIfValidAndRead() {
        customerlist.clear();
                boolean result = true;

                for(int i =0; i<linearLayout.getChildCount();i++){

                    View orderview = linearLayout.getChildAt(i);

                    EditText editTextName = (EditText) orderview.findViewById(R.id.edit_name);
                    AppCompatSpinner spinerteam = (AppCompatSpinner) orderview.findViewById(R.id.detailsadd);

                    Order order = new Order();

                    if(editTextName.getText().toString().equals("")){
                        order.setId(Long.valueOf(editTextName.getText().toString()));

                    }else{
                        result = false;
                        break;
                    }
                    if(spinerteam.getSelectedItemPosition()!=0){
                        order.setDetails(list.get(spinerteam.getSelectedItemPosition()));
                    }else{
                        result = false;
                        break;
                    }
                    customerlist.add(order);




                }

                if(customerlist.size()==0){
                    result = false;
                    Toast.makeText(this, "Add ID", Toast.LENGTH_SHORT).show();
                }else if(!result)
                    Toast.makeText(this, "Enter all details correctly!", Toast.LENGTH_SHORT).show();

                return result;
    }

    private void addView(){
        final View orderview = getLayoutInflater().inflate(R.layout.row_add_edit,null,false);

        EditText editText = (EditText) orderview.findViewById(R.id.edit_name);
         AppCompatSpinner spinerteam = (AppCompatSpinner) orderview.findViewById(R.id.detailsadd);
        ImageView imageClose = (ImageView)orderview.findViewById(R.id.image_remove);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        spinerteam.setAdapter(arrayAdapter);

    }
}

