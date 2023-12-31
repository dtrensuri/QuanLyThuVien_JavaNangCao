/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.GUI;

import MyCustom.MyDateFormat;
import MyCustom.MyDialog;
import QLTV.BUS.DocGiaBUS;
import QLTV.DAO.MyConnect;
import QLTV.DTO.DocGia;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author chihi
 */
public class pnQuanLyDocGiaGUI extends javax.swing.JPanel {
    DefaultTableModel tabModelDocGia;
    public DocGiaBUS docGiaBUS;
    ArrayList<DocGia> listDG ;
    /**
     * Creates new form pnQuanLyDocGiaGUI
     */
    public pnQuanLyDocGiaGUI() {
        new MyConnect();
        initComponents();
        docGiaBUS = new DocGiaBUS();
        
        tabModelDocGia = (DefaultTableModel)jtblListDocGia.getModel();
        showColumneTable();
        loadTableDocGia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfMaThe = new javax.swing.JTextField();
        jtfKhoa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfNienKhoa = new javax.swing.JTextField();
        jtfLop = new javax.swing.JTextField();
        jbtnThem = new javax.swing.JButton();
        jbtnLuu = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jbtnTimKiem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jbtnXoaTrang = new javax.swing.JButton();
        jtfHoVaTen = new javax.swing.JTextField();
        jdateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblListDocGia = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(1743, 333));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mã thẻ :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Họ và tên :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Ngày sinh :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Khoa :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        jtfMaThe.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfMaThe.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jtfMaThe, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 271, -1));

        jtfKhoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfKhoa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jtfKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 271, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Lớp :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Niên khóa :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, -1));

        jtfNienKhoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfNienKhoa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jtfNienKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 269, -1));

        jtfLop.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfLop.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jtfLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 269, -1));

        jbtnThem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnThem.setIcon(new javax.swing.ImageIcon("C:\\Users\\chihi\\OneDrive\\Documents\\NetBeansProjects\\QuanLyThuVien_1_1\\image\\add-icon.png")); // NOI18N
        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 210, -1));

        jbtnLuu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnLuu.setIcon(new javax.swing.ImageIcon("C:\\Users\\chihi\\OneDrive\\Documents\\NetBeansProjects\\QuanLyThuVien_1_1\\image\\Pencil-icon.png")); // NOI18N
        jbtnLuu.setText("Sửa");
        jbtnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLuuActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 210, -1));

        jbtnXoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnXoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\chihi\\OneDrive\\Documents\\NetBeansProjects\\QuanLyThuVien_1_1\\image\\delete-icon.png")); // NOI18N
        jbtnXoa.setText("Xóa");
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 210, -1));

        jbtnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnTimKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\chihi\\OneDrive\\Documents\\NetBeansProjects\\QuanLyThuVien_1_1\\image\\Search-icon.png")); // NOI18N
        jbtnTimKiem.setText("Tìm kiếm");
        jbtnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 210, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setText("Quản lý độc giả");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jbtnXoaTrang.setIcon(new javax.swing.ImageIcon("C:\\Users\\chihi\\OneDrive\\Documents\\NetBeansProjects\\QuanLyThuVien_DocGia\\image\\Refresh-icon.png")); // NOI18N
        jbtnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaTrangActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnXoaTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        jtfHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfHoVaTen.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jtfHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 271, -1));

        jdateChooserNgaySinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jdateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
        jdateChooserNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jdateChooserNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 270, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtblListDocGia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtblListDocGia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtblListDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblListDocGia.setRowHeight(35);
        jtblListDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblListDocGiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblListDocGia);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(153, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(347, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        // TODO add your handling code here:
        if (jtfMaThe.isEditable()==false) {
            new MyDialog("Bạn đang ở chế độ sửa thông tin, muốn thêm mới hãy ấn reset !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        
        if (jtfMaThe.getText().equals("")) {
            new MyDialog("Vui lòng nhập mã thẻ mới !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        if (jtfHoVaTen.getText().equals("")) {
            new MyDialog("Vui lòng nhập họ và tên độc giả !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        if (jdateChooserNgaySinh.getDate()==null) {
            new MyDialog("Vui lòng nhập ngày sinh của độc giả !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        if (jtfKhoa.getText().equals("")) {
            new MyDialog("Vui lòng nhập tên khoa  !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        if (jtfNienKhoa.getText().equals("")) {
            new MyDialog("Vui lòng nhập niên khóa !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        if (jtfLop.getText().equals("")) {
            new MyDialog("Vui lòng nhập tên lớp !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn thêm độc giả mới?", MyDialog.WARNING_DIALOG);
        if(dlg.OK_OPTION == dlg.getAction()){
            docGiaBUS.themDocGia(
            jtfMaThe.getText(),
            jtfHoVaTen.getText(),
            jdateChooserNgaySinh.getDate(),
            jtfKhoa.getText(),
            jtfNienKhoa.getText(),
            jtfLop.getText());
        }
        loadTableDocGia();
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jbtnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLuuActionPerformed
        // TODO add your handling code here:
        if (jtfMaThe.isEditable()==true) {
            new MyDialog("Bạn đang ở chế độ thêm thông tin mới, muốn sửa thông tin hãy click vào thông tin cần sửa trong bảng !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        docGiaBUS.suaDocGia(
        jtfMaThe.getText(),
        jtfHoVaTen.getText(),
        jdateChooserNgaySinh.getDate(),
        jtfKhoa.getText(),
        jtfNienKhoa.getText(),
        jtfLop.getText());
        loadTableDocGia();
    }//GEN-LAST:event_jbtnLuuActionPerformed

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        // TODO add your handling code here:
        if (jtfMaThe.isEditable()==true) {
            new MyDialog("Bạn đang ở chế độ thêm thông tin mới, muốn xóa thông tin hãy click vào thông tin cần xóa trong bảng !!!", MyDialog.ERROR_DIALOG);
            return ;
        }
        docGiaBUS.xoaDocGia(jtfMaThe.getText());
        loadTableDocGia();
    }//GEN-LAST:event_jbtnXoaActionPerformed

    private void jbtnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTimKiemActionPerformed
        while(true){
            String input = JOptionPane.showInputDialog(this, "Bạn vui lòng nhập tên độc giả cần tìm");
            if(input != null && input.length()>0){
                tabModelDocGia.setRowCount(0);
                listDG = docGiaBUS.getDocGiaYeuCau(input);
                for(DocGia dg : listDG){
                    tabModelDocGia.addRow(new Object[]{tabModelDocGia.getRowCount()+1,
                        dg.getMaThe(),
                        dg.getHoTen(),
                        MyDateFormat.getStringToDate(dg.getNgaySinh()),
                        dg.getKhoa(),
                        dg.getNienKhoa(),
                        dg.getLop()
                    });
                }
                if(tabModelDocGia.getRowCount()==0){
                    MyDialog dlg = new MyDialog("Không tìm được thông tin độc giả theo yêu cầu, vui lòng nhập lại!!!",MyDialog.WARNING_DIALOG);
                    if(dlg.CANCEL_OPTION == dlg.getAction()){
                        break;
                    } 
                }else{
                    new MyDialog("Tìm được "+tabModelDocGia.getRowCount()+" kết quả của độc giả có tên "+input+" !!",MyDialog.INFO_DIALOG);
                    break;
                }
            }else {
                return;
            }
        }
    }//GEN-LAST:event_jbtnTimKiemActionPerformed

    private void jbtnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaTrangActionPerformed
        // TODO add your handling code here:
        jtfMaThe.setEditable(true);
        jtfMaThe.setText("");
        jtfHoVaTen.setText("");
        jdateChooserNgaySinh.setDate(null);
        jtfKhoa.setText("");
        jtfNienKhoa.setText("");
        jtfLop.setText("");
        loadTableDocGia();
    }//GEN-LAST:event_jbtnXoaTrangActionPerformed

    private void jtblListDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblListDocGiaMouseClicked
        // TODO add your handling code here:
        jtfMaThe.setEditable(false);
        int row = jtblListDocGia.getSelectedRow();
        jtfMaThe.setText(jtblListDocGia.getValueAt(row, 1).toString());
        jtfHoVaTen.setText(jtblListDocGia.getValueAt(row, 2).toString());
        String a = jtblListDocGia.getValueAt(row, 3).toString();
        jdateChooserNgaySinh.setDate(MyDateFormat.getDateToString(a));
        jtfKhoa.setText(jtblListDocGia.getValueAt(row, 4).toString());
        jtfNienKhoa.setText(jtblListDocGia.getValueAt(row, 5).toString());
        jtfLop.setText(jtblListDocGia.getValueAt(row, 6).toString());
    }//GEN-LAST:event_jtblListDocGiaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnLuu;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnTimKiem;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JButton jbtnXoaTrang;
    private com.toedter.calendar.JDateChooser jdateChooserNgaySinh;
    private javax.swing.JTable jtblListDocGia;
    private javax.swing.JTextField jtfHoVaTen;
    private javax.swing.JTextField jtfKhoa;
    private javax.swing.JTextField jtfLop;
    private javax.swing.JTextField jtfMaThe;
    private javax.swing.JTextField jtfNienKhoa;
    // End of variables declaration//GEN-END:variables
    private void loadTableDocGia() {
        chinhColumn();
        tabModelDocGia.setRowCount(0);
        docGiaBUS.getListDocGia();
        listDG = docGiaBUS.getDanhSachDocGia();
        for(DocGia dg : listDG){            
            tabModelDocGia.addRow(new Object[]{tabModelDocGia.getRowCount()+1,
                dg.getMaThe(),
                dg.getHoTen(),
                MyDateFormat.getStringToDate(dg.getNgaySinh()),
                dg.getKhoa(),
                dg.getNienKhoa(),
                dg.getLop()
            });
//            System.out.println(""+dg.getHoTen());
        }
    }
    
    private void showColumneTable(){
        tabModelDocGia.addColumn("STT");
        tabModelDocGia.addColumn("Mã thẻ");
        tabModelDocGia.addColumn("Họ và tên");
        tabModelDocGia.addColumn("Ngày sinh");
        tabModelDocGia.addColumn("Khoa");
        tabModelDocGia.addColumn("Niên khóa");
        tabModelDocGia.addColumn("Lớp");
    }
    
    private void xoaThongTin(){
        jtfMaThe.setText("");
        jtfHoVaTen.setText("");
        jdateChooserNgaySinh.setDate(null);
        jtfKhoa.setText("");
        jtfNienKhoa.setText("");
        jtfLop.setText("");
    }
    
    private void chinhColumn(){
        JTableHeader header = jtblListDocGia.getTableHeader();
        
        Font font = new Font("Arial", Font.BOLD, 40);
        header.setBackground(new Color(242, 153, 74));
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setOpaque(false);
        header.setForeground(Color.BLACK);
        header.setReorderingAllowed(false);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
    }
}
