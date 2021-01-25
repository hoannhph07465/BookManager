package com.example.duanmau.ui.HoaDon.HoaDonChiTiet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duanmau.Data.DataHoaDonChiTiet;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.HoaDon.AdapterHoaDon.HoaDonAdapter;
import com.example.duanmau.ui.LoaiSach.AddLoaiSach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTiet extends AppCompatActivity {
    private RecyclerView rccView;
    private RecyclerView.LayoutManager layoutManager;
    private BookDatabaseHelper bookDatabaseHelper;
    List<DataHoaDonChiTiet> dataHoaDonChiTietList;
    private  static HoaDonCgiTietAdapter sachAdapter;
    private  String a;
    private FloatingActionButton fab1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);
        rccView = findViewById(R.id.rccView);
        dataHoaDonChiTietList = new ArrayList<>();
        setTitle("Hoa don chi tiet");
        rccView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rccView.setLayoutManager(layoutManager);
        bookDatabaseHelper = new BookDatabaseHelper(this);
        bookDatabaseHelper.createDataBase();
        Intent intent = getIntent();
         a = intent.getStringExtra("key");
        LoadAdapterHoaDon();

        fab1 = findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HoaDonChiTiet.this, ThemHoaDonChiTiet.class);
                intent.putExtra("ab",a);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LoadAdapterHoaDon();
    }

    private void LoadAdapterHoaDon() {
        dataHoaDonChiTietList = bookDatabaseHelper.dataHoaDonChiTietList(a);
        sachAdapter = new HoaDonCgiTietAdapter(dataHoaDonChiTietList,HoaDonChiTiet.this,bookDatabaseHelper);
        rccView.setAdapter(sachAdapter);
        sachAdapter.notifyDataSetChanged();

    }
}
