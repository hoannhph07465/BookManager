package com.example.duanmau.ui.TopBanChay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.DataHoaDon;
import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.Data.DataSach;
import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.ui.LoaiSach.AdapterLoaiSach.LoaiSachAdapter;
import com.example.duanmau.ui.Sach.AdapterSach.SachAdapter;
import com.example.duanmau.ui.Sach.AdapterTopSach.TopSachAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TopFragment extends Fragment {
    private EditText edtNhap;
    private Button btnSearch;
    private RecyclerView rccView;
    private RecyclerView.LayoutManager layoutManager;
    private BookDatabaseHelper bookDatabaseHelper;
    List<DataSach> dataSaches = new ArrayList<>();
    TopSachAdapter sachAdapter;







    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_share, container, false);

        edtNhap = root.findViewById(R.id.edtNhap);
        btnSearch =root.findViewById(R.id.btnSearch);
        rccView = root.findViewById(R.id.rccView);
        layoutManager = new LinearLayoutManager(getContext());
        rccView.setLayoutManager(layoutManager);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookDatabaseHelper = new BookDatabaseHelper(getActivity());
                dataSaches = bookDatabaseHelper.getSachTop(edtNhap.getText().toString());

                sachAdapter = new TopSachAdapter(dataSaches,getContext(),bookDatabaseHelper);
                rccView.setAdapter(sachAdapter);
                sachAdapter.notifyDataSetChanged();
            }
        });

        return root;
    }
}