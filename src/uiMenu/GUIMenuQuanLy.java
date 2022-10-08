package uiMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import entity.NhanVien;
import uiQuanLy.GUIBaoCaoNgay;
import uiQuanLy.GUIBaoCaoThang;
import uiQuanLy.GUIDanhSachDonDatHang;
import uiQuanLy.GUIDanhSachHoaDon;
import uiQuanLy.GUIDanhSachSach;
import uiQuanLy.GUIDanhSachVPP;
import uiQuanLy.GUILapHoaDon;
import uiQuanLy.GUIQuanLyKhachHang;
import uiQuanLy.GUIQuanLyNhaCungCap;
import uiQuanLy.GUIQuanLyNhanVien;
import uiQuanLy.GUIQuanLySach;
import uiQuanLy.GUIQuanLyVPP;
import uiQuanLy.GUIThemDonDatHang;
import uiQuanLy.GUIThongKeDoanhThu;
import uiQuanLy.GUIThongKeSanPham;
import uiTimKiem.FormTimKiemDonDatHang;
import uiTimKiem.FormTimKiemHoaDon;
import uiTimKiem.FormTimKiemKhachHang;
import uiTimKiem.FormTimKiemNhaCungCap;
import uiTimKiem.FormTimKiemNhanVien;
import uiTimKiem.FormTimKiemSach;
import uiTimKiem.FormTimKiemVPP;


public class GUIMenuQuanLy extends JFrame implements ActionListener {
//	 	Thanh Menu
	JMenuBar menuBar;
	JMenu menuTuyChon, menuHoaDon, menuDonDatHang, 
			menuSach, menuVPP, menuKhachHang, menuNhanVien, 
			menuNCC, menuThongKe, menuBaoCao;
	// Menu item của menuTuyChon
	JMenuItem meimDangXuat, meimThoat, meimDoiMatKhau;
	
	// Menu item của menuQuanLy
	JMenuItem meimLapHoaDon, meimDanhSachHoaDon, meimTimKiemHoaDon; //HoaDon
	JMenuItem meimThemDonDatHang, meimDanhSachDonDatHang, meimTimKiemDonDatHang; // DonDatHang
	JMenuItem meimDanhSachSach ,meimCapNhatSach, meimTimKiemSach; //Sach
	JMenuItem meimDanhSachVPP, meimCapNhatVPP , meimTimKiemVPP; //VanPhongPham
	JMenuItem meimCapNhatKhachHang, meimTimKiemKhachHang; //Khách Hàng
	JMenuItem meimCapNhatNhanVien, meimTimKiemNhanVien; //Nhân Viên
	JMenuItem meimCapNhatNCC , meimTimKiemNCC; //NCC
	JMenuItem meimThongKeSanPham, meimThongKeDoanhThu; //Thống kê
	JMenuItem meimBaoCaoNgay, meimBaoCaoThang;//Báo cáo

	JLabel lbNhanVien, lbNgayHienTai;
	public NhanVien nhanVien;
	JPanel pnMain = new JPanel();
	private JPanel childPanel;
	
	public GUIMenuQuanLy(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		setTitle("QUẢN LÝ NHÀ SÁCH");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1376, 838);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		
		Box bc, b1, b2, b3;
		bc = Box.createVerticalBox();
		add(bc);
		
		//HEADER
		bc.add(b1 = Box.createHorizontalBox());
		menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.add(Box.createRigidArea(new Dimension(0, 50)));
		b1.add(menuBar);

