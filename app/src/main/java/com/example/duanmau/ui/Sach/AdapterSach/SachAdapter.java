package com.example.duanmau.ui.Sach.AdapterSach;

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

import com.example.duanmau.Data.Account;
import com.example.duanmau.Data.DataSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.LoaiSach.LoaiSachFragment;
import com.example.duanmau.ui.Sach.AddSach;
import com.example.duanmau.ui.Sach.FixSach;
import com.example.duanmau.ui.Sach.SachFragment;
import com.example.duanmau.ui.TaiKhoan.FixAccount;

import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachHolder> {
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataSach> accountList;
    private Context context;

    public SachAdapter(List<DataSach> accountList, Context context, BookDatabaseHelper bookDatabaseHelper) {
        this.bookDatabaseHelper = bookDatabaseHelper;
        this.accountList = accountList;
        this.context = context;
    }

    @NonNull
    @Override
    public SachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sach,parent,false);

        return new SachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SachHolder holder, final int position) {
        final DataSach account = accountList.get(position);

        holder.tvHoTen.setText(account.tenSach);
        holder.tvSdt.setText(String.valueOf(account.giaBia));
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

                Intent intent = new Intent(context, FixSach.class);
                Bundle bundle = new Bundle();
                bundle.putString("theLoai",account.theLoai);
                bundle.putString("maSach",account.maSach);

                bundle.putString("tenSach",account.tenSach);
                bundle.putString("tacGia",account.tacGia);
                bundle.putString("nhaXuatBan",account.nhaXuatBan);
                bundle.putInt("giaBia",account.giaBia);

                intent.putExtras(bundle);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }
    private void deleteNote(int position) {

        bookDatabaseHelper.deleteSach(accountList.get(position));

        accountList.remove(position);
        SachFragment sachFragment = new SachFragment();
        sachFragment.notifyAdapter();
    }

}
