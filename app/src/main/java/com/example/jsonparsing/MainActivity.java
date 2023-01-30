package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static TextView textview;
    Button btn;


    TextView tv_name, tv_salary, tv_posiiton;
    String name, salary, position;
    String json_string = "{\"employee\":{\"name\":\"Husnain \",\"salary\":65000,\"position\":\"Inspector\"}}";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_name = findViewById(R.id.name);
        tv_salary = findViewById(R.id.salary);
        tv_posiiton = findViewById(R.id.positionn);

        try {
            JSONObject jsonObject = new JSONObject(json_string);
            JSONObject objEmp = jsonObject.getJSONObject("employee");
            name = objEmp.getString("name");
            salary = objEmp.getString("salary");
            position = objEmp.getString("position");
            tv_name.setText("Name : " + name);
            tv_salary.setText("Salary : " + salary);
            tv_posiiton.setText("Position : " + position);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}