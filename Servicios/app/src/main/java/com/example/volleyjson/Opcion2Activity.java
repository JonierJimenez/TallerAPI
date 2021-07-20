package com.example.volleyjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.List;

public class Opcion2Activity extends AppCompatActivity {

    String url2 = "https://pokeapi.co/api/v2/evolution-trigger/1";
    private RecyclerView recyclerView;


    ArrayList<Pokemon> listaPokemon2;
    RecyclerView mRecyclerView2;
    //TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion2);
        //datos = findViewById(R.id.textView);
        listaPokemon2 = new ArrayList<>();
        mRecyclerView2 = findViewById(R.id.recyclerViewBoton2);
        requestDatos();
    }

    public void requestDatos(){
        RequestQueue cola = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url2, null,
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
            String cadena="";

            JSONArray PokemonsEvolucion = response.getJSONArray("pokemon_species");

            for (int i = 0 ; i<PokemonsEvolucion.length(); i++) {
                JSONObject com = PokemonsEvolucion.getJSONObject(i);

                String name = com.getString("name");
                String url = com.getString("url");

                //cadena = cadena + name +","+url+"\n";
                Pokemon po = new Pokemon(name,url);
                listaPokemon2.add(po);
            }
            //datos.setText(cadena);

        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        PonerDatosEnElRecyclerView(listaPokemon2);
    }//fin parse Json


    public void PonerDatosEnElRecyclerView(List<Pokemon> listaevolucion){

        Adaptador2 adaptador2 = new Adaptador2(this, listaevolucion);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView2.setAdapter(adaptador2);

    }

}