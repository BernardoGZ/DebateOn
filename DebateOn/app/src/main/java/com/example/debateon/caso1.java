package com.example.debateon;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class caso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caso1_ted_title);

        findViewById(R.id.btn_caso1_comenzar).setOnKeyListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.test_teachout);
            }
        });
        findViewById(R.id.btn_favor_teach).setOnKeyListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.test_juicio);
            }
        });
        findViewById(R.id.btn_contra_teach).setOnKeyListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.test_juicio);
            }
        });
    }
}