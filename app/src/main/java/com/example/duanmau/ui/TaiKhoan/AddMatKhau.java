package com.example.duanmau.ui.TaiKhoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.Data.Account;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;

public class AddMatKhau extends AppCompatActivity {
    private EditText edtPassword;
    private EditText edtRetype;
    private Toolbar toolbar;

    private String nameAccount;
    private String name;
    private String phone;
    private String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mat_khau);
        edtPassword = findViewById(R.id.edtPassword);
        edtRetype = findViewById(R.id.edtRetype);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nameAccount = bundle.getString("nameAccount");
        name = bundle.getString("name");
        phone = bundle.getString("phone");
        address = bundle.getString("address");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_password, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itEnd) {
            if (edtPassword.getText().toString().equals(edtRetype.getText().toString())){
                insertAccount();



                finish();
            }else {
                Toast.makeText(AddMatKhau.this,"Mat khau khong khop",Toast.LENGTH_LONG).show();

            }

        } else if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
    public void insertAccount(){
        Account account = new Account();
        account.setTenTaiKHoan(nameAccount);
        account.setHoTen(name);
        account.setSoDIenThoai(phone);
        account.setDiaChi(address);
        account.setMatKhau(edtPassword.getText().toString());
        BookDatabaseHelper bookDatabaseHelper = new BookDatabaseHelper(this);
        bookDatabaseHelper.insertAccount(account);

    }


}
