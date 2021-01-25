package com.example.duanmau.ui.TaiKhoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.R;

public class AddDiaChi extends AppCompatActivity {
    private EditText edtAddress;
    private Toolbar toolbar;
    private String nameAccount;
    private String name;
    private String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dia_chi);
        edtAddress = findViewById(R.id.edtAddress);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nameAccount = bundle.getString("nameAccount");
        name = bundle.getString("name");
        phone = bundle.getString("phone");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itNext) {
            if (edtAddress.getText().toString().length()>1){
                Intent intent = new Intent(this,AddMatKhau.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameAccount",nameAccount);
                bundle.putString("name",name);
                bundle.putString("phone",phone);
                bundle.putString("address",edtAddress.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(AddDiaChi.this,"Khong duoc de trong dia chi",Toast.LENGTH_LONG).show();
            }


        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }
}
