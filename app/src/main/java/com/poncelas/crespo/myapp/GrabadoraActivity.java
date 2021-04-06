package com.poncelas.crespo.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class GrabadoraActivity extends AppCompatActivity {

    private MediaRecorder grabacion; //Objeto con el cual se grabara en la aplicacion
    private String salida = null; // path (ruta) del archivo a grabar
    private Button btnGrabar; //boton que ejecutara la accion de grabar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_grab);

        btnGrabar = (Button)findViewById(R.id.btnGrabar);// Asignamos el boton del activity_main.xml al objeto que creamos anteriormente
      atras();






        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(GrabadoraActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
            //Comprobacion para saber si el archivo manifest contiene los permisos, si no los posee, la aplicacion no funcionara
        }

    }
    private void atras(){
        getSupportActionBar().setTitle("GRABADORA");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void Grabar(View view){ //metodo para realizar una grabacion
        if (grabacion == null){// si el objeto de grabacion no tiene ningun dato

            salida = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabacion.mp3"; //ruta y nombre de salida del archivo
            grabacion = new MediaRecorder();//asignacion de nuevo objeto de la clase MediaRecorder
            grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);//Se obtendra el audio de nuestro microfono
            grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);// Formato en el cual se grabara el audio
            grabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);//Codificador de audio
            grabacion.setOutputFile(salida);// ruta donde se guardara el audio que se grabe

            try {

                grabacion.prepare(); //se prepara el estado de la grabacion
                grabacion.start();//se inicia el estado de la grabacion

            }catch (IOException e){

            }

            Toast.makeText(getApplicationContext(), "Grabando....", Toast.LENGTH_SHORT).show();//se lanza una notificacion para alertar que se esta grabando

        }else if (grabacion != null){ //si el objeto grabacion contiene un archivo
            grabacion.stop();//se detiene la grabacion
            grabacion.release();//se libera memoria
            grabacion = null;//vuelve a un estado null
            btnGrabar.setBackgroundResource(R.drawable.stop_rec);//Cambiamos el boton para informar que se ha detenido la grabacion
            Toast.makeText(getApplicationContext(), "Grabación Finalizada....", Toast.LENGTH_SHORT).show();//se lanza una alerta para informar que se ha detenido la grabacion
        }
    }
    public void  Reproducir(View view){
        if (salida != null){//verificamos si existe un archivo en la ruta almacenada en salida para continuar con la reproduccion

            MediaPlayer mediaPlayer = new MediaPlayer(); //Creamos un objeto de la clase MediaPlayer para reproducir el contenido
            try {
                mediaPlayer.setDataSource(salida);//Se carga el archivo contenido en la ruta del string Salida
                mediaPlayer.prepare();//se carga el archivo a reproducir
            }catch (IOException e){

            }
            mediaPlayer.start();//se inicia la reproduccion del audio grabado anteriormente
            Toast.makeText(getApplicationContext(), "Reproduciendo Audio....", Toast.LENGTH_SHORT).show();//Se lanza una alerta para informar que el contenido se esta reproduciendo
        }else{
            Toast.makeText(getApplicationContext(), "Necesita Grabar un Audio....", Toast.LENGTH_SHORT).show(); //se lanza una alerta para informar que no se encuentra un archivo alojado
        }

    }


}
