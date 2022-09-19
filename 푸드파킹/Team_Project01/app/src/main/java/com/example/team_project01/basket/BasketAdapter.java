package com.example.team_project01.basket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.team_project01.R;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder>{
    LayoutInflater inflater;

    public BasketAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_basket_recv, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imag_plus, imag_min;
        TextView tv_menu_cnt;
        int menu_cnt = 1;
        public ViewHolder(@NonNull View v) {
            super(v);
            imag_min = v.findViewById(R.id.imag_min);
            imag_plus = v.findViewById(R.id.imag_plus);
            tv_menu_cnt = v.findViewById(R.id.tv_menu_cnt);

            imag_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    menu_cnt++;
                    tv_menu_cnt.setText(menu_cnt+"");
                }
            });

            imag_min.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (menu_cnt > 1) {
                        menu_cnt--;
                        tv_menu_cnt.setText(menu_cnt+"");
                    }
                }
            });
        }
    }
}
