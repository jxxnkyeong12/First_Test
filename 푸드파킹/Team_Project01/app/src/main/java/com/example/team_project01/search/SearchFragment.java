package com.example.team_project01.search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.team_project01.R;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    RecyclerView recv_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        recv_search = v.findViewById(R.id.recv_search);

        ArrayList<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("치킨","스파게티", R.drawable.black,  R.drawable.black));
        list.add(new CategoryDTO("짬뽕","떢볶이", R.drawable.black,  R.drawable.black));
        list.add(new CategoryDTO("스테이크","김치찌개", R.drawable.black,  R.drawable.black));
        list.add(new CategoryDTO("족발","피자", R.drawable.black,  R.drawable.black));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        SearchAdapter adapter = new SearchAdapter(inflater, list);
        recv_search.setLayoutManager(layoutManager);
        recv_search.setAdapter(adapter);

        return v;
    }
}