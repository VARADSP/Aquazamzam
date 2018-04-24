package com.example.dell_lapy.aquazamzam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class product extends AppCompatActivity {
    Button cmw;
    Button mw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        cmw = (Button) findViewById(R.id.cmw);
        cmw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(product.this, coldmineralwater.class);
                startActivity(intent);
            }


        });


        mw = (Button) findViewById(R.id.mw);
        mw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(product.this, mineralwater.class);
                startActivity(intent);


            }
        });
    }
}