/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Student {
    String MaSV;
    String HoTen;
    String Email;
    String SoDT;
    boolean Gioitinh;
    String DiaChi;

    public Student() {
    }

    public Student(String MaSV, String HoTen, String Email, String SoDT, boolean Gioitinh, String DiaChi) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Email = Email;
        this.SoDT = SoDT;
        this.Gioitinh = Gioitinh;
        this.DiaChi = DiaChi;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}

