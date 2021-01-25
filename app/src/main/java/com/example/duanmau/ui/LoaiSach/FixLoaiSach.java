package com.example.duanmau.ui.LoaiSach;

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
import android.widget.Toast;

import com.example.duanmau.Data.Account;
import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.TaiKhoan.FixAccount;
import com.example.duanmau.ui.TaiKhoan.TaiKhoanFragment;

import java.util.ArrayList;
import java.util.List;

public class FixLoaiSach extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtMaLoaiSach;
    private EditText edtTenLoaiSach;
    private EditText edtViTri;
    private EditText edtMoTa;
    private Button btnExit;




    List<DataLoaiSach> dataLoaiSaches = new ArrayList<>();
    private BookDatabaseHelper bookDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_loai_sach);
        toolbar = findViewById(R.id.toolbar);
        edtMaLoaiSach = findViewById(R.id.edtMaLoaiSach);
        edtTenLoaiSach = findViewById(R.id.edtTenLoaiSach);
        edtViTri = findViewById(R.id.edtViTri);
        edtMoTa = findViewById(R.id.edtMoTa);
        btnExit = findViewById(R.id.btnExit);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        setTitle("Sửa loại sách");
        Bundle bundle = getIntent().getExtras();
        String maLoaiSach = bundle.getString("maLoaiSach");
        String tenLoaiSach = bundle.getString("tenLoaiSach");
        String viTri = bundle.getString("viTri");
        String moTa = bundle.getString("moTa");
        edtMaLoaiSach.setText(maLoaiSach);
        edtTenLoaiSach.setText(tenLoaiSach);
        edtViTri.setText(viTri);
        edtMoTa.setText(moTa);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_sach, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itSave) {
            bookDatabaseHelper = new BookDatabaseHelper(this);
            dataLoaiSaches.addAll(bookDatabaseHelper.dataSachListBook());
            DataLoaiSach dataLoaiSach = new DataLoaiSach();
            dataLoaiSach.setMaLoaiSach(edtMaLoaiSach.getText().toString());
            dataLoaiSach.setTenLoaiSach(edtTenLoaiSach.getText().toString());
            dataLoaiSach.setViTri(edtViTri.getText().toString());
            dataLoaiSach.setMoTa(edtMoTa.getText().toString());

            bookDatabaseHelper.updateLoaiSach(dataLoaiSach);
            TaiKhoanFragment.notifyAdapter();


            Toast.makeText(FixLoaiSach.this, "Sua thanh cong", Toast.LENGTH_LONG).show();
            finish();

        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }
}
