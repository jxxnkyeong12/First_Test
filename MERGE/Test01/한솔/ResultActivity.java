package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        RamenDTO dto = (RamenDTO) intent.getSerializableExtra("dto");

        Log.d("주문서", "품명: "+dto.getName());
        Log.d("주문서", "가격: "+dto.getPrice());
        Log.d("주문수", "갯수: "+dto.getCnt());

    }
}