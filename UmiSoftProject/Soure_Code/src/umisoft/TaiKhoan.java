/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umisoft;

import java.io.Serializable;

public class TaiKhoan implements Serializable{
    private String Hovaten;
    private int idNV;
    private String Tendangnhap;
    private String Matkhau;
    private boolean Tinhtrang;
    private int idLoaiNV;

    public TaiKhoan() {
    }

    public TaiKhoan(String Hovaten, int idNV, String Tendangnhap, String Matkhau, boolean Tinhtrang, int idLoaiNV) {
        this.Hovaten = Hovaten;
        this.idNV = idNV;
        this.Tendangnhap = Tendangnhap;
        this.Matkhau = Matkhau;
        this.Tinhtrang = Tinhtrang;
        this.idLoaiNV = idLoaiNV;
    }

    public String getHovaten() {
        return Hovaten;
    }

    public void setHovaten(String Hovaten) {
        this.Hovaten = Hovaten;
    }

    public int getIdLoaiNV() {
        return idLoaiNV;
    }

    public void setIdLoaiNV(int idLoaiNV) {
        this.idLoaiNV = idLoaiNV;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getTendangnhap() {
        return Tendangnhap;
    }

    public void setTendangnhap(String Tendangnhap) {
        this.Tendangnhap = Tendangnhap;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public boolean isTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(boolean Tinhtrang) {
        this.Tinhtrang = Tinhtrang;
    }
    
    
}
