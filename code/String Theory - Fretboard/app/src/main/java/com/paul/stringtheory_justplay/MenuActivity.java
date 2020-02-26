package com.paul.stringtheory_justplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn = findViewById(R.id.freestylebutton);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
}
