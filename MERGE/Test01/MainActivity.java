package com.example.and10_intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn , btn_call , btn_gps , btn_internet;
    // 안드로이드의 4대 컴포넌트 : (현) 액티비티
    // 4가지의 컴포넌트들간의 통신을 담당 : Intent(전달)

    //
=======
<<<<<<< HEAD

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "숫자";
    TextView tv_txt;  //setContentView가 이러어지고나서 그 다음에 사용할수 있음 (디자인 연결 후 찾기)
    Button btn, btn_num;
    EditText edt_text, edt_num;
    RadioButton rdo_man, rdo_woman;
    RadioGroup rdog_group;
=======
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
public class MainActivity extends AppCompatActivity {
    TextView tv_tex;
    Button bt_btn, btn_btn;
    EditText et_tex, edt_tex;
<<<<<<< HEAD
=======
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_text ; // = findViewById(R.id.tv_text); // setContentView가 이루어지고나서 그다음에 사용할수있음(디자인 연결 후 찾기 )
    Button btn_text , btn_num;
    EditText edt_text , edt_num;
>>>>>>> 2b1e6a0fb1293fbdc585d6f12e5117a7d0a6c91a
=======
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
    RadioButton rdo_man, rdo_woman;
    RadioGroup rdo_group;
>>>>>>> 66fca196730ed801547770e5b4cbe78dad06305e

>>>>>>> 6e9b3cf37761aba3e5a9a6082bcba5f5689b2caa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
<<<<<<< HEAD
=======

<<<<<<< HEAD
        btn_call = findViewById(R.id.btn_call);
        btn_gps = findViewById(R.id.btn_gps);
        btn_internet = findViewById(R.id.btn_internet);
=======
<<<<<<< HEAD
        tv_text = findViewById(R.id.tv_text);
        btn_text = findViewById(R.id.btn_txt);
        edt_text = findViewById(R.id.edt_text);
>>>>>>> 6e9b3cf37761aba3e5a9a6082bcba5f5689b2caa

        btn_call.setOnClickListener(this);
        btn_gps.setOnClickListener(this);
        btn_internet.setOnClickListener(this);

<<<<<<< HEAD
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
=======
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
                Log.d("라디오 그룹", "onCheckedChanged: " + group.getChildAt(checkedId-1).getId()); //View(Object) 최상위 클래스를 리턴함
                //캐스팅에 해당하는 클래스 타입이 어떤 타입인지를 정확히 명시하고 해당하는 클래스 기능 사용
                RadioButton tempRdo = (RadioButton) group.getChildAt(checkedId-1);
                Log.d("라디오 그룹","onCheckedChanged" + tempRdo.getText());
            }
        });

        btn_num.setOnClickListener(this);


        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("체크상태", "onCheckedChanged: man" + isChecked);
                if(isChecked){

                    rdo_woman.setChecked(false);
                }

=======
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
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
<<<<<<< HEAD
=======

        tv_text = findViewById(R.id.tv_text);
        btn_text = findViewById(R.id.btn_txt);
        edt_text = findViewById(R.id.edt_text);

        btn_num = findViewById(R.id.btn_num);
        edt_num = findViewById(R.id.edt_num);

        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_wonam);

        rdo_group = findViewById(R.id.rdo_group);

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭이 되었을때는 여기 부분이 실행됨
                tv_text.setText("글씨를 바꿨음");
                tv_text.setText(edt_text.getText());
>>>>>>> 2b1e6a0fb1293fbdc585d6f12e5117a7d0a6c91a
=======
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
            }
        });

        rdo_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
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
>>>>>>> 66fca196730ed801547770e5b4cbe78dad06305e
            }
        });


<<<<<<< HEAD
        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("체크상태", "onCheckedChanged: woman" + isChecked);
                if(isChecked){
                    rdo_man.setChecked(false);
                }

               

            }
        });
>>>>>>> 6e9b3cf37761aba3e5a9a6082bcba5f5689b2caa

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
<<<<<<< HEAD
=======


    // EditText에 들어있는 값이 (?????) => 숫자로 일단 바뀌는 값인지를 체크한다. (<>바뀌지않는값 NG)
    // 숫자로 바꾼 값이 0이상이면 OK , 그외에는 NG
    // "0" <- 사용자가 입력함 ? Integer.parseInt("0") => 0 => OK
    // NG : 앱이 종료됨.( 개발자가 오류가 날것같은코드를 인지하고 해당하는 부분에 오류가 발생 시 예외처리를 할수가있다 )

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
=======

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
>>>>>>> 66fca196730ed801547770e5b4cbe78dad06305e
    }



<<<<<<< HEAD





=======
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
<<<<<<< HEAD
=======
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("라디오 그룹", "onCheckedChanged: " + checkedId);
                Log.d("라디오 그룹", "onCheckedChanged: " + group.getChildAt(checkedId-1).getId()); //View(Object) 최상위 클래스를 리턴함
                //캐스팅에 해당하는 클래스 타입이 어떤 타입인지를 정확히 명시하고 해당하는 클래스 기능 사용
                RadioButton tempRdo = (RadioButton) group.getChildAt(checkedId-1);
                Log.d("라디오 그룹","onCheckedChanged" + tempRdo.getText());
            }
        });

        btn_num.setOnClickListener(this);

        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    rdo_woman.setChecked(false);
                }
                Log.d("체크상태", "onCheckedChanged: man " + isChecked);

            }
        });

        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    rdo_man.setChecked(false);
                }
                Log.d("체크상태", "onCheckedChanged: woman " + isChecked);
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
    // NG : 앱이 종료됨.( 개발자가 오류가 날것같은코드를 인지하고 해당하는 부분에 오류가 발생 시 예외처리를 할수가있다 )

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

>>>>>>> 2b1e6a0fb1293fbdc585d6f12e5117a7d0a6c91a
=======
>>>>>>> 66fca196730ed801547770e5b4cbe78dad06305e
>>>>>>> 6e9b3cf37761aba3e5a9a6082bcba5f5689b2caa
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
}