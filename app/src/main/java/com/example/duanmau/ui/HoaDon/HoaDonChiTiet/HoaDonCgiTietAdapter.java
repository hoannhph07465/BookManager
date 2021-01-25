package com.example.duanmau.ui.HoaDon.HoaDonChiTiet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.DataHoaDon;
import com.example.duanmau.Data.DataHoaDonChiTiet;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.HoaDon.AdapterHoaDon.HoaDonHolder;
import com.example.duanmau.ui.HoaDon.HoaDonFragment;

import java.util.List;

public class HoaDonCgiTietAdapter extends RecyclerView.Adapter<HoaDonChiTietHolder> {
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataHoaDonChiTiet> dataHoaDonChiTietList;
    private Context context;

    public HoaDonCgiTietAdapter(List<DataHoaDonChiTiet> dataHoaDonChiTietList, Context context, BookDatabaseHelper bookDatabaseHelper) {
        this.dataHoaDonChiTietList = dataHoaDonChiTietList;
        this.bookDatabaseHelper = bookDatabaseHelper;
        this.context = context;
    }


    @NonNull
    @Override
    public HoaDonChiTietHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hoadonchitiet,parent,false);

        return new HoaDonChiTietHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoaDonChiTietHolder holder, int position) {
        final DataHoaDonChiTiet dataHoaDonChiTiet = dataHoaDonChiTietList.get(position);
        holder.tvMaHoaDon.setText(dataHoaDonChiTiet.getMaHoaDon());
        holder.tvMaSach.setText(dataHoaDonChiTiet.getMaSach());
        holder.tvSoluong.setText(String.valueOf(dataHoaDonChiTiet.getSoLuong()));
        holder.tvTien.setText(String.valueOf(dataHoaDonChiTiet.getTien()));
    }

    @Override
    public int getItemCount() {
        return dataHoaDonChiTietList.size();
    }
//    private void deleteNote(int position) {
//
//        bookDatabaseHelper.deletecHoaDDon(dataHoaDons.get(position));
//
//        dataHoaDons.remove(position);
//        HoaDonFragment hoaDonFragment = new HoaDonFragment();
//        hoaDonFragment.notifyAdapter();
//    }
}
