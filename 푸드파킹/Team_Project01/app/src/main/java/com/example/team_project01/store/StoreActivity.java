package com.example.team_project01.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.team_project01.MainActivity;
import com.example.team_project01.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;

public class StoreActivity extends AppCompatActivity {

    TabLayout tab_store;
    Toolbar store_toolbar;
    RecyclerView recv_store_menu;
    View layout_store_info;
    LinearLayout layout_store_tab_info, layout_store_tab_review;
    Spinner store_spinner;
    TextView store_tv_spinner;

    String[] items = {"최신순", "평점 높은 순", "평점 낮은 순"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        tab_store = findViewById(R.id.tab_store);
        store_toolbar = findViewById(R.id.store_toolbar);
        recv_store_menu = findViewById(R.id.recv_store_menu);
        layout_store_info = findViewById(R.id.layout_store_info);
        layout_store_tab_info = findViewById(R.id.layout_store_tab_info);
        layout_store_tab_review = findViewById(R.id.layout_store_tab_review);
        store_spinner = findViewById(R.id.store_spinner);
        store_tv_spinner = findViewById(R.id.store_tv_spinner);

        setSupportActionBar(store_toolbar);

        //기본화면
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoreActivity.this, RecyclerView.VERTICAL, false);
        StoreMenuAdapter adapter = new StoreMenuAdapter(menu_list(), getLayoutInflater());
        recv_store_menu.setLayoutManager(layoutManager);
        recv_store_menu.setAdapter(adapter);

        recv_store_menu.setVisibility(View.VISIBLE);
        layout_store_tab_info.setVisibility(View.GONE);
        layout_store_tab_review.setVisibility(View.GONE);


        //탭
        tab_store.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position =  tab.getPosition();
                if(position == 0) {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoreActivity.this, RecyclerView.VERTICAL, false);
                    StoreMenuAdapter adapter = new StoreMenuAdapter(menu_list(), getLayoutInflater());
                    recv_store_menu.setLayoutManager(layoutManager);
                    recv_store_menu.setAdapter(adapter);

                    recv_store_menu.setVisibility(View.VISIBLE);
                    layout_store_tab_info.setVisibility(View.GONE);
                    layout_store_tab_review.setVisibility(View.GONE);

                }else if(position == 1) {
                    recv_store_menu.setVisibility(View.GONE);
                    layout_store_tab_info.setVisibility(View.VISIBLE);
                    layout_store_tab_review.setVisibility(View.GONE);

                }else {
                    spinner();

                    recv_store_menu.setVisibility(View.GONE);
                    layout_store_tab_info.setVisibility(View.GONE);
                    layout_store_tab_review.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position =  tab.getPosition();
                if(position == 0) {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoreActivity.this, RecyclerView.VERTICAL, false);
                    StoreMenuAdapter adapter = new StoreMenuAdapter(menu_list(), getLayoutInflater());
                    recv_store_menu.setLayoutManager(layoutManager);
                    recv_store_menu.setAdapter(adapter);

                    recv_store_menu.setVisibility(View.VISIBLE);
                    layout_store_tab_info.setVisibility(View.GONE);
                    layout_store_tab_review.setVisibility(View.GONE);

                }else if(position == 1) {
                    recv_store_menu.setVisibility(View.GONE);
                    layout_store_tab_info.setVisibility(View.VISIBLE);
                    layout_store_tab_review.setVisibility(View.GONE);

                }else {
                    spinner();

                    recv_store_menu.setVisibility(View.GONE);
                    layout_store_tab_info.setVisibility(View.GONE);

                    layout_store_tab_review.setVisibility(View.VISIBLE);

                }
            }
        });

        //뒤로가기
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //뒤로가기 버튼 활성화
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //스피너
    public void spinner() {
        ArrayAdapter<String> sp_adapter = new ArrayAdapter<String>(
                StoreActivity.this, R.layout.support_simple_spinner_dropdown_item, items
        );

        sp_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        store_spinner.setAdapter(sp_adapter);
        store_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                store_tv_spinner.setText(items[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                store_tv_spinner.setText(items[0]);
            }
        });
    }

    //탭 - 메뉴
    public ArrayList<StoreMenuDTO> menu_list() {
        ArrayList<StoreMenuDTO> list = new ArrayList<>();
        list.add(new StoreMenuDTO(R.drawable.black, "순희비빔밥", "8000원"));
        list.add(new StoreMenuDTO(R.drawable.black, "열무비빔밥", "9000원"));
        list.add(new StoreMenuDTO(R.drawable.black, "순희비빔밥", "8000원"));
        list.add(new StoreMenuDTO(R.drawable.black, "열무비빔밥", "9000원"));
        list.add(new StoreMenuDTO(R.drawable.black, "순희비빔밥", "8000원"));
        list.add(new StoreMenuDTO(R.drawable.black, "열무비빔밥", "9000원"));

        return list;
    }
}