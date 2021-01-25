package com.example.duanmau.ui.Sach.AdapterTopSach;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.DataSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.Sach.FixSach;
import com.example.duanmau.ui.Sach.SachFragment;

import java.util.List;

public class TopSachAdapter extends RecyclerView.Adapter<TopSachHolder> {
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataSach> accountList;
    private Context context;

    public TopSachAdapter(List<DataSach> accountList, Context context, BookDatabaseHelper bookDatabaseHelper) {
        this.bookDatabaseHelper = bookDatabaseHelper;
        this.accountList = accountList;
        this.context = context;
    }

    @NonNull
    @Override
    public TopSachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_sach,parent,false);

        return new TopSachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TopSachHolder holder, final int position) {
        final DataSach account = accountList.get(position);

        holder.tvHoTen.setText(account.tenSach);
        holder.tvSdt.setText(String.valueOf(account.giaBia));


    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }


}
