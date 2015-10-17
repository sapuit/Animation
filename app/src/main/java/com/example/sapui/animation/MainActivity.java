package com.example.sapui.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements Animation.AnimationListener {

    TextView  txtMessage;
    Button    btnStart;
    Button    nextActivity;
    // Animation
    Animation animFadein;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage   = (TextView) findViewById(R.id.txtMessage);
        btnStart     = (Button) findViewById(R.id.btnStart);
        nextActivity = (Button) findViewById(R.id.nextActivity);
        // load the animation
        animFadein   = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        // set animation listener
        animFadein.setAnimationListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextActivity:
                Intent nextActivity = new Intent(this,
                        NextActivity.class);
                startActivity(nextActivity);
                //push from bottom to top
                //overridePendingTransition(R.anim.push_up_in,
                //          R.anim.push_up_out);
                //slide from right to left
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
                break;

            case R.id.btnStart:
                txtMessage.setVisibility(View.VISIBLE);
                // start the animation
                txtMessage.startAnimation(animFadein);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // check for fade in animation
        if (animation == animFadein) {
            Toast.makeText(getApplicationContext(),
                    "Animation Stopped", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
