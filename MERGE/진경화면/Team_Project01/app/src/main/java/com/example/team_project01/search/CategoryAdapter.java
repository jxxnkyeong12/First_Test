package com.example.team_project01.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.team_project01.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<CategoryDTO> list;

    public CategoryAdapter(LayoutInflater inflater, ArrayList<CategoryDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgv_category1, imgv_category2;
        TextView tv_category1, tv_category2;

        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_category1 = v.findViewById(R.id.imgv_category1);
            imgv_category2 = v.findViewById(R.id.imgv_category2);
            tv_category1 = v.findViewById(R.id.tv_category1);
            tv_category2 = v.findViewById(R.id.tv_category2);

        }

        public void bind(@NonNull ViewHolder vh, int i) {
            vh.imgv_category1.setImageResource(list.get(i).getImgv_category1());
            vh.imgv_category2.setImageResource(list.get(i).getImgv_category2());
            vh.tv_category1.setText(list.get(i).getTv_category1());
            vh.tv_category2.setText(list.get(i).getTv_category2());
        }
    }
}