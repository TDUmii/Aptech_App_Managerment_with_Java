/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umisoft;

import java.io.Serializable;

public class DichVu implements Serializable{
    private int id;
    private String noiDung;
    private float chiPhi;
    private int thoiGianDuKienHoanThanh;

    public DichVu() {
    }

    public DichVu(int id, String noiDung, float chiPhi, int thoiGianDuKienHoanThanh) {
        this.id = id;
        this.noiDung = noiDung;
        this.chiPhi = chiPhi;
        this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public int getThoiGianDuKienHoanThanh() {
        return thoiGianDuKienHoanThanh;
    }

    public void setThoiGianDuKienHoanThanh(int thoiGianDuKienHoanThanh) {
        this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
    }
    
}
