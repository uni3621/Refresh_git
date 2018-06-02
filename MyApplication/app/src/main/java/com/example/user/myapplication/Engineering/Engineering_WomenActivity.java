package com.example.user.myapplication.Engineering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.user.myapplication.R;

public class Engineering_WomenActivity extends AppCompatActivity {
    ImageButton floor_1_button;
    ImageButton floor_2_button;
    ImageButton floor_3_button;
    ImageButton floor_4_button;
    ImageButton floor_5_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_women);

        floor_1_button = (ImageButton) findViewById(R.id.w_selection_floor_1);
        floor_2_button = (ImageButton) findViewById(R.id.w_selection_floor_2);
        floor_3_button = (ImageButton) findViewById(R.id.w_selection_floor_3);
        floor_4_button = (ImageButton) findViewById(R.id.w_selection_floor_4);
        floor_5_button = (ImageButton) findViewById(R.id.w_selection_floor_5);

        floor_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Engineering_WomenActivity.this, Engineering_1floor_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        floor_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Engineering_WomenActivity.this, Engineering_2floor_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        floor_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Engineering_WomenActivity.this, Engineering_3floor_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        floor_4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Engineering_WomenActivity.this, Engineering_4floor_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        floor_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Engineering_WomenActivity.this, Engineering_5floor_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
