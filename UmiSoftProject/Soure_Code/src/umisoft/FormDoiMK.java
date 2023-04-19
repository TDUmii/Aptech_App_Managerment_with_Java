/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package umisoft;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormDoiMK extends javax.swing.JFrame {
    ConnectDB cn  = new ConnectDB();
    Connection conn;
    getUser user=new getUser();
    public FormDoiMK() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("iconMain.png"));
        Image image = icon.getImage();
        setIconImage(image);
        setTitle("UmiSoft Reset Password");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatkhaumoi = new javax.swing.JPasswordField();
        txtXacnhanmatkhau = new javax.swing.JPasswordField();
        btnXacnhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Mật Khẩu Mới:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Xác Nhận Lại Mật Khẩu:");

        txtMatkhaumoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtXacnhanmatkhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnXacnhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXacnhan.setText("Xác Nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatkhaumoi, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtXacnhanmatkhau)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnXacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatkhaumoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtXacnhanmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnXacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:     
        
        
        conn=cn.getConnection();
        if(txtMatkhaumoi.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Hãy nói tôi mật khẩu của bạn đi tôi sẽ không nói với ai đâu (o´▽`o");
        else if(txtXacnhanmatkhau.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Hãy chắc chắn bạn không ghi nhầm mật khẩu bằng cách điền mật khẩu lại lần nữa (´ ∀ ` *)");
        else if(!txtMatkhaumoi.getText().equals(txtXacnhanmatkhau.getText())){
            JOptionPane.showMessageDialog(this, "Có lẽ bạn đã ấn nhầm chữ chỗ nào đó khiến mật khẩu không khớp rồi (￢‿￢ )");
            txtMatkhaumoi.setText("");
            txtXacnhanmatkhau.setText("");
        }
        else{
            try {
                int idnew=user.getLoaiNV()/10;
                String sql="update NHANVIEN set password=?, idLoaiNV=?" + " where account=?";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(3, user.getUsername());
                pst.setString(1, txtXacnhanmatkhau.getText());
                pst.setInt(2, idnew);
                
                pst.executeUpdate();
                if(idnew==1){
                    HomePanelForAdmin hpAdmin=new HomePanelForAdmin();
                    hpAdmin.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công (☆ω☆)");
                }
                else if(idnew==2){
                    HomePanelForStaffTiepNhan hpTiepnhan=new HomePanelForStaffTiepNhan();
                    hpTiepnhan.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công (☆ω☆)");
                }
                else if(idnew==3){
                    HomePanelForStaffKiThuat hpKithuat=new HomePanelForStaffKiThuat();
                    hpKithuat.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công (☆ω☆)");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
               
    }//GEN-LAST:event_btnXacnhanActionPerformed

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
            java.util.logging.Logger.getLogger(FormDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDoiMK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtMatkhaumoi;
    private javax.swing.JPasswordField txtXacnhanmatkhau;
    // End of variables declaration//GEN-END:variables
}
