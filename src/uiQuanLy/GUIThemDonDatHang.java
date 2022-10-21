/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiQuanLy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

import dao.DAODonDatHang;
import dao.DAOHoaDon;
import dao.DAOKhachHang;
import dao.DAOSanPham;
import entity.ChiTietDonDatHang;
import entity.ChiTietHoaDon;
import entity.DonDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import uiMenu.GUIMenuQuanLy;

/**
 *
 * @author DuyBui
 */
public class GUIThemDonDatHang extends javax.swing.JPanel implements ActionListener{
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDatHang;
    private javax.swing.JButton btnHuyDonDatHang;
    private javax.swing.JButton btnThayDoiSL;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cbbKhuyenMai;
    private javax.swing.JComboBox<String> cboKhachHang;
    private javax.swing.JComboBox<String> cboSanPham;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtDiaChi;
    private com.toedter.calendar.JDateChooser jdcNgayDat;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblMaDDH;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblNgayDat;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTongSLHang;
    private javax.swing.JLabel lblTongThanhTien;
    private javax.swing.JLabel lblTongThanhToan;
    private javax.swing.JPanel pnTTDonDatHang;
    private javax.swing.JPanel pnTTKhachHang;
    private javax.swing.JTable tblMuaHang;
    private javax.swing.JTextField txtMaDDH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTongSLHang;
    private javax.swing.JTextField txtTongThanhTien;
    private javax.swing.JTextField txtTongThanhToan;
    private DefaultComboBoxModel modelcboKhachHang;
    private DefaultComboBoxModel modelcboSanPham;
    private DefaultComboBoxModel modelcboGioiTinh;
    private JComboBox<String> cboKhuyenMai;
    private DefaultComboBoxModel modelcboKhuyenMai;
    private DefaultTableModel modeltblMuaHang;
    private JButton btnLamMoi;
    
    private ArrayList<KhachHang> dsKhachHang;
    private ArrayList<SanPham> dsSanPham;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private ArrayList<ChiTietDonDatHang> dsCTDDH;
    private double thanhTien;
    private double thanhToan;
    private DonDatHang donDatHang;
    
    private DAOKhachHang daoKhachHang;
    private DAOSanPham daoSanPham;
    private DAODonDatHang daoDonDatHang;
    
    private JFrame parent;

    public GUIThemDonDatHang() {
		// TODO Auto-generated constructor stub
    	init();
	}
    
    
    
