package com.example.team_project01.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.team_project01.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    RecyclerView recv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recv_list = findViewById(R.id.recv_list);

        //리스트에 가게 정보 임의로 넣음
        ArrayList<ListDTO>  list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.spaghetti, "한식1", "성범비빔밥1", "5.0(999)+", "5km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식2", "성범비빔밥2", "4.0(999)+", "4km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식3", "성범비빔밥3", "3.0(999)+", "3km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식4", "성범비빔밥4", "2.0(999)+", "2km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식5", "성범비빔밥5", "1.0(999)+", "1km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식6", "성범비빔밥6", "5.0(999)+", "6km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식7", "성범비빔밥7", "4.0(999)+", "7km(농성동)"));
        list.add(new ListDTO(R.drawable.spaghetti, "한식8", "성범비빔밥8", "3.0(999)+", "8km(농성동)"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getLayoutInflater().getContext(), RecyclerView.VERTICAL, false);
        ListAdapter adapter = new ListAdapter(getLayoutInflater() , list);

        recv_list.setLayoutManager(layoutManager);
        recv_list.setAdapter(adapter);
    }
}