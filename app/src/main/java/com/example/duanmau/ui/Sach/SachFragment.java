package com.example.duanmau.ui.Sach;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.Account;
import com.example.duanmau.Data.DataSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.Sach.AdapterSach.SachAdapter;
import com.example.duanmau.ui.TaiKhoan.AdapterAccount.AccountAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SachFragment extends Fragment {
    private RecyclerView rccView;
    private FloatingActionButton fab1;
    private RecyclerView.LayoutManager layoutManager;
    private BookDatabaseHelper bookDatabaseHelper;
    List<DataSach> accountList;
    public  static SachAdapter sachAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        rccView = root.findViewById(R.id.rccView);
        accountList = new ArrayList<>();

        rccView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rccView.setLayoutManager(layoutManager);
        bookDatabaseHelper = new BookDatabaseHelper(getActivity());
        bookDatabaseHelper.createDataBase();
        LoadDataLoaiThu();
        fab1 = root.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddSach.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        LoadDataLoaiThu();

    }

    private void LoadDataLoaiThu() {
        accountList = bookDatabaseHelper.dataSachList();
        sachAdapter = new SachAdapter(accountList, getContext(),bookDatabaseHelper);
        rccView.setAdapter(sachAdapter);
        sachAdapter.notifyDataSetChanged();

    }
    public static  void notifyAdapter(){
        sachAdapter.notifyDataSetChanged();
    }
}