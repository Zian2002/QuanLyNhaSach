package uiMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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


public class GUIMenuQuanLy extends JFrame implements ActionListener {
	// Thanh Menu
		JToolBar toolbar1;
		JMenuBar menuBar;
		JMenu menuTuyChon, menuHoaDon,menuKhachHang, menuSach, menuVPP, menuNCC ,menuDonDatHang, menuNhanVien, menuThongKe;
		// Menu item của menuTuyChon
		JMenuItem meimDangXuat, meimThoat, meimDoiMatKhau;
		// Menu item của menuQuanLy
		JMenuItem meimLapHoaDon, meimTimKiemHoaDon; //HoaDon
		JMenuItem meimThemDonDatHang, meimTimKiemDDH; // DonDatHang
		JMenuItem meimCapNhatSach , meimTimKiemSach; //Sach
		JMenuItem meimCapVPP , meimTimKiemVPP; //VanPhongPham
		JMenuItem meimCapNCC , meimTimKiemNCC; //VanPhongPham
		JMenuItem meimCapNhatKhachHang, meimTimKiemKhachHang; //Khách Hàng
		JMenuItem meimCapNhatNhanVien, meimTimKiemNhanVien; //Nhân Viên
		JMenuItem meimThongKeSanPham, meimThongKeDoanhThu;

		
		// Menu item của menuVPP
		JMenuItem meimThongKe;
		
		
		JLabel lbNhanVien, lbNgayHienTai;
		JTextField txtTenNhanVien;
		JTextField txtMaNhanVien;
		public static boolean ktrLogin;
		public NhanVien nhanVienHD;
		JPanel pnMain = new JPanel();
		private JPanel childPanel;
		public GUIMenuQuanLy() {
			setLocationRelativeTo(null);
			this.nhanVienHD = nhanVienHD;
			setType(Type.POPUP);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width+60,height-40);
			setPreferredSize(new Dimension(width+60, height-40));
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png"));
			setTitle("Quản lý nhà sách");
			Font font1 = new Font("Arial", Font.BOLD, 20);
			Box bc, b1, b2, b3;
			bc = Box.createVerticalBox();
			add(bc);
			//HEADER
			bc.add(b1 = Box.createHorizontalBox());
			menuBar = new JMenuBar();
			menuBar.setToolTipText("");
			menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			menuBar.add(Box.createRigidArea(new Dimension(0, 80)));
			b1.add(menuBar);

			menuTuyChon = new JMenu("Tuỳ Chọn");
			menuTuyChon.setIcon(new ImageIcon(".\\image\\menu.png"));
			menuHoaDon = new JMenu("Hóa đơn");
			menuHoaDon.setIcon(new ImageIcon(".\\image\\employees.png"));
			menuDonDatHang = new JMenu("Đơn đặt hàng");
			menuDonDatHang.setIcon(new ImageIcon(".\\image\\bed.png"));
			menuSach = new JMenu("Sách");
			menuSach.setIcon(new ImageIcon(".\\image\\services.png"));
			menuVPP = new JMenu("Van phòng phẩm");
			menuVPP.setIcon(new ImageIcon(".\\image\\function.png"));
			menuNCC = new JMenu("Nhà cung cấp");
			menuNCC.setIcon(new ImageIcon(".\\image\\information.png"));
			menuKhachHang = new JMenu("Khách Hàng");
			menuKhachHang.setIcon(new ImageIcon(".\\image\\manager.png"));
			menuNhanVien = new JMenu("Nhân viên");
			menuNhanVien.setIcon(new ImageIcon(".\\image\\manager.png"));

			
			menuBar.add(menuTuyChon);
			menuBar.add(menuHoaDon);
			menuBar.add(menuDonDatHang);
			menuBar.add(menuSach);
			menuBar.add(menuVPP);
			menuBar.add(menuNCC);
			menuBar.add(menuKhachHang);
			menuBar.add(menuNhanVien);
			menuBar.add(Box.createHorizontalStrut(width-1000));
//			menuBar.add(lbNhanVien = new JLabel(nhanVienHD.toString()));
			menuBar.add(Box.createHorizontalStrut(30));
			menuBar.add(lbNgayHienTai = new JLabel());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			lbNgayHienTai.setText(sdf.format(date.getTime()));

			
			//tuỳ chọn
			meimDangXuat = new JMenuItem("Đăng Xuất", new ImageIcon(".\\image\\logout.png"));
			menuTuyChon.add(meimDangXuat);
			meimThoat = new JMenuItem("Thoát", new ImageIcon(".\\image\\exit.png"));
			menuTuyChon.add(meimThoat);
			meimDoiMatKhau = new JMenuItem("Đổi mật khẩu");
			
			
			//Hóa đơn
			meimLapHoaDon = new JMenuItem("Lâp hóa đơn");
			menuHoaDon.add(meimLapHoaDon);
			meimTimKiemHoaDon = new JMenuItem("Tìm kiếm hóa đơn");
			menuHoaDon.add(meimTimKiemHoaDon);
			
