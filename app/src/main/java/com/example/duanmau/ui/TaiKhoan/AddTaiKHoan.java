package com.example.duanmau.ui.TaiKhoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.R;

public class AddTaiKHoan extends AppCompatActivity {
    private EditText edtNameAcount;
    private Toolbar toolbar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tai_khoan);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        edtNameAcount = findViewById(R.id.edtNameAcount);



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
            if (edtNameAcount.getText().toString().length()>6){
                Intent intent = new Intent(this, AddHoTen.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameAccount",edtNameAcount.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }else {
                Toast.makeText(AddTaiKHoan.this,"Tai khoan phai lon hon 6 ky tu",Toast.LENGTH_LONG).show();
            }


        } else if (id == android.R.id.home) {

            finish();
        }
        return true;
    }
}
