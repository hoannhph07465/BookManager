package com.example.duanmau.ui.TaiKhoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.R;

public class AddHoTen extends AppCompatActivity {
    private EditText edtName;
    private Toolbar toolbar;
    private  String nameAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ho_ten);
        edtName = findViewById(R.id.edtName);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

         nameAccount = bundle.getString("nameAccount");
        Log.e("nameaccount", nameAccount+"");

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

            if (edtName.getText().toString().length()>6){
                Intent intent = new Intent(this, AddPhone.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameAccount",nameAccount);
                bundle.putString("name",edtName.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(AddHoTen.this,"Ho ten phai lon hon 6 ky tu",Toast.LENGTH_LONG).show();
            }

        } else if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}