			// đơn đặt hàng
			meimThemDonDatHang = new JMenuItem("Thêm đơn đặt hàng");
			menuDonDatHang.add(meimThemDonDatHang);
			meimTimKiemDDH = new JMenuItem("Tìm kiếm đơn đặt hàng");
			menuHoaDon.add(meimTimKiemHoaDon);
			
//			//Nút con Nhân Viên
//			meimCapNhatNhanVien = new JMenuItem("Cập Nhật", new ImageIcon(".\\image\\update.png"));
//			meimTimKiemNhanVien = new JMenuItem("Tìm Kiếm", new ImageIcon(".\\image\\find.png"));
//			menuHoaDon.add(meimCapNhatNhanVien);
//			menuHoaDon.add(meimTimKiemNhanVien);
//
//			//Nút con Khách Hàng
//			meimCapNhatKhachHang = new JMenuItem("Cập Nhật", new ImageIcon(".\\image\\update.png"));
//			meimTimKiemKhachHang = new JMenuItem("Tìm Kiếm", new ImageIcon(".\\image\\find.png"));
//			menuKhachHang.add(meimCapNhatKhachHang);
//			menuKhachHang.add(meimTimKiemKhachHang);
//
//
//
//			//Nút Con menuChuNang
//			meimThongKe = new JMenuItem("Thống Kê Hoá Đơn", new ImageIcon(".\\image\\report.png"));

//			menuVPP.add(meimThongKe);
			menuBar.add(Box.createHorizontalStrut(width-300));
			
			bc.add(b1 = Box.createHorizontalBox());
			b1.add(pnMain, BorderLayout.CENTER);//thay đổi pnMain thành GUI khác
			pnMain.setBackground(new Color(231, 220, 167, 91));
			pnMain.setPreferredSize(new Dimension(width-520, height-1320));
			pnMain.setLayout(new BorderLayout(0,0));
			pnMain.setSize(width-520,height-1320);

			// FOORTER
//			JLabel lbTrong, lbSang, lbThinh, lbNhan, lbYen, lbMaTrong, lbMaSang, lbMaThinh, lbMaNhan, lbMaYen, lbGV, lbTenGV;
//			bc.add(b1 = Box.createHorizontalBox());
//				b1.add(Box.createHorizontalStrut(width-1420));
//				b1.add(b2 = Box.createVerticalBox());
//				b2.add(Box.createVerticalStrut(15));
//				b2.add(b3 = Box.createHorizontalBox());
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbTrong = new JLabel("Trần Quốc Trọng (Nhóm Trưởng)"));
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbMaTrong = new JLabel("20005791"));
//				b2.add(Box.createVerticalStrut(20));
//				b2.add(b3 = Box.createHorizontalBox());
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbSang = new JLabel("Nguyễn Nhật Sang"));
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbMaSang = new JLabel("20001531 "));
//				b3.add(Box.createHorizontalStrut(40));
//				b3.add(lbThinh = new JLabel("Lê Quốc Thịnh"));
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbMaThinh = new JLabel("20006611"));
//				b2.add(Box.createVerticalStrut(20));
//				b2.add(b3 = Box.createHorizontalBox());
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbNhan = new JLabel("Phạm Đức Nhân"));
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbMaNhan = new JLabel("20019671"));
//				b3.add(Box.createHorizontalStrut(40));
//				b3.add(lbYen = new JLabel("Ngô Đình Bảo Yến"));
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbMaYen = new JLabel("20051981 "));
//				b2.add(Box.createVerticalStrut(20));
//				b2.add(b3 = Box.createHorizontalBox());
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbGV = new JLabel("Giảng viên: "));
//				b3.add(Box.createHorizontalStrut(20));
//				b3.add(lbTenGV = new JLabel("Tôn Long Phước"));
//				b2.add(Box.createVerticalStrut(15));
//				b1.add(Box.createHorizontalStrut(width-1420));
//				setFontLabel(Arrays.asList(lbTrong, lbSang, lbThinh, lbNhan, lbYen, lbMaTrong, lbMaSang, lbMaThinh, lbMaNhan, lbMaYen, lbGV, lbTenGV));
//				setColorLabel(Arrays.asList(lbTrong, lbSang, lbThinh, lbNhan, lbYen, lbMaTrong, lbMaSang, lbMaThinh, lbMaNhan, lbMaYen, lbGV, lbTenGV));
//				b1.setBackground(new Color(134, 230, 163, 90));
//				b1.setOpaque(true);


			//bc.add(Box.createVerticalStrut(50));
			// Đăng Ký Sự Kiện
//			meimCapNhatKhachHang.addActionListener(this);
//			meimCapNhatNhanVien.addActionListener(this);
//			meimThongKe.addActionListener(this);
//
//			meimTimKiemNhanVien.addActionListener(this);
//			meimTimKiemKhachHang.addActionListener(this);
//
//			meimDangXuat.addActionListener(this);
//			meimThoat.addActionListener(this);
			setVisible(true);

			
//			showPanel(new GUIThueTraPhong(this));
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
		
	}
	
}
