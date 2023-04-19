
package umisoft;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.lang.String;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FormDangNhap extends javax.swing.JFrame {
    ConnectDB cn  = new ConnectDB();
    Connection conn;

    public FormDangNhap() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("UmiSoft Login");
        ImageIcon icon = new ImageIcon(getClass().getResource("iconMain.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }
    
     private void login(){
         conn=cn.getConnection();
         
         String account = txtTendangnhap.getText().toString().trim();
         String password = txtMatkhau.getText().toString().trim();
//         Integer idLoaiNV = null;
         
         // kiểm tra đầu vào tên đăng nhập
        StringBuilder sb = new StringBuilder();
        if (txtTendangnhap.getText().equals("")){
            sb.append("Lỗi rồi >.<\nHãy nhập tên đăng nhập (´｡• ω •｡`)\n");
        }
        //kiểm tra đầu vào mật khẩu
        if (txtMatkhau.getText().equals("")){
            sb.append("Lỗi rồi >.<\nHãy nhập mật khẩu (´｡• ω •｡`)\n");
        }
        if (sb.length()>0){
            JOptionPane.showMessageDialog(this, sb.toString(), "LỖIIIIIII", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         String sql_login = "Select * from NHANVIEN where account=? and password=?";
         TaiKhoan taiKhoan = null;
         try {
             PreparedStatement pst = conn.prepareStatement(sql_login);
             pst.setString(1, account);
             pst.setString(2, password);
             ResultSet rs = pst.executeQuery();
             if(rs.next()){
                    taiKhoan = new TaiKhoan();
                    taiKhoan.setIdNV(rs.getInt("idNV"));
                    taiKhoan.setTendangnhap(rs.getString("account"));
                    taiKhoan.setMatkhau(rs.getString("password"));
                    taiKhoan.setIdLoaiNV(rs.getInt("idLoaiNV"));
                    
                    getUser user=new getUser();
                    user.setUsername(txtTendangnhap.getText());
                    user.setLoaiNV(taiKhoan.getIdLoaiNV());
                   if(taiKhoan.getIdLoaiNV()==10 || taiKhoan.getIdLoaiNV()==20|| taiKhoan.getIdLoaiNV()==30){
                       FormDoiMK doimk=new FormDoiMK();
                       doimk.setVisible(true);
                       this.dispose();
                   } else {
                       if(taiKhoan.getIdLoaiNV()==1){
                           HomePanelForAdmin hpAdmin=new HomePanelForAdmin();
                           hpAdmin.setVisible(true);
                           this.dispose();
                           JOptionPane.showMessageDialog(this, "Đăng nhập thành công (☆ω☆)");
                       }
                       else if(taiKhoan.getIdLoaiNV()==2){
                           HomePanelForStaffTiepNhan hpTiepnhan=new HomePanelForStaffTiepNhan();
                           hpTiepnhan.setVisible(true);
                           this.dispose();
                           JOptionPane.showMessageDialog(this, "Đăng nhập thành công (☆ω☆)");
                       }
                       else if(taiKhoan.getIdLoaiNV()==3){
                           HomePanelForStaffKiThuat hpKithuat=new HomePanelForStaffKiThuat();
                           hpKithuat.setVisible(true);
                           this.dispose();
                           JOptionPane.showMessageDialog(this, "Đăng nhập thành công (☆ω☆)");
                       }
                     }
             }else{
                 JOptionPane.showMessageDialog(this, "Đăng nhập thất bại ＼(￣▽￣)／");
             }
         } catch (HeadlessException | SQLException e) {
             
         }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTendangnhap = new javax.swing.JTextField();
        btnDangnhap = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnDangki = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatkhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTendangnhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTendangnhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTendangnhap.setToolTipText("Tên Đăng Nhập");
        txtTendangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTendangnhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTendangnhapMouseEntered(evt);
            }
        });
        txtTendangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTendangnhapActionPerformed(evt);
            }
        });

        btnDangnhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangnhap.setText("Đăng Nhập");
        btnDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangnhapActionPerformed(evt);
            }
        });

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnDangki.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangki.setText("Đăng Kí");
        btnDangki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangkiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tên Đăng Nhập:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mật Khẩu:");

        txtMatkhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMatkhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDangki, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addComponent(btnDangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTendangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtMatkhau))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnDangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangki, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangnhapActionPerformed
        login();
    }//GEN-LAST:event_btnDangnhapActionPerformed

    private void txtTendangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTendangnhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTendangnhapActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        txtTendangnhap.setText("");
        txtMatkhau.setText("");
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnDangkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangkiActionPerformed
        JOptionPane.showMessageDialog(this, "Liên hệ với quản lý để mở tài khoản bạn nhé ╰(*´︶`*)╯");
    }//GEN-LAST:event_btnDangkiActionPerformed

    private void txtTendangnhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTendangnhapMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTendangnhapMouseEntered

    private void txtTendangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTendangnhapMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTendangnhapMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangki;
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtTendangnhap;
    // End of variables declaration//GEN-END:variables
}
