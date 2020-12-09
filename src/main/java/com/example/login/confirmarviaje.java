package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class confirmarviaje extends AppCompatActivity {

    TextView vidchofer, vpasajero,vidruta;
    Button botonaceptar,botoncancelar;
    private AsyncHttpClient webcoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmarviaje);
        vidchofer = (TextView) findViewById(R.id.textView24idchoferr);
        vpasajero = (TextView) findViewById(R.id.textViewconfirmasusuario);
        vidruta = (TextView) findViewById(R.id.textView26idruta);
        botonaceptar = (Button) findViewById(R.id.viajebotonok);
        botoncancelar = (Button) findViewById(R.id.viajebotoncancel);


        String registraridchofer = getIntent().getStringExtra("finalizarglobalidchofer");
        String registraridusuario = getIntent().getStringExtra("finalizarglobalidusuario");
        String registraridrutas = getIntent().getStringExtra("finalizarglobalidrutas");

        vidchofer.setText(registraridchofer);
        vpasajero.setText(registraridusuario);
        vidruta.setText(registraridrutas);

        webcoche = new  AsyncHttpClient();

    }


    public void ingresarviaje(View view) {

        try {

            objectosdelviaje viajeobj = new objectosdelviaje ();

            viajeobj.setIdchofer(Integer.parseInt(vidchofer.getText().toString()));
            viajeobj.setIdpasajero(Integer.parseInt(vpasajero.getText().toString()));
            viajeobj.setIdruta(Integer.parseInt(vidruta.getText().toString()));
            agregarviaje(viajeobj);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }


    }

    public void regresaralmenuprincipal(View view) {

        Intent menu = new Intent(getApplicationContext(), menucliente.class);
        menu.putExtra("idmenusuarioparacliente", vpasajero.getText().toString());
        startActivity(menu);


    }




    public void agregarviaje(objectosdelviaje viaj){

        String url ="https://jamphiercarriel.000webhostapp.com/registrarviaje.php?";
        String parametros ="id_chofer="+viaj.getIdchofer()+"&id_pasajero="+viaj.getIdpasajero()+"&id_ruta="+viaj.getIdruta();
        webcoche.post(url+parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (statusCode==200){

                    Toast.makeText(getApplicationContext(), "REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();


                }

            }





            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }





}
