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

public class viajar extends AppCompatActivity {

    TextView idusuario,tidchofer;
    private AsyncHttpClient webchoferes;
    private ListView lvdatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajar);
        idusuario = (TextView) findViewById(R.id.tviajaridusuario);
        tidchofer = (TextView) findViewById(R.id.tviajaridchofer);


        webchoferes = new  AsyncHttpClient();

        String idusario = getIntent().getStringExtra("globalidbuscarviaje");
        idusuario.setText(idusario);
        lvdatos = (ListView) findViewById(R.id.listachoferes);

        try {

            obtenerusuarios();
        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+e, Toast.LENGTH_SHORT).show();
        }



    }




    public void obtenerusuarios(){

        String url ="https://jamphiercarriel.000webhostapp.com/listachofer.php";

        webchoferes.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                String str = new String(responseBody);

                listarusuarios(str);


            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void listarusuarios(String respuesta) {
        final ArrayList<usuario> lista = new ArrayList<usuario>();
        try {
            JSONArray json = new JSONArray(respuesta);
            for (int i= 0;i<json.length();i++){
                usuario obj  = new usuario();
                obj.setId(json.getJSONObject(i).getInt("id_usuario"));
                obj.setCedula(json.getJSONObject(i).getString("cedula"));
                obj.setNombres(json.getJSONObject(i).getString("nombres"));
                obj.setApellidos(json.getJSONObject(i).getString("apellidos"));
                obj.setCorreo(json.getJSONObject(i).getString("correo"));
                obj.setCelular(json.getJSONObject(i).getString("celular"));
                obj.setUser(json.getJSONObject(i).getString("user"));
                obj.setClave(json.getJSONObject(i).getString("clave"));
                lista.add(obj);
            }

            ArrayAdapter<usuario> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lvdatos.setAdapter(a);

            lvdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    usuario p = lista.get(i);
                    String idchofer =  String.valueOf(p.getId());


                    siguienteventana(idchofer);



                }
            });




        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }




    }


    //enviaremos por aqui el objecto xd
    public void  siguienteventana(String idchofer){

        tidchofer.setText(idchofer);
        Intent menu = new Intent(getApplicationContext(), finalizarviaje.class);

        menu.putExtra("globalviajeidchofer", idchofer);
        menu.putExtra("globalviajeidusuario", idusuario.getText().toString());

        startActivity(menu);







    }





}
