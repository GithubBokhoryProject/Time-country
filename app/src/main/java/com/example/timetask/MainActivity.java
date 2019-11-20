package com.example.timetask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String url ="http://worldtimeapi.org/api/timezone/Africa/Cairo";
    TextView time,timezone;
    String url_khartom="http://worldtimeapi.org/api/timezone/Africa/Khartoum";
    String url_tons="http://worldtimeapi.org/api/timezone/Africa/Tunis";
    String url_Amman="http://worldtimeapi.org/api/timezone/Asia/Amman";
    String url_Doubi="http://worldtimeapi.org/api/timezone/Asia/Dubai";
    String url_qatar="http://worldtimeapi.org/api/timezone/Asia/Qatar";
    ////////////////timer update data
    private CountDownTimer countDownTimer;
    private long Timeleftinmsecond=600000; //10m
    private boolean timerruninng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time=findViewById(R.id.txttime);
        timezone=findViewById(R.id.txttimezone);
        /////////////////////////////////

        /////////////////////////////////////////////////
    }
    /// btn cairo
    public void btn_cairo(View view){
        if(timerruninng){
            stoptimer();
        }
        else{
            startupdatecairo();
        }

    }
    //////startcairo @@ stob cairo update
 public void startupdatecairo(){
    countDownTimer=new CountDownTimer(Timeleftinmsecond,2000) {
        @Override
        public void onTick(long l) {
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    readjeson(response);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "on error response : " + error, Toast.LENGTH_SHORT).show();
                }
            });
            MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

        }

        @Override
        public void onFinish() {

        }
    }.start();
    timerruninng=true;
 }
    private void stoptimer() {
        countDownTimer.cancel();
        timerruninng=false;
    }

    ///// end code start and stop cairo


    private void readjeson(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);
            String time1=jsonObject.getString("utc_datetime");
            String timezone1=jsonObject.getString("timezone");
            time.setText(time1.toString());
            timezone.setText(timezone1.toString());

        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    /////////////////////////////////////////////////////
    /// btn khartom
    public void btn_khartom(View view){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url_khartom, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                readjeson(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "on error response : " + error, Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

    }
    /// btn Tunis
    public void btn_tunis(View view){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url_tons, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                readjeson(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "on error response : " + error, Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

    }
    /// btn oman
    public void btn_Amman(View view){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url_Amman, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                readjeson(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "on error response : " + error, Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

    }
    /// btn Doubi

    public void btn_Doubi(View view) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url_Doubi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                readjeson(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "on error response : " + error, Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

    }
    /// btn Qatar

    public void btn_Qatar(View view) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url_qatar, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                readjeson(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "on error response : " + error, Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);
    }
}
