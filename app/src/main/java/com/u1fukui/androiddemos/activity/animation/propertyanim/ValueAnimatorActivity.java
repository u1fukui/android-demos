package com.u1fukui.androiddemos.activity.animation.propertyanim;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.u1fukui.androiddemos.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ValueAnimatorActivity extends ActionBarActivity {

    @InjectView(R.id.valueanim_state)
    TextView mStateView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanim);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.valueanim_button)
    public void startProgrammaticAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 10f);
        anim.setDuration(500);
        anim.addUpdateListener(createListener());
        anim.start();
    }

    @OnClick(R.id.valueanim_button2)
    public void startXmlAnimator() {
        ValueAnimator anim = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.animator_sample);
        anim.addUpdateListener(createListener());
        anim.start();
    }

    private ValueAnimator.AnimatorUpdateListener createListener() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Time\t\tFraction\t\tValue\n");

        return new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 経過時間
                long time = animation.getCurrentPlayTime();

                // アニメーションの経過割合 (0 -> 1.0)
                float fraction = animation.getAnimatedFraction();

                // このタイミングでの Value
                float value = (Float) animation.getAnimatedValue();

                // 出力
                sb.append(String.format("%04d\t\t%10.3f\t\t%10.3f\n",
                        time, fraction, value));
                mStateView.setText(sb.toString());
            }
        };
    }
}
