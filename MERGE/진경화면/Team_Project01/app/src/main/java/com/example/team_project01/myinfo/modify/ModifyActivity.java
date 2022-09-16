package com.example.team_project01.myinfo.modify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.team_project01.R;
import com.example.team_project01.myinfo.MyinfoFragment;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener {
  Button btn_modify;
  ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        btn_modify = findViewById(R.id.btn_modify);
        back = findViewById(R.id.back);


        back.setOnClickListener(this);

        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back){
            onBackPressed();
        }
    }
}