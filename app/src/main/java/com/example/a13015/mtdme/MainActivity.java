package com.example.a13015.mtdme;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.MapView;

import org.json.JSONObject;
public class MainActivity extends AppCompatActivity {
    private String Api_Key = "86639260e8744e749c5fd72630c543d5";
    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        final MapView map = findViewById(R.id.googlemap);

        final Button startAPICall = findViewById(R.id.startGetNewsCall);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d("Get news", "Start API button clicked");
                TextView textView = findViewById(R.id.editText);
                textView.setText("Api Found!");
                startAPICall();
            }
        });
        final Button checkloc = findViewById(R.id.checkloc);
        checkloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d("check location", "check location button clicked");
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

    }
    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://developer.cumtd.com/api/v2.2/json/getnews" + "?key=" + Api_Key,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d("Get News", response.toString());
                            TextView textView = findViewById(R.id.editText);
                            textView.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w("Get News", error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
