package com.example.team_project01.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.team_project01.MainActivity;
import com.example.team_project01.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    TabLayout tab_store;
    Toolbar store_toolbar;
    RecyclerView recv_store_menu;
    View layout_store_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        tab_store = findViewById(R.id.tab_store);
        store_toolbar = findViewById(R.id.store_toolbar);
        recv_store_menu = findViewById(R.id.recv_store_menu);
        layout_store_info = findViewById(R.id.layout_store_info);

        setSupportActionBar(store_toolbar);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoreActivity.this, RecyclerView.VERTICAL, false);
        StoreMenuAdapter adapter = new StoreMenuAdapter(menu_list(), getLayoutInflater());
        recv_store_menu.setLayoutManager(layoutManager);
        recv_store_menu.setAdapter(adapter);

        tab_store.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position =  tab.getPosition();
                if(position == 0) {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoreActivity.this, RecyclerView.VERTICAL, false);
                    StoreMenuAdapter adapter = new StoreMenuAdapter(menu_list(), getLayoutInflater());
                    recv_store_menu.setLayoutManager(layoutManager);
                    recv_store_menu.setAdapter(adapter);

                }else if(position == 1) {
                    Toast.makeText(StoreActivity.this, "준비 중", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(StoreActivity.this, "준비 중", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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