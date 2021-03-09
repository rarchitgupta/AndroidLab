package com.example.l2q3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ConstraintLayout c;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        c = findViewById(R.id.layout);
        img.setDrawingCacheEnabled(true);
        img.buildDrawingCache(true);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE )
                {
                    bitmap = img.getDrawingCache();
                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());
                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);
                    MainActivity.this.getWindow().setStatusBarColor(Color.rgb(r,g,b));
                    MainActivity.this.getWindow().getDecorView().setBackgroundColor(Color.rgb(r,g,b));
                }
                return true;
            }

        });
    }
}