package com.u1fukui.androiddemos.activity.animation.transition;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.u1fukui.androiddemos.R;

import butterknife.ButterKnife;

public class SharedElementSecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_second);
        ButterKnife.inject(this);
    }
}
