/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umisoft;

import java.io.Serializable;

public class taikhoanfortable implements Serializable{
    private int id;
    private String hovaten;
    private String tendn;
    private String matkhau;

    public taikhoanfortable() {
    }

    public taikhoanfortable(int id, String hovaten, String tendn, String matkhau) {
        this.id = id;
        this.hovaten = hovaten;
        this.tendn = tendn;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
    
}
