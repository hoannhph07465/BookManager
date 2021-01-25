package com.example.duanmau.ui.Sach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class SpinerAdapetLoaiSach extends ArrayAdapter<DataLoaiSach> {
    public List<DataLoaiSach> sachList = new ArrayList<>();
    public Context context;
    public int resource;


    public SpinerAdapetLoaiSach(Context context, int resource, List<DataLoaiSach> sachList) {
        super(context, resource, sachList);
        this.context = context;
        this.resource = resource;
        this.sachList = sachList;

    }

    public void setSpinner(List<DataLoaiSach> dataLoaiSach) {
        this.sachList = dataLoaiSach;
        notifyDataSetChanged();
    }

    class viewHolder {
        TextView txtLoaiThu;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        viewHolder view;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_loaithu, parent, false);
            view = new viewHolder();

            view.txtLoaiThu = convertView.findViewById(R.id.txtLoaiThu);
            convertView.setTag(view);
        } else {
            view = (viewHolder) convertView.getTag();
        }
        view.txtLoaiThu.setText(sachList.get(position).getMaLoaiSach());


        return convertView;
    }
}
