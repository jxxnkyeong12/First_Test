package com.example.team_project01.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.team_project01.R;

import java.util.ArrayList;

public class ReserveAdapter extends BaseAdapter {

    ArrayList<TimeDTO> list;
    LayoutInflater inflater;



    public ReserveAdapter(ArrayList<TimeDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.contains(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_time,parent,false);
        GridViewHolder viewHolder = new GridViewHolder(convertView);
        viewHolder.bind(list.get(position));
        return  convertView;
    }

    public class GridViewHolder {
        TextView timetext;

        public  GridViewHolder (View v){
           timetext = v.findViewById(R.id.timetext);
        }

        public void bind(TimeDTO dto) {
            timetext.setText(dto.getTime());
        }
    }

}
