package com.cd.com.customviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        int type=0;
        switch(v.getId()){
            case R.id.btn1:
                type=0;
            break;
            case R.id.btn2:
                type=1;
                break;
            case R.id.btn3:
                type=2;
                break;
            case R.id.btn4:
                type=3;
                break;
            case R.id.btn5:
                type=4;
                break;
        }
        intent.putExtra("type",type);
        startActivity(intent);
    }
}
