package com.example.duanmau.ui.Sach.AdapterTopSach;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;

public class TopSachHolder extends RecyclerView.ViewHolder {


    public TextView tvHoTen;
    public TextView tvSdt;



    public TopSachHolder(@NonNull final View itemView) {
        super(itemView);

        tvHoTen = itemView.findViewById(R.id.tvHoTen);
        tvSdt = itemView.findViewById(R.id.tvSdt);




    }

}
