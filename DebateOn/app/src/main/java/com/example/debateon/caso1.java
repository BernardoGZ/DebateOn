package com.example.debateon;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class caso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caso1_ted_title);

        Control_Info control_info = new Control_Info();

        findViewById(R.id.btn_caso1_comenzar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.test_teachout);
                findViewById(R.id.btn_favor_teach).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.test_juicio);
                    }
                });
                findViewById(R.id.btn_contra_teach).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.test_juicio);
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_0_0) ;
                    }
                });
            }
        });

    }
}