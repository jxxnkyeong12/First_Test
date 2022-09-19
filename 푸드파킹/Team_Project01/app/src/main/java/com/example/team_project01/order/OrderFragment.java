package com.example.team_project01.order;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.team_project01.R;
import com.example.team_project01.list.ListActivity;


public class OrderFragment extends Fragment {
    CardView order;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.fragment_order, container, false);
            order = v.findViewById(R.id.order);

            order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ListActivity.class);
                    startActivity(intent);
                }
            });
        return v;
    }
}