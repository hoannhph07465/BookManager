package com.example.duanmau.ui.ThongKe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.duanmau.R;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.Data.DataTien;

import java.util.ArrayList;
import java.util.List;

public class ThongKeFragment extends Fragment {
    private TextView tvNgay;
    private TextView tvThang;
    private TextView tvNam;
    private BookDatabaseHelper bookDatabaseHelper;
    private List<DataTien> dataHoaDonChiTietList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_send, container, false);
        tvNgay = root.findViewById(R.id.tvNgay);
        tvThang = root.findViewById(R.id.tvThang);
        tvNam = root.findViewById(R.id.tvNam);
        bookDatabaseHelper = new BookDatabaseHelper(getContext());
        dataHoaDonChiTietList = new ArrayList<>();
        String a = String.valueOf(bookDatabaseHelper.thongKeNgay());
        tvNgay.setText(a);

        String b = String.valueOf(bookDatabaseHelper.thongKeThang());
        tvThang.setText(b);

        String c = String.valueOf(bookDatabaseHelper.thongKeNam());
        tvNam.setText(c);






        return root;
    }
}