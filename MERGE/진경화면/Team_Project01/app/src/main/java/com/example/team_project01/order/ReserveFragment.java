package com.example.team_project01.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.team_project01.R;

import java.util.ArrayList;


public class ReserveFragment extends Fragment {

    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v =  inflater.inflate(R.layout.fragment_reserve, container, false);
        gridView = v.findViewById(R.id.gridview);

        ArrayList<TimeDTO> list = new ArrayList<>();

        list.add(new TimeDTO("10:00"));
        list.add(new TimeDTO("10:30"));
        list.add(new TimeDTO("11:00"));
        list.add(new TimeDTO("12:00"));
        list.add(new TimeDTO("01:00"));
        list.add(new TimeDTO("02:00"));
        list.add(new TimeDTO("02:30"));
        list.add(new TimeDTO("03:00"));
        list.add(new TimeDTO("04:00"));
        list.add(new TimeDTO("05:00"));
        list.add(new TimeDTO("06:00"));
        list.add(new TimeDTO("07:00"));
        list.add(new TimeDTO("08:00"));




        ReserveAdapter adapter = new ReserveAdapter(list, inflater);
        gridView.setAdapter(adapter);

        return v;
    }
}