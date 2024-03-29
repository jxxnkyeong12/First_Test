package com.example.team_project01.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.team_project01.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReserveActivity extends AppCompatActivity implements View.OnClickListener {

    TextView res_timetxt,res_datetxt, res_two,res_three, res_four, res_five,res_six,res_seven
                        , res_two2, res_three2,res_four2, res_five2,res_six2,res_seven2 ;
    //DatePicker calendarView;
    CalendarView calendarView;
    ImageView back, res_up, res_up2, res_up3, res_down, res_down2, res_down3;

    FrameLayout res_container;
    LinearLayout res_time;

    boolean arrow = true;
    int arr = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        back = findViewById(R.id.back);

        res_datetxt = findViewById(R.id.res_datetxt);
        res_timetxt = findViewById(R.id.res_timetxt);

        calendarView = findViewById(R.id.calendarView);
        res_time = findViewById(R.id.res_time);

        res_up = findViewById(R.id.res_up);
        res_up2 = findViewById(R.id.res_up2);
        res_up3 = findViewById(R.id.res_up3);

        res_down = findViewById(R.id.res_down);
        res_down2 = findViewById(R.id.res_down2);
        res_down3 = findViewById(R.id.res_down3);

       // res_container = findViewById(R.id.res_container);

        res_two = findViewById(R.id.res_two);
        res_two2 = findViewById(R.id.res_two2);
        res_three = findViewById(R.id.res_three);
        res_three2 = findViewById(R.id.res_three2);
        res_four = findViewById(R.id.res_four);
        res_four2 = findViewById(R.id.res_four2);
        res_five = findViewById(R.id.res_five);
        res_five2 = findViewById(R.id.res_five2);
        res_six = findViewById(R.id.res_six);
        res_six2 = findViewById(R.id.res_six2);
        res_six2 = findViewById(R.id.res_six2);
        res_seven = findViewById(R.id.res_seven);
        res_seven2 = findViewById(R.id.res_seven2);


        back.setOnClickListener(this);

        res_up.setOnClickListener(this);
        res_up2.setOnClickListener(this);
        res_up3.setOnClickListener(this);

        res_down.setOnClickListener(this);
        res_down2.setOnClickListener(this);
        res_down3.setOnClickListener(this);





       // getSupportFragmentManager().beginTransaction().replace(R.id.res_container, new ReserveFragment()).commit();




        //날짜변환
        DateFormat formatter = new SimpleDateFormat("M월dd일");
        Date date = new Date(calendarView.getDate());
        res_datetxt.setText(formatter.format(date));
        calendarView.setMinDate(System.currentTimeMillis() -1000 ); //오늘기준 이전날짜 선택불가능하게
        
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                res_datetxt.setText( (month+1) + "월 " + dayOfMonth + "일");
            }
        });

    }


    @Override
    public void onClick(View v) {

        //날짜선택 옆 화살표들 누르면 접혔다가 펴졌다가 하는...!
        if(v.getId() == R.id.res_up){
            if(arrow || arr ==1){
                calendarView.setVisibility(View.GONE);
                res_up.setVisibility(View.GONE);
                res_down.setVisibility(View.VISIBLE);
                arrow = false;
                arr = 0;
            }
        }else if (v.getId() == R.id.res_down){

                calendarView.setVisibility(View.VISIBLE);
                res_down.setVisibility(View.GONE);
                res_up.setVisibility(View.VISIBLE);
                arrow = true;
                arr = 1;

         //시간 선택 펼쳤다 접었다
        }else if (v.getId() == R.id.res_up2) {
            if(arr == 0){
                res_time.setVisibility(View.GONE);
                res_up2.setVisibility(View.GONE);
                res_down2.setVisibility(View.VISIBLE);
                arrow = false;
                arr = 1;

            }
        }else if (v.getId() == R.id.res_down2){

            res_time.setVisibility(View.VISIBLE);
            res_up2.setVisibility(View.VISIBLE);
            res_down2.setVisibility(View.GONE);
            arrow = true;
            arr = 0;

        //뒤로가기
        }else if (v.getId() == R.id.back){
            onBackPressed();
        }
    }
}