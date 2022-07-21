package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_shin, btn_jin, btn_yeol, btn_hc, btn_result, btn_price;
    EditText ed_txt;
    TextView txt_main, txt_shin, txt_jin, txt_yeol, txt_hc;
    int money = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_shin = findViewById(R.id.btn_shin);
        btn_price = findViewById(R.id.btn_price);
        ed_txt = findViewById(R.id.ed_txt);
        btn_jin = findViewById(R.id.btn_jin);
        btn_jin = findViewById(R.id.btn_jin);
        btn_result = findViewById(R.id.btn_result);
        txt_main = findViewById(R.id.txt_main);
        btn_yeol = findViewById(R.id.btn_yeol);
        btn_hc = findViewById(R.id.btn_hc);
        txt_shin = findViewById(R.id.txt_shin);
        txt_jin = findViewById(R.id.txt_jin);
        txt_yeol = findViewById(R.id.txt_yeol);
        txt_hc = findViewById(R.id.txt_hc);
        ArrayList<RamenDTO> list = new ArrayList<>();
        list.add(new RamenDTO("신라면", 10,900, 0));
        list.add(new RamenDTO("진라면", 10,800, 0));
        list.add(new RamenDTO("열라면", 10,700, 0));
        list.add(new RamenDTO("불닭", 10,1100, 0));

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        //금액입력 버튼 클릭시!!
        btn_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money += Integer.parseInt(ed_txt.getText() + "");
                txt_main.setText("금액" + money + "원");
            }
        });


        //신라면 주문하기 눌렀을때
        btn_shin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money < list.get(0).price){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }else{

                    if(list.get(0).cnt > 0) {
                        //금액차감
                        money -= list.get(0).price;
                        //상품갯수 빼기
                        list.get(0).cnt--;

                        //차감금액 띄우기
                        txt_main.setText("금액" + money + "원");


                        //버튼 누른 횟수
                        list.get(0).count++;


                        //현재 남은 갯수
                        txt_shin.setText(list.get(0).cnt + "개 남음");

                    }else{
                        Toast.makeText(MainActivity.this, "품절 되었습니다", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

 //진라면 주문하기 눌렀을때
        btn_jin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money < list.get(1).price){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }else{

                    if(list.get(1).cnt > 0) {
                        //금액차감
                        money -= list.get(1).price;
                        //상품갯수 빼기
                        list.get(1).cnt--;

                        //차감금액 띄우기
                        txt_main.setText("금액" + money + "원");


                        //버튼 누른 횟수
                        list.get(1).count++;

                        //현재 남은 갯수
                        txt_jin.setText(list.get(1).cnt + "개 남음");

                    }else{
                        Toast.makeText(MainActivity.this, "품절 되었습니다", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
 //열라면 주문하기 눌렀을때
        btn_yeol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money < list.get(2).price){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }else{

                    if(list.get(2).cnt > 0) {
                        //금액차감
                        money -= list.get(2).price;
                        //상품갯수 빼기
                        list.get(2).cnt--;

                        //차감금액 띄우기
                        txt_main.setText("금액" + money + "원");


                        //버튼 누른 횟수
                        list.get(2).count++;

                        //현재 남은 갯수
                        txt_yeol.setText(list.get(2).cnt + "개 남음");

                    }else{
                        Toast.makeText(MainActivity.this, "품절 되었습니다", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


 //불닭 주문하기 눌렀을때
        btn_hc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money < list.get(3).price){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }else{

                    if(list.get(3).cnt > 0) {
                        //금액차감
                        money -= list.get(3).price;
                        //상품갯수 빼기
                        list.get(3).cnt--;

                        //차감금액 띄우기
                        txt_main.setText("금액" + money + "원");


                        //버튼 누른 횟수
                        list.get(3).count++;

                        //현재 남은 갯수
                        txt_hc.setText(list.get(3).cnt + "개 남음");

                    }else{
                        Toast.makeText(MainActivity.this, "품절 되었습니다", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });












        //잔돈 반환 버튼
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("list", list);
                intent.putExtra("money", money);
                startActivity(intent);
            }
        });
    }
}