		menuTuyChon = new JMenu("Tuỳ Chọn");
		menuTuyChon.setIcon(new ImageIcon("./image/tuychon.png"));
		menuHoaDon = new JMenu("Hóa đơn");
		menuHoaDon.setIcon(new ImageIcon("./image/hoadon.png"));
		menuDonDatHang = new JMenu("Đơn đặt hàng");
		menuDonDatHang.setIcon(new ImageIcon("./image/them.png"));
		menuSach = new JMenu("Sách");
		menuSach.setIcon(new ImageIcon("./image/sach.png"));
		menuVPP = new JMenu("Văn phòng phẩm");
		menuVPP.setIcon(new ImageIcon("./image/vpp.png"));
		menuKhachHang = new JMenu("Khách Hàng");
		menuKhachHang.setIcon(new ImageIcon("./image/khachhang.png"));
		menuNhanVien = new JMenu("Nhân viên");
		menuNhanVien.setIcon(new ImageIcon("./image/nhanvien.png"));
		menuNCC = new JMenu("Nhà cung cấp");
		menuNCC.setIcon(new ImageIcon("./image/ncc.png"));
		menuThongKe = new JMenu("Thống kê");
		menuThongKe.setIcon(new ImageIcon("./image/thongke.png"));
		menuBaoCao = new JMenu("Báo cáo");
		menuBaoCao.setIcon(new ImageIcon("./image/baocao.png"));
	
		
		menuBar.add(menuTuyChon);
		menuBar.add(menuHoaDon);
		menuBar.add(menuDonDatHang);
		menuBar.add(menuSach);
		menuBar.add(menuVPP);
		menuBar.add(menuKhachHang);
		menuBar.add(menuNhanVien);
		menuBar.add(menuNCC);
		menuBar.add(menuThongKe);
		menuBar.add(menuBaoCao);		
	
//		menuBar.add(Box.createHorizontalStrut(width-1050)); //***
		menuBar.add(Box.createHorizontalStrut(120));
		menuBar.add(lbNhanVien = new JLabel("Nhân viên: " + "Bùi Nhựt Duy"));
		menuBar.add(Box.createHorizontalStrut(30));
		menuBar.add(lbNgayHienTai = new JLabel());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		lbNgayHienTai.setText(sdf.format(date.getTime()));

		
		//Tùy chọn
		meimDoiMatKhau = new JMenuItem("Đổi mật khẩu", new ImageIcon("./image/doimk.png"));
		meimDangXuat = new JMenuItem("Đăng Xuất", new ImageIcon("./image/dangxuat.png"));
		meimThoat = new JMenuItem("Thoát", new ImageIcon("./image/thoat.png"));
		menuTuyChon.add(meimDoiMatKhau);
		menuTuyChon.add(meimDangXuat);
		menuTuyChon.add(meimThoat);


		//Hóa đơn
		meimLapHoaDon = new JMenuItem("Lâp hóa đơn", new ImageIcon("./image/laphoadon.png"));
		meimDanhSachHoaDon = new JMenuItem("Danh sách hóa đơn", new ImageIcon("./image/danhsach.png"));
		meimTimKiemHoaDon = new JMenuItem("Tìm kiếm hóa đơn", new ImageIcon("./image/timkiem.png"));
		menuHoaDon.add(meimLapHoaDon);
		menuHoaDon.add(meimDanhSachHoaDon);
		menuHoaDon.add(meimTimKiemHoaDon);
		
		// đơn đặt hàng
		meimThemDonDatHang = new JMenuItem("Thêm đơn đặt hàng", new ImageIcon("./image/them.png"));
		meimDanhSachDonDatHang = new JMenuItem("Danh sách đơn đặt hàng", new ImageIcon("./image/danhsach.png"));
		meimTimKiemDonDatHang = new JMenuItem("Tìm kiếm đơn đặt hàng", new ImageIcon("./image/timkiem.png"));
		menuDonDatHang.add(meimThemDonDatHang);
		menuDonDatHang.add(meimDanhSachDonDatHang);
		menuDonDatHang.add(meimTimKiemDonDatHang);
		
		// Sách
		meimDanhSachSach = new JMenuItem("Danh sách sách", new ImageIcon("./image/danhsach.png"));
		meimCapNhatSach = new JMenuItem("Cập nhật sách", new ImageIcon("./image/lammoi.png"));
		meimTimKiemSach = new JMenuItem("Tìm kiếm sách", new ImageIcon("./image/timkiem.png"));
		menuSach.add(meimDanhSachSach);
		menuSach.add(meimCapNhatSach);
		menuSach.add(meimTimKiemSach);
		
