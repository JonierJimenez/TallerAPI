package com.example.volleyjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Opcion1Activity extends AppCompatActivity {

    String url1 = "https://pokeapi.co/api/v2/pokemon";
    String urlImage="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png";
    private RecyclerView recyclerView;


    ArrayList<Pokemon> listaPokemon;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion1);

        listaPokemon = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recyclerViewBoton1); // recyclerView = findViewById(R.id.recyclerView);
        requestDatos();
        //datos1 = findViewById(R.id.Datos1);

        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaPokemonAdapter = new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        //dato = findViewById(R.id.Datos);
        listaPokemonAdapter.adicionarListaPokemon(listaPokemon);*/

    }

    public void requestDatos(){
        RequestQueue cola = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parserJson(response);
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error en la conexion", Toast.LENGTH_LONG).show();
                }
        }){
           /* @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                // headers.put("Content-Type", "application/json");
                headers.put("X-Auth-Token", "df875ad8e5ac477cb91ca3687c170e6c");
                return headers;
            }*/
        };
        cola.add(jsonObjectRequest);
    }//fin requestDatos

    public void parserJson(JSONObject response){
        try {

            JSONArray Pokemons = response.getJSONArray("results");

            for (int i = 0 ; i<Pokemons.length(); i++) {
                JSONObject com = Pokemons.getJSONObject(i);

                String name = com.getString("name");
                String url = com.getString("url");

                Pokemon po = new Pokemon(name,url);
                listaPokemon.add(po);
            }


        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        PonerDatosEnElRecyclerView(listaPokemon);
    }//fin parseoJson

    public void PonerDatosEnElRecyclerView (List<Pokemon> listaDePokemons){
        Adaptador adaptador = new Adaptador(this, listaDePokemons);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(adaptador);

    }

}