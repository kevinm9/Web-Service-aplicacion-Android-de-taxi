package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class menu extends Activity {

    Button bingresar,bregistrarventana;
    EditText tusuario,tclave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bregistrarventana = (Button) findViewById(R.id.bregistro);
        bingresar = (Button) findViewById(R.id.bingresar);
        tusuario = (EditText) findViewById(R.id.txtusuario);
        tclave = (EditText) findViewById(R.id.txtclave);

    }

    public void ingresaraccion(View view) {


        try {
            String username = tusuario.getText().toString();
            String password = tclave.getText().toString();
            new PostAsync().execute(username, password);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }


    public void abrirventanaderegistro(View view) {


        try {
            Intent menu = new Intent(getApplicationContext(), registrarse.class);
            startActivity(menu);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }


    //enviaremos por aqui el objecto xd
public void  ventanamenu(int id){

    String idusuario =  String.valueOf(id);
    Intent menu = new Intent(getApplicationContext(), menusuario.class);



    menu.putExtra("gloablidusuario", idusuario);





    startActivity(menu);


}






    class PostAsync extends AsyncTask<String, String, JSONObject> {
        JSONParser jsonParser = new JSONParser();

        private static final String LOGIN_URL = "https://jamphiercarriel.000webhostapp.com/ingreso.php";

        //variables que devolvera el json xd
        private static final String TAG_SUCCESS = "success";
        private static final String TAG_MESSAGE = "message";
        private static final String TAG_ID = "id";



        @Override
        protected void onPreExecute() {

            Toast.makeText(getApplicationContext(), "Cargando ..", Toast.LENGTH_SHORT).show();
        }


        //metodo post del json al servidor ctm xd
        @Override
        protected JSONObject doInBackground(String... args) {

            try {

                HashMap<String, String> params = new HashMap<>();
                params.put("name", args[0]);
                params.put("password", args[1]);

                Log.d("request", "starting");

                JSONObject json = jsonParser.makeHttpRequest(
                        LOGIN_URL, "POST", params);

                if (json != null) {
                    Log.d("JSON result", json.toString());



                    return json;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }


        //se extraen datos de los objectos json  xd
        protected void onPostExecute(JSONObject json) {

            int success = 0;
            String message = "";
            int idusuario = 0;

            if (json != null) {
                //muestra  toda la cadena del json xd
                //Toast.makeText(menu.this, json.toString(),
                //        Toast.LENGTH_SHORT).show();

                try {

                    //variables que devuelve el json estableciasdas al comienzo de la clase ctm xd
                    success = json.getInt(TAG_SUCCESS);
                    message = json.getString(TAG_MESSAGE);
                    idusuario = json.getInt(TAG_ID);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            if (success == 1) {
                Log.d("Success!", message);
                ventanamenu(idusuario);



            }else{
                Toast.makeText(menu.this, "No es posible ingresar al sistema",
                        Toast.LENGTH_SHORT).show();

                Log.d("Failure", message);
            }
        }



    }



}
