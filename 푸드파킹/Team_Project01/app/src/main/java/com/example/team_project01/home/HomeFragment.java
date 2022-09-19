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
<<<<<<< HEAD
import com.example.team_project01.basket.BasketActivity;
=======
import com.example.team_project01.common.MapActivity;
>>>>>>> 95e4f0142e34009fde8bd84a5a4da3b519926899
import com.example.team_project01.store.StoreActivity;

public class HomeFragment extends Fragment {

<<<<<<< HEAD
    ImageView imgv_banner, imgv_test, imgv_basket;
=======
    ImageView imgv_banner, imgv_test;
    TextView tv_home_address;
>>>>>>> 95e4f0142e34009fde8bd84a5a4da3b519926899

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        imgv_banner = v.findViewById(R.id.imgv_banner);
        imgv_test = v.findViewById(R.id.imgv_test);
<<<<<<< HEAD
        imgv_basket = v.findViewById(R.id.imgv_basket);


        //장바구니 아이콘 클릭시
        imgv_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BasketActivity.class);
=======
        tv_home_address = v.findViewById(R.id.tv_home_address);

        tv_home_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapActivity.class);
>>>>>>> 95e4f0142e34009fde8bd84a5a4da3b519926899
                startActivity(intent);
            }
        });

<<<<<<< HEAD


        //가게 이미지 클릭시
=======
        /* 임시로 연결 삭제 예정 */
>>>>>>> 95e4f0142e34009fde8bd84a5a4da3b519926899
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