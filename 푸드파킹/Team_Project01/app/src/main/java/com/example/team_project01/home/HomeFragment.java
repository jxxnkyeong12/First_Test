package com.example.team_project01.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.team_project01.R;
import com.example.team_project01.basket.BasketActivity;
import com.example.team_project01.store.StoreActivity;

public class HomeFragment extends Fragment {

    ImageView imgv_banner, imgv_test, imgv_basket;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        imgv_banner = v.findViewById(R.id.imgv_banner);
        imgv_test = v.findViewById(R.id.imgv_test);
        imgv_basket = v.findViewById(R.id.imgv_basket);


        //장바구니 아이콘 클릭시
        imgv_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BasketActivity.class);
                startActivity(intent);
            }
        });



        //가게 이미지 클릭시
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