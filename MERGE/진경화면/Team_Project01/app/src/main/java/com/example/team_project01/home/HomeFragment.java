package com.example.team_project01.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.team_project01.R;
import com.example.team_project01.common.MapActivity;
import com.example.team_project01.store.StoreActivity;

public class HomeFragment extends Fragment {

    ImageView imgv_banner, imgv_test;
    TextView tv_home_address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        imgv_banner = v.findViewById(R.id.imgv_banner);
        imgv_test = v.findViewById(R.id.imgv_test);
        tv_home_address = v.findViewById(R.id.tv_home_address);

        tv_home_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        /* 임시로 연결 삭제 예정 */
        imgv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StoreActivity.class);
                startActivity(intent);
            }
        });



        return v;
    }
}