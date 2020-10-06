package com.chalmers.greentips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DailyTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_tips);
    }

    public void gotransport (View v){
        startActivity(new Intent(DailyTipsActivity.this, TransportTipsActivity.class));
    }
}