	public GUIThemDonDatHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		init();
		loadTTKhachHang();
	}



	public void init() {
		daoKhachHang = new DAOKhachHang();
    	daoSanPham = new DAOSanPham();
    	daoDonDatHang = new DAODonDatHang();
    	dsCTDDH = new ArrayList<ChiTietDonDatHang>();
        initComponents();
        setModel();
        formatForm();
        updateCboKhachHang();
        addListenerCBOKhachHang();
        updateCboSanPham();
        addListenerCBOSanPham();
    }
 
	private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnTTKhachHang = new javax.swing.JPanel();
        lblMaKH = new javax.swing.JLabel();
        cboKhachHang = new javax.swing.JComboBox<>();
        txtMaKH = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblNgaySinh = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        btnLamMoi = new javax.swing.JButton();
        pnTTDonDatHang = new javax.swing.JPanel();
        lblMaDDH = new javax.swing.JLabel();
        lblNgayDat = new javax.swing.JLabel();
        txtMaDDH = new javax.swing.JTextField();
        jdcNgayDat = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMuaHang = new javax.swing.JTable();
        cboSanPham = new javax.swing.JComboBox<>();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnThayDoiSL = new javax.swing.JButton();
        lblTongSLHang = new javax.swing.JLabel();
        lblTongThanhTien = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        lblTongThanhToan = new javax.swing.JLabel();
        txtTongSLHang = new javax.swing.JTextField();
        txtTongThanhTien = new javax.swing.JTextField();
        txtTongThanhToan = new javax.swing.JTextField();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        btnDatHang = new javax.swing.JButton();
        btnHuyDonDatHang = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1536, 650));

        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 0));
        lblTitle.setText("THÊM ĐƠN ĐẶT HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(558, 558, 558)
                .addComponent(lblTitle)
                .addContainerGap(784, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTTKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        lblMaKH.setText("Mã khách hàng: ");

        cboKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTenKH.setText("Tên khách hàng: ");

        lblGioiTinh.setText("Giới tính: ");

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSDT.setText("Số điện thoại: ");


        lblDiaChi.setText("Địa chỉ:  ");


        lblNgaySinh.setText("Ngày sinh: ");

        jdcNgaySinh.setDateFormatString("yyyy-MM-dd");

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTTKhachHangLayout = new javax.swing.GroupLayout(pnTTKhachHang);
        pnTTKhachHang.setLayout(pnTTKhachHangLayout);
        pnTTKhachHangLayout.setHorizontalGroup(
            pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(lblMaKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lblSDT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDT))
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnLamMoi)))
                .addContainerGap())
        );
        pnTTKhachHangLayout.setVerticalGroup(
            pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(cboKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(txtSDT))
                    .addComponent(lblSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTKhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pnTTDonDatHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin đơn đặt hàng"));

        lblMaDDH.setText("Mã đơn đặt hàng: ");

        lblNgayDat.setText("Ngày đặt hàng: ");

        jdcNgayDat.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout pnTTDonDatHangLayout = new javax.swing.GroupLayout(pnTTDonDatHang);
        pnTTDonDatHang.setLayout(pnTTDonDatHangLayout);
        pnTTDonDatHangLayout.setHorizontalGroup(
            pnTTDonDatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTDonDatHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTTDonDatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaDDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTDonDatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDDH)
                    .addComponent(jdcNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTTDonDatHangLayout.setVerticalGroup(
            pnTTDonDatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTDonDatHangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnTTDonDatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDDH)
                    .addComponent(lblMaDDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnTTDonDatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jdcNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        modeltblMuaHang = new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn vị tính", "Đơn giá", "Số lượng", "Thành tiền"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };
        tblMuaHang = new JTable(modeltblMuaHang) {	
			public boolean isCellEditable(int row, int col) {	
				return false;	
		}	
		public Component prepareRenderer( TableCellRenderer renderer, int row, int col ) {	
			Component c = super.prepareRenderer(renderer, row, col);	
			if ( row % 2 == 0 && !isCellSelected(row, col)) {	
				c.setBackground( Color.decode("#FFFFFF") );	
			}	
			else	
				if(!isCellSelected(row, col)){	
					c.setBackground( Color.decode("#99FFFF") );	
				}else {	
					c.setBackground(Color.decode("#25C883"));	
				}	
			return c;	
		}	
	};;
        tblMuaHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblMuaHang);
        if (tblMuaHang.getColumnModel().getColumnCount() > 0) {
            tblMuaHang.getColumnModel().getColumn(0).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblMuaHang.getColumnModel().getColumn(1).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblMuaHang.getColumnModel().getColumn(2).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblMuaHang.getColumnModel().getColumn(3).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblMuaHang.getColumnModel().getColumn(4).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblMuaHang.getColumnModel().getColumn(5).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblMuaHang.getColumnModel().getColumn(6).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(6).setPreferredWidth(40);
            tblMuaHang.getColumnModel().getColumn(7).setResizable(false);
            tblMuaHang.getColumnModel().getColumn(7).setPreferredWidth(70);
        }

        modelcboSanPham = new DefaultComboBoxModel<>();
        cboSanPham.setModel(modelcboSanPham);

        lblSoLuong.setText("Số lượng: ");

        btnThemSP.setText("Thêm sản phẩm");

        btnXoaSP.setText("Xóa sản phẩm");

        btnThayDoiSL.setText("Thay đổi số lượng");

        lblTongSLHang.setText("Tổng số lượng hàng: ");
        lblTongSLHang.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblTongThanhTien.setText("Tổng thành tiền: ");
        lblTongThanhTien.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblKhuyenMai.setText("Khuyến mãi:");
        lblKhuyenMai.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblTongThanhToan.setText("Tổng thanh toán: ");
        lblTongThanhToan.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtTongSLHang.setPreferredSize(new java.awt.Dimension(70, 25));

        txtTongThanhTien.setPreferredSize(new java.awt.Dimension(70, 25));

        txtTongThanhToan.setPreferredSize(new java.awt.Dimension(70, 25));

        cbbKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "10%" }));

        btnDatHang.setText("Đặt hàng");

        btnHuyDonDatHang.setText("Hủy đơn đặt hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1045, 1045, 1045)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnTTDonDatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTongSLHang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTongSLHang, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(94, 94, 94)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTongThanhToan)
                                            .addComponent(lblTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnThemSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnHuyDonDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(24, 24, 24)))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnTTDonDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTongThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTongThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTongThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTongThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuyDonDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongSLHang, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(lblTongSLHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbKhuyenMai)
                            .addComponent(lblKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        
        cboKhuyenMai = new JComboBox<String>(new String[] {"0%", "5%", "7%"});
        dangKySuKien();

        jPanel1.getAccessibleContext().setAccessibleName("");
    }
          
	private void dangKySuKien() {
		btnLamMoi.addActionListener(this);
		btnDatHang.addActionListener(this);
		btnHuyDonDatHang.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnXoaSP.addActionListener(this);
		btnThayDoiSL.addActionListener(this);
	}
	
	private void loadData() {
		dsKhachHang = daoKhachHang.getDanhsachKhachHang();
		dsSanPham =  daoSanPham.getDanhsachSanPham();
	}

                                       
    private void btnHuyDDHActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	if (JOptionPane.showConfirmDialog(null, "Xác nhận hủy hóa đơn") == JOptionPane.YES_OPTION)
			GUIMenuQuanLy.showPanel(new GUIThemDonDatHang());
    }          
    private void setModel() {
    	modelcboGioiTinh = new DefaultComboBoxModel<>();
    	modelcboGioiTinh.addElement("Nam");
    	modelcboGioiTinh.addElement("Nữ");
    	cboGioiTinh.setModel(modelcboGioiTinh);
    	
    	modelcboKhachHang = new DefaultComboBoxModel<>();
    	cboKhachHang.setModel(modelcboKhachHang);
    	
    	modelcboSanPham = new DefaultComboBoxModel<>();
    	cboSanPham.setModel(modelcboSanPham);
    }
    
    private void updateCboKhachHang() {
    	dsKhachHang = daoKhachHang.getDanhsachKhachHang();
		modelcboKhachHang.removeAllElements();
		modelcboKhachHang.addAll(dsKhachHang);
		modelcboKhachHang.setSelectedItem(null);
    }
    
    private void updateCboSanPham() {
		dsSanPham = daoSanPham.getDanhsachSanPham();
		modelcboSanPham.removeAllElements();
		modelcboSanPham.addAll(dsSanPham);
		modelcboSanPham.setSelectedItem(null);
    }
    
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	clearPanelKhachHang();
    	updateCboKhachHang();
    }                                          

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	int selected = tblMuaHang.getSelectedRow();
    	if (selected == -1) {
    		JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa");
    		return;
    	}
    	String maSP = tblMuaHang.getValueAt(selected, 1).toString();
    
    	if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa") == JOptionPane.YES_OPTION)
	    	for (ChiTietDonDatHang chiTietDonDatHang : dsCTDDH) {
				if (chiTietDonDatHang.getSanPham().getMaSP() == maSP) {
					dsCTDDH.remove(chiTietDonDatHang);
					updateTableMuaHang();
					return;
				}
			}
    }      
    
    private void btnDatHangActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	if (cboKhachHang.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin khách hàng");
			return;
		}
		if (dsCTDDH.size() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất 1 sản phẩm");
			return;
		}
		
		String ngaySinh = ((JTextField) jdcNgaySinh.getDateEditor().getUiComponent()).getText();
		if (modelcboKhachHang.getSelectedItem() instanceof KhachHang)
			this.khachHang = (KhachHang)modelcboKhachHang.getSelectedItem();
		else
			this.khachHang = new KhachHang(txtMaKH.getText(), modelcboKhachHang.getSelectedItem().toString(), txtSDT.getText(), 
									LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
									cboGioiTinh.getSelectedItem().equals("Nam")?true:false, txtDiaChi.getText());
		donDatHang = new DonDatHang("maHD", khachHang, LocalDateTime.now(), 0, dsCTDDH);	
		if(daoDonDatHang.themDonDatHang(donDatHang)) {
			JOptionPane.showMessageDialog(null, "Thêm đơn đặt hàng thành công");
		}
		else {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, thử lại sau");
		}
	}

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	if (modelcboSanPham.getSelectedItem() instanceof String || modelcboSanPham.getSelectedItem() == null) {
    		JOptionPane.showMessageDialog(null, "Vui long chon san pham hop le");
    		return;
    	}
    	
    	int sTT = modeltblMuaHang.getRowCount();
    	SanPham sanPham = (SanPham) modelcboSanPham.getSelectedItem();
    	int soLuong = Integer.parseInt(txtSoLuong.getText());
    	
    	if (sanPham.getSoLuongCon() < soLuong) {
    		JOptionPane.showMessageDialog(null, "Số lượng không đủ!\n Số lượng còn lại: " + sanPham.getSoLuongCon());
    		return;
    	}
    	
    	ChiTietDonDatHang chiTietDonDatHang = new ChiTietDonDatHang(sanPham, sanPham.getGiaBan(), soLuong);
    	for (int i = 0; i < dsCTDDH.size(); i++) {
    		ChiTietDonDatHang cthd = dsCTDDH.get(i);
			if (cthd.equals(chiTietDonDatHang)) {
				if (cthd.getSanPham().getSoLuongCon() < cthd.getSoLuong() + soLuong) {
					JOptionPane.showMessageDialog(null, "Số lượng không đủ!\n Số lượng còn lại: " + 
									(sanPham.getSoLuongCon() - cthd.getSoLuong()));
		    		return;
				}
				cthd.setSoLuong(cthd.getSoLuong() + soLuong);
				modeltblMuaHang.setValueAt(chiTietDonDatHang.getSoLuong(), i, 6);
				updateTableMuaHang();
				modelcboSanPham.setSelectedItem(null);
		    	txtSoLuong.setText("1");
				return;
			}
		}
    	dsCTDDH.add(chiTietDonDatHang);
    	updateTableMuaHang();
    	modelcboSanPham.setSelectedItem(null);
    	txtSoLuong.setText("1");
    }         
    
    private void btnThayDoiSLActionPerformed(ActionEvent evt) {
    	int selected = tblMuaHang.getSelectedRow();
    	if (selected == -1) {
    		JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần thay đổi số lượng");
    		return;
    	}
    	String maSP = tblMuaHang.getValueAt(selected, 1).toString();
    
    	for (ChiTietDonDatHang chiTietDonDatHang : dsCTDDH) {
			if (chiTietDonDatHang.getSanPham().getMaSP() == maSP) {
				int soLuongMoi = chiTietDonDatHang.getSoLuong();
		    	try {
					soLuongMoi = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng"));
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng dương");
					return;
				}
		    	if (chiTietDonDatHang.getSanPham().getSoLuongCon() < soLuongMoi) {
					JOptionPane.showMessageDialog(null, "Số lượng không đủ!\n Số lượng còn lại: " + 
									chiTietDonDatHang.getSanPham().getSoLuongCon());
		    		return;
				}
		    	chiTietDonDatHang.setSoLuong(soLuongMoi);
		    	updateTableMuaHang();
			}
		}
    	
	    	
    }                                        
	
    private void addListenerCBOKhachHang() {
    	cboKhachHang.setEditable(true);
    	cboKhachHang.setMaximumRowCount(5);
    	JTextField editor = (JTextField) cboKhachHang.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
//				if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				if(e.getKeyCode() != KeyEvent.VK_TAB) {
					String txt = ((JTextComponent)cboKhachHang.getEditor().getEditorComponent()).getText();
					modelcboKhachHang.removeAllElements();
					if (!txt.equals("")) {
						for (KhachHang khachHang : dsKhachHang) {
							if(khachHang.toString().toLowerCase().contains(txt.trim().toLowerCase())) {
								modelcboKhachHang.addElement(khachHang);
							}
						}
					}
					else
						modelcboKhachHang.addAll(dsKhachHang);
					
					modelcboKhachHang.setSelectedItem(txt);
				}
			}
		});
        
        editor.addFocusListener(new FocusAdapter() {
    	   @Override
    	   public void focusGained(FocusEvent e) {
    	      cboKhachHang.showPopup();
    	   }
    	}
      );
        
        cboKhachHang.addItemListener((ItemEvent e) -> { 
            Object item = e.getItem(); 
            if (e.getStateChange() == ItemEvent.SELECTED) { 
            	// nếu chọn item trong cbo
                if (item instanceof KhachHang) {
                	setEditableKhachHang(false);
                	KhachHang khachHang = (KhachHang) item;
                	txtMaDDH.setText(daoDonDatHang.getMaDonDatHang(khachHang.getsDT()));
                	txtMaKH.setText(khachHang.getMaKH());
                	txtSDT.setText(khachHang.getsDT());
                	txtDiaChi.setText(khachHang.getDiaChi());
                	if (khachHang.isGioiTinh())
                		modelcboGioiTinh.setSelectedItem("Nam");
                	else
                		modelcboGioiTinh.setSelectedItem("Nữ");	
                	((JTextField) jdcNgaySinh.getDateEditor().getUiComponent())
                	.setText(khachHang.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                }
                else {
                	setEditableKhachHang(true);
                	clearPanelKhachHang();
                	txtMaKH.setText("jdbc");
                }
            }
        }); 
        		
    }
    
    private void setEditableKhachHang(boolean check) {
    	txtDiaChi.setEditable(check);
    	txtSDT.setEditable(check);
    	cboGioiTinh.setEditable(check);
    	cboGioiTinh.setEnabled(check);
    	jdcNgaySinh.setEnabled(false);
    }
    
    private void loadTTKhachHang() {
    	if (khachHang != null) {
    		txtMaKH.setText(khachHang.getMaKH());
    		modelcboKhachHang.setSelectedItem(khachHang);
    		cboKhachHang.setEditable(false);
    		if (khachHang.isGioiTinh())
    			modelcboGioiTinh.setSelectedItem("Nam");
    		else
    			modelcboGioiTinh.setSelectedItem("Nữ");
    		txtDiaChi.setText(khachHang.getDiaChi());
    		txtSDT.setText(khachHang.getsDT());
//    		btn.setEnabled(false);
    	}
    }
    
    private void clearPanelKhachHang() {
    	txtMaKH.setText("");
    	txtDiaChi.setText("");
    	txtSDT.setText("");
    	modelcboGioiTinh.setSelectedItem("Nam");
    	((JTextField) jdcNgaySinh.getDateEditor().getUiComponent()).setText("");
    }
    
    private void addListenerCBOSanPham() {
    	cboSanPham.setEditable(true);
    	cboSanPham.setMaximumRowCount(5);
    	JTextField editor = (JTextField) cboSanPham.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				cboSanPham.setPopupVisible(true);
//				if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				if(e.getKeyCode() != KeyEvent.VK_TAB) {
					String txt = ((JTextComponent)cboSanPham.getEditor().getEditorComponent()).getText();
					modelcboSanPham.removeAllElements();
					if (!txt.equals("")) {
						for (SanPham sanPham : dsSanPham) {
							if(sanPham.toString().toLowerCase().contains(txt.trim().toLowerCase())) {
								modelcboSanPham.addElement(sanPham);
							}
						}
					}
					else
						modelcboSanPham.addAll(dsSanPham);
					
					modelcboSanPham.setSelectedItem(txt);
			}
			}
		});
        
        editor.addFocusListener(new FocusAdapter() {
        	@Override
     	   public void focusGained(FocusEvent e) {
     	      cboSanPham.showPopup();
     	   }
		});
        
        		
    }

    private void updateTableMuaHang() {
    	modeltblMuaHang.setRowCount(0);
    	int tongSL = 0;
    	double tongThanhTien = 0;
    	for (ChiTietDonDatHang chiTietHoaDon : dsCTDDH) {
    		int sTT = modeltblMuaHang.getRowCount();
    		SanPham sanPham = chiTietHoaDon.getSanPham();
    		Object row[] = {sTT++, sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getLoaiSP().getTenLoai(),
       			 sanPham.getDonViTinh().getTenDVT(), sanPham.getGiaBan(), chiTietHoaDon.getSoLuong(), 
       			 chiTietHoaDon.getThanhTien()};
    		modeltblMuaHang.addRow(row);
    		tongSL += chiTietHoaDon.getSoLuong();
    		tongThanhTien += chiTietHoaDon.getThanhTien();
		}
    	txtTongSLHang.setText(tongSL +"");
    	DecimalFormat tienFormat = new DecimalFormat("#,##0.00");
    	txtTongThanhTien.setText(tienFormat.format(tongThanhTien)+" VND");
    	txtTongThanhToan.setText(tienFormat.format(tongThanhTien)+" VND");
    	thanhTien = tongThanhTien;
    	
    	if (thanhTien >= 5000000) {
    		cboKhuyenMai.setSelectedItem("7%");
    		thanhToan = thanhTien - thanhTien*0.07;
    	}else if (thanhTien >= 2000000) {
    		cboKhuyenMai.setSelectedItem("5%");
    		thanhToan = thanhTien - thanhTien*0.05;
    	}else {
    		cboKhuyenMai.setSelectedItem("0%");
    		thanhToan = thanhTien;
    	}
    }
    
    private void formatForm() {
    	lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(Color.red);
        txtMaKH.setEditable(false);
        txtMaDDH.setEditable(false);
        cboKhuyenMai.setEnabled(false);
        
        ((JTextField) jdcNgaySinh.getDateEditor().getUiComponent()).setSelectedTextColor(Color.black);
        
        btnThemSP.setIcon(new ImageIcon("./image/them.png"));
        btnThayDoiSL.setIcon(new ImageIcon("./image/lammoi.png"));
        btnXoaSP.setIcon(new ImageIcon("./image/xoa.png"));

        jdcNgayDat.setEnabled(false);
        ((JTextField)jdcNgayDat.getDateEditor().getUiComponent()).setText(LocalDate.now()
        		.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        
     // không duy chuyển cột
        tblMuaHang.getTableHeader().setReorderingAllowed(false);
        txtSoLuong.setText("1");
        txtTongSLHang.setEditable(false);
        txtTongThanhTien.setEditable(false);
        txtTongThanhToan.setEditable(false);
        cboKhuyenMai.setEnabled(false);
        txtSoLuong.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		// TODO Auto-generated method stub
        		super.focusGained(e);
        		txtSoLuong.selectAll();
        	}
		});
        
        txtSoLuong.addKeyListener(new KeyAdapter() {
        	@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
        ArrayList<JTextField> numberTextField = new ArrayList<JTextField>(Arrays.asList(
        		txtTongSLHang, txtTongThanhTien, txtTongThanhToan));
        numberTextField.forEach(x -> x.setHorizontalAlignment(SwingConstants.RIGHT));
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if(object.equals(btnLamMoi)) {
			btnLamMoiActionPerformed(e);
		} 
		else if(object.equals(btnThemSP)) {
			btnThemSPActionPerformed(e);
		}
		else if(object.equals(btnXoaSP)) {
			btnXoaSPActionPerformed(e);
		}
		else if(object.equals(btnThayDoiSL)) {
			btnThayDoiSLActionPerformed(e);
		}
		else if(object.equals(btnDatHang)) {
			btnDatHangActionPerformed(e);
		}
		else if(object.equals(btnHuyDonDatHang)) {
			btnHuyDDHActionPerformed(e);
		}
		
	}
	
}
