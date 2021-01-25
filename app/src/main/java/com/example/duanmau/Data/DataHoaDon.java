package com.example.duanmau.Data;

public class DataHoaDon {
    public String maHoaDon;
    public String ngay;


    public DataHoaDon() {
    }

    public DataHoaDon(String maHoaDon, String ngay) {
        this.maHoaDon = maHoaDon;
        this.ngay = ngay;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
