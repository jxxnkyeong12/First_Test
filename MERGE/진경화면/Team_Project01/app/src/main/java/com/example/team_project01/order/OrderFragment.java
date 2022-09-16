package com.example.team_project01.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.team_project01.MainActivity;
import com.example.team_project01.R;


public class OrderFragment extends Fragment implements View.OnClickListener {

   CardView order_reserve;
   ImageView order_test;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);

       order_reserve = v.findViewById(R.id.order_reserve);
          v.findViewById(R.id.order_test);
       order_reserve.setOnClickListener(this);



        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.order_reserve){
            Intent intent = new Intent(getContext(), ReserveActivity.class);
            startActivity(intent);
            Log.d("TAG", "onClick: 여기 찍히나");
        }
    }
}