package com.example.duanmau.ui.HoaDon.AdapterHoaDon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;

public class HoaDonHolder extends RecyclerView.ViewHolder {


    public TextView tvHoTen;
    public TextView tvSdt;
    public ImageView imgDelAccount;




    public HoaDonHolder(@NonNull final View itemView) {
        super(itemView);

        tvHoTen = itemView.findViewById(R.id.tvHoTen);
        tvSdt = itemView.findViewById(R.id.tvSdt);
        imgDelAccount = itemView.findViewById(R.id.imgDelAccount);




    }

}
