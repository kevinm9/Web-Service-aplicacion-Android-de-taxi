package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class menusuario extends AppCompatActivity {

    Button menusuariocliente,menusuarioclientechofer;
    TextView id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menusuario);

        menusuariocliente = (Button) findViewById(R.id.buttoncliente);
        menusuarioclientechofer = (Button) findViewById(R.id.buttonchofer);
        id = (TextView) findViewById(R.id.menuidusuario);

        String idusario = getIntent().getStringExtra("gloablidusuario");
        id.setText(idusario);
    }

    public void abrirchofer(View view) {


        try {
            Intent menuchofer = new Intent(getApplicationContext(), menuchofer.class);

            menuchofer.putExtra("idmenuusarioachofer", id.getText().toString());

            startActivity(menuchofer);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    public void abrircliente(View view) {


        try {
            Intent menucleinte = new Intent(getApplicationContext(), menucliente.class);
            menucleinte.putExtra("idmenusuarioparacliente", id.getText().toString());
            startActivity(menucleinte);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }



}
