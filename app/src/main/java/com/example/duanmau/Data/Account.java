package com.example.duanmau.Data;

public class Account {
    public String tenTaiKHoan;
    public String hoTen;
    public String soDIenThoai;
    public String diaChi;
    public String matKhau;

    public Account() {
    }

    public Account(String tenTaiKHoan, String hoTen, String soDIenThoai, String diaChi, String matKhau) {
        this.tenTaiKHoan = tenTaiKHoan;
        this.hoTen = hoTen;
        this.soDIenThoai = soDIenThoai;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
    }

    public String getTenTaiKHoan() {
        return tenTaiKHoan;
    }

    public void setTenTaiKHoan(String tenTaiKHoan) {
        this.tenTaiKHoan = tenTaiKHoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDIenThoai() {
        return soDIenThoai;
    }

    public void setSoDIenThoai(String soDIenThoai) {
        this.soDIenThoai = soDIenThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
