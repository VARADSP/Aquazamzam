package com.example.dell_lapy.aquazamzam;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.Calendar;

public class book extends AppCompatActivity {
    database myDb;//create an instance
    EditText Name,Address,Mobile,Date,Product;
    Button booking ;
    Button viewData;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Spinner myspinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(book.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myDb = new database(this);//create a new instance
        Name = (EditText) findViewById(R.id.n1);
        Mobile = (EditText) findViewById(R.id.m1);
        Address = (EditText) findViewById(R.id.a1);
        Date = (EditText) findViewById(R.id.d1);
        booking = (Button) findViewById(R.id.b3);
        viewData= (Button)findViewById(R.id.viewData);
        AddData();
        viewAll();

    }


    public void AddData(){

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertdata(Name.getText().toString(),
                        Mobile.getText().toString(),
                        Address.getText().toString(),
                        Date.getText().toString());
                if(isInserted = true)
                    Toast.makeText(book.this,"data inserted",Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(book.this,"data not inserted",Toast.LENGTH_LONG).show();


            }
        });}



    public void viewAll()
    {viewData.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor res=myDb.getAllData();
                    if(res.getCount()==0)
                    {
                        //message
                        showMessage("Error","No data to show");
                        return;
                    }
                    StringBuffer buffer=new StringBuffer();
                    while (res.moveToNext())
                    {
                        buffer.append("\n-----------------------------------------------------\n Full_Name:- "+res.getString(0)+"\n");
                        buffer.append("Mobile_No:- "+res.getString(1)+"\n");
                        buffer.append("Address:- "+res.getString(2)+"\n");
                        buffer.append("Date_Of_Order:- "+res.getString(3)+"\n");
                                        }
                    //show all data
                    showMessage("My Order",buffer.toString());
                }

            }
    );
    }

    //res have some property


    public void showMessage(String title, String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);//can cancel it after use
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

}



