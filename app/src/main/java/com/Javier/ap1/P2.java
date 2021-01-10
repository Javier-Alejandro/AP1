package com.Javier.ap1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import  android.widget.Toast;

public class P2 extends  Activity{
    public Button bNext;
    public EditText tNombre;
    public EditText tPaterno;
    public EditText tMaterno;

    public String[] datos = {null,null,null};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_p2);
        bNext=(Button)findViewById(R.id.buttonNext);
        tNombre= (EditText)findViewById(R.id.editTextNombre);
        tPaterno=(EditText)findViewById(R.id.editTextPaterno);
        tMaterno=(EditText)findViewById(R.id.editTextMaterno);

        bNext.setOnClickListener( new View.OnClickListener() {


            @SuppressLint({"WrongConstant", "ShowToast"})
            @Override
            public void onClick(View v) {
                datos[0]= tNombre.getText().toString().toUpperCase();
                datos[1]= tPaterno.getText().toString().toUpperCase();
                datos[2]= tMaterno.getText().toString().toUpperCase();



                if((datos[0].equals("")) || (datos[1].equals("")) || (datos[2].equals(""))){
                    Toast.makeText(getApplicationContext(),"Faltaron campos por llenar", 0b1).show();
                }
                else {

                    //   makeText(getApplicationContext(), datos[0],10);
                    //  makeText(getApplicationContext(), datos[1],10);
                    // makeText(getApplicationContext(), datos[2],10);
                    Intent miIntent2= new Intent(P2.this , P3.class);
                    miIntent2.putExtra("datosP2", datos);
                    // miIntent2.putExtra("datos", datos);
                    startActivity(miIntent2);


                }



            }
        });




    }
}
