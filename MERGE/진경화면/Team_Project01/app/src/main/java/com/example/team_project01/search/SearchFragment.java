package com.example.team_project01.search;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.team_project01.MainActivity;
import com.example.team_project01.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchFragment extends Fragment {

    SearchView searchview;
    TextView tv_search_cancel;
    ListView search_listview;
    LinearLayout layout_category;
    RecyclerView recv_search;

    public ArrayList<SearchDTO> searchList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        searchview = v.findViewById(R.id.searchview);
        tv_search_cancel = v.findViewById(R.id.tv_search_cancel);
        search_listview = v.findViewById(R.id.search_listview);
        layout_category = v.findViewById(R.id.layout_category);
        recv_search = v.findViewById(R.id.recv_search);

        search();
        searching();
        return v;
    }

    //기본 검색창
    public void search() {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("한식", "양식", R.drawable.black, R.drawable.black));
        list.add(new CategoryDTO("중식", "일식", R.drawable.black, R.drawable.black));
        list.add(new CategoryDTO("분식", "아시안", R.drawable.black, R.drawable.black));
        list.add(new CategoryDTO("패스트푸드", "카페", R.drawable.black, R.drawable.black));
        list.add(new CategoryDTO("브런치", "뷔페", R.drawable.black, R.drawable.black));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        CategoryAdapter adapter = new CategoryAdapter(getLayoutInflater(), list);
        recv_search.setLayoutManager(layoutManager);
        recv_search.setAdapter(adapter);
    }

    //검색어 입력중
    public void searching() {
        searchList.add(new SearchDTO("교촌치킨"));
        searchList.add(new SearchDTO("떡볶이"));
        searchList.add(new SearchDTO("신전떡볶이"));
        searchList.add(new SearchDTO("초밥"));
        searchList.add(new SearchDTO("네네치킨"));
        searchList.add(new SearchDTO("푸라닭치킨"));
        searchList.add(new SearchDTO("아주커치킨"));
        searchList.add(new SearchDTO("동대문엽기떡볶이"));
        searchList.add(new SearchDTO("자매떡볶이"));

        searchview.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_search_cancel.setVisibility(View.VISIBLE);

                tv_search_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        search_listview.setVisibility(View.GONE);
                        layout_category.setVisibility(View.VISIBLE);
                        search();
                    }
                });

                searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        ArrayList<SearchDTO> filterSearch = new ArrayList<>();
                        for (int i = 0; i < searchList.size(); i++) {
                            SearchDTO dto = searchList. get(i);

                            if (dto.getString().toLowerCase().contains(newText.toLowerCase())) {
                                filterSearch.add(dto);
                            }
                        }//for

                        search_listview.setVisibility(View.VISIBLE);

                        SearchAdapter adapter = new SearchAdapter(filterSearch, getLayoutInflater(), newText);
                        search_listview.setAdapter(adapter);

                        layout_category.setVisibility(View.GONE);
                        return false;
                    }
                });
            }
        });




    }


}