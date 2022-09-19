package com.example.team_project01.myinfo;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.team_project01.R;
import com.example.team_project01.myinfo.modify.ModifyActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyinfoFragment extends Fragment implements View.OnClickListener {

   CircleImageView profile_image, myinfo_orderhistory, myinfo_review;
   CardView myinfo_cardview;
   LinearLayout myinfo_liner, myinfo_modify;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myinfo, container, false);
        profile_image = v.findViewById(R.id.profile_image);
        myinfo_cardview = v.findViewById(R.id.myinfo_cardview);
        myinfo_liner = v.findViewById(R.id.myinfo_liner);
        myinfo_orderhistory = v.findViewById(R.id.myinfo_orderhistory);
        myinfo_review = v.findViewById(R.id.myinfo_review);
        myinfo_modify = v.findViewById(R.id.myinfo_modify);


        myinfo_modify.setOnClickListener(this);
        myinfo_orderhistory.setOnClickListener(this);
        myinfo_review.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() ==R.id.myinfo_modify){
            Intent intent = new Intent(getContext(), ModifyActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.myinfo_orderhistory){
            Intent intent = new Intent(getContext(), OrderHistoryActivity.class);
            startActivity(intent);
        }else if (v.getId() ==R.id.myinfo_review){
            Intent intent = new Intent(getContext(), LikeActivity.class);
            startActivity(intent);
        }
    }
}