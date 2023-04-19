
package umisoft;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import umisoft.thread.Clock;


public class HomePanelForStaffTiepNhan extends javax.swing.JFrame {
    ConnectDB cn  = new ConnectDB();
    Connection conn;
    ArrayList<DichVu> arr=new ArrayList<>();
    ArrayList<PhieuNhan> list=new ArrayList<>();
//    private DefaultTableModel tblModel;
    float thanhtien=0;
    int time=0;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String dichvusuachua=null;
     
    public void LoadDataToArrayList(){
        arr.clear();
        try {
            conn=cn.getConnection();
            String sql="SELECT * FROM DICHVU ";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String noiDung=rs.getString("noiDung");
                float chiPhi=rs.getFloat("chiPhi");
                int thoigian=rs.getInt("thoiGianDuTinhHoanThanh");
                
                DichVu dv=new DichVu(id,noiDung,chiPhi,thoigian);
                
                arr.add(dv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private void fillTable(){
        DefaultTableModel model=(DefaultTableModel) tblPhieunhan.getModel();
        model.setRowCount(0);
        
        
        for (int i = 0; i < list.size(); i++) {
            Vector v=new Vector();
            v.add(list.get(i).getNoiDung());
            v.add(list.get(i).getChiPhi());
            v.add(list.get(i).getThoiGianDuKienHoanThanh());
            model.addRow(v);
        }
        
    }
     
    public void LoadDataArrayListToTable(){
        DefaultTableModel model=(DefaultTableModel) tblDichvu.getModel();
        model.setRowCount(0);
        
        
        for (int i = 0; i < arr.size(); i++) {
            Vector v=new Vector();
            v.add(arr.get(i).getId());
            v.add(arr.get(i).getNoiDung());
            v.add(arr.get(i).getChiPhi());
            v.add(arr.get(i).getThoiGianDuKienHoanThanh());
            model.addRow(v);
        }
    }
            
    public HomePanelForStaffTiepNhan() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("UmiSoft STAFF");
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
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTenkhachhang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSodienthoai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSerimay = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtChitietloi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtChiphi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtThoigian = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnThem = new javax.swing.JButton();
        btnLammoi2 = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhieunhan = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rdbDangxuly = new javax.swing.JRadioButton();
        rdbHoantra = new javax.swing.JRadioButton();
        txtMota2 = new javax.swing.JTextField();
        txtThanhtien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNgaynhan = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnLuu = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtSerimay2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTenkhachhang2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTimkiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichvu = new javax.swing.JTable();
        btnLammoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1123, 830));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("Mô tả:");

        txtMota.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtMota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMotaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setText("Tên Khách Hàng:");

        txtTenkhachhang.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtTenkhachhang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenkhachhangKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Số Điện Thoại:");

        txtSodienthoai.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Seri Máy:");

        txtSerimay.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtSerimay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerimayKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenkhachhang)
                    .addComponent(txtSodienthoai)
                    .addComponent(txtSerimay)
                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSerimay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("Chi tiết lỗi:");

        txtChitietloi.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel10.setText("Chi Phí:");

        txtChiphi.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel11.setText("(Vnđ)");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setText("Thời Gian Dự Kiến Hoàn Thành:");

