package com.example.team_project01.order;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.team_project01.ListActivity;
import com.example.team_project01.R;
import com.example.team_project01.common.MapActivity;


public class OrderFragment extends Fragment {
    CardView order, order_pack;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.fragment_order, container, false);
            order = v.findViewById(R.id.order);
            order_pack = v.findViewById(R.id.order_pack);



            order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(inflater.getContext(), ListActivity.class);
                    startActivity(intent);
                }
            });


            //지도 위치 보려고 임시적으로 여기서 확임함!!! 나중에 지울 예정 -- jk 2022/9/17
            order_pack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(inflater.getContext(), MapActivity.class);
                    startActivity(intent);
                }
            });

        return v;
    }
}