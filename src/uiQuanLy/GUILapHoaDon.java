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
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

import dao.DAOKhachHang;
import dao.DAOSanPham;
import entity.ChiTietDonDatHang;
import entity.DonDatHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

/**
 *
 * @author DuyBui
 */
public class GUILapHoaDon extends javax.swing.JPanel {

	private javax.swing.JButton btnHuyHoaDon;
	private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoiSL;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboKhuyenMai;
    private javax.swing.JComboBox<SanPham> cboSanPham;
    private javax.swing.JComboBox<KhachHang> cboKhachHang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblnhanVien;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblSoTienTraLai;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTienKhachDua;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTongSLHang;
    private javax.swing.JLabel lblTongThanhTien;
    private javax.swing.JLabel lblTongThanhToan;
    private javax.swing.JPanel pnTTHoaDon;
    private javax.swing.JPanel pnTTKhachHang;
    private javax.swing.JTable tblMuaHang;
    private DefaultTableModel modelMuaHang;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtnhanVien;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoTienKhachDua;
    private javax.swing.JTextField txtSoTienTraLai;
    private javax.swing.JTextField txtTongSLHang;
    private javax.swing.JTextField txtTongThanhTien;
    private javax.swing.JTextField txtTongThanhToan;
    
    
    private DefaultComboBoxModel modelCboSanPham;
    private DefaultComboBoxModel modelCboKhachHang;
    private DefaultComboBoxModel modelCboGioiTinh;
    
    private ArrayList<KhachHang> dsKhachHang;
    private ArrayList<SanPham> dsSanPham;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private ArrayList<ChiTietDonDatHang> dsHangMua;
    
    private DAOKhachHang daoKhachHang;
    private DAOSanPham daoSanPham;
    
    
    public void init() {
    	daoKhachHang = new DAOKhachHang();
    	daoSanPham = new DAOSanPham();
        initComponents();
        setModel();
        formatForm();
        updateCboKhachHang();
        addListenerCBOKhachHang();
        updateCboSanPham();
        addListenerCBOSanPham();
    }
    
    public GUILapHoaDon(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
    	init();
        
    }
    
    public GUILapHoaDon(NhanVien nhanVien, KhachHang khachHang) {
    	this.nhanVien = nhanVien;
    	this.khachHang = khachHang;
    	init();
    	loadTTKhachHang();
    }
    
    public GUILapHoaDon(NhanVien nhanVien, DonDatHang donDatHang) {
    	this.nhanVien = nhanVien;
    	this.khachHang = donDatHang.getKhachHang();
    	this.dsHangMua = donDatHang.getdSCTDonDatHang();
    	init();
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
        txtSoDienThoai = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        pnTTHoaDon = new javax.swing.JPanel();
        lblMaHD = new javax.swing.JLabel();
        lblnhanVien = new javax.swing.JLabel();
        lblNgayLap = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtnhanVien = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
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
        cboKhuyenMai = new javax.swing.JComboBox<>();
        lblSoTienTraLai = new javax.swing.JLabel();
        lblTienKhachDua = new javax.swing.JLabel();
        txtSoTienTraLai = new javax.swing.JTextField();
        txtSoTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnXuatHoaDon = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1536, 650));

        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setText("LẬP HÓA ĐƠN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(657, 657, 657)
                .addComponent(lblTitle)
                .addContainerGap(685, Short.MAX_VALUE))
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

//        cboKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        lblTenKH.setText("Tên khách hàng: ");

        lblGioiTinh.setText("Giới tính: ");

