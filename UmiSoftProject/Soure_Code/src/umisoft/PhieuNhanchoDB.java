
package umisoft;

public class PhieuNhanchoDB {
    private String nguoiNhan;
    private String noiDung;
    private String moTa;
    private String series;
    private String trangThai;
    private float chiPhi;
    private String SDT;

    public PhieuNhanchoDB() {
    }

    public PhieuNhanchoDB(String nguoiNhan, String noiDung, String moTa, String series, String trangThai, float chiPhi, String SDT) {
        this.nguoiNhan = nguoiNhan;
        this.noiDung = noiDung;
        this.moTa = moTa;
        this.series = series;
        this.trangThai = trangThai;
        this.chiPhi = chiPhi;
        this.SDT = SDT;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
