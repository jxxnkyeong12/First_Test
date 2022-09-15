package com.example.team_project01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import android.content.Intent;
=======
import android.content.Context;
>>>>>>> e09d6ba7f057dee0ec439d76535cbec06f7f398a
>>>>>>> a1d20339caaa226e7c53729913ebcb91587d0a39
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.team_project01.home.HomeFragment;
import com.example.team_project01.myinfo.MyinfoFragment;
import com.example.team_project01.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD

    FrameLayout container;
=======
<<<<<<< HEAD

    FrameLayout main_container;
=======
    FrameLayout container;
>>>>>>> e09d6ba7f057dee0ec439d76535cbec06f7f398a
>>>>>>> a1d20339caaa226e7c53729913ebcb91587d0a39
    SpaceNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);
        bottom_nav = (SpaceNavigationView) findViewById(R.id.bottom_nav);

        //하단 네비게이션 버튼 아이디 찾아주기
        bottom_nav.initWithSaveInstanceState(savedInstanceState);
        bottom_nav.addSpaceItem(new SpaceItem("홈", R.drawable.ic_nav_home));
        bottom_nav.addSpaceItem(new SpaceItem("검색", R.drawable.ic_nav_search));
        bottom_nav.addSpaceItem(new SpaceItem("내 정보", R.drawable.ic_nav_myinfo));
        bottom_nav.addSpaceItem(new SpaceItem("더보기", R.drawable.ic_nav_more));
        bottom_nav.showIconOnly();

        bottom_nav.requestLayout();

        //어플 메인화면
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        //하단네비바 클릭시
        bottom_nav.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this, "주문", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                if(itemIndex == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                }else if(itemIndex == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                }else if(itemIndex == 2) {
                    Toast.makeText(MainActivity.this, "내정보", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyinfoFragment()).commit();
                }else {
                    Toast.makeText(MainActivity.this, "더보기", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });
    }

    @Override
    protected  void onSaveInstanceState( Bundle outState) {
        super . onSaveInstanceState(outState);
        bottom_nav . onSaveInstanceState(outState);
    }

}