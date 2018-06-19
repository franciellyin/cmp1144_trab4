package com.atividades.fran.mobile_atividade4;

import android.content.pm.ActivityInfo;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private float x, minX, maxX, positionXImage, middleX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define a orientação da tela para landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        relativeLayout = findViewById(R.id.relativeLayout);
        imageView = findViewById(R.id.imageView);

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                middleX = (relativeLayout.getWidth()*0.5f);
                positionXImage = imageView.getX();

                minX = imageView.getWidth();
                maxX = relativeLayout.getWidth() - imageView.getWidth();

                x = event.getX();

                if(x < middleX){
                    //entao o toque foi realizado na esquerda
                    positionXImage -= 50f;
                }else{
                    //entao o toque foi realizado na direita
                    positionXImage += 50f;
                }

                if(positionXImage < -150f){
                    //valida se a imagem está no limite definido
                    positionXImage = -150f;
                }
                if(positionXImage > 1300f){
                    //valida se a imagem está no limite definido
                    positionXImage = 1300f;
                }
                imageView.setX(positionXImage);

                return true;
            }
        });
    }

}
