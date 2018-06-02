package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.user.myapplication.Engineering.Engineering_WomenActivity;

public class Select_Building_WomenActivity extends AppCompatActivity {
    ImageButton engineering_button_women;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_building_women);

        engineering_button_women = (ImageButton) findViewById(R.id.building3_Button_w);

        engineering_button_women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Select_Building_WomenActivity.this, Engineering_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}

