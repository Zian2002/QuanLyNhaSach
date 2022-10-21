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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

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
public class GUILapHoaDon extends javax.swing.JPanel implements ActionListener{

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
    private javax.swing.JLabel lblNhanVien;
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
    private ArrayList<ChiTietDonDatHang> dsCTDDH;
    private double thanhTien;
    private double thanhToan;
    private HoaDon hoaDon;
    
    private ArrayList<ChiTietHoaDon> dsCTHD;
    private DAOKhachHang daoKhachHang;
    private DAOSanPham daoSanPham;
    private DAOHoaDon daoHoaDon;
    
    private JFrame parent;
	private JDateChooser jdcNgaySinh;
	private JLabel lblNgaySinh;
    
    
    public void init() {
    	daoKhachHang = new DAOKhachHang();
    	daoSanPham = new DAOSanPham();
    	daoHoaDon = new DAOHoaDon();
    	dsCTHD = new ArrayList<ChiTietHoaDon>();
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
       	loadTTKhachHang();
    	this.dsCTHD = donDatHang.convertToCTHDList();
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
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblNgaySinh = new javax.swing.JLabel();
        pnTTHoaDon = new javax.swing.JPanel();
        lblMaHD = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
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
        Component filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));

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
//
//        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtMaKHActionPerformed(evt);
//            }
//        });

        lblTenKH.setText("Tên khách hàng: ");

        lblGioiTinh.setText("Giới tính: ");

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSDT.setText("Số điện thoại: ");


        lblDiaChi.setText("Địa chỉ:  ");

        btnLamMoi.setText("Làm mới");

        jdcNgaySinh.setDateFormatString("yyyy-MM-dd");

        lblNgaySinh.setText("Ngày sinh: ");

        javax.swing.GroupLayout pnTTKhachHangLayout = new javax.swing.GroupLayout(pnTTKhachHang);
        pnTTKhachHang.setLayout(pnTTKhachHangLayout);
        pnTTKhachHangLayout.setHorizontalGroup(
            pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(lblMaKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoDienThoai)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTKhachHangLayout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addComponent(btnLamMoi)))
                .addContainerGap())
        );
        pnTTKhachHangLayout.setVerticalGroup(
            pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(cboKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnTTHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        lblMaHD.setText("Mã hóa đơn: ");

        lblNhanVien.setText("Nhân viên : ");

        lblNgayLap.setText("Ngày lập: ");

        javax.swing.GroupLayout pnTTHoaDonLayout = new javax.swing.GroupLayout(pnTTHoaDon);
        pnTTHoaDon.setLayout(pnTTHoaDonLayout);
        pnTTHoaDonLayout.setHorizontalGroup(
            pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTHoaDonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtnhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayLap))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnTTHoaDonLayout.setVerticalGroup(
            pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTHoaDonLayout.createSequentialGroup()
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTTHoaDonLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
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
        lblSoLuong.setText("Số lượng: ");

        btnThemSP.setText("Thêm sản phẩm");

        btnXoaSP.setText("Xóa sản phẩm");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1045, 1045, 1045)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(494, 494, 494)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnXoaSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(pnTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(pnTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        
        dangKySuKien();
    }//
    
    private void dangKySuKien() {
    	btnLamMoi.addActionListener(this);
    	btnThemSP.addActionListener(this);
    	btnXoaSP.addActionListener(this);
    	btnThayDoiSL.addActionListener(this);
    	btnThanhToan.addActionListener(this);
    	btnHuyHoaDon.addActionListener(this);
    	btnXuatHoaDon.addActionListener(this);
    }
    

	private void btnHuyHoaDonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, "Xác nhận hủy hóa đơn") == JOptionPane.YES_OPTION)
			GUIMenuQuanLy.showPanel(new GUILapHoaDon(nhanVien));
	}

	private void btnXuatHoaDonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		GUIMenuQuanLy.showPanel(new GUILapHoaDon(nhanVien));
		
	}

	private void btnThanhToanActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (cboKhachHang.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin khách hàng");
			return;
		}
		if (dsCTHD.size() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất 1 sản phẩm");
			return;
		}
		
		String ngaySinh = ((JTextField) jdcNgaySinh.getDateEditor().getUiComponent()).getText();
		if (modelCboKhachHang.getSelectedItem() instanceof KhachHang)
			this.khachHang = (KhachHang)modelCboKhachHang.getSelectedItem();
		else
			this.khachHang = new KhachHang(txtMaKH.getText(), modelCboKhachHang.getSelectedItem().toString(), txtSoDienThoai.getText(), 
									LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
									cboGioiTinh.getSelectedItem().equals("Nam")?true:false, txtDiaChi.getText());
		hoaDon = new HoaDon(txtMaHD.getText(), nhanVien, khachHang, LocalDateTime.now(), dsCTHD);
		if(daoHoaDon.themHoaDonMoi(hoaDon)) {
			JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công");
			btnThanhToan.setEnabled(false);
			btnXuatHoaDon.setEnabled(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, thử lại sau");
		}
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

    }
    
    private void updateCboKhachHang() {
    	dsKhachHang = daoKhachHang.getDanhsachKhachHang();
		modelCboKhachHang.removeAllElements();
		modelCboKhachHang.addAll(dsKhachHang);
		modelCboKhachHang.setSelectedItem(null);
    }
    
    private void updateCboSanPham() {
		dsSanPham = daoSanPham.getDanhsachSanPham();
		modelCboSanPham.removeAllElements();
		modelCboSanPham.addAll(dsSanPham);
		modelCboSanPham.setSelectedItem(null);
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
	    	for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
				if (chiTietHoaDon.getSanPham().getMaSP() == maSP) {
					dsCTHD.remove(chiTietHoaDon);
					updateTableMuaHang();
					return;
				}
			}
    }                                        

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	if (modelCboSanPham.getSelectedItem() instanceof String || modelCboSanPham.getSelectedItem() == null) {
    		JOptionPane.showMessageDialog(null, "Vui long chon san pham hop le");
    		return;
    	}
    	
    	int sTT = modelMuaHang.getRowCount();
    	SanPham sanPham = (SanPham) modelCboSanPham.getSelectedItem();
    	int soLuong = Integer.parseInt(txtSoLuong.getText());
    	
    	if (sanPham.getSoLuongCon() < soLuong) {
    		JOptionPane.showMessageDialog(null, "Số lượng không đủ!\n Số lượng còn lại: " + sanPham.getSoLuongCon());
    		return;
    	}
    	
    	ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sanPham, sanPham.getGiaBan(), soLuong);
    	for (int i = 0; i < dsCTHD.size(); i++) {
    		ChiTietHoaDon cthd = dsCTHD.get(i);
			if (cthd.equals(chiTietHoaDon)) {
				if (cthd.getSanPham().getSoLuongCon() < cthd.getSoLuong() + soLuong) {
					JOptionPane.showMessageDialog(null, "Số lượng không đủ!\n Số lượng còn lại: " + 
									(sanPham.getSoLuongCon() - cthd.getSoLuong()));
					updateCboSanPham();
		    		return;
				}
				cthd.setSoLuong(cthd.getSoLuong() + soLuong);
				modelMuaHang.setValueAt(chiTietHoaDon.getSoLuong(), i, 6);
				updateTableMuaHang();
				updateCboSanPham();
				modelCboSanPham.setSelectedItem(null);
		    	txtSoLuong.setText("1");
				return;
			}
		}
    	dsCTHD.add(chiTietHoaDon);
    	updateTableMuaHang();
    	updateCboSanPham();
    	modelCboSanPham.setSelectedItem(null);
    	txtSoLuong.setText("1");
    }         
    
    private void btnThayDoiSLActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	int selected = tblMuaHang.getSelectedRow();
    	if (selected == -1) {
    		JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần thay đổi số lượng");
    		return;
    	}
    	String maSP = tblMuaHang.getValueAt(selected, 1).toString();
    
    	for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
			if (chiTietHoaDon.getSanPham().getMaSP() == maSP) {
				int soLuongMoi = chiTietHoaDon.getSoLuong();
		    	try {
					soLuongMoi = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng"));
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng dương");
					return;
				}
		    	if (chiTietHoaDon.getSanPham().getSoLuongCon() < soLuongMoi) {
					JOptionPane.showMessageDialog(null, "Số lượng không đủ!\n Số lượng còn lại: " + 
									chiTietHoaDon.getSanPham().getSoLuongCon());
		    		return;
				}
		    	chiTietHoaDon.setSoLuong(soLuongMoi);
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
    	txtSoDienThoai.setEditable(check);
    	cboGioiTinh.setEditable(check);
    	cboGioiTinh.setEnabled(check);
    	jdcNgaySinh.setEnabled(false);
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
    
    private void loadCTDDH() {
//    	dsCTHD = dsCTDDH
    }
    
    private void clearPanelKhachHang() {
    	txtMaKH.setText("");
    	txtDiaChi.setText("");
    	txtSoDienThoai.setText("");
    	modelCboGioiTinh.setSelectedItem("Nam");
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

    private void updateTableMuaHang() {
    	modelMuaHang.setRowCount(0);
    	int tongSL = 0;
    	double tongThanhTien = 0;
    	for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
    		int sTT = modelMuaHang.getRowCount();
    		SanPham sanPham = chiTietHoaDon.getSanPham();
    		Object row[] = {sTT++, sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getLoaiSP().getTenLoai(),
       			 sanPham.getDonViTinh().getTenDVT(), sanPham.getGiaBan(), chiTietHoaDon.getSoLuong(), 
       			 chiTietHoaDon.getThanhTien()};
    		modelMuaHang.addRow(row);
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
        txtMaHD.setText(daoHoaDon.getMaHoaDon());
        txtMaHD.setEditable(false);
        txtnhanVien.setText(nhanVien.getTenNV());
        txtnhanVien.setEditable(false);
        txtNgayLap.setText(LocalDate.now().toString());
        txtNgayLap.setEditable(false);
        
        ((JTextField) jdcNgaySinh.getDateEditor().getUiComponent()).setSelectedTextColor(Color.black);
        
        btnThemSP.setIcon(new ImageIcon("./image/them.png"));
        btnThayDoiSL.setIcon(new ImageIcon("./image/lammoi.png"));
        btnXoaSP.setIcon(new ImageIcon("./image/xoa.png"));
        btnThanhToan.setIcon(new ImageIcon("./image/tien.png"));
        btnXuatHoaDon.setIcon(new ImageIcon("./image/in.png"));
        btnHuyHoaDon.setIcon(new ImageIcon("./image/huy.png"));
        
     // không duy chuyển cột
        tblMuaHang.getTableHeader().setReorderingAllowed(false);
        txtSoLuong.setText("1");
        txtTongSLHang.setEditable(false);
        txtTongThanhTien.setEditable(false);
        txtTongThanhToan.setEditable(false);
        txtSoTienTraLai.setEditable(false);
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
        
        // format txt
        txtSoTienKhachDua.addKeyListener(new KeyAdapter() {
        	DecimalFormat tienFormat = new DecimalFormat("#,##0.00");
			@Override
			public void keyPressed(KeyEvent arg0) {
				try {
					if(txtSoTienKhachDua.getText().trim().equals("")) {
						txtSoTienTraLai.setText("");
					}
					else {
						double tienNhan = Double.parseDouble(txtSoTienKhachDua.getText());
						double tienTraLai = tienNhan - thanhToan;
						txtSoTienTraLai.setText(tienFormat.format(tienTraLai)+" VND");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(txtSoTienKhachDua.getText().trim().equals("")) {
						txtSoTienTraLai.setText("");
					}
					else {
						double tienNhan = Double.parseDouble(txtSoTienKhachDua.getText());
						double tienTraLai = tienNhan - thanhToan;
						txtSoTienTraLai.setText(tienFormat.format(tienTraLai)+" VND");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
        
        ArrayList<JTextField> numberTextField = new ArrayList<JTextField>(Arrays.asList(txtTongSLHang,
        		txtTongThanhTien, txtTongThanhToan, txtSoTienKhachDua, txtSoTienTraLai));
        numberTextField.forEach(x -> x.setHorizontalAlignment(SwingConstants.RIGHT));
        
        btnXuatHoaDon.setEnabled(false);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnThemSP)) {
			btnThemSPActionPerformed(e);
		}
		else if (object.equals(btnThayDoiSL)) {
			btnThayDoiSLActionPerformed(e);
		}
		else if (object.equals(btnXoaSP)) {
			btnXoaSPActionPerformed(e);
		}
		else if (object.equals(btnLamMoi)) {
			btnLamMoiActionPerformed(e);
		}
		else if (object.equals(btnHuyHoaDon)) {
			btnHuyHoaDonActionPerformed(e);
		}
		else if (object.equals(btnThanhToan)) {
			btnThanhToanActionPerformed(e);
		}
		else if (object.equals(btnXuatHoaDon)) {
			btnXuatHoaDonActionPerformed(e);
		}
	}
}