		// Văn phòng phẩm
		meimDanhSachVPP = new JMenuItem("Danh sách văn phòng phẩm", new ImageIcon("./image/danhsach.png"));
		meimCapNhatVPP = new JMenuItem("Cập nhật văn phòng phẩm", new ImageIcon("./image/lammoi.png"));
		meimTimKiemVPP = new JMenuItem("Tìm kiếm văn phòng phẩm", new ImageIcon("./image/timkiem.png"));
		menuVPP.add(meimDanhSachVPP);
		menuVPP.add(meimCapNhatVPP);
		menuVPP.add(meimTimKiemVPP);
		
		
		// Khách Hàng
		meimCapNhatKhachHang = new JMenuItem("Cập nhật khách hàng", new ImageIcon("./image/lammoi.png"));
		meimTimKiemKhachHang = new JMenuItem("Tìm kiếm khách hàng", new ImageIcon("./image/timkiem.png"));
		menuKhachHang.add(meimCapNhatKhachHang);
		menuKhachHang.add(meimTimKiemKhachHang);
		
		// Nhân Viên
		meimCapNhatNhanVien = new JMenuItem("Cập nhật nhân viên", new ImageIcon("./image/lammoi.png"));
		meimTimKiemNhanVien = new JMenuItem("Tìm kiếm nhân viên", new ImageIcon("./image/timkiem.png"));
		menuNhanVien.add(meimCapNhatNhanVien);
		menuNhanVien.add(meimTimKiemNhanVien);

		// Nhà cung cấp
		meimCapNhatNCC = new JMenuItem("Cập nhật nhà cung cấp", new ImageIcon("./image/lammoi.png"));
		meimTimKiemNCC = new JMenuItem("Tìm kiếm nhà cung cấp", new ImageIcon("./image/timkiem.png"));
		menuNCC.add(meimCapNhatNCC);
		menuNCC.add(meimTimKiemNCC);
		
		// Thống kê
		meimThongKeDoanhThu = new JMenuItem("Thống kê doanh thu", new ImageIcon("./image/tien.png"));
		meimThongKeSanPham = new JMenuItem("Thống kê sản phẩm", new ImageIcon("./image/sanpham.png"));
		menuThongKe.add(meimThongKeDoanhThu);
		menuThongKe.add(meimThongKeSanPham);
		
		// Báo cáo
		meimBaoCaoNgay = new JMenuItem("Báo cáo ngày", new ImageIcon("./image/baocao.png"));
		meimBaoCaoThang = new JMenuItem("Báo cáo tháng", new ImageIcon("./image/thongke.png"));
		menuBaoCao.add(meimBaoCaoNgay);
		menuBaoCao.add(meimBaoCaoThang);
	
		menuBar.add(Box.createHorizontalStrut(width-300));
	
			
		
		// MAIN
		bc.add(b1 = Box.createHorizontalBox());
		b1.add(pnMain, BorderLayout.CENTER);//thay đổi pnMain thành GUI khác
		pnMain.setBackground(new Color(236,242,242, 91));
		pnMain.setPreferredSize(new Dimension(width-520, height-1320));
		pnMain.setLayout(new BorderLayout(0,0));
		pnMain.setSize(width-520,height-1320);
		pnMain.setBorder(BorderFactory.createLineBorder(new Color(201,218,218)));

//		 FOORTER
		JLabel lbSVTH, lbDuy, lbMaDuy, lbChien, lbMaChien, lbThinh, lbMaThinh;
		bc.add(b1 = Box.createHorizontalBox());
			b1.add(Box.createHorizontalStrut(width-1420));
			b1.add(b2 = Box.createVerticalBox());
			b2.add(Box.createVerticalStrut(20));
			b2.add(b3 = Box.createHorizontalBox());
			b3.add(lbSVTH = new JLabel("Sinh viên thực hiện"));
			b2.add(Box.createVerticalStrut(10));
			b2.add(b3 = Box.createHorizontalBox());
			
			b3.add(Box.createHorizontalStrut(20));
			b3.add(lbChien = new JLabel("Võ Minh Chiến"));
			b3.add(Box.createHorizontalStrut(5));
			b3.add(new JLabel("-"));
			b3.add(Box.createHorizontalStrut(5));
			b3.add(lbMaChien = new JLabel("20022621"));
			b3.add(Box.createHorizontalStrut(40));
			
			b3.add(lbDuy = new JLabel("Bùi Nhựt Duy (Nhóm trưởng)"));
			b3.add(Box.createHorizontalStrut(5));
			b3.add(new JLabel("-"));
			b3.add(Box.createHorizontalStrut(5));
			b3.add(lbMaDuy = new JLabel("20022361"));
			b3.add(Box.createHorizontalStrut(40));
			
			b3.add(lbThinh = new JLabel("Lê Quốc Thịnh"));
			b3.add(Box.createHorizontalStrut(5));
			b3.add(new JLabel("-"));
			b3.add(Box.createHorizontalStrut(5));
			b3.add(lbMaThinh = new JLabel("20006611"));
			b3.add(Box.createHorizontalStrut(20));
			
			b2.add(Box.createVerticalStrut(20));
			b1.add(Box.createHorizontalStrut(width-1420));
			b1.setBackground(new Color(201,218,218));
			b1.setOpaque(true);
				
			
		// Format
			Font font = new Font("Arial", Font.BOLD, 14);
			// group
			ArrayList<JMenu> menuList = new ArrayList<JMenu>(Arrays.asList(menuTuyChon, menuHoaDon, menuDonDatHang, menuSach, menuVPP, 
					menuKhachHang, menuNhanVien, menuNCC, menuThongKe, menuBaoCao));
			ArrayList<JMenuItem> menuItemList = new ArrayList<JMenuItem>(Arrays.asList(meimDoiMatKhau, meimDangXuat, meimThoat, meimLapHoaDon, meimDanhSachHoaDon,
					meimTimKiemHoaDon, meimThemDonDatHang, meimDanhSachDonDatHang, meimTimKiemDonDatHang,
					meimDanhSachSach, meimCapNhatSach, meimTimKiemSach, meimDanhSachVPP, meimCapNhatVPP,
					meimTimKiemVPP, meimCapNhatKhachHang, meimTimKiemKhachHang, meimCapNhatNhanVien,
					meimTimKiemNhanVien, meimCapNhatNCC, meimTimKiemNCC, meimThongKeDoanhThu, 
					meimThongKeSanPham, meimBaoCaoNgay, meimBaoCaoThang));
			ArrayList<JLabel> labelList = new ArrayList<JLabel>(Arrays.asList(lbNhanVien, lbNgayHienTai, lbDuy, lbMaDuy, 
					lbChien, lbMaChien, lbThinh, lbMaThinh, lbSVTH));
			
			
			//Menu
			menuList.forEach(x -> {
				x.setLabel(x.getLabel().toUpperCase());
				x.setFont(new Font("Arial", Font.BOLD, 12));
			});
			menuBar.add(Box.createHorizontalStrut(width-1150));
			// MenuItem
			menuItemList.forEach(x->{
				x.setFont(new Font("Arial", Font.BOLD, 14));
			});
			labelList.forEach(x->{
				x.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
			});
				
