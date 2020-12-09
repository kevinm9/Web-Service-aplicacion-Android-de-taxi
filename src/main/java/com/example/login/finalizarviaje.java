package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class finalizarviaje extends AppCompatActivity {

    TextView tidusuario,tidchofer,tiidrutas;
    private AsyncHttpClient webchoferes;
    private ListView lvdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizarviaje);

        tidusuario = (TextView) findViewById(R.id.finalizarviajeidusuario);
        tidchofer = (TextView) findViewById(R.id.finalizarviajeidchofer);
        tiidrutas = (TextView) findViewById(R.id.finalizarviajeidrutas);

        webchoferes = new  AsyncHttpClient();
        String vvidusario = getIntent().getStringExtra("globalviajeidusuario");
        String vvidchofer = getIntent().getStringExtra("globalviajeidchofer");

        tidusuario.setText(vvidusario);
        tidchofer.setText(vvidchofer);

        lvdatos = (ListView) findViewById(R.id.listaidrutasrutas);

        obtenerrutas();


    }


    public void obtenerrutas(){

        String url ="https://jamphiercarriel.000webhostapp.com/listarruta.php";

        webchoferes.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                String str = new String(responseBody);

                listarutas(str);


            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void listarutas(String respuesta) {
        final ArrayList<objectoruta> lista = new ArrayList<objectoruta>();
        try {
            JSONArray json = new JSONArray(respuesta);
            for (int i= 0;i<json.length();i++){
                objectoruta obj  = new objectoruta();
                obj.setId(json.getJSONObject(i).getInt("id_ruta"));
                obj.setOrigen(json.getJSONObject(i).getString("lugar_desde"));
                obj.setDestino(json.getJSONObject(i).getString("lugar_hasta"));
                obj.setCosto(json.getJSONObject(i).getString("precio"));

                lista.add(obj);
            }

            ArrayAdapter<objectoruta> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lvdatos.setAdapter(a);

            lvdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    objectoruta p = lista.get(i);
                    String idrutasss =  String.valueOf(p.getId());

                    siguienteventana(idrutasss);



                }
            });




        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }




    }


    //enviaremos por aqui el objecto xd
    public void  siguienteventana(String idrutash){

        tiidrutas.setText(idrutash);


        Intent menu = new Intent(getApplicationContext(), confirmarviaje.class);

        menu.putExtra("finalizarglobalidrutas", idrutash);
        menu.putExtra("finalizarglobalidchofer", tidchofer.getText().toString());
        menu.putExtra("finalizarglobalidusuario", tidusuario.getText().toString());

        startActivity(menu);







    }









}
