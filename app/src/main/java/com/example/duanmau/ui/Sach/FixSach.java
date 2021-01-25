package com.example.duanmau.ui.Sach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.Data.DataSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class FixSach extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtTheLoaii;
    private Spinner Spinerr;
    private EditText edtTenSachh;
    private EditText edtTacGiaa;
    private EditText edtNhaXuatBann;
    private EditText edtGiaBiaz;
    private Button btnExit;





    private SpinerAdapetLoaiSach spinerAdapetLoaiSach;
    private List<DataLoaiSach> dataLoaiSaches;
    private BookDatabaseHelper bookDatabaseHelper;
    private String spiner;
    private List<DataSach> dataSaches = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_sach);

        toolbar = findViewById(R.id.toolbar);

        edtTheLoaii = findViewById(R.id.edtTheLoaii);
        Spinerr = findViewById(R.id.Spinerr);
        edtTenSachh = findViewById(R.id.edtTenSachh);
        edtTacGiaa = findViewById(R.id.edtTacGiaa);
        edtNhaXuatBann = findViewById(R.id.edtNhaXuatBann);
        edtGiaBiaz = findViewById(R.id.edtGiaBiaz);
        btnExit = findViewById(R.id.btnExit);
        dataLoaiSaches = new ArrayList<>();
        bookDatabaseHelper = new BookDatabaseHelper(this);
        dataLoaiSaches = bookDatabaseHelper.dataSachListBook();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Bundle bundle = getIntent().getExtras();

        String theLoai = bundle.getString("theLoai");

        String tenSach = bundle.getString("tenSach");
        String tacGia = bundle.getString("tacGia");
        String nhaXuatBan = bundle.getString("nhaXuatBan");
        String giaBia = String.valueOf(bundle.getInt("giaBia"));

        edtTheLoaii.setText(theLoai);

        spinerAdapetLoaiSach = new SpinerAdapetLoaiSach(this, R.layout.item_spinner_loaithu, dataLoaiSaches);
        Spinerr.setAdapter(spinerAdapetLoaiSach);
        spinerAdapetLoaiSach.notifyDataSetChanged();

        edtTenSachh.setText(tenSach);
        edtTacGiaa.setText(tacGia);
        edtNhaXuatBann.setText(nhaXuatBan);
        edtGiaBiaz.setText(giaBia);


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
            dataSaches.addAll(bookDatabaseHelper.dataSachList());

            DataSach dataSach = new DataSach();
            dataSach.setTheLoai(edtTheLoaii.getText().toString());

            spiner = Spinerr.getSelectedItem().toString();
            dataSach.setMaSach(spiner);

            dataSach.setTenSach(edtTenSachh.getText().toString());
            dataSach.setTacGia(edtTacGiaa.getText().toString());
            dataSach.setNhaXuatBan(edtNhaXuatBann.getText().toString());
            dataSach.setGiaBia(Integer.parseInt(edtGiaBiaz.getText().toString()));

            bookDatabaseHelper.updateSach(dataSach);

            Toast.makeText(this, "Sua  thanh cong", Toast.LENGTH_LONG).show();
            finish();

        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }
}