		// Đăng Ký Sự Kiện
		meimDoiMatKhau.addActionListener(this);
		meimDangXuat.addActionListener(this);
		meimThoat.addActionListener(this);
		meimLapHoaDon.addActionListener(this);
		meimDanhSachHoaDon.addActionListener(this);
		meimTimKiemHoaDon.addActionListener(this);
		meimThemDonDatHang.addActionListener(this);
		meimDanhSachDonDatHang.addActionListener(this);
		meimTimKiemDonDatHang.addActionListener(this);
		meimDanhSachSach.addActionListener(this);
		meimCapNhatSach.addActionListener(this);
		meimTimKiemSach.addActionListener(this);
		meimDanhSachVPP.addActionListener(this);
		meimCapNhatVPP.addActionListener(this);
		meimTimKiemVPP.addActionListener(this);
		meimCapNhatKhachHang.addActionListener(this);
		meimTimKiemKhachHang.addActionListener(this);
		meimCapNhatNhanVien.addActionListener(this);
		meimTimKiemNhanVien.addActionListener(this);
		meimCapNhatNCC.addActionListener(this);
		meimTimKiemNCC.addActionListener(this);
		meimThongKeDoanhThu.addActionListener(this);
		meimThongKeSanPham.addActionListener(this);
		meimBaoCaoNgay.addActionListener(this);
		meimBaoCaoThang.addActionListener(this);
				
		showPanel(new GUILapHoaDon());
	}

	public void showPanel(JPanel panel) {
		childPanel = panel;
		pnMain.removeAll();
		pnMain.add(childPanel);
		pnMain.validate();
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(meimDoiMatKhau)) {
			new GUIDoiMatKhau().setVisible(true);
		}
		else if (object.equals(meimDangXuat)) {
			
		}
		else if (object.equals(meimThoat)) {
			
		}
		else if (object.equals(meimLapHoaDon)) {
			showPanel(new GUILapHoaDon());
		}
		else if (object.equals(meimDanhSachHoaDon)) {
			showPanel(new GUIDanhSachHoaDon());
		}
		else if (object.equals(meimTimKiemHoaDon)) {
			new FormTimKiemHoaDon().setVisible(true);
		}
		else if (object.equals(meimThemDonDatHang)) {
			showPanel(new GUIThemDonDatHang());
		}
		else if (object.equals(meimDanhSachDonDatHang)) {
			showPanel(new GUIDanhSachDonDatHang());
		}
		else if (object.equals(meimTimKiemDonDatHang)) {
			new FormTimKiemDonDatHang().setVisible(true);
		}
		else if (object.equals(meimDanhSachSach)) {
			showPanel(new GUIDanhSachSach());
		}
		else if (object.equals(meimCapNhatSach)) {
			showPanel(new GUIQuanLySach());
		}
		else if (object.equals(meimTimKiemSach)) {
			new FormTimKiemSach().setVisible(true);
		}
		else if (object.equals(meimDanhSachVPP)) {
			showPanel(new GUIDanhSachVPP());
		}
		else if (object.equals(meimCapNhatVPP)) {
			showPanel(new GUIQuanLyVPP());
		}
		else if (object.equals(meimTimKiemVPP)) {
			new FormTimKiemVPP().setVisible(true);
		}
		else if (object.equals(meimCapNhatKhachHang)) {
			showPanel(new GUIQuanLyKhachHang());
		}
		else if (object.equals(meimTimKiemKhachHang)) {
			new FormTimKiemKhachHang().setVisible(true);
		}
		else if (object.equals(meimCapNhatNhanVien)) {
			showPanel(new GUIQuanLyNhanVien());
		}
		else if (object.equals(meimTimKiemNhanVien)) {
			new FormTimKiemNhanVien().setVisible(true);
		}
		else if (object.equals(meimCapNhatNCC)) {
			showPanel(new GUIQuanLyNhaCungCap());
		}
		else if (object.equals(meimTimKiemNCC)) {
			new FormTimKiemNhaCungCap().setVisible(true);
		}
		else if (object.equals(meimThongKeDoanhThu)) {
			showPanel(new GUIThongKeDoanhThu());
		}
		else if (object.equals(meimThongKeSanPham)) {
			showPanel(new GUIThongKeSanPham());
		}
		else if (object.equals(meimBaoCaoNgay)) {
			showPanel(new GUIBaoCaoNgay());
		}
		else if (object.equals(meimBaoCaoThang)) {
			showPanel(new GUIBaoCaoThang());
		}
	}
	
}
