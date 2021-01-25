package com.example.duanmau.Data;

import androidx.annotation.NonNull;

public class DataLoaiSach {
    public String maLoaiSach;
    public String tenLoaiSach;
    public String viTri;
    public String moTa;

    public DataLoaiSach() {
    }

    public DataLoaiSach(String maLoaiSach, String tenLoaiSach, String viTri, String moTa) {
        this.maLoaiSach = maLoaiSach;
        this.tenLoaiSach = tenLoaiSach;
        this.viTri = viTri;
        this.moTa = moTa;

    }

    public DataLoaiSach(String maLoaiSach) {
        this.maLoaiSach = maLoaiSach;

    }

    public String getMaLoaiSach() {
        return maLoaiSach;
    }

    public void setMaLoaiSach(String maLoaiSach) {
        this.maLoaiSach = maLoaiSach;
    }

    public String getTenLoaiSach() {
        return tenLoaiSach;
    }

    public void setTenLoaiSach(String tenLoaiSach) {
        this.tenLoaiSach = tenLoaiSach;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @NonNull
    @Override
    public String toString() {
        return maLoaiSach;
    }
}
