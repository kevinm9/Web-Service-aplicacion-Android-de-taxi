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

public class carro extends AppCompatActivity {

    Button botoncarrito;
    EditText t1,t2,t3,t4;
    private AsyncHttpClient webcoche;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro);


        t1 = (EditText) findViewById(R.id.tcarro1);
        t2 = (EditText) findViewById(R.id.tcarro2);
        t3 = (EditText) findViewById(R.id.tcarro3);
        t4 = (EditText) findViewById(R.id.tcarro4);

        botoncarrito = (Button) findViewById(R.id.botonruta);
        webcoche = new  AsyncHttpClient();

        String idusario = getIntent().getStringExtra("idchoferparaaudto");
        t1.setText(idusario);

    }



    public void ingresacarrito(View view) {

        try {

            objectocarro carro = new objectocarro ();

            carro.setIdchofer(Integer.parseInt(t1.getText().toString()));
            carro.setMatricula(t2.getText().toString().replaceAll(" ","%20"));
            carro.setModelo(t3.getText().toString().replaceAll(" ","%20"));
            carro.setAnio(t4.getText().toString().replaceAll(" ","%20"));
            agregarcarro(carro);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }


    }



    public void agregarcarro (objectocarro car){

        String url ="https://jamphiercarriel.000webhostapp.com/registrarvehiculo.php?";
        String parametros ="usuario="+t1.getText().toString()+"&matricula="+car.getMatricula()+"&modelo="+car.getModelo()+"&anio="+car.getAnio();
        webcoche.post(url+parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (statusCode==200){

                    Toast.makeText(getApplicationContext(), "REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();

                    t2.setText("");
                    t3.setText("");
                    t4.setText("");


                }

            }





            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }





}