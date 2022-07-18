package com.example.and07_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_text ; // = findViewById(R.id.tv_text); // setContentView가 이루어지고나서 그다음에 사용할수있음(디자인 연결 후 찾기 )
    Button btn_text , btn_num;
    EditText edt_text , edt_num;
    RadioButton rdo_man , rdo_woman;
    RadioGroup rdo_group ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_text = findViewById(R.id.tv_text);
        btn_text = findViewById(R.id.btn_txt);
        edt_text = findViewById(R.id.edt_text);

        btn_num = findViewById(R.id.btn_num);
        edt_num = findViewById(R.id.edt_num);

        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_woman);

        rdo_group = findViewById(R.id.rdo_group);

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭이 되었을때는 여기 부분이 실행됨
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                tv_text.setText("글씨를 바꿨음");
                tv_text.setText(edt_text.getText());
            }
        });

        btn_num.setOnClickListener(this);

        rdo_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("라디오 그룹", "onCheckedChanged: " + checkedId);
                Log.d("라디오 그룹", "onCheckedChanged: " +group.getChildAt(0).getId());//View ( Object ) 최상위 클래스를 리턴함
                //↓ 캐스팅 해당하는 클래스 타입이 어떤 타입인지를 정확히 명시하고 해당하는 클래스의 기능을 사용함.
                RadioButton tempRdo = (RadioButton) group.getChildAt(checkedId-1);
                Log.d("라디오그룹"   , "onCheckedChanged: " + tempRdo.getText());
            }
        });


        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("체크상태", "onCheckedChanged: man" + isChecked);
                if(isChecked){
                    rdo_woman.setChecked(false);
                }
            }
        });

        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("체크상태", "onCheckedChanged: woman" + isChecked);
                if(isChecked){
                    rdo_man.setChecked(false);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (rtnInt(edt_num.getText()+"")){
            Log.d("아무값" , "OK: ");
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        }else{
            Log.d("아무값" , "NG: ");
            Toast.makeText(this, "NG", Toast.LENGTH_SHORT).show();
        }
    }
    // EditText에 들어있는 값이 (?????) => 숫자로 일단 바뀌는 값인지를 체크한다. (<>바뀌지않는값 NG)
    // 숫자로 바꾼 값이 0이상이면 OK , 그외에는 NG
    // "0" <- 사용자가 입력함 ? Integer.parseInt("0") => 0 => OK
    // <=== NG ===> 앱이 종료됨.( 개발자가 오류가 날것같은코드를 인지하고 해당하는 부분에 오류가 발생 시 예외처리를 할수가있다 )

    // numberFormatException

    // "AB0" <- ?? 잘못된입력
    // " 0" <-trim x 공백이나 특수문자 문자열은 사용이불가능합니다.
    // "-10" <- 0이상의 숫자를 입력해주세요.
    public boolean rtnInt(String inputData){ // => int형태로 바뀌고 그리고나서 0이상이면 OK를 리턴하는 메소드
        try{
            if(Integer.parseInt(inputData) >= 0 ) return true;//바뀌는게 오류가 안나고 0이상이면 true가 리턴됨
        }catch (Exception e){
            e.getStackTrace();
        }
        return false;
    }



}