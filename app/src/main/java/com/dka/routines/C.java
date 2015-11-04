package com.dka.routines;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author Dmitry.Kalyuzhnyi 16.10.2015.
 */
public class C extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.af_activity);
        Log.d(">>>", "cvb created");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(">>>", "C resumed");
    }
}
