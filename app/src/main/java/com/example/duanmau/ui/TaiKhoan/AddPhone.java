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

public class AddPhone extends AppCompatActivity {
    private EditText edtPhone;
    private Toolbar toolbar;
    private String nameAccount;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone);
        edtPhone = findViewById(R.id.edtPhone);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nameAccount = bundle.getString("nameAccount");
        name = bundle.getString("name");


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
            if (edtPhone.getText().toString().length() == 10){
                Intent intent = new Intent(this, AddDiaChi.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameAccount",nameAccount);
                bundle.putString("name",name);
                bundle.putString("phone",edtPhone.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(AddPhone.this,"So dien thoai phai co 10 so",Toast.LENGTH_LONG).show();
            }


        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }
}
