package com.example.volleyjson;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button conectar, listar, Opcion1, Opcion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         Opcion1 = findViewById(R.id.btnOpcion1);
         Opcion2 = findViewById(R.id.btnOpcion2);

         Opcion1.setOnClickListener(this);
         Opcion2.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.btnOpcion1: i = new Intent(getApplicationContext(),Opcion1Activity.class); startActivity(i); break;
            case R.id.btnOpcion2: i = new Intent(getApplicationContext(),Opcion2Activity.class); startActivity(i); break;
        }
    }


}
