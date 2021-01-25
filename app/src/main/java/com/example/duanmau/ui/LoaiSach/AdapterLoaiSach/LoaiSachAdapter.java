package com.example.duanmau.ui.LoaiSach.AdapterLoaiSach;

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

import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.LoaiSach.AddLoaiSach;
import com.example.duanmau.ui.LoaiSach.FixLoaiSach;
import com.example.duanmau.ui.LoaiSach.LoaiSachFragment;
import com.example.duanmau.ui.TaiKhoan.TaiKhoanFragment;

import java.util.List;

public class LoaiSachAdapter extends RecyclerView.Adapter<LoaiSachHolder> {
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataLoaiSach> dataLoaiSaches;
    private Context context;

    public LoaiSachAdapter(List<DataLoaiSach> dataLoaiSaches, Context context, BookDatabaseHelper bookDatabaseHelper) {
        this.bookDatabaseHelper = bookDatabaseHelper;
        this.dataLoaiSaches = dataLoaiSaches;
        this.context = context;
    }

    @NonNull
    @Override
    public LoaiSachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_loaisach,parent,false);

        return new LoaiSachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LoaiSachHolder holder, final int position) {
        final DataLoaiSach account = dataLoaiSaches.get(position);

        holder.tvHoTen.setText(account.tenLoaiSach);
        holder.tvSdt.setText(String.valueOf(account.moTa));
        holder.imgDelAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có muốn xóa không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteNote(position);
                        Toast.makeText(context,"Delete",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        holder.imgFixAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, FixLoaiSach.class);
                Bundle bundle = new Bundle();

                bundle.putString("maLoaiSach",account.maLoaiSach);
                bundle.putString("tenLoaiSach",account.tenLoaiSach);
                bundle.putString("viTri",account.viTri);
                bundle.putString("moTa",account.moTa);


                intent.putExtras(bundle);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return dataLoaiSaches.size();
    }

    private void deleteNote(int position) {

        bookDatabaseHelper.deletecLoaiSach(dataLoaiSaches.get(position));

        dataLoaiSaches.remove(position);
        LoaiSachFragment loaiSachFragment = new LoaiSachFragment();
        loaiSachFragment.notifyAdapter();
    }
}
