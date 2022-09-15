package com.example.team_project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.team_project01.home.HomeFragment;
<<<<<<< HEAD
import com.example.team_project01.more.MoreFragment;
=======
import com.example.team_project01.myinfo.MyinfoFragment;
import com.example.team_project01.order.OrderFragment;
>>>>>>> 95cbb656e26a6320a9a4847078cf46ddcbbb13c4
import com.example.team_project01.search.SearchFragment;
import com.example.team_project01.store.StoreActivity;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    FrameLayout main_container;
    SpaceNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_container = findViewById(R.id.main_container);
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
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();

        //하단네비바 클릭시
        bottom_nav.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new OrderFragment()).commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                if(itemIndex == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
                }else if(itemIndex == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new SearchFragment()).commit();
                }else if(itemIndex == 2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new MyinfoFragment()).commit();
                }else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new MoreFragment()).commit();
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