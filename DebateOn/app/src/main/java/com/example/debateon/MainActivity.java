package com.example.debateon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnComenzar).setOnKeyListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.main_menu);
            }
        });
        findViewById(R.id.btn_caso1).setOnKeyListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.caso1_ted_title);
            }
        });
    }
}