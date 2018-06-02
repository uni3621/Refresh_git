package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton man_button;
    ImageButton women_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        man_button = (ImageButton) findViewById(R.id.Man_Button);
        women_button = (ImageButton) findViewById(R.id.Women_Button);

        man_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Select_Building_MenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        women_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Select_Building_WomenActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

}
