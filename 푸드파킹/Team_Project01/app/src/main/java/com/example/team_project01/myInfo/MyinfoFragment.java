package com.example.team_project01.myinfo;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.team_project01.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyinfoFragment extends Fragment {

   CircleImageView profile_image;
   CardView myinfo_cardview;
   LinearLayout myinfo_liner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myinfo, container, false);
        profile_image = v.findViewById(R.id.profile_image);
        myinfo_cardview = v.findViewById(R.id.myinfo_cardview);
        myinfo_liner = v.findViewById(R.id.myinfo_liner);




        return v;
    }
}