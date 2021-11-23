package com.example.debateon;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class caso1_juicio extends AppCompatActivity {

    Control_Info control_info;
    TextView textViewCaption;
    TextView textViewRefuta;
    TextView postura;
    TextView puntaje;
    ImageView msgBox2;
    Button btnContinuar;
    Button btnFavor;
    Button btnContra;
    Button btnfin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caso_juicio);

        control_info = caso1_teach.getControl();

        textViewCaption = findViewById(R.id.txt_juicio_caption);
        textViewRefuta = findViewById(R.id.txt_juicio_refuta);
        postura = findViewById(R.id.textView4);
        msgBox2 = findViewById(R.id.msgBox2);
        btnContinuar = findViewById(R.id.btn_caso1_continuar);
        btnFavor = findViewById(R.id.btn_favor_juicio);
        btnContra = findViewById(R.id.btn_contra_juicio);
        btnfin = findViewById(R.id.btn_finalizar);

        changeText();

        //Juicio a favor
        findViewById(R.id.btn_favor_juicio).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                control_info.postura = 1;
                control_info.decision_id += '1';
                control_info.contador_niveles++;
                msgBox2.setVisibility(View.INVISIBLE);
                textViewRefuta.setVisibility(View.INVISIBLE);
                btnContinuar.setVisibility(View.VISIBLE);
                postura.setVisibility(View.INVISIBLE);
                btnFavor.setVisibility(View.INVISIBLE);
                btnContra.setVisibility(View.INVISIBLE);
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
                msgBox2.setVisibility(View.INVISIBLE);
                textViewRefuta.setVisibility(View.INVISIBLE);
                btnContinuar.setVisibility(View.VISIBLE);
                postura.setVisibility(View.INVISIBLE);
                btnFavor.setVisibility(View.INVISIBLE);
                btnContra.setVisibility(View.INVISIBLE);
                changeText();
            }
        });

        //Refuta
        findViewById(R.id.btn_caso1_continuar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                msgBox2.setVisibility(View.VISIBLE);
                textViewRefuta.setVisibility(View.VISIBLE);
                btnContinuar.setVisibility(View.INVISIBLE);
                if (control_info.contador_niveles != 2){
                    postura.setVisibility(View.VISIBLE);
                    btnFavor.setVisibility(View.VISIBLE);
                    btnContra.setVisibility(View.VISIBLE);
                }
                else if (control_info.contador_niveles == 2){
                    btnfin.setVisibility(View.VISIBLE);
                }

            }
        });

        //Finalizar
        findViewById(R.id.btn_finalizar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.caso1_fin);
                puntaje = findViewById(R.id.textViewPuntaje);
                puntaje.setText(getPuntaje().toString());
                //Salir
//                findViewById(R.id.btn_fin_salir).setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        finishAndRemoveTask();
//                    }
//                });

                //Volver a jugar
//                findViewById(R.id.btn_fin_salir2).setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(caso1_juicio, MainActivity.class);
//                        this.startActivity(intent);
//                        this.finishAffinity();
//                    }
//                });

            }
        });
    }
    private String getPuntaje(){
        if (control_info.decision_id.equals("00")){
            return "3/3";
        }
        else if (control_info.decision_id.equals("01")){
            return "2/3";
        }
        else if (control_info.decision_id.equals("10")){
            return "3/3";
        }
        else if (control_info.decision_id.equals("11")){
            return "1/3";
        }
        else{
            return "0/3";
        }
    }
    private void changeText(){
        if (control_info.postura_inicial == 0)
        {
            switch (control_info.contador_niveles) {
                case 0:
                    control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_0_0) ;
                    control_info.contra_arg = getString(R.string.refuta_ted_contra_0_0);
                    break;
                case 1:
                    if (control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_1_0) ;
                        control_info.contra_arg = getString(R.string.refuta_ted_contra_1_0);
                    }
                    else if (control_info.postura == 1) {
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_1_1) ;
                        control_info.contra_arg = getString(R.string.refuta_ted_contra_1_1);
                    }
                    break;
                case 2:
                    if (control_info.decision_id.equals("00") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_0);
                        control_info.contra_arg = getString(R.string.refuta_ted_contra_2_0);
                    }
                    else if (control_info.decision_id.equals("01") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_1);
                        control_info.contra_arg = getString(R.string.refuta_ted_contra_2_1);
                    }
                    else if (control_info.decision_id.equals("10") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_2);
                        control_info.contra_arg = getString(R.string.refuta_ted_contra_2_2);
                    }
                    else if (control_info.decision_id.equals("11") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_contra_2_3);
                        control_info.contra_arg = getString(R.string.refuta_ted_contra_2_3);
                    }
                    break;

            }
        }
        else {
            switch (control_info.contador_niveles) {
                case 0:
                    control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_0_0) ;
                    control_info.contra_arg = getString(R.string.refuta_ted_favor_0_0);
                    break;
                case 1:
                    if (control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_1_0) ;
                        control_info.contra_arg = getString(R.string.refuta_ted_favor_1_0);
                    }
                    else if (control_info.postura == 1) {
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_1_1) ;
                        control_info.contra_arg = getString(R.string.refuta_ted_favor_1_1);
                    }

                    break;
                case 2:
                    if (control_info.decision_id.equals("00") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_0);
                        control_info.contra_arg = getString(R.string.refuta_ted_favor_2_0);
                    }
                    else if (control_info.decision_id.equals("01") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_1);
                        control_info.contra_arg = getString(R.string.refuta_ted_favor_2_1);
                    }
                    else if (control_info.decision_id.equals("10") && control_info.postura == 0){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_2);
                        control_info.contra_arg = getString(R.string.refuta_ted_favor_2_2);
                    }
                    else if (control_info.decision_id.equals("11") && control_info.postura == 1){
                        control_info.respuesta_usuario = getString(R.string.respuesta_ted_favor_2_3);
                        control_info.contra_arg = getString(R.string.refuta_ted_favor_2_3);
                    }
                    break;
            }
        }
        Log.i("testing:", control_info.postura_inicial + " " + control_info.postura + " "+ control_info.contador_niveles + " " + control_info.decision_id + " " + control_info.respuesta_usuario);
        textViewCaption.setText(control_info.respuesta_usuario.toString());
        textViewRefuta.setText(control_info.contra_arg.toString());

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