package com.example.team_project01.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.team_project01.R;

public class HomeFragment extends Fragment {

    ImageView imgv_banner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        imgv_banner = v.findViewById(R.id.imgv_banner);




        return v;
    }
}