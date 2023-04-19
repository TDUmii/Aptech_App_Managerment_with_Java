/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umisoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    ConnectDB cn  = new ConnectDB();
    Connection conn;
    
    public ArrayList<TaiKhoan> getListTaiKhoan(){
        conn=cn.getConnection();
        ArrayList<TaiKhoan> list =new ArrayList<>();
        String sql="SELECT * FROM NHANVIEN";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                TaiKhoan tk=new TaiKhoan();
                tk.setIdNV(rs.getInt("idNV"));
                tk.setHovaten(rs.getNString("name"));
                tk.setTendangnhap(rs.getString("account"));
                tk.setMatkhau(rs.getString("password"));
                
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        }
    
    public ArrayList<DichVu> getListDichVu(){
        conn=cn.getConnection();
        ArrayList<DichVu> list = new ArrayList<>();
        String sql="SELECT * FROM DICHVU";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                DichVu dv=new DichVu();
                dv.setId(rs.getInt("id"));
                dv.setNoiDung(rs.getString("noiDung"));
                dv.setChiPhi(rs.getFloat("chiPhi"));
                dv.setThoiGianDuKienHoanThanh(rs.getInt("thoiGianDuTinhHoanThanh"));
                
                list.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
