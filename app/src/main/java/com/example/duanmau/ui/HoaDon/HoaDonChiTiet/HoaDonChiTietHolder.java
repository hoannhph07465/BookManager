package com.example.duanmau.ui.HoaDon.HoaDonChiTiet;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;

public class HoaDonChiTietHolder extends RecyclerView.ViewHolder {

    public TextView tvMaHoaDon;
    public TextView tvMaSach;
    public TextView tvSoluong;
    public TextView tvTien;













    public HoaDonChiTietHolder(@NonNull final View itemView) {
        super(itemView);
        tvMaHoaDon = itemView.findViewById(R.id.tvMaHoaDon);
        tvMaSach = itemView.findViewById(R.id.tvMaSach);
        tvSoluong = itemView.findViewById(R.id.tvSoluong);
        tvTien = itemView.findViewById(R.id.tvTien);




    }

}
