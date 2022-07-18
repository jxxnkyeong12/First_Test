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
    TextView tv_tex;
    Button bt_btn, btn_btn;
    EditText et_tex, edt_tex;
    RadioButton rdo_man, rdo_woman;
    RadioGroup rdo_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_tex = findViewById(R.id.tv_tex);
        bt_btn = findViewById(R.id.bt_btn);
        et_tex = findViewById(R.id.et_tex);
        btn_btn = findViewById(R.id.btn_btn);
        edt_tex = findViewById(R.id.edt_tex);
        rdo_man =findViewById(R.id.rbo_man);
        rdo_woman = findViewById(R.id.rbo_woman);
        rdo_group = findViewById(R.id.rdog_group);

        btn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rtnInt(edt_tex.getText() + "")){
                    Log.d("아무값", "OK ");
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                }else{
                    Log.d("아무값", "NG: ");
                    Toast.makeText(MainActivity.this, "NG", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rdo_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                Log.d("라디오 그룹", "onCheckedChanged: " + i);
                Log.d("라디오 그룹", "onCheckedChanged: " + group.getChildAt(i-1).getId());

                //↓ 캐스팅 해당하는 클래스 타입이 어떤 타입인지를 정확히 명시하고 해당하는 클래스의 기능을 사용함.
                RadioButton tempRdo = (RadioButton) group.getChildAt(i-1);
                Log.d("라디오 그룹", "onCheckedChanged: " + tempRdo.getText());
            }
        });


        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("체크상태", "man: " + b);
                if(rdo_man.isChecked()){
                    rdo_woman.setChecked(false);
                }
            }
        });



        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("체크상태", "woman: " + b);
                if(rdo_woman.isChecked()){
                    rdo_man.setChecked(false);
                }
            }
        });

      /*  bt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭이 되었을때는 여기 부분이 실행됨
                tv_tex.setText(et_tex.getText());
            }
        });
*/
    }



    //EditText에 들어있는 값이 (???) => 숫자로 일단 바뀌는지 값인지를 체크한다.
    //숫자로 바꾼 값이 0이상이면 OK , 그외는 NG
    //"0" <- 사용자가 입력함 ? Integer.parseInt("0") =>0
    //"AB0" <- ?? 잘못된 입력
    public boolean rtnInt(String inputData) { // => int 형태로 바뀌고 그리고 나서 0이상이면 OK를 리턴하는 메소드
    try {
        if(Integer.parseInt(inputData) >= 0) return true; //바뀌는게 오류가 안나고 0이상이면 true가 리턴됨
    }catch (Exception e){
        e.printStackTrace();
    }
     return false;
    }

    public boolean checked(){

        return  false;
    }
}