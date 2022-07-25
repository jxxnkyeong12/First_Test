package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView tv_sub1,tv_sub2,tv_sub3, tv_sub4, tv_sub5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub1 = findViewById(R.id.tv_sub1);
        tv_sub2 = findViewById(R.id.tv_sub2);
        tv_sub3 = findViewById(R.id.tv_sub3);
        tv_sub4 = findViewById(R.id.tv_sub4);
        tv_sub5 = findViewById(R.id.tv_sub5);

        Intent intent = getIntent();
        tv_sub1.setText(intent.getIntExtra("money", -1)+"");


        ArrayList<RamenDTO> list = (ArrayList<RamenDTO>) intent.getSerializableExtra("list");


        if (list.get(0).count > 0) {
            //신라면을 눌렀을때
            tv_sub2.setText(list.get(0).name + ":" + list.get(0).count + "");

        }
        if (list.get(1).count > 0) {
            //진라면을 눌렀을때
            tv_sub3.setText(list.get(1).name + ":" + list.get(1).count + "");

        }
        if (list.get(2).count > 0) {
            //열라면을 눌렀을때
            tv_sub4.setText(list.get(2).name + ":" + list.get(2).count + "");

        }
        if (list.get(3).count > 0) {
            //불닭을 눌렀을때
            tv_sub5.setText(list.get(3).name + ":" + list.get(3).count + "");

        }




    }
}