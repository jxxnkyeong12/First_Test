package com.example.team_project01.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.team_project01.R;

import java.util.ArrayList;


public class MoreFragment extends Fragment {
    RecyclerView more_recv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_more, container, false);

        more_recv = v.findViewById(R.id.more_recv);

        ArrayList<MoreCategoryDTO> list = new ArrayList<>();
        list.add(new MoreCategoryDTO(R.drawable.loudspeaker, "공지사항"));
        list.add(new MoreCategoryDTO(R.drawable.settings, "앱 설정"));
        list.add(new MoreCategoryDTO(R.drawable.call_agent, "고객센터"));
        list.add(new MoreCategoryDTO(R.drawable.page, "약관 및 정책"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        MoreAdapter adapter = new MoreAdapter(inflater, list);

        more_recv.setLayoutManager(layoutManager);
        more_recv.setAdapter(adapter);

        return v;
    }



}