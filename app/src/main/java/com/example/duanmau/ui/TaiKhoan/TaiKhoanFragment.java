package com.example.duanmau.ui.TaiKhoan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.Data.Account;
import com.example.duanmau.ui.TaiKhoan.AdapterAccount.AccountAdapter;
import com.example.duanmau.SqliteOpenHelper.BookDatabaseHelper;
import com.example.duanmau.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanFragment extends Fragment {
    private RecyclerView rccView;
    private FloatingActionButton fab1;
    private RecyclerView.LayoutManager layoutManager;
    private BookDatabaseHelper bookDatabaseHelper;
    private List<Account> accountList;
    public static AccountAdapter accountAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        accountList = new ArrayList<>();
        rccView = root.findViewById(R.id.rccView);
        rccView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rccView.setLayoutManager(layoutManager);
        bookDatabaseHelper = new BookDatabaseHelper(getActivity());
        bookDatabaseHelper.createDataBase();
        loadAccontAdapter();

        fab1 = root.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddTaiKHoan.class);
                startActivity(intent);

            }
        });


        return root;
    }

    @Override
    public void onStart() {
        loadAccontAdapter();
        super.onStart();
    }

    public void loadAccontAdapter() {
        accountList.clear();
        accountList = bookDatabaseHelper.accountList();
        accountAdapter = new AccountAdapter(accountList, getContext(),bookDatabaseHelper);
        rccView.setAdapter(accountAdapter);
        accountAdapter.notifyDataSetChanged();

    }
    public static  void notifyAdapter(){
        accountAdapter.notifyDataSetChanged();
    }


}