        txtThoigian.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel13.setText("(Giờ)");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnThem.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLammoi2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnLammoi2.setText("Làm Mới");
        btnLammoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoi2ActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addComponent(txtChitietloi, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLammoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLammoi2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtChitietloi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtThoigian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel6.setText("Phiếu Nhận Máy");

        tblPhieunhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPhieunhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lỗi", "Đơn Giá", "Thời Gian Sửa (Giờ)"
            }
        ));
        tblPhieunhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieunhanMouseClicked(evt);
            }
        });
        tblPhieunhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPhieunhanKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhieunhan);

        jLabel8.setText("Thành tiền:");

        jLabel14.setText("Ngày Nhận:");

        jLabel15.setText("Trạng Thái Phiếu:");

        jLabel16.setText("Mô tả:");

        buttonGroup1.add(rdbDangxuly);
        rdbDangxuly.setSelected(true);
        rdbDangxuly.setText("Đang Xử Lý");

        buttonGroup1.add(rdbHoantra);
        rdbHoantra.setText("Hoàn Trả");

        jLabel17.setText("VNĐ");

        btnLuu.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel18.setText("Seri-Máy");

        jLabel19.setText("Tên khách hàng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMota2)
                                    .addComponent(txtSerimay2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(rdbDangxuly, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(rdbHoantra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtThanhtien, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                                    .addComponent(txtNgaynhan))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtTenkhachhang2))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLuu)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jSeparator1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(125, 125, 125))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSerimay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rdbDangxuly)
                    .addComponent(rdbHoantra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtThanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNgaynhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("Tìm Kiếm:");

        txtTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        tblDichvu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblDichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Chi tiết lỗi", "Chi phí (Vnđ)", "Dự kiến hoàn thành (Giờ)"
            }
        ));
        tblDichvu.setGridColor(new java.awt.Color(0, 0, 0));
        tblDichvu.setRowSelectionAllowed(false);
        tblDichvu.setSelectionBackground(new java.awt.Color(0, 204, 0));
        tblDichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichvuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichvu);
        if (tblDichvu.getColumnModel().getColumnCount() > 0) {
            tblDichvu.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        btnLammoi.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLammoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThoat.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClock.setText("8:8:8 AM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
        arr.clear();
        float gia=0;
        try {
            conn=cn.getConnection();
            
            if(txtTimkiem.getText().isEmpty())
                gia=0;
            else
                if(txtTimkiem.getText().chars().allMatch(Character::isDigit))
                    gia=Float.parseFloat(txtTimkiem.getText());
            
            String sql="SELECT * FROM DICHVU WHERE noiDung LIKE N'%"+txtTimkiem.getText()+"%' OR chiPhi="+gia;
            System.out.println(sql);
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String noiDung=rs.getString("noiDung");
                float chiPhi=rs.getFloat("chiPhi");
                int thoigian=rs.getInt("thoiGianDuTinhHoanThanh");
                DichVu dv=new DichVu(id,noiDung,chiPhi,thoigian);
                
                arr.add(dv);
                
            }
            conn.close();
//            LoadDataToArrayList();
            LoadDataArrayListToTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimkiemKeyReleased

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        txtTimkiem.setText("");
        LoadDataToArrayList();
        LoadDataArrayListToTable();
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void tblDichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichvuMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) tblDichvu.getModel();
        int selected = tblDichvu.getSelectedRow();
        PhieuNhan pn=new PhieuNhan();
        if(selected >= 0){
            int id = (int) tblDichvu.getValueAt(selected, 0);
            
            try {
                conn=cn.getConnection();
                String sql="SELECT * FROM DICHVU where id=?";
                ps=conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs=ps.executeQuery();
                while(rs.next()){
                    txtChitietloi.setText(rs.getString("noiDung"));
                    txtChiphi.setText(rs.getString("chiPhi"));
                    txtThoigian.setText(rs.getString("thoiGianDuTinhHoanThanh"));
                }
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_tblDichvuMouseClicked

    private void btnLammoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoi2ActionPerformed
        // TODO add your handling code here:
        txtChitietloi.setText("");
        txtChiphi.setText("");
        txtThoigian.setText("");
    }//GEN-LAST:event_btnLammoi2ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtChitietloi.getText().equals("")||txtChiphi.getText().equals("")||txtThoigian.getText().equals("")){
            sb.append("Không được để trống\n");
        }
        if(sb.length()>0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PhieuNhan pn = new PhieuNhan();
        pn.setNoiDung(txtChitietloi.getText());
        pn.setChiPhi(txtChiphi.getText());
        pn.setThoiGianDuKienHoanThanh(txtThoigian.getText());
        
        try {
            conn=cn.getConnection();
            String sql="select * from DICHVU ";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if (rs.next()) {
                ThanhTien gia=new ThanhTien();
                gia.setGia(rs.getFloat("chiPhi"));
                
                time += rs.getInt("thoiGianDuTinhHoanThanh");
                thanhtien += gia.getGia();
                dichvusuachua += rs.getString("noiDung");
                                
                txtThanhtien.setText(""+thanhtien);
                
                if(time <= 8)
                    txtNgaynhan.setText("12/7/2022");
                else if(time>8 && time<=16)
                    txtNgaynhan.setText("12/8/2022");
                else if(time>16 && time<=24)
                    txtNgaynhan.setText("12/9/2022");
                else if(time>24 && time<=32)
                    txtNgaynhan.setText("12/10/2022");
                else if(time==0)
                    txtNgaynhan.setText("12/6/2022");
                
            }
        } catch (SQLException e) {
        }
        list.add(pn);
        fillTable();
        btnLammoi2ActionPerformed(evt);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblPhieunhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieunhanMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) tblPhieunhan.getModel();
        int selected = tblPhieunhan.getSelectedRow();
        PhieuNhan pn=new PhieuNhan();
        if(selected >= 0){
            String noiDung = (String) tblPhieunhan.getValueAt(selected, 0);
            
            try {
                conn=cn.getConnection();
                String sql="SELECT * FROM DICHVU where noiDung=?";
                ps=conn.prepareStatement(sql);
                ps.setString(1, noiDung);
                rs=ps.executeQuery();
                while(rs.next()){
                    txtChitietloi.setText(rs.getString("noiDung"));
                    txtChiphi.setText(rs.getString("chiPhi"));
                    txtThoigian.setText(rs.getString("thoiGianDuTinhHoanThanh"));
                }
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_tblPhieunhanMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        for (PhieuNhan pn : list) {
            if(pn.getNoiDung().equals(txtChitietloi.getText())){
                list.remove(pn);
                try {
                    conn=cn.getConnection();
                    String sql="select * from DICHVU ";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    ResultSet rs=pst.executeQuery();
                    if (rs.next()) {
                        thanhtien -= rs.getFloat("chiPhi");
                        txtThanhtien.setText(""+thanhtien);
                        time += rs.getInt("thoiGianDuTinhHoanThanh");
                        if(time <= 8)
                            txtNgaynhan.setText("12/10/2022");
                        else if(time>8 && time<=16)
                            txtNgaynhan.setText("12/11/2022");
                        else if(time>16 && time<=24)
                            txtNgaynhan.setText("12/12/2022");
                        else if(time>24 && time<=32)
                            txtNgaynhan.setText("12/13/2022");
                        else if(time==0)
                            txtNgaynhan.setText("12/9/2022");
                    }
                } catch (SQLException e) {
                }
                fillTable();
                btnLammoi2ActionPerformed(evt);
            }
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        FormDangNhap dn=new FormDangNhap();
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        conn=cn.getConnection();
        //xác nhận lưu
        if(txtMota2.getText().equals("")||txtNgaynhan.getText().equals("")||txtSerimay2.getText().equals("")||txtTenkhachhang2.getText().equals("")||txtThanhtien.getText().equals("")||dichvusuachua.equals("")||txtSodienthoai.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin khách hàng .-.");
        else{
        int dangki = JOptionPane.showConfirmDialog(this, "Xác nhận? (´,,•ω•,,)♡", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if(dangki != JOptionPane.YES_OPTION){
            return;
        }
        try {
            
            String trangthai =null;
            if(rdbDangxuly.isSelected())
                trangthai="Đang Xử Lý";
            else
                trangthai="Hoàn Trả";

            String nhanviensql="insert into PHIEUNHAN(nguoiNhan,noiDung,moTa,series,trangThai,chiPhi,SDT) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(nhanviensql);
            ps.setString(1, txtTenkhachhang2.getText());
            ps.setString(2, dichvusuachua);
            ps.setString(3, txtMota2.getText());
            ps.setString(4, txtSerimay2.getText());
            ps.setString(5, trangthai);
            ps.setFloat(6, thanhtien);
            ps.setString(7, txtSodienthoai.getText());
            
            time = 0;
            thanhtien=0;
            
            int n=ps.executeUpdate();
            
            if(n!=0)
                JOptionPane.showMessageDialog(this,"Đăng kí thành công (￣▽￣)");
            else
                JOptionPane.showMessageDialog(this,"Đăng kí thất bại (￣▽￣)");
            LoadDataToArrayList();
            LoadDataArrayListToTable();
            txtChiphi.setText("");
            txtChitietloi.setText("");
            txtMota.setText("");
            txtMota2.setText("");
            txtNgaynhan.setText("");
            txtSerimay.setText("");
            txtSerimay2.setText("");
            txtSodienthoai.setText("");
            txtTenkhachhang.setText("");
            txtTenkhachhang2.setText("");
            txtThanhtien.setText("");
            txtThoigian.setText("");
            txtTimkiem.setText("");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void txtMotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotaKeyReleased
        // TODO add your handling code here:
        txtMota2.setText(txtMota.getText());
    }//GEN-LAST:event_txtMotaKeyReleased

    private void txtSerimayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerimayKeyReleased
        // TODO add your handling code here:
        txtSerimay2.setText(txtSerimay.getText());
    }//GEN-LAST:event_txtSerimayKeyReleased

    private void txtTenkhachhangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenkhachhangKeyReleased
        // TODO add your handling code here:
        txtTenkhachhang2.setText(txtTenkhachhang.getText());
    }//GEN-LAST:event_txtTenkhachhangKeyReleased

    private void tblPhieunhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPhieunhanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPhieunhanKeyReleased

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
            java.util.logging.Logger.getLogger(HomePanelForStaffTiepNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePanelForStaffTiepNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePanelForStaffTiepNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePanelForStaffTiepNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomePanelForStaffTiepNhan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HomePanelForStaffTiepNhan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnLammoi2;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblClock;
    private javax.swing.JRadioButton rdbDangxuly;
    private javax.swing.JRadioButton rdbHoantra;
    private javax.swing.JTable tblDichvu;
    private javax.swing.JTable tblPhieunhan;
    private javax.swing.JTextField txtChiphi;
    private javax.swing.JTextField txtChitietloi;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtMota2;
    private javax.swing.JTextField txtNgaynhan;
    private javax.swing.JTextField txtSerimay;
    private javax.swing.JTextField txtSerimay2;
    private javax.swing.JTextField txtSodienthoai;
    private javax.swing.JTextField txtTenkhachhang;
    private javax.swing.JTextField txtTenkhachhang2;
    private javax.swing.JTextField txtThanhtien;
    private javax.swing.JTextField txtThoigian;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
