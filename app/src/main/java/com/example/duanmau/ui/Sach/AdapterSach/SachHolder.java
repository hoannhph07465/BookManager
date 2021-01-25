package com.example.duanmau.ui.Sach.AdapterSach;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;

public class SachHolder extends RecyclerView.ViewHolder {


    public TextView tvHoTen;
    public TextView tvSdt;
    public ImageView imgDelAccount;
    public ImageView imgFixAccount;


    public SachHolder(@NonNull final View itemView) {
        super(itemView);

        tvHoTen = itemView.findViewById(R.id.tvHoTen);
        tvSdt = itemView.findViewById(R.id.tvSdt);
        imgDelAccount = itemView.findViewById(R.id.imgDelAccount);
        imgFixAccount = itemView.findViewById(R.id.imgFixAccount);



    }

}
