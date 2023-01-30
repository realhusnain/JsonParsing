package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DataDetails extends AppCompatActivity {
    TextView deatail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_details);
        deatail=findViewById(R.id.Getdata);
        Intent intent = getIntent();


//        int position=getIntent().getIntExtra("position",0);

        deatail.setText(intent.getStringExtra("firstName"));


    }
}