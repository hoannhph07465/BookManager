package com.example.duanmau.ui.HoaDon.HoaDonChiTiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duanmau.Data.DataHoaDon;
import com.example.duanmau.Data.DataHoaDonChiTiet;
import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.Sach.SpinerAdapetLoaiSach;

import java.util.ArrayList;
import java.util.List;

public class ThemHoaDonChiTiet extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtMaHoaDon;
    private Spinner Spiner;
    private EditText edtsoLuong;
    private Button btnSave;
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataLoaiSach> dataLoaiSaches;
    private SpinerAdapetLoaiSach spinerAdapetLoaiSach;
    private  String maHoaDon;
    private String spiner;
    private  String a;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don_chi_tiet);
        toolbar = findViewById(R.id.toolbar);
        edtMaHoaDon = findViewById(R.id.edtMaHoaDon);
        Spiner = findViewById(R.id.Spiner);
        edtsoLuong = findViewById(R.id.edtsoLuong);
        btnSave = findViewById(R.id.btnSave);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        dataLoaiSaches = new ArrayList<>();
        bookDatabaseHelper = new BookDatabaseHelper(this);
        dataLoaiSaches = bookDatabaseHelper.dataSachListBook();
        Intent intent = getIntent();
        a = intent.getStringExtra("ab");


        Bundle bundle = getIntent().getExtras();
        maHoaDon = bundle.getString("maHoaDon");


        if (maHoaDon == null){
            edtMaHoaDon.setText(a);
        }else {
            edtMaHoaDon.setText(maHoaDon);
        }

        spinerAdapetLoaiSach = new SpinerAdapetLoaiSach(this, R.layout.item_spinner_loaithu, dataLoaiSaches);
        Spiner.setAdapter(spinerAdapetLoaiSach);
        spinerAdapetLoaiSach.notifyDataSetChanged();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertHoaDon();
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aaa, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            finish();
        }
        return true;
    }

    public void insertHoaDon() {
        DataHoaDonChiTiet dataHoaDonChiTiet = new DataHoaDonChiTiet();
        if (maHoaDon == null){
            dataHoaDonChiTiet.setMaHoaDon(a);
        }else {
            dataHoaDonChiTiet.setMaHoaDon(maHoaDon);
        }

        spiner = Spiner.getSelectedItem().toString();
        dataHoaDonChiTiet.setMaSach(spiner);
        dataHoaDonChiTiet.setSoLuong(Integer.parseInt(edtsoLuong.getText().toString()));
        double tien  = Integer.parseInt(edtsoLuong.getText().toString()) * 1500;
        dataHoaDonChiTiet.setTien(tien);
        BookDatabaseHelper bookDatabaseHelper = new BookDatabaseHelper(this);
        bookDatabaseHelper.insertHoaDonChiTiet(dataHoaDonChiTiet);

    }
}
