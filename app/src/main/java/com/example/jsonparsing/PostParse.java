package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostParse extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelClass> list;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_parse);
        recyclerView = findViewById(R.id.recyclerVieww);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait Getting Response...");
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        list = new ArrayList<>();
        JsonParsing jsonParsing = new JsonParsing();
        jsonParsing.execute();

    }

    public class JsonParsing extends AsyncTask<String, String, String> {

        private String current = "";

        @Override
        protected String doInBackground(String... strings) {

            String strUrl = "https://dummyjson.com/users";
            HttpURLConnection con = null;
            try {
                URL url = new URL(strUrl);
                con = (HttpURLConnection) url.openConnection();

                InputStream inputStream = con.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                while (data != -1) {
                    current += (char) data;
                    data = inputStreamReader.read();
                }
//                System.out.println("Response is " + current);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {


            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("users");
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    JSONObject hair = jsonObject1.getJSONObject("hair");

                    ModelClass modelClass = new ModelClass(" ", " ", " ",
                            " ", " ", " ", " ");

                    modelClass.setFirstName("Id:" + jsonObject1.get("id") +
                            "\n" + "Firstname:" + jsonObject1.get("firstName") +
                            "\n" + "Lastname:" + jsonObject1.get("lastName") +
                            "\n" + "Eyecolor: " + jsonObject1.get("eyeColor") +
                            "\n" + "Gender: " + jsonObject1.get("gender") +
                            "\n" + "Haircolor: " + hair.get("color") +
                            "\n" + "Type: " + hair.get("type"));


                    list.add(modelClass);
                    progressDialog.dismiss();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            initRecyclerView(list);
        }
    }

    private void initRecyclerView(List<ModelClass> list) {
        CustomAdapter adapter = new CustomAdapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}


//                    String color = hairs.getString("color");


