package com.example.and10_intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn , btn_call , btn_gps , btn_internet;
    // 안드로이드의 4대 컴포넌트 : (현) 액티비티
    // 4가지의 컴포넌트들간의 통신을 담당 : Intent(전달)

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_call = findViewById(R.id.btn_call);
        btn_gps = findViewById(R.id.btn_gps);
        btn_internet = findViewById(R.id.btn_internet);

        btn_call.setOnClickListener(this);
        btn_gps.setOnClickListener(this);
        btn_internet.setOnClickListener(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                intent.putExtra("test","넘길값");
                intent.putExtra("num",100);

                LoginDTO dto = new LoginDTO( 11 , "admin");
                ArrayList<LoginDTO> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(new LoginDTO(i , "pw" + i));
                }
                // LoginDTO타입을 요소로가지는 ArrayList를 만들기
                // size == 10 이어야한다.

                intent.putExtra("list" , list);
                intent.putExtra("dto" , dto); // 직렬화 Serializable ???????

                //11 , pw : admin

                startActivity(intent);
                //현재위치=>이동할위치 두개를 파라메터로 지정을 해둠.
                // 직접 LoginActivity라는 액티비티를 하나만들고
                // 메인액티비티의 버튼을 클릭했을때 ↑ 새로 띄워지게 처리해보기.

                //Intent intent = new Intent(MainActivity.this, SubActivity.class);
                //startActivity(intent);
            }
        });//View ( => Button )


        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                intent.putExtra("dto" , new LoginDTO(1,"dtoPw"));
                intent.putExtra("sData" , "데이터");
                intent.putExtra("iData", 50);
                //startActivity(intent);//실제 액티비티를 띄움
                //startActivity라는 메소드는 새창을 띄우는 용도로만 사용을함.
                //다음 액티비티의 작업이나 결과를 받아오기위해서는 다른 메소드를 사용.
                // intent (명시적 , 암시적 )
                // 명시적 : <- 내가 만든 클래스(바운더리)에서 작업이 되었을때를 의미함.
                // 암시적 : <- 내가 만들지 않은 어떠한 곳에서 작업이 되었을때(카메라,갤러리,인터넷 등)
                startActivityForResult(intent,REQ_TESTCODE);

            }
        });

      /*  Intent intent = new Intent(MainActivity.this, SubActivity.class);
        startActivityForResult(intent,REQ_SUB_CODE);*/
    }
    // 상수 <-
    final int REQ_TESTCODE = 1001;
    final int REQ_SUB_CODE = 1002;

    //어떤 액티비티가 종료되었는지를 어떻게 구별할까?

    // 1001번 왜썼을까???? , Kakao에서는 왜 콜백을 만들었을까?
    @Override // <- startActivityForResult로 Intent(Activity)를 실행하면 항상 콜백부분.(메소드)
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_TESTCODE){
            Log.d("TAG", " : 테스트 액티비티가 실행되고 결과를 표시할꺼임.");
            Log.d("TAG", " : 결과코드 " + resultCode);
            // intent를 받아왔음 안에들어있는 스트링값을 출력하기.

        }else if(requestCode == REQ_SUB_CODE){
            Log.d("TAG", " : 서브 액티비티가 실행되고 결과를 표시할꺼임.");
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_call){
            //안드로이드에서 기본적으로 제공하고 우리가 만들지않은 작업을 하게되면 암시적 인텐트 라고 한다.
            // 전화걸기 ( 권한 권한 매우낮음 -> 매니페스트 파일에 명시만 해놓으면 바로 사용가능한 부분 ) permission
            Intent intent = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:/119"));
            startActivity(intent);

        }else  if(v.getId() == R.id.btn_gps){
            // gps <= 권한을 승인받아야함 . 현재위치를 노출해야할때.
        } else if(v.getId() == R.id.btn_internet){

        }
    }
}