package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class menucliente extends AppCompatActivity {


    Button menuviaje,menubuscar;
    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menucliente);

        id = (TextView) findViewById(R.id.idmenuclienteid);
        menuviaje = (Button) findViewById(R.id.menuclientebviajar);
        menubuscar = (Button) findViewById(R.id.menuclientebbuscar);

        String idusario = getIntent().getStringExtra("idmenusuarioparacliente");
        id.setText(idusario);


    }


    public void menuviajeee(View view) {


        try {
            Intent menu = new Intent(getApplicationContext(), viajar.class);
            menu.putExtra("globalidbuscarviaje", id.getText().toString());
            startActivity(menu);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    public void menuuubuscarr(View view) {


        try {
            Intent menu = new Intent(getApplicationContext(), buscarviaje.class);

            startActivity(menu);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

}