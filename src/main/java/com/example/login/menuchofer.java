package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class menuchofer extends AppCompatActivity {

    Button menuchoferauto,menuchoferrutas;
    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuchofer);

        menuchoferrutas = (Button) findViewById(R.id.menuchoferbruta);
        menuchoferauto = (Button) findViewById(R.id.menuchoferbauto);

        id = (TextView) findViewById(R.id.tmenuchoferid);

        String idusario = getIntent().getStringExtra("idmenuusarioachofer");
        id.setText(idusario);

    }



    public void ventanachoferrutas(View view) {


        try {
            Intent menu1 = new Intent(getApplicationContext(), ruta.class);
            startActivity(menu1);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    public void ventanachofeauto(View view) {


        try {
            Intent menu = new Intent(getApplicationContext(), carro.class);
            menu.putExtra("idchoferparaaudto", id.getText().toString());
            startActivity(menu);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }






}
