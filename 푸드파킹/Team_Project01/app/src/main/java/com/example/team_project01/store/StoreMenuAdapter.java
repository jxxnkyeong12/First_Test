package com.example.team_project01.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.team_project01.R;

import java.util.ArrayList;

public class StoreMenuAdapter extends RecyclerView.Adapter<StoreMenuAdapter.ViewHolder> {

    ArrayList<StoreMenuDTO> list;
    LayoutInflater inflater;

    public StoreMenuAdapter(ArrayList<StoreMenuDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_store_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_menu_image;
        TextView tv_menu_name, tv_menu_price;

        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_menu_image = v.findViewById(R.id.imgv_menu_image);
            tv_menu_name = v.findViewById(R.id.tv_menu_name);
            tv_menu_price = v.findViewById(R.id.tv_menu_price);

        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.imgv_menu_image.setImageResource(list.get(i).getImgv_menu_image());
            h.tv_menu_name.setText(list.get(i).getTv_menu_name());
            h.tv_menu_price.setText(list.get(i).getTv_menu_price());
        }
    }
}