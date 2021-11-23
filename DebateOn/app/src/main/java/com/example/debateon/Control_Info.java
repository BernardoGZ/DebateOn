package com.example.debateon;

import java.lang.String;

public class Control_Info {
    public int postura_inicial = 0;     //0 = en contra, 1 = a favor
    public int postura = 0;             //0 = en contra, 1 = a favor
    public int contador_niveles = 0;    //Contador de niveles en arbol de decisiones
    public String decision_id = "";
    public String respuesta_usuario = "";
    public String contra_arg = "";

    public Control_Info(){
        postura_inicial = 0;
        postura = 0;
        contador_niveles = 0;
        decision_id = "";
        respuesta_usuario = "";
        contra_arg = "";
    }
}
