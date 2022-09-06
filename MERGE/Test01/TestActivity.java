package com.example.and10_intend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity {


;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent(); //보내준 Intent를 받아옴.


        String text = intent.getStringExtra("text");
      //  LoginDTO dto =(LoginDTO)intent.getSerializableExtra("dto");
        int num = intent.getIntExtra("num1", -1);

        Log.d("String", "글자넘어왔니? " + text);
    //    Log.d("dto", " dto :  " + dto.getId() + " - " +  dto.getPw());
        Log.d("int", "int " + num + "");


    findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent reIntent = new Intent(); // 그냥 생성
            reIntent.putExtra("test", "테스트가 끝남");
            //결과 코드를 지정을 한다
            setResult(RESULT_OK, reIntent );


            //액티비티를 종료함 (끔)
            finish();
        }
    });

    }
}