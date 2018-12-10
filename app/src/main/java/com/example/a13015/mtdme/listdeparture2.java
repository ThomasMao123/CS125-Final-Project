package com.example.a13015.mtdme;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
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
import org.json.*;
//import com.google.gson.JsonObject;

//import com.google.android.gms.maps.MapView;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import org.json.JSONObject;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.TextView;
import android.os.Build;
import android.app.Service;
import android.location.Criteria;
import java.text.DateFormat;
import java.util.ArrayList;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.annotation.TargetApi;
import android.provider.Settings;
public class listdeparture2 extends AppCompatActivity {
    private static RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdeparture2);
        requestQueue = Volley.newRequestQueue(this);
        //final MapView map = findViewById(R.id.googlemap);
        TextView textView = findViewById(R.id.stopname);
        textView.setText(GlobalVariableContainer.stops[1]);
        startAPICall();

    }
    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://developer.cumtd.com/api/v2.2/json/getdeparturesbystop" + "?stop_id=" + GlobalVariableContainer.stopID[1] + "&key=86639260e8744e749c5fd72630c543d5",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d("Get departure list", response.toString());
                            //TextView textView = findViewById(R.id.editText);
                            try {
                                JSONArray jsonarr = response.getJSONArray("departures");

                                JSONObject jsob0 = jsonarr.getJSONObject(0);
                                String headsign0 = jsob0.getString("headsign");
                                Button busname0 = findViewById(R.id.busname0);
                                busname0.setText(headsign0);
                                int etaasint0 = jsob0.getInt("expected_mins");
                                String etaasstr0 = Integer.toString(etaasint0) + "min";
                                TextView eta0 = findViewById(R.id.eta0);
                                eta0.setText(etaasstr0);

                                JSONObject jsob1 = jsonarr.getJSONObject(1);
                                String headsign1 = jsob1.getString("headsign");
                                Button busname1 = findViewById(R.id.busname1);
                                busname1.setText(headsign1);
                                int etaasint1 = jsob1.getInt("expected_mins");
                                String etaasstr1 = Integer.toString(etaasint1) + "min";
                                TextView eta1 = findViewById(R.id.eta1);
                                eta1.setText(etaasstr1);

                                JSONObject jsob2 = jsonarr.getJSONObject(2);
                                String headsign2 = jsob2.getString("headsign");
                                Button busname2 = findViewById(R.id.busname2);
                                busname2.setText(headsign2);
                                int etaasint2 = jsob2.getInt("expected_mins");
                                String etaasstr2 = Integer.toString(etaasint2) + "min";
                                TextView eta2 = findViewById(R.id.eta2);
                                eta2.setText(etaasstr2);

                                JSONObject jsob3 = jsonarr.getJSONObject(3);
                                String headsign3 = jsob3.getString("headsign");
                                Button busname3 = findViewById(R.id.busname3);
                                busname3.setText(headsign3);
                                int etaasint3 = jsob3.getInt("expected_mins");
                                String etaasstr3 = Integer.toString(etaasint3) + "min";
                                TextView eta3 = findViewById(R.id.eta3);
                                eta3.setText(etaasstr3);

                                Button checkstoploc2 = findViewById(R.id.checkstoploc2);
                                checkstoploc2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Log.d("locate stop1 on map", "locate stop1 button clicked");
                                        startActivity(new Intent(listdeparture2.this, locatestop2.class));
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

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
