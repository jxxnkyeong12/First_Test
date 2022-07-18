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

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "숫자";
    TextView tv_txt;  //setContentView가 이러어지고나서 그 다음에 사용할수 있음 (디자인 연결 후 찾기)
    Button btn, btn_num;
    EditText edt_text, edt_num;
    RadioButton rdo_man, rdo_woman;
    RadioGroup rdog_group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_txt = findViewById(R.id.tv_txt1);
        btn = findViewById(R.id.btn);
        edt_text = findViewById(R.id.edt_text);
        edt_num = findViewById(R.id.edt_num);
        btn_num = findViewById(R.id.btn_num);
        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_woman);

        rdog_group = findViewById(R.id.rdog_group);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭이 되었을때는 여기 부분이 실행됨
                //tv_txt.setText("글씨가 들어감?");
                //tv_txt.setText((CharSequence) editText); 혼자해봤다가 안된거
                tv_txt.setText(edt_text.getText());

            }
        });

        btn_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(rtnInt(edt_num.getText()+"")){
                    Log.d(TAG, "OK");
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
               }else {
                   Log.d(TAG, "노우");
                   Toast.makeText(MainActivity.this, "NG", Toast.LENGTH_SHORT).show();
               }
            }
        });



        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { //체크가 바꼈을때만 감지해!
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Log.d("체크상태", "onCheckedChanged: " + isChecked);
                if(rdo_man.isChecked()){
                    rdo_woman.setChecked(false);
                }

            }
        });


        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("체크상태", "onCheckedChanged: " + isChecked);
                if(rdo_woman.isChecked()){
                    rdo_man.setChecked(false);

                }
            }
        });

        rdog_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("라디오 그룹", "onCheckedChanged: " + checkedId);
                Log.d("라디오 그룹", "onCheckedChanged: " +group.getChildAt(checkedId-1).getId());//View ( Object ) 최상위 클래스를 리턴함
                //↓ 캐스팅 해당하는 클래스 타입이 어떤 타입인지를 정확히 명시하고 해당하는 클래스의 기능을 사용함.
                RadioButton tempRdo = (RadioButton) group.getChildAt(checkedId-1);
                Log.d("라디오그룹"   , "onCheckedChanged: " + tempRdo.getText());
            }
        });

    }





    //EditText에 들어있는 값이 (?????) => 숫자로 일단 바뀌는 값인지를 체크한다. (<>바뀌지 않는 값 NG)
    //숫자로 바꾼 값이 0이상이면 OK, 그외에는 NG
    //"0" <= 사용자가 입력함 ?  Integer.parseInt("0") => 0 => OK
    //<==== NG ====> 이밑 잘못하면 앱이 꺼져 ㅎ(개발자가 오류가 날것같은 코드를 인지하고 해당하는 부분에 오류가 발생 시 예외처리를 할수가있다.)

    //numberFormatException

    //"AB0" <-?? 이건 바꿔도 안돼. 걍 잘못된 입력.
    //" 0" <-trim x 공백이나 특수문자 문자열은 사용이 불가능합니다.
    //"-10" <-0 이상의 숫자를 입력해주세요.

    public boolean rtnInt(String inputData) {  //int 형태로 바뀌고 그리고 나서 0이상이면 OK를 리턴하는 메소드

        try{
            if(Integer.parseInt(inputData) >= 0 )
            return true;//바뀌는게 오류가 안나고 0이상이면 true가 리턴됨
        }catch (Exception e){
            e.getStackTrace();
        }
        return false;
    }


}