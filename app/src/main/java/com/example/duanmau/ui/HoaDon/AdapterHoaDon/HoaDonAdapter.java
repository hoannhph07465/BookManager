package com.example.duanmau.ui.HoaDon.AdapterHoaDon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.DataHoaDon;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.HoaDon.HoaDonChiTiet.HoaDonChiTiet;
import com.example.duanmau.ui.HoaDon.HoaDonFragment;

import java.util.List;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonHolder> {
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataHoaDon> dataHoaDons;
    private Context context;

    public HoaDonAdapter(List<DataHoaDon> dataHoaDons, Context context,BookDatabaseHelper bookDatabaseHelper) {
        this.dataHoaDons = dataHoaDons;
        this.bookDatabaseHelper = bookDatabaseHelper;
        this.context = context;
    }

    @NonNull
    @Override
    public HoaDonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hoadon,parent,false);

        return new HoaDonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HoaDonHolder holder, final int position) {
        final DataHoaDon dataHoaDon = dataHoaDons.get(position);

        holder.tvHoTen.setText(dataHoaDon.maHoaDon);
        holder.tvSdt.setText(String.valueOf(dataHoaDon.ngay));
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HoaDonChiTiet.class);
                intent.putExtra("key",dataHoaDon.maHoaDon);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return dataHoaDons.size();
    }
    private void deleteNote(int position) {

        bookDatabaseHelper.deletecHoaDDon(dataHoaDons.get(position));

        dataHoaDons.remove(position);
        HoaDonFragment hoaDonFragment = new HoaDonFragment();
        hoaDonFragment.notifyAdapter();
    }
}
