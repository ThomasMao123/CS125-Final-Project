package com.example.a13015.mtdme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.Intent;

import com.android.volley.toolbox.Volley;

public class FirstPage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        final Button turnPage = findViewById(R.id.turntosecondpage);
        turnPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d("Turn page", "Turn to second page");
                startActivity(new Intent(FirstPage.this, MainActivity.class));

            }
        });
    }
}
