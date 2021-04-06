package com.poncelas.crespo.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_go_video);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn1 = (Button) findViewById(R.id.btn_go_grab);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GrabadoraActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        Button btn2 = (Button) findViewById(R.id.btn_go_camara);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CamaraActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}