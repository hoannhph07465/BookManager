package com.example.duanmau.ui.HoaDon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duanmau.Data.DataHoaDon;
import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.HoaDon.HoaDonChiTiet.ThemHoaDonChiTiet;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddHoaDon extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtMaHoaDon;
    private EditText edtNgay;
    private ImageView imgDate;

    private Button btnSave;
    private Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hoa_don);

        toolbar = findViewById(R.id.toolbar);

        btnSave = findViewById(R.id.btnSave);
        btnExit = findViewById(R.id.btnExit);
        edtMaHoaDon = findViewById(R.id.edtMaHoaDon);
        edtNgay = findViewById(R.id.edtNgay);
        imgDate = findViewById(R.id.imgDate);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseDate();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertHoaDon();
                Toast.makeText(AddHoaDon.this, "Them thanh cong", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddHoaDon.this, ThemHoaDonChiTiet.class);
                Bundle bundle = new Bundle();
                bundle.putString("maHoaDon",edtMaHoaDon.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
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
        if (id == R.id.itSave) {

            insertHoaDon();


            Toast.makeText(this, "Them thanh cong", Toast.LENGTH_LONG).show();

            finish();

        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }

    public void ChooseDate() {
        final Calendar calendar = Calendar.getInstance();

        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                edtNgay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, Year, Month, Day);
        datePickerDialog.show();
    }

    public void insertHoaDon() {
        DataHoaDon dataHoaDon = new DataHoaDon();
        dataHoaDon.setMaHoaDon(edtMaHoaDon.getText().toString());
        dataHoaDon.setNgay(edtNgay.getText().toString());


        BookDatabaseHelper bookDatabaseHelper = new BookDatabaseHelper(this);
        bookDatabaseHelper.insertHoaDon(dataHoaDon);

    }
}
