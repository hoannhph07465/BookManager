package com.example.duanmau.SqliteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.duanmau.Data.Account;
import com.example.duanmau.Data.DataHoaDon;
import com.example.duanmau.Data.DataHoaDonChiTiet;
import com.example.duanmau.Data.DataLoaiSach;
import com.example.duanmau.Data.DataSach;
import com.example.duanmau.Data.DataTien;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookDatabaseHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "";
    private static String DB_NAME = "BookManager";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;


    public String Account = "Account";

    private String tenTaiKhoan = "tenTaiKhoan";
    private String hoVaTen = "hoVaTen";
    private String soDienThoai = "soDienThoai";
    private String diaChi = "diaChi";
    private String matKhau = "matKhau";


    public String Sach = "Sach";


    private String theLoai = "theLoai";
    private String maSach = "maSach";
    private String tenSach = "tenSach";
    private String tacGia = "tacGia";
    private String nhaXuatBan = "nhaXuatBan";
    private String giaBia = "giaBia";


    public String LoaiSach = "LoaiSach";

    private String maLoaiSach = "maLoaiSach";
    private String tenLoaiSach = "tenLoaiSach";
    private String viTri = "viTri";
    private String moTa = "moTa";


    private String HoaDon = "HoaDon";

    private String maHoaDon = "maHoaDon";
    private String ngay = "ngay";

    private String HoaDonChiTiet = "HoaDonChiTiet";

    private String soLuong = "soLuong";
    private String tien = "tien";


    public BookDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);

        this.context = context;

        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }

    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e("abc", "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException {
        InputStream mInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }


    public long insertAccount(Account account) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tenTaiKhoan, account.getTenTaiKHoan());
        contentValues.put(hoVaTen, account.getHoTen());
        contentValues.put(soDienThoai, account.getSoDIenThoai());
        contentValues.put(diaChi, account.getDiaChi());
        contentValues.put(matKhau, account.getMatKhau());
        long id = sqLiteDatabase.insert(Account, null, contentValues);

        sqLiteDatabase.close();
        return id;

    }

    public void deletecAcount(Account account) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(Account, tenTaiKhoan + " = ?",
                new String[]{String.valueOf(account.getTenTaiKHoan())});
        sqLiteDatabase.close();
    }

    public int updateAccount(Account account) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tenTaiKhoan, account.getTenTaiKHoan());
        contentValues.put(hoVaTen, account.getHoTen());
        contentValues.put(soDienThoai, account.getSoDIenThoai());
        contentValues.put(diaChi, account.getDiaChi());
        contentValues.put(matKhau, account.getMatKhau());
        return sqLiteDatabase.update(Account, contentValues, "tenTaiKhoan" + " = ?",
                new String[]{account.getTenTaiKHoan()});

    }

    public long insertLoaiSach(DataLoaiSach dataLoaiSach) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(maLoaiSach, dataLoaiSach.getMaLoaiSach());
        contentValues.put(tenLoaiSach, dataLoaiSach.getTenLoaiSach());
        contentValues.put(viTri, dataLoaiSach.getViTri());
        contentValues.put(moTa, dataLoaiSach.getMoTa());

        long id = sqLiteDatabase.insert(LoaiSach, null, contentValues);

        sqLiteDatabase.close();
        return id;

    }

    public void deletecLoaiSach(DataLoaiSach dataLoaiSach) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(LoaiSach, maLoaiSach + " = ?",
                new String[]{String.valueOf(dataLoaiSach.getMaLoaiSach())});
        sqLiteDatabase.close();
    }

    public int updateLoaiSach(DataLoaiSach dataLoaiSach) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(maLoaiSach, dataLoaiSach.getMaLoaiSach());
        contentValues.put(tenLoaiSach, dataLoaiSach.getTenLoaiSach());
        contentValues.put(viTri, dataLoaiSach.getViTri());
        contentValues.put(moTa, dataLoaiSach.getMoTa());


        return sqLiteDatabase.update(LoaiSach, contentValues, maLoaiSach + " = ?",
                new String[]{dataLoaiSach.getMaLoaiSach()});

    }

    public long insertSach(DataSach dataSach) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(theLoai, dataSach.getTheLoai());
        contentValues.put(maSach, dataSach.getMaSach());
        contentValues.put(tenSach, dataSach.getTenSach());
        contentValues.put(tacGia, dataSach.getTacGia());
        contentValues.put(nhaXuatBan, dataSach.getNhaXuatBan());
        contentValues.put(giaBia, dataSach.getGiaBia());

        long id = sqLiteDatabase.insert(Sach, null, contentValues);

        sqLiteDatabase.close();
        return id;

    }

    public void deleteSach(DataSach dataSach) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(Sach, theLoai + " = ?",
                new String[]{String.valueOf(dataSach.getTheLoai())});
        sqLiteDatabase.close();
    }

    public int updateSach(DataSach dataSach) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(maSach, dataSach.getMaSach());
        contentValues.put(theLoai, dataSach.getTheLoai());
        contentValues.put(tenSach, dataSach.getTacGia());
        contentValues.put(tacGia, dataSach.getTacGia());
        contentValues.put(nhaXuatBan, dataSach.getNhaXuatBan());
        contentValues.put(giaBia, dataSach.getGiaBia());


        return sqLiteDatabase.update(Sach, contentValues, theLoai + " = ?",
                new String[]{dataSach.getTheLoai()});

    }


    public List<Account> accountList() {

        List<Account> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM Account";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Account account = new Account();
                    account.tenTaiKHoan = cursor.getString(cursor.getColumnIndex(tenTaiKhoan));
                    account.hoTen = cursor.getString(cursor.getColumnIndex(hoVaTen));
                    account.soDIenThoai = cursor.getString(cursor.getColumnIndex(soDienThoai));
                    account.diaChi = cursor.getString(cursor.getColumnIndex(diaChi));
                    account.matKhau = cursor.getString(cursor.getColumnIndex(matKhau));

                    list.add(account);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }

    public List<DataSach> dataSachList() {

        List<DataSach> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM Sach";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataSach dataSach = new DataSach();
                    dataSach.maSach = cursor.getString(cursor.getColumnIndex(maSach));
                    dataSach.theLoai = cursor.getString(cursor.getColumnIndex(theLoai));
                    dataSach.tenSach = cursor.getString(cursor.getColumnIndex(tenSach));
                    dataSach.tacGia = cursor.getString(cursor.getColumnIndex(tacGia));
                    dataSach.nhaXuatBan = cursor.getString(cursor.getColumnIndex(nhaXuatBan));
                    dataSach.giaBia = Integer.parseInt(cursor.getString(cursor.getColumnIndex(giaBia)));

                    list.add(dataSach);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }

    public List<DataLoaiSach> dataSachListBook() {

        List<DataLoaiSach> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM LoaiSach";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataLoaiSach dataLoaiSachch = new DataLoaiSach();
                    dataLoaiSachch.maLoaiSach = cursor.getString(cursor.getColumnIndex(maLoaiSach));
                    dataLoaiSachch.tenLoaiSach = cursor.getString(cursor.getColumnIndex(tenLoaiSach));
                    dataLoaiSachch.viTri = cursor.getString(cursor.getColumnIndex(viTri));
                    dataLoaiSachch.moTa = cursor.getString(cursor.getColumnIndex(moTa));


                    list.add(dataLoaiSachch);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }


    public List<DataSach> getSachTop(String month) {

        List<DataSach> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        if (Integer.parseInt(month)<10){
            month = "0"+month;
        }

        String SQL = "SELECT maSach, SUM(soLuong) as soLuong FROM HoaDonChiTiet " +
                " INNER JOIN HoaDon " +" on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon WHERE " +
                " strftime('%m', HoaDon.ngay ) = '"+ month +"' " +
                " GROUP BY maSach ORDER BY soLuong DESC LIMIT 10";
        Cursor c = sqLiteDatabase.rawQuery(SQL, null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Log.d("//=====",c.getString(0));
            DataSach s = new DataSach();
            s.setTenSach(c.getString(0));
            s.setGiaBia(c.getInt(1));
            list.add(s);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    public List<DataHoaDon> dataSachListHoaDon() {

        List<DataHoaDon> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM HoaDon";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataHoaDon dataHoaDon = new DataHoaDon();
                    dataHoaDon.maHoaDon = cursor.getString(cursor.getColumnIndex(maHoaDon));
                    dataHoaDon.ngay = cursor.getString(cursor.getColumnIndex(ngay));

                    list.add(dataHoaDon);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }

    public int thongKeNgay() {

        List<DataTien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT  tien FROM HoaDonChiTiet INNER JOIN HoaDon on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon WHERE HoaDon.ngay = date('now') ";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();
        int tong = 0;

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataTien dataTien = new DataTien();
                    dataTien.tien = Double.parseDouble(cursor.getString(cursor.getColumnIndex(tien)));
                    list.add(dataTien);
                    tong += dataTien.getTien();

                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return tong;

    }

    public int thongKeThang() {

        List<DataTien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT  tien FROM HoaDonChiTiet INNER JOIN HoaDon on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon WHERE strftime('%m',HoaDon.ngay) = strftime('%m','now') ";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();
        int tong = 0;

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataTien dataTien = new DataTien();
                    dataTien.tien = Double.parseDouble(cursor.getString(cursor.getColumnIndex(tien)));
                    list.add(dataTien);
                    tong += dataTien.getTien();

                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return tong;

    }

    public int thongKeNam() {

        List<DataTien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT  tien FROM HoaDonChiTiet INNER JOIN HoaDon on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon WHERE strftime('%Y',HoaDon.ngay) = strftime('%Y','now') ";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();
        int tong = 0;

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataTien dataTien = new DataTien();
                    dataTien.tien = Double.parseDouble(cursor.getString(cursor.getColumnIndex(tien)));
                    list.add(dataTien);
                    tong += dataTien.getTien();

                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return tong;

    }


    public List<DataHoaDonChiTiet> dataHoaDonChiTietList(String ma) {

        List<DataHoaDonChiTiet> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(HoaDonChiTiet, null, maHoaDon + " = ?", new String[]{ma}, null, null, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataHoaDonChiTiet dataHoaDonChiTiet = new DataHoaDonChiTiet();
                    dataHoaDonChiTiet.maHoaDon = cursor.getString(cursor.getColumnIndex(maHoaDon));
                    dataHoaDonChiTiet.maSach = cursor.getString(cursor.getColumnIndex(maSach));
                    dataHoaDonChiTiet.soLuong = Integer.parseInt(cursor.getString(cursor.getColumnIndex(soLuong)));
                    dataHoaDonChiTiet.tien = Double.parseDouble(cursor.getString(cursor.getColumnIndex(tien)));

                    list.add(dataHoaDonChiTiet);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }


    public long insertHoaDonChiTiet(DataHoaDonChiTiet dataHoaDonChiTiet) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(maHoaDon, dataHoaDonChiTiet.getMaHoaDon());
        contentValues.put(maSach, dataHoaDonChiTiet.getMaSach());
        contentValues.put(soLuong, dataHoaDonChiTiet.getSoLuong());
        contentValues.put(tien, dataHoaDonChiTiet.getTien());

        long id = sqLiteDatabase.insert(HoaDonChiTiet, null, contentValues);

        sqLiteDatabase.close();
        return id;

    }


    public long insertHoaDon(DataHoaDon dataHoaDon) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(maHoaDon, dataHoaDon.getMaHoaDon());
        contentValues.put(ngay, dataHoaDon.getNgay());

        long id = sqLiteDatabase.insert(HoaDon, null, contentValues);

        sqLiteDatabase.close();
        return id;

    }

    public void deletecHoaDDon(DataHoaDon dataHoaDon) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(HoaDon, maHoaDon + " = ?",
                new String[]{String.valueOf(dataHoaDon.getMaHoaDon())});
        sqLiteDatabase.close();
    }

    public int updateHoaDon(DataHoaDon dataHoaDon) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(maHoaDon, dataHoaDon.getMaHoaDon());
        contentValues.put(ngay, dataHoaDon.getNgay());


        return sqLiteDatabase.update(HoaDon, contentValues, maHoaDon + " = ?",
                new String[]{dataHoaDon.getMaHoaDon()});

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
