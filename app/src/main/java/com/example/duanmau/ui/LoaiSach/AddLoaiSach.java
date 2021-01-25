package com.example.duanmau.ui.LoaiSach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;

public class AddLoaiSach extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtMaLoaiSach;
    private EditText edtTenLoaiSach;
    private EditText edtViTri;
    private EditText edtMoTa;
    private Button btnSave;
    private Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loai_sach);
        toolbar = findViewById(R.id.toolbar);
        edtMaLoaiSach = findViewById(R.id.edtMaLoaiSach);
        edtTenLoaiSach = findViewById(R.id.edtTenLoaiSach);
        edtViTri = findViewById(R.id.edtViTri);
        edtMoTa = findViewById(R.id.edtMoTa);
        btnSave = findViewById(R.id.btnSave);
        btnExit = findViewById(R.id.btnExit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertLoaiSach();
                Toast.makeText(AddLoaiSach.this, "Them thanh cong", Toast.LENGTH_LONG).show();
                finish();

            }
        });

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

            insertLoaiSach();

            Toast.makeText(this, "Them thanh cong", Toast.LENGTH_LONG).show();
            finish();

        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }

    public void insertLoaiSach() {
        DataLoaiSach dataLoaiSach = new DataLoaiSach();
        dataLoaiSach.setMaLoaiSach(edtMaLoaiSach.getText().toString());
        dataLoaiSach.setTenLoaiSach(edtTenLoaiSach.getText().toString());
        dataLoaiSach.setViTri(edtViTri.getText().toString());
        dataLoaiSach.setMoTa(edtMoTa.getText().toString());

        BookDatabaseHelper bookDatabaseHelper = new BookDatabaseHelper(this);
        bookDatabaseHelper.insertLoaiSach(dataLoaiSach);

    }
}
