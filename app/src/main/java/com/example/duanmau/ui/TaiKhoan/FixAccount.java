package com.example.duanmau.ui.TaiKhoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.Data.Account;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class FixAccount extends AppCompatActivity {
    private EditText textinputTaikhoan;
    private EditText textinputName;
    private EditText textinputPhone;
    private EditText textinputAddress;
    private EditText textinputPassword;

    private Button btnSave;
    private Button btnExit;
    List<Account> accounts = new ArrayList<>();
    private BookDatabaseHelper bookDatabaseHelper;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_account);

        textinputTaikhoan = findViewById(R.id.textinput_taikhoan);
        textinputName = findViewById(R.id.textinput_name);
        textinputPhone = findViewById(R.id.textinput_phone);
        textinputAddress = findViewById(R.id.textinput_address);
        textinputPassword = findViewById(R.id.textinput_password);


        btnSave = findViewById(R.id.btnSave);
        btnExit = findViewById(R.id.btnExit);

        setTitle("Sửa tài khoản");

        Bundle bundle = getIntent().getExtras();
        String taiKhoan = bundle.getString("taiKhoan");
        String name = bundle.getString("Name");
        String soDienThoai = bundle.getString("soDienThoai");
        String diaChi = bundle.getString("diaChi");
        String matKhau = bundle.getString("matKhau");
         final int position = bundle.getInt("position");
        textinputTaikhoan.setText(taiKhoan);
        textinputName.setText(name);
        textinputPhone.setText(soDienThoai);
        textinputAddress.setText(diaChi);
        textinputPassword.setText(matKhau);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bookDatabaseHelper = new BookDatabaseHelper(FixAccount.this);
                accounts.addAll(bookDatabaseHelper.accountList());
                Account account = accounts.get(position);
                account.setTenTaiKHoan(textinputTaikhoan.getText().toString());
                account.setHoTen(textinputName.getText().toString());
                account.setSoDIenThoai(textinputPhone.getText().toString());
                account.setDiaChi(textinputAddress.getText().toString());
                account.setMatKhau(textinputPassword.getText().toString());

                bookDatabaseHelper.updateAccount(account);
                TaiKhoanFragment.notifyAdapter();
                Toast.makeText(FixAccount.this,"Sua thanh cong",Toast.LENGTH_LONG).show();
                finish();

            }
        });


    }

}
