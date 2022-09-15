package com.example.team_project01.more;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.team_project01.R;

import java.util.ArrayList;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<MoreCategoryDTO> list;

    public MoreAdapter(LayoutInflater inflater, ArrayList<MoreCategoryDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_more_recv, parent, false);
        return new ViewHolder(v);
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
        TextView tv_more;
        ImageView img_more;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_more = v.findViewById(R.id.tv_more);
            img_more = v.findViewById(R.id.img_more);

        }
        public void bind(@NonNull ViewHolder holder, int position){
                tv_more.setText(list.get(position).getTv_more());
                img_more.setImageResource(list.get(position).getImg_more());
        }
    }
}
