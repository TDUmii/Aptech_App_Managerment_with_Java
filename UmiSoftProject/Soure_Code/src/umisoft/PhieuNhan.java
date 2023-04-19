/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umisoft;

public class PhieuNhan {
    private String id;
    private String noiDung;
    private String chiPhi;
    private String thoiGianDuKienHoanThanh;




    public PhieuNhan() {
    }

    public PhieuNhan(String id, String noiDung, String chiPhi, String thoiGianDuKienHoanThanh) {
        this.id = id;
        this.noiDung = noiDung;
        this.chiPhi = chiPhi;
        this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(String chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getThoiGianDuKienHoanThanh() {
        return thoiGianDuKienHoanThanh;
    }

    public void setThoiGianDuKienHoanThanh(String thoiGianDuKienHoanThanh) {
        this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
    }

    
    
    
}
