package com.example.debateon;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class caso1_juicio extends AppCompatActivity {

    Control_Info control_info;
    TextView textViewCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_juicio);
        Bundle bundle = getIntent().getExtras();
        control_info = caso1_teach.getControl();

        textViewCaption = findViewById(R.id.txt_juicio_caption);
        changeText();

        //Juicio a favor
        findViewById(R.id.btn_favor_juicio).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                control_info.postura = 1;
                control_info.decision_id += '1';
                control_info.contador_niveles++;
                changeText();
            }
        });

        //Juicio en contra
        findViewById(R.id.btn_contra_juicio).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                control_info.postura = 0;
                control_info.decision_id += '0';
                control_info.contador_niveles++;
                changeText();
            }
        });
    }

    private void changeText(){
        if (control_info.postura_inicial == 0)
        {
            switch (control_info.contador_niveles) {
                case 0:
                    control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_0_0) ;
                    break;
                case 1:
                    if (control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_1_0) ;
                    }
                    else if (control_info.postura == 1) {
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_1_1) ;
                    }
                    break;
                case 2:
                    if (control_info.decision_id.equals("00") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_0);
                    }
                    else if (control_info.decision_id.equals("01") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_1);
                    }
                    else if (control_info.decision_id.equals("10") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_2);
                    }
                    else if (control_info.decision_id.equals("11") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_3);
                    }
                    break;

            }
        }
        else {
            switch (control_info.contador_niveles) {
                case 0:
                    control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_0_0) ;

                    break;
                case 1:
                    if (control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_1_0) ;
                    }
                    else if (control_info.postura == 1) {
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_1_1) ;
                    }

                    break;
                case 2:
                    if (control_info.decision_id.equals("00") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_0);
                    }
                    else if (control_info.decision_id.equals("01") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_1);
                    }
                    else if (control_info.decision_id.equals("10") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_2);
                    }
                    else if (control_info.decision_id.equals("11") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_3);
                    }
                    break;
            }
        }
        Log.i("testing:", control_info.postura_inicial + " " + control_info.postura + " "+ control_info.contador_niveles + " " + control_info.decision_id + " " + control_info.respuesta_usuario);
        textViewCaption.setText(control_info.respuesta_usuario.toString());

//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                changeArgument();
//            }
//        }, 5000);   //5 seconds


    }

    private void changeArgument(){
        //textViewCaption.setText(control_info.contra_arg);
    }
}