package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int cnt1, cnt2, cnt3, cnt4;
    Button btn_shin, btn_jin, btn_yeol, btn_hc, btn_price, btn_result;
    EditText ed_txt;
    TextView txt_main, txt_shin, txt_jin, txt_yeol, txt_hc;
    int cost = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_txt = findViewById(R.id.ed_txt);
        btn_price = findViewById(R.id.btn_price);
        txt_main = findViewById(R.id.txt_main);
        btn_shin = findViewById(R.id.btn_shin);
        btn_result = findViewById(R.id.btn_result);

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        //품목 ArrayList 저장
        ArrayList<RamenDTO> list = new ArrayList<>();
        list.add(new RamenDTO("신라면", 10, 900));
        list.add(new RamenDTO("진라면", 10, 800));
        list.add(new RamenDTO("열라면", 10, 700));
        list.add(new RamenDTO("불닭볶음면", 10, 1100));

        //버튼 누르고 잔액 표시
        btn_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Log.d("이벤트 버튼", txt_main.toString());*/
                txt_main.setText("금액 : " + Integer.parseInt(ed_txt.getText().toString()) + "원");
                cost = Integer.parseInt(ed_txt.getText().toString());
            }
        });

        //신라면만...
        btn_shin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt1++;
                cost = 900;
                String name = "신라면";

                RamenDTO dto = new RamenDTO(name, cnt1, (cost * cnt1));

                int money = Integer.parseInt(ed_txt.getText().toString());
                intent.putExtra("dto", dto);

                txt_main.setText("금액 : " + (money - (cost * cnt1)) + "원");


            }

        });


        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(intent);
            }
        });

    }//onCreate
}//class