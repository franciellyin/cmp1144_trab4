package com.atividades.fran.mobile_atividade4;

import android.content.pm.ActivityInfo;
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

                Log.v("frontier:: image", Float.toString(imageView.getWidth()));
                Log.v("frontier:: position", Float.toString(positionXImage));
                Log.v("frontier:: x", Float.toString(event.getX()));

                minX = -180f;//metade da imagem
                maxX = relativeLayout.getWidth() - (imageView.getWidth()/2);

                x = event.getX();

                if(x < middleX){
                    //entao o toque foi realizado na esquerda
                    positionXImage -= 50f;
                }else{
                    //entao o toque foi realizado na direita
                    positionXImage += 50f;
                }

                if(positionXImage < minX){
                    //valida se a imagem está no limite definido
                    positionXImage = minX;
                }
                if(positionXImage > maxX){
                    //valida se a imagem está no limite definido
                    positionXImage = maxX;
                }
                imageView.setX(positionXImage);

                return true;
            }
        });
    }

}
