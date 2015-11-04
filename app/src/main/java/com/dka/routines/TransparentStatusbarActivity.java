package com.dka.routines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

/**
 * @author Dmitry.Kalyuzhnyi 16.10.2015.
 */
public class TransparentStatusbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.ts_activity);
        findViewById(R.id.anim_toolbar).post(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.anim_toolbar).setAlpha(0);
            }
        });


    }

}
