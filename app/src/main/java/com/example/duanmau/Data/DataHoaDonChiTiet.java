package com.example.duanmau.Data;

public class DataHoaDonChiTiet {
    public String maHoaDon;
    public String maSach;
    public int soLuong;
    public double tien;

    public DataHoaDonChiTiet() {
    }

    public DataHoaDonChiTiet(String maHoaDon, String maSach, int soLuong, double tien) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.tien = tien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }
}
