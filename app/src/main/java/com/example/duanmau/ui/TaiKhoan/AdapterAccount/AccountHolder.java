package com.example.duanmau.ui.TaiKhoan.AdapterAccount;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;
import com.example.duanmau.ui.TaiKhoan.FixAccount;
import com.example.duanmau.ui.TaiKhoan.TaiKhoanFragment;

public class AccountHolder extends RecyclerView.ViewHolder {

    public final TextView tvHoTen;
    public final  TextView tvSdt;
    public ImageView imgDelAccount;
    public ImageView imgFixAccount;





    public AccountHolder(@NonNull final View itemView) {
        super(itemView);

        tvHoTen = itemView.findViewById(R.id.tvHoTen);
        tvSdt = itemView.findViewById(R.id.tvSdt);

        imgDelAccount = itemView.findViewById(R.id.imgDelAccount);
        imgFixAccount = itemView.findViewById(R.id.imgFixAccount);



    }

}
