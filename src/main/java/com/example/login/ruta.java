package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class ruta extends AppCompatActivity {

    Button breruta;
    EditText t1,t2,t3;
    private AsyncHttpClient webruta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);

        t1 = (EditText) findViewById(R.id.ruta1);
        t2 = (EditText) findViewById(R.id.ruta2);
        t3 = (EditText) findViewById(R.id.ruta3);

        breruta = (Button) findViewById(R.id.botonruta);
        webruta = new  AsyncHttpClient();

    }

    public void ingresaruta(View view) {

        try {

            objectoruta ru = new objectoruta ();
            ru.setOrigen(t1.getText().toString().replaceAll(" ","%20"));
            ru.setDestino(t2.getText().toString().replaceAll(" ","%20"));
            ru.setCosto(t3.getText().toString().replaceAll(" ","%20"));

            agregarruta(ru);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }


    }




    public void agregarruta (objectoruta ru){

        String url ="https://jamphiercarriel.000webhostapp.com/registrarruta.php?";
        String parametros ="desde="+ru.getOrigen()+"&hasta="+ru.getDestino()+"&precio="+ru.getCosto();
        webruta.post(url+parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (statusCode==200){

                    Toast.makeText(getApplicationContext(), "REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");


                }

            }





            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }








}
