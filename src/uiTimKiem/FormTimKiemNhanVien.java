/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiTimKiem;

import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.JXRadioGroup;

/**
 *
 * @author MSII
 */
public class FormTimKiemNhanVien extends javax.swing.JPanel {
	
    public com.toedter.calendar.JDateChooser getJdcNgaySinh() {
		return jdcNgaySinh;
	}

	public void setJdcNgaySinh(com.toedter.calendar.JDateChooser jdcNgaySinh) {
		this.jdcNgaySinh = jdcNgaySinh;
	}

	public javax.swing.JRadioButton getJrdNam() {
		return jrdNam;
	}

	public void setJrdNam(javax.swing.JRadioButton jrdNam) {
		this.jrdNam = jrdNam;
	}

	public javax.swing.JRadioButton getJrdNu() {
		return jrdNu;
	}

	public void setJrdNu(javax.swing.JRadioButton jrdNu) {
		this.jrdNu = jrdNu;
	}

	public javax.swing.JTextField getTxtCCCD() {
		return txtCCCD;
	}

	public void setTxtCCCD(javax.swing.JTextField txtCCCD) {
		this.txtCCCD = txtCCCD;
	}

	public javax.swing.JTextField getTxtTenNV() {
		return txtTenNV;
	}

	public void setTxtTenNV(javax.swing.JTextField txtTenNV) {
		this.txtTenNV = txtTenNV;
	}

	/**
     * Creates new form GUITimKiemNhanVien
     */
    public FormTimKiemNhanVien() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblCCCD = new javax.swing.JLabel();
        jrdNam = new javax.swing.JRadioButton();
        lblNgaySinh = new javax.swing.JLabel();
        jrdNu = new javax.swing.JRadioButton();
        txtTenNV = new javax.swing.JTextField();
        lblGioiTinh = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        lblTimKiemNV = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();

     

        lblCCCD.setText("CCCD/CMND:");

        jrdNam.setSelected(true);
        jrdNam.setText("Nam");

        lblNgaySinh.setText("Ngày sinh:");

        jrdNu.setText("Nữ");
        jrdNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdNuActionPerformed(evt);
            }
        });

        lblGioiTinh.setText("Giới tính:");

        lblTimKiemNV.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTimKiemNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimKiemNV.setText("Tìm kiếm nhân viên");

        lblTenNV.setText("Tên nhân viên:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(lblTimKiemNV)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioiTinh)
                    .addComponent(lblNgaySinh)
                    .addComponent(lblCCCD)
                    .addComponent(lblTenNV))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jrdNam)
                        .addGap(43, 43, 43)
                        .addComponent(jrdNu))
                    .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTimKiemNV)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNV)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCCCD)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgaySinh)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiTinh)
                    .addComponent(jrdNam)
                    .addComponent(jrdNu))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        JXRadioGroup ggt = new JXRadioGroup();
        ggt.add(jrdNam);
        ggt.add(jrdNu);
        jdcNgaySinh.setDateFormatString("yyyy-MM-dd");
        ((JTextComponent)jdcNgaySinh.getDateEditor().getUiComponent()).setEditable(false);
    }// </editor-fold>                       

    private void jrdNuActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify                     
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JRadioButton jrdNam;
    private javax.swing.JRadioButton jrdNu;
    private javax.swing.JLabel lblCCCD;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTimKiemNV;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration                   
}
