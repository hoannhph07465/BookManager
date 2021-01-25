package com.example.duanmau.ui.LoaiSach;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.LoaiSach.AdapterLoaiSach.LoaiSachAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LoaiSachFragment extends Fragment {
    private RecyclerView rccView;
    private FloatingActionButton fab1;
    private RecyclerView.LayoutManager layoutManager;
    private BookDatabaseHelper bookDatabaseHelper;
    List<DataLoaiSach> accountList;
    public static LoaiSachAdapter sachAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        rccView = root.findViewById(R.id.rccView);
        accountList = new ArrayList<>();

        rccView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rccView.setLayoutManager(layoutManager);
        bookDatabaseHelper = new BookDatabaseHelper(getActivity());
        bookDatabaseHelper.createDataBase();
        LoadLoaiSachAdapter();
        fab1 = root.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddLoaiSach.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onStart() {
        LoadLoaiSachAdapter();
        super.onStart();
    }

    private void LoadLoaiSachAdapter() {
        bookDatabaseHelper = new BookDatabaseHelper(getActivity());
        accountList = bookDatabaseHelper.dataSachListBook();
        sachAdapter = new LoaiSachAdapter(accountList, getActivity(),bookDatabaseHelper);
        rccView.setAdapter(sachAdapter);
        sachAdapter.notifyDataSetChanged();

    }
    public static  void notifyAdapter(){
        sachAdapter.notifyDataSetChanged();
    }
}