package com.example.debateon;

import android.os.Bundle;
import android.view.View;
import java.lang.String;

import androidx.appcompat.app.AppCompatActivity;

public class Control_Info {
    public int postura_inicial = 0; //0 = en contra, 1 = a favor
    public int contador_niveles = 0; //Contador de niveles en arbol de decisiones
    public String respuesta_usuario = "";
    public String contra_respuesta = "";

    public Control_Info(){
        postura_inicial = 0;
        contador_niveles = 0;
        respuesta_usuario = "";
        contra_respuesta = "";
    }
}
