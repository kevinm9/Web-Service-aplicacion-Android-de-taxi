package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class registrarse extends AppCompatActivity {


    Button bregistarr,bcancelarl;
    EditText t1,t2,t3,t4,t5,t6,t7,t8;
    private AsyncHttpClient inusuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        t1 = (EditText) findViewById(R.id.editText);
        t2 = (EditText) findViewById(R.id.editText2);
        t3 = (EditText) findViewById(R.id.editText3);
        t4 = (EditText) findViewById(R.id.editText4);
        t5 = (EditText) findViewById(R.id.editText5);
        t6 = (EditText) findViewById(R.id.editText6);
        t7 = (EditText) findViewById(R.id.editText7);
        t8 = (EditText) findViewById(R.id.editText8);

        bregistarr = (Button) findViewById(R.id.bregistrar);
        bcancelarl = (Button) findViewById(R.id.bcancelar);

        inusuario = new  AsyncHttpClient();
    }



    public void ingresaraccion(View view) {

        try {

            usuario u = new usuario ();
            u.setCedula(t2.getText().toString());
            u.setNombres(t3.getText().toString().replaceAll(" ","%20"));
            u.setApellidos(t4.getText().toString().replaceAll(" ","%20"));
            u.setCorreo(t5.getText().toString());
            u.setCelular(t6.getText().toString());
            u.setUser(t7.getText().toString());
            u.setClave(t8.getText().toString());
            agregarusuario(u);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }


    }


    public void abrirventanlogin(View view) {

        Intent menu = new Intent(getApplicationContext(), menu.class);
        startActivity(menu);


    }





    public void agregarusuario (usuario u){

        String url ="https://jamphiercarriel.000webhostapp.com/resgistrarusuario.php?";
        String parametros ="cedula="+u.getCedula()+"&nombres="+u.getNombres()+"&apellidos="+u.getApellidos()+"&correo="+u.getCorreo()+"&celular="+u.getCelular()+"&user="+u.getUser()+"&clave="+u.getClave();
        inusuario.post(url+parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (statusCode==200){

                    Toast.makeText(getApplicationContext(), "REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");

                }

            }





            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), " FRACASO", Toast.LENGTH_SHORT).show();
            }
        });



    }





}
