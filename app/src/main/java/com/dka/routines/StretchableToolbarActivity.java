package com.dka.routines;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Dmitry.Kalyuzhnyi 15.10.2015.
 */
public class StretchableToolbarActivity extends AppCompatActivity{
    private CoordinatorLayout mCoordinatorLayour;
    private AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st_activity);

        mCoordinatorLayour = (CoordinatorLayout) findViewById(R.id.root_coordinator);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);


        mAppBarLayout.post(new Runnable() {
            @Override
            public void run() {
                int heightPx = findViewById(R.id.iv_header).getHeight();
                setAppBarOffset(heightPx/2);
            }
        });
    }

    private void setAppBarOffset(int topOffset){
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mAppBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.onNestedPreScroll(mCoordinatorLayour, mAppBarLayout, null, 0, topOffset, new int[]{0, 0});
    }
}
