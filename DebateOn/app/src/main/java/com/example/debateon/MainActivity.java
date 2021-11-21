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
        findViewById(R.id.btnComenzar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.main_menu);
                findViewById(R.id.btn_caso1).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, caso1.class));
                    }

                });
            }
        });

//        findViewById(R.id.btn_caso1).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, caso1.class));
//            }
//
//        });

    }

    }


