package com.example.duanmau.ui.TaiKhoan.AdapterAccount;

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
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.TaiKhoan.FixAccount;
import com.example.duanmau.ui.TaiKhoan.TaiKhoanFragment;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountHolder> {
    private BookDatabaseHelper  bookDatabaseHelper;
    private List<Account> accountList;
    private Context context;

    public AccountAdapter(List<Account> accountList, Context context, BookDatabaseHelper bookDatabaseHelper) {
        this.accountList = accountList;
        this.bookDatabaseHelper = bookDatabaseHelper;
        this.context = context;
    }

    @NonNull
    @Override
    public AccountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_account,parent,false);

        return new AccountHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AccountHolder holder, final int position) {
        final Account account = accountList.get(position);

        holder.tvHoTen.setText(account.hoTen);
        holder.tvSdt.setText(account.soDIenThoai);
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

                Intent intent = new Intent(context, FixAccount.class);
                Bundle bundle = new Bundle();
                bundle.putString("taiKhoan",account.tenTaiKHoan);
                bundle.putString("Name",account.hoTen);
                bundle.putString("soDienThoai",account.soDIenThoai);
                bundle.putString("diaChi",account.diaChi);
                bundle.putString("matKhau",account.matKhau);
                bundle.putInt("position",position);
                intent.putExtra("lable", account.hoTen);

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

        bookDatabaseHelper.deletecAcount(accountList.get(position));

        accountList.remove(position);
        TaiKhoanFragment taiKhoanFragment = new TaiKhoanFragment();
        taiKhoanFragment.notifyAdapter();
    }


}