//        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSDT.setText("Số điện thoại: ");

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        lblDiaChi.setText("Địa chỉ:  ");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

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
                    .addComponent(lblMaKH)
                    .addComponent(lblSDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoai))
                .addGap(18, 18, 18)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(cboKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTKhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi)
                        .addContainerGap())))
        );
        pnTTKhachHangLayout.setVerticalGroup(
            pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnTTHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        lblMaHD.setText("Mã hóa đơn: ");

        lblnhanVien.setText("Nhân viên bán hàng: ");

        lblNgayLap.setText("Ngày lập: ");

        javax.swing.GroupLayout pnTTHoaDonLayout = new javax.swing.GroupLayout(pnTTHoaDon);
        pnTTHoaDon.setLayout(pnTTHoaDonLayout);
        pnTTHoaDonLayout.setHorizontalGroup(
            pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTHoaDonLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblnhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addComponent(lblMaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD)
                    .addComponent(txtnhanVien)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnTTHoaDonLayout.setVerticalGroup(
            pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTHoaDonLayout.createSequentialGroup()
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblnhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        modelMuaHang = new javax.swing.table.DefaultTableModel(
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
        
        tblMuaHang = new JTable(modelMuaHang) {
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
		};
        
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

//        cboSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSoLuong.setText("Số lượng: ");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        btnThemSP.setText("Thêm sản phẩm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa sản phẩm");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnThayDoiSL.setText("Thay đổi số lượng");

        lblTongSLHang.setText("Tổng số lượng hàng: ");
        lblTongSLHang.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblTongThanhTien.setText("Tổng thành tiền: ");
        lblTongThanhTien.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblKhuyenMai.setText("Khuyến mãi");
        lblKhuyenMai.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblTongThanhToan.setText("Tổng thanh toán: ");
        lblTongThanhToan.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtTongSLHang.setPreferredSize(new java.awt.Dimension(70, 25));

        txtTongThanhTien.setPreferredSize(new java.awt.Dimension(70, 25));

        txtTongThanhToan.setPreferredSize(new java.awt.Dimension(70, 25));

        cboKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "10%" }));

        lblSoTienTraLai.setText("Số tiền trả lại: ");

        lblTienKhachDua.setText("Số tiền khách đưa: ");

        btnThanhToan.setText("Thanh toán");

        btnXuatHoaDon.setText("Xuất hóa đơn");

        btnHuyHoaDon.setText("Hủy hóa đơn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1045, 1045, 1045)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTongThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTongThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTongSLHang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTongThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTongThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTongSLHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboKhuyenMai, 0, 190, Short.MAX_VALUE))
                            .addGap(92, 92, 92)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSoTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(txtSoTienTraLai))
                            .addGap(494, 494, 494))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnThemSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                                    .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGap(0, 0, Short.MAX_VALUE))))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(pnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(pnTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnTTKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTongSLHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTongSLHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSoTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
    }       

    private void setModel() {
    	modelCboGioiTinh = new DefaultComboBoxModel<>();
    	modelCboGioiTinh.addElement("Nam");
    	modelCboGioiTinh.addElement("Nữ");
    	cboGioiTinh.setModel(modelCboGioiTinh);
    	
    	modelCboKhachHang = new DefaultComboBoxModel<>();
    	cboKhachHang.setModel(modelCboKhachHang);
    	
    	modelCboSanPham = new DefaultComboBoxModel<>();
    	cboSanPham.setModel(modelCboSanPham);
    	
//    	modelMuaHang = new DefaultTableModel();
//    	tblMuaHang.setModel(modelMuaHang);
    }
    
    private void updateCboKhachHang() {
    	
    	dsKhachHang = daoKhachHang.getDanhsachKhachHang();
		modelCboKhachHang.removeAllElements();
		modelCboKhachHang.addAll(dsKhachHang);
    }
    
    private void updateCboSanPham() {
    	
		dsSanPham = daoSanPham.getDanhsachSanPham();
		modelCboSanPham.removeAllElements();
		modelCboSanPham.addAll(dsSanPham);
    }
    
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	clearPanelKhachHang();
    	modelCboKhachHang.setSelectedItem(null);
    } 
    
    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
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
					modelCboKhachHang.removeAllElements();
					if (!txt.equals("")) {
						for (KhachHang khachHang : dsKhachHang) {
							if(khachHang.toString().toLowerCase().contains(txt.trim().toLowerCase())) {
								modelCboKhachHang.addElement(khachHang);
							}
						}
					}
					else
						modelCboKhachHang.addAll(dsKhachHang);
					
					modelCboKhachHang.setSelectedItem(txt);
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
                	txtMaKH.setText(khachHang.getMaKH());
                	txtSoDienThoai.setText(khachHang.getsDT());
                	txtDiaChi.setText(khachHang.getDiaChi());
                	if (khachHang.isGioiTinh())
                		modelCboGioiTinh.setSelectedItem("Nam");
                	else
                		modelCboGioiTinh.setSelectedItem("Nữ");	
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
    	txtSoDienThoai.setEditable(check);
    	cboGioiTinh.setEditable(check);
    	cboGioiTinh.setEnabled(check);
    }
    
    private void loadTTKhachHang() {
    	if (khachHang != null) {
    		txtMaKH.setText(khachHang.getMaKH());
    		modelCboKhachHang.setSelectedItem(khachHang);
    		cboKhachHang.setEditable(false);
    		if (khachHang.isGioiTinh())
    			modelCboGioiTinh.setSelectedItem("Nam");
    		else
    			modelCboGioiTinh.setSelectedItem("Nữ");
    		txtDiaChi.setText(khachHang.getDiaChi());
    		txtSoDienThoai.setText(khachHang.getsDT());
    		btnLamMoi.setEnabled(false);
    	}
    }
    
    private void clearPanelKhachHang() {
    	
    	txtMaKH.setText("");
    	txtDiaChi.setText("");
    	txtSoDienThoai.setText("");
    	modelCboGioiTinh.setSelectedItem("Nam");
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
					modelCboSanPham.removeAllElements();
					if (!txt.equals("")) {
						for (SanPham sanPham : dsSanPham) {
							if(sanPham.toString().toLowerCase().contains(txt.trim().toLowerCase())) {
								modelCboSanPham.addElement(sanPham);
							}
						}
					}
					else
						modelCboSanPham.addAll(dsSanPham);
					
					modelCboSanPham.setSelectedItem(txt);
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

    private void formatForm() {
    	lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(Color.red);
        txtMaKH.setEditable(false);
        txtMaHD.setText("jdbc");
        txtMaHD.setEditable(false);
        txtnhanVien.setText(nhanVien.getTenNV());
        txtnhanVien.setEditable(false);
        txtNgayLap.setText(LocalDate.now().toString());
        txtNgayLap.setEditable(false);
        
        btnThemSP.setIcon(new ImageIcon("./image/them.png"));
        btnThayDoiSL.setIcon(new ImageIcon("./image/lammoi.png"));
        btnXoaSP.setIcon(new ImageIcon("./image/xoa.png"));
        btnThanhToan.setIcon(new ImageIcon("./image/tien.png"));
        btnXuatHoaDon.setIcon(new ImageIcon("./image/in.png"));
        btnHuyHoaDon.setIcon(new ImageIcon("./image/huy.png"));
        
     // không duy chuyển cột
        tblMuaHang.getTableHeader().setReorderingAllowed(false);
        
        txtTongSLHang.setEditable(false);
        txtTongThanhTien.setEditable(false);
        txtTongThanhToan.setEditable(false);
        txtSoTienTraLai.setEditable(false);
        cboKhuyenMai.setEnabled(false);
    }
}
