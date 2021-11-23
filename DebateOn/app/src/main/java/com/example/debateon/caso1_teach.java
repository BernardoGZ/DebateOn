package com.example.debateon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class caso1_teach extends AppCompatActivity {

    static Control_Info control_info;
    TextView textViewCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caso1_ted_title);

        control_info = new Control_Info();

        findViewById(R.id.btn_caso1_comenzar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.caso1_contexto);
                findViewById(R.id.btn_fin_salir).setOnClickListener(new View.OnClickListener(){
                       @Override
                       public void onClick(View view) {
                           setContentView(R.layout.caso_teachout);
                           Intent intent = new Intent(caso1_teach.this, caso1_juicio.class);
                           findViewById(R.id.btn_favor_teach).setOnClickListener(new View.OnClickListener(){
                               @Override
                               public void onClick(View view) {
                                   control_info.postura_inicial = 1;
                                   startActivity(intent);
                               }
                           });
                           findViewById(R.id.btn_contra_teach).setOnClickListener(new View.OnClickListener(){
                               @Override
                               public void onClick(View view) {
                                   control_info.postura_inicial = 0;
                                   startActivity(intent);
                               }
                           });
                       }
                   });

            }
        });



    }

    public static Control_Info getControl(){
        return  control_info;
    }
}