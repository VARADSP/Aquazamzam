package com.example.dell_lapy.aquazamzam;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myorder extends AppCompatActivity {
    database myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        myDb = new database(this);
        myDb=new database(this);
        Button b1;
        b1 = (Button) findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent g = new Intent(myorder.this, book.class);
                startActivity(g);

            }
        });



    }
    public void viewData(View view)
    {
        Cursor res=myDb.getAllData();//res have some property
        if(res.getCount()==0)
        {
            //message
            showMessage("Error","No data to show");
            return;
        }
        else
        {
            //create some string buffer
            StringBuffer buffer=new StringBuffer();
            while (res.moveToNext())
            {
                buffer.append("\n-----------------------------------------------------\nFull_Name:- "+res.getString(0)+"\n");
                buffer.append("Mobile_N0:- "+res.getString(1)+"\n");
                buffer.append("Address:- "+res.getString(2)+"\n");
                buffer.append("Date_Of_Order:- "+res.getString(3)+"\n");

            }
            //show all data
            showMessage("My Order",buffer.toString());
        }

    }
    public void showMessage(String title, String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);//can cancel it after use
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }




}






