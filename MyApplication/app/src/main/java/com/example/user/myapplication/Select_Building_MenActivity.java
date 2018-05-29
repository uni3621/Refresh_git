package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Select_Building_MenActivity extends AppCompatActivity {
    ImageButton engineering_button_men;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_building_men);

        engineering_button_men = (ImageButton) findViewById(R.id.building3_Button_m);

        engineering_button_men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(Select_Building_MenActivity.this, Engineering_MenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
