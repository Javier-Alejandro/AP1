package com.Javier.ap1;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
//import android.widget.AdapterView.OnItemSelectedListener;

import androidx.annotation.Nullable;

public class P3 extends Activity {

    public  DatePicker dp;
    public  Spinner sp1;
    public Spinner sp2;
    public Button bConsultar;
    public  int [] fecha= new int [3];
    public  String[] pe3;
    public String[] estados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_p3);
        Bundle pe2 = getIntent().getExtras();
        pe3 = pe2.getStringArray("datosP2");
        bConsultar = (Button) findViewById(R.id.buttonConsultar);
        sp1 = (Spinner) findViewById(R.id.spinnerSex);
        sp2= (Spinner)findViewById(R.id.spinnerEstado);
        dp = (DatePicker) findViewById(R.id.datePickerFecha);

        estados = new String[]
                {"Aguscalientes",
                        "Baja California Sur", "Baja California",
                        "Campeche", "Chiapas", "Chihuahua", "Coahuila",
                        "Colima", "DistritoFederal", "Durango",
                        "Guadalajara", "Guerrero", "Hidalgo",
                        "Jalisco", "México", "Michoacan", "Morelos",
                        "Nayarid", "Nuevo Leon", "Oaxaca", "Puebla",
                        "Queretaro", "Quintana Roo", "San Luis Potosi",
                        "Sinaloa", "Sonora", "Tabasco", "Tamaulipas",
                        "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas",
                        "Nacido en el Extranjero"
                };
        ArrayAdapter <String> adapter = new ArrayAdapter <>(this, android.R.layout.simple_spinner_item, estados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp2.setAdapter(adapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View vis, int pos, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            } //anexe el }); de abajo
        });

        bConsultar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                int position = sp1.getLastVisiblePosition();
                String sex = sp1.getItemAtPosition(position).toString().toUpperCase();

                int position2 = sp2.getLastVisiblePosition();
                String est = sp2.getItemAtPosition(position2).toString().toUpperCase();

                fecha[0] = dp.getDayOfMonth();
                fecha[1] = dp.getMonth() + 1;
                fecha[2] = dp.getYear();

                Curp miCurp = new Curp();
                miCurp.setNombre(pe3[0]);
                miCurp.setPaterno(pe3[1]);
                miCurp.setMaterno(pe3[2]);
                miCurp.setSexo(sex);
                miCurp.setEstado(est);

                miCurp.setDD(fecha[0]);
                miCurp.setMM(fecha[1]);
                miCurp.setYYYY(fecha[2]);

                dialogo(miCurp.generaCurp(miCurp.generaClave(position2)));


            }
        });
    }
    public void dialogo (String mensage){
        /*se crea un nuevo objeto de tipo
         *AlertDialog.Builder el cual recibe
         *como parametro la propia clase */
        AlertDialog.Builder rc = new AlertDialog.Builder(P3.this);
        rc.setTitle("C.U.R.P.");
        rc.setMessage(mensage);
        rc.setPositiveButton("Aceptar", null);
        rc.show();
    }

}
