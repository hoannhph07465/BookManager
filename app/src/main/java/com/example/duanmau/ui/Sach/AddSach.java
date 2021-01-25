package com.example.duanmau.ui.Sach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.Data.DataSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class AddSach extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtTheLoai;
    private Spinner Spiner;
    private EditText edtTenSach;
    private EditText edtTacGia;
    private EditText edtNhaXuatBan;
    private EditText edtGiaBia;

    private TextInputLayout textInTheLoai;
    private TextInputLayout textInTenSach;
    private TextInputLayout textInTacGia;
    private TextInputLayout textInNhaXuatBan;


    private SpinerAdapetLoaiSach spinerAdapetLoaiSach;
    private List<DataLoaiSach> dataLoaiSaches;
    private BookDatabaseHelper bookDatabaseHelper;
    private String spiner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sach);
        toolbar = findViewById(R.id.toolbar);

        edtTheLoai = findViewById(R.id.edtTheLoai);
        Spiner = findViewById(R.id.Spiner);
        edtTenSach = findViewById(R.id.edtTenSach);
        edtTacGia = findViewById(R.id.edtTacGia);
        edtNhaXuatBan = findViewById(R.id.edtNhaXuatBan);
        edtGiaBia = findViewById(R.id.edtGiaBia);

        textInTheLoai = findViewById(R.id.textInTheLoai);
        textInTenSach = findViewById(R.id.textInTenSach);
        textInTacGia = findViewById(R.id.textInTacGia);
        textInNhaXuatBan = findViewById(R.id.textInNhaXuatBan);

        dataLoaiSaches = new ArrayList<>();
        bookDatabaseHelper = new BookDatabaseHelper(this);
        dataLoaiSaches = bookDatabaseHelper.dataSachListBook();


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        spinerAdapetLoaiSach = new SpinerAdapetLoaiSach(this, R.layout.item_spinner_loaithu, dataLoaiSaches);
        Spiner.setAdapter(spinerAdapetLoaiSach);
        spinerAdapetLoaiSach.notifyDataSetChanged();


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
            insertSach();
            Toast.makeText(this, "Them thanh cong", Toast.LENGTH_LONG).show();
            finish();

        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }

    public void insertSach() {
        DataSach dataSach = new DataSach();
        dataSach.setTheLoai(edtTheLoai.getText().toString());

        spiner = Spiner.getSelectedItem().toString();
        dataSach.setMaSach(spiner);

        dataSach.setTenSach(edtTenSach.getText().toString());
        dataSach.setTacGia(edtTacGia.getText().toString());
        dataSach.setNhaXuatBan(edtNhaXuatBan.getText().toString());
        dataSach.setGiaBia(Integer.parseInt(edtGiaBia.getText().toString()));

        BookDatabaseHelper bookDatabaseHelper = new BookDatabaseHelper(this);
        bookDatabaseHelper.insertSach(dataSach);

    }
}
