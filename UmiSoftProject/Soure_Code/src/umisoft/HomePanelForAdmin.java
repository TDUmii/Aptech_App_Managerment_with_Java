/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package umisoft;

import java.awt.Image;
import java.awt.List;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import umisoft.thread.Clock;

public class HomePanelForAdmin extends javax.swing.JFrame {
    ConnectDB cn  = new ConnectDB();
    Connection conn;
        
    ArrayList<taikhoanfortable> arr=new ArrayList<>();
    public void LoadDataToArrayList(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        arr.clear();
        try {
            conn=cn.getConnection();
            String sql="SELECT * FROM NHANVIEN ";
//            System.out.println(sql);
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
//            System.out.println(sql);
            while(rs.next()){
                int id=rs.getInt("idNV");
                String hovaten=rs.getString("name");
                String tendn=rs.getString("account");
                String matkhau=rs.getString("password");
                
                taikhoanfortable tk=new taikhoanfortable(id, hovaten, tendn, matkhau);
                
                arr.add(tk);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void LoadDataArrayListToTable(){
        DefaultTableModel model=(DefaultTableModel) tblTaikhoan.getModel();
        model.setRowCount(0);
        
        
        for (int i = 0; i < arr.size(); i++) {
            Vector v=new Vector();
            v.add(arr.get(i).getId());
            v.add(arr.get(i).getHovaten());
            v.add(arr.get(i).getTendn());
            v.add(arr.get(i).getMatkhau());
            model.addRow(v);
        }
    }
    public HomePanelForAdmin(){
        initComponents();
        setLocationRelativeTo(null);
        setTitle("UmiSoft ADMIN");
        ImageIcon icon = new ImageIcon(getClass().getResource("iconMain.png"));
        Image image = icon.getImage();
        setIconImage(image);
        
        LoadDataToArrayList();
        LoadDataArrayListToTable();
        
        initClock();
    }

    private void initClock() {
        Clock th=new Clock(lblClock);
        th.start();
    }
    public HomePanelForAdmin(String account, String password) {
        initComponents();    
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHovaten = new javax.swing.JTextField();
        txtTendangnhap = new javax.swing.JTextField();
        txtMatkhau = new javax.swing.JPasswordField();
        rdbTiepnhan = new javax.swing.JRadioButton();
        rdbKithuat = new javax.swing.JRadioButton();
        rdbQuanly = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapnhap = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaikhoan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Họ Và Tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Tên Đăng Nhập:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("Mật Khẩu:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("Vị trí làm việc:");

        txtHovaten.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        txtTendangnhap.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        txtMatkhau.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtMatkhau.setText("123456");
        txtMatkhau.setToolTipText("mật khẩu mặc định: 123456");

        buttonGroup1.add(rdbTiepnhan);
        rdbTiepnhan.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        rdbTiepnhan.setText("Tiếp Nhận");

        buttonGroup1.add(rdbKithuat);
        rdbKithuat.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        rdbKithuat.setText("Kĩ Thuật");

        buttonGroup1.add(rdbQuanly);
        rdbQuanly.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        rdbQuanly.setSelected(true);
        rdbQuanly.setText("Quản Lý");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        btnThem.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapnhap.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnCapnhap.setText("Cập Nhập");
        btnCapnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhapActionPerformed(evt);
            }
        });

        btnLammoi.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setText("ID:");

        txtId.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        btnTimkiem.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnTimkiem.setText("Tìm ");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClock.setText("8:8:8 AM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHovaten, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbQuanly, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdbTiepnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdbKithuat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTendangnhap)
                    .addComponent(txtMatkhau))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapnhap))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHovaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdbTiepnhan)
                    .addComponent(rdbKithuat)
                    .addComponent(rdbQuanly))
                .addGap(25, 25, 25)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnLammoi))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimkiem)
                            .addComponent(btnCapnhap)
                            .addComponent(btnThoat)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chỉnh sửa", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblTaikhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Họ và tên", "Tên đăng nhập", "Mật khẩu"
            }
        ));
        jScrollPane1.setViewportView(tblTaikhoan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý Tài Khoản", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhapActionPerformed
        conn=cn.getConnection();
        String account = txtTendangnhap.getText().toString().trim();
        String password = txtMatkhau.getText().toString().trim();
        String name = txtHovaten.getText().toString().trim();
        String idNV = txtId.getText().toString().trim();
        int LoaiNV = 1;
        if(rdbTiepnhan.isSelected())
            LoaiNV=2;
        else if(rdbKithuat.isSelected())
            LoaiNV=3;
        try {
            if (txtHovaten.getText().equals(""))
                JOptionPane.showMessageDialog(this,"Tôi chưa biết tên của bạn (o^▽^o)");
            else if (txtTendangnhap.getText().equals(""))
                JOptionPane.showMessageDialog(this,"Bạn sẽ không thể đăng nhập nếu không có tên đăng nhập (o^▽^o)");
            else if (txtMatkhau.getText().equals(""))
                JOptionPane.showMessageDialog(this,"Hãy nói tôi mật khẩu của bạn đi tôi sẽ không nói với ai đâu (o´▽`o)");
            else{
                
                String sql="update NHANVIEN set account=?, password=?, name=?, idLoaiNV=?" + " where idNV=?";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(5, idNV);
                pst.setString(1,account);
                pst.setString(2,password);
                pst.setString(3,name);
                pst.setInt(4, LoaiNV);
                
                int n=pst.executeUpdate();
                if(n!=0)
                    JOptionPane.showMessageDialog(this,"Cập Nhập thành công (￣▽￣)");
                else
                    JOptionPane.showMessageDialog(this,"Cập Nhập thất bại (￣▽￣)");
                LoadDataToArrayList();
                LoadDataArrayListToTable();
                btnLammoiActionPerformed(evt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnCapnhapActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        conn=cn.getConnection();
        
        //xác nhận đăng kí tài khoản
        int dangki = JOptionPane.showConfirmDialog(this, "Xác nhận đăng kí tài khoản? (´,,•ω•,,)♡", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if(dangki != JOptionPane.YES_OPTION){
            return;
        }
        try {
            //kiểm tra các dữ liệu đầu vào
            if (txtHovaten.getText().equals(""))
                JOptionPane.showMessageDialog(this,"Tôi chưa biết tên của bạn (o^▽^o)");
            else if (txtTendangnhap.getText().equals(""))
                JOptionPane.showMessageDialog(this,"Bạn sẽ không thể đăng nhập nếu không có tên đăng nhập (o^▽^o)");
            else if (txtMatkhau.getText().equals(""))
                JOptionPane.showMessageDialog(this,"Hãy nói tôi mật khẩu của bạn đi tôi sẽ không nói với ai đâu (o´▽`o)");
            else{
            int LoaiNV = 10;
            if(rdbTiepnhan.isSelected())
                LoaiNV=20;
            else if(rdbKithuat.isSelected())
                LoaiNV=30;

            String nhanviensql="insert into NHANVIEN(account,password,name,idLoaiNV) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(nhanviensql);
            ps.setString(1, txtTendangnhap.getText());
            ps.setString(2, txtMatkhau.getText());
            ps.setString(3, txtHovaten.getText());
            ps.setInt(4, LoaiNV);
            
            int n=ps.executeUpdate();
            
            if(n!=0)
                JOptionPane.showMessageDialog(this,"Đăng kí thành công (￣▽￣)");
            else
                JOptionPane.showMessageDialog(this,"Đăng kí thất bại (￣▽￣)");
            LoadDataToArrayList();
            LoadDataArrayListToTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        btnLammoiActionPerformed(evt);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        txtHovaten.setText("");
        txtTendangnhap.setText("");
        txtMatkhau.setText("");
        txtId.setText("");
        rdbQuanly.setSelected(true);
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        conn=cn.getConnection();
        int check=0;
        TaiKhoan tk=new TaiKhoan();
        try {
            if(txtId.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Bạn phải điền ID tôi mới có thể tìm >~<");
            else{
                String sql="select * from NHANVIEN where idNV=?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1, txtId.getText());
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    tk.setHovaten(rs.getString("name"));
                    tk.setTendangnhap(rs.getString("account"));
                    tk.setMatkhau(rs.getString("password"));
                    tk.setIdLoaiNV(rs.getInt("idLoaiNV"));
                    
                    check =1;
                }
            }
            if(check!=0){
                txtHovaten.setText(tk.getHovaten());
                txtTendangnhap.setText(tk.getTendangnhap());
                txtMatkhau.setText(tk.getMatkhau());
                int LoaiNV = tk.getIdLoaiNV();
                if(LoaiNV==1||LoaiNV==10)
                    rdbQuanly.setSelected(true);
                else if(LoaiNV==3||LoaiNV==30)
                    rdbKithuat.setSelected(true);
                else if(LoaiNV==2||LoaiNV==20)
                    rdbTiepnhan.setSelected(true);
            }else
                JOptionPane.showMessageDialog(this, "Không tìm thấy ID trùng khớp.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        conn=cn.getConnection();
        String id=txtId.getText();
        try {
            if(txtId.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Bạn phải điền ID mới có thể thực hiện thao tác >~<");
            else{
                String sql_nhanvien="DELETE from NHANVIEN  WHERE idNV=?";
                PreparedStatement ps=conn.prepareStatement(sql_nhanvien);
                ps.setString(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Bạn đã xóa thành công tài khoản có ID:"+id);
                
                LoadDataToArrayList();
                LoadDataArrayListToTable();
                btnLammoiActionPerformed(evt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        FormDangNhap dn=new FormDangNhap();
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePanelForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePanelForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePanelForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePanelForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePanelForAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhap;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JRadioButton rdbKithuat;
    private javax.swing.JRadioButton rdbQuanly;
    private javax.swing.JRadioButton rdbTiepnhan;
    private javax.swing.JTable tblTaikhoan;
    private javax.swing.JTextField txtHovaten;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtTendangnhap;
    // End of variables declaration//GEN-END:variables
}
