package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class buscarviaje extends AppCompatActivity {


    private AsyncHttpClient webviajes;
    private ListView lvdatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarviaje);


        webviajes = new  AsyncHttpClient();
        lvdatos = (ListView) findViewById(R.id.listaviewviejaes);

        obtenerviajes();

    }







    public void obtenerviajes(){

        String url ="https://jamphiercarriel.000webhostapp.com/listarviaje.php";

        webviajes.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                    String str = new String(responseBody);

                    listarviajes(str);


            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void listarviajes(String respuesta) {
        final ArrayList <objectosdelviaje> lista = new ArrayList<objectosdelviaje>();
        try {
            JSONArray json = new JSONArray(respuesta);
            for (int i= 0;i<json.length();i++){
                objectosdelviaje obj  = new objectosdelviaje();
                obj.setChofer(json.getJSONObject(i).getString("Chofer"));
                obj.setPasajero(json.getJSONObject(i).getString("Pasajero"));
                obj.setOrigen(json.getJSONObject(i).getString("Origen"));
                obj.setDestino(json.getJSONObject(i).getString("Destino"));
                obj.setFecha(json.getJSONObject(i).getString("fecha"));
                lista.add(obj);
             }

            ArrayAdapter<objectosdelviaje> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lvdatos.setAdapter(a);

            lvdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    objectosdelviaje p = lista.get(i);
                    String dato = "Viaje en transcurso de: " +  p.getPasajero();
                    Toast.makeText(getApplicationContext(), dato, Toast.LENGTH_SHORT).show();






                }
            });




        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }




    }



}
