package com.example.speedometertask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void gototaskone(View view){
        startActivity(new Intent(this,SpeedoMeterActivity.class));
    }
    public void gototasktwo(View view){
        startActivity(new Intent(this,ArrayActivity.class));
    }
}
