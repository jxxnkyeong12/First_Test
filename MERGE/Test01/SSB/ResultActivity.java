package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    TextView tv_sub1,tv_sub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub1 = findViewById(R.id.tv_sub1);
        tv_sub2 = findViewById(R.id.tv_sub2);


        Intent intent = getIntent();
        tv_sub1.setText( intent.getIntExtra("money", -1) + "");


        ArrayList<RamenDTO> list = (ArrayList<RamenDTO>) intent.getSerializableExtra("list");

        String text = "";
        if (list.get(0).count > 0) {
            //신라면을 눌렀을때
            text +=  list.get(0).name + ":" + list.get(0).count + " ";

        }

        if (list.get(1).count > 0) {
            //진라면을 눌렀을때
            text +=  list.get(1).name + ":" + list.get(1).count + " ";

        }
        if (list.get(2).count > 0) {
            //열라면을 눌렀을때
            text +=  list.get(2).name + ":" + list.get(2).count+ " ";

        }
        if (list.get(3).count > 0) {
            //불닭을 눌렀을때
            text +=  list.get(3).name + ":" + list.get(3).count + " ";

        }

        if (list.get(4).count > 0) {
            Random random = new Random();
                int ran = random.nextInt(4);
                text += list.get(ran).name + ":" + "1";

        }

        tv_sub2.setText(text);


    }
}