package com.example.sapui.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Button btnBack = (Button) findViewById(R.id.btnBack);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                finish();
                //push from top to bottom
                overridePendingTransition(R.anim.push_down_in,
                        R.anim.push_down_out);
                //slide from left to right
                //overridePendingTransition(R.anim.slide_in_left,
                // R.anim.slide_out_right);
                break;

            // More buttons go here (if any) ...
        }
    }
}
