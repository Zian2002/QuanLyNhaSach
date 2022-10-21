/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiQuanLy;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import dao.DAOHoaDon;
import entity.ChiTietHoaDon;
import entity.HoaDon;

/**
 *
 * @author DuyBui
 */
public class GUIDanhSachHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form GUIDanhSachHoaDon
     */
    public GUIDanhSachHoaDon() {
        init();
        loadData();
    }
    
    private void init() {
    	initComponents();
        daoHoaDon = new DAOHoaDon();
        tableClickAction();
        
    }
    
    private void loadData() {
    	dsHoaDon = daoHoaDon.getDSHoaDon();
    	for (HoaDon hoaDon : dsHoaDon) {
			Object row[] = {tblDanhSachHD.getRowCount()+1, hoaDon.getMaHD(), hoaDon.getNhanVien().getTenNV(),
					hoaDon.getKhachHang().getTenKH(), hoaDon.getThoiGianLap().toString(), hoaDon.getTongSoLuong(),
					hoaDon.getTongThanhTien(), hoaDon.getdSCTHoaDon()};
			modeltblDanhSachHD.addRow(row);
		}
    }
    
    public void tableClickAction() {
    	tblDanhSachHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clearTTHD();
				int row = tblDanhSachHD.getSelectedRow();
				HoaDon hoaDon = dsHoaDon.get(row);
				txtMaHD.setText(hoaDon.getMaHD());
				txtTenNV.setText(hoaDon.getNhanVien().getTenNV());
				txtTenKH.setText(hoaDon.getKhachHang().getTenKH());
				txtNgayLap.setText(hoaDon.getThoiGianLap().toString());
				txtTongSL.setText(hoaDon.getTongSoLuong()+"");
				txtTongThanhTien.setText(hoaDon.getTongThanhTien()+"");
				ArrayList<ChiTietHoaDon> chiTietHoaDons = hoaDon.getdSCTHoaDon();
				for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
					Object r[] = {tblCTHD.getRowCount(), chiTietHoaDon.getSanPham().getMaSP(),
							chiTietHoaDon.getSanPham().getTenSP(), chiTietHoaDon.getSanPham().getLoaiSP().getTenLoai(),
							chiTietHoaDon.getDonGia(), chiTietHoaDon.getSoLuong(), chiTietHoaDon.getThanhTien()};
					modeltblCTHD.addRow(r);
				}
			}
		});
    }
    
    public void clearTTHD() {
    	txtMaHD.setText("");
    	txtNgayLap.setText("");
    	txtTenKH.setText("");
    	txtTenNV.setText("");
    	txtTongSL.setText("");
    	txtTongThanhTien.setText("");
    	modeltblCTHD.setRowCount(0);
    }
                     
    private void initComponents() {
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(50, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(50, 32767));
        pnlDanhSachHD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachHD = new javax.swing.JTable();
        pnlThongTinHD = new javax.swing.JPanel();
        lbMaHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        lbNgayLap = new javax.swing.JLabel();
        lbTenNV = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        lbTongSL = new javax.swing.JLabel();
        lbTongThanhTien = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtTongSL = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        txtTongThanhTien = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        pnlCTHD = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        btnXuatHoaDon = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();

        pnlDanhSachHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));
        pnlDanhSachHD.setPreferredSize(new java.awt.Dimension(740, 638));

        modeltblDanhSachHD = new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "STT", "Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày lập", "Số lượng", "Thành tiền"
                }
            );
        
        tblDanhSachHD = new JTable(modeltblDanhSachHD){	
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
		tblDanhSachHD.getTableHeader().setReorderingAllowed(false);
		
        jScrollPane1.setViewportView(tblDanhSachHD);
        if (tblDanhSachHD.getColumnModel().getColumnCount() > 0) {
            tblDanhSachHD.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblDanhSachHD.getColumnModel().getColumn(1).setPreferredWidth(45);
            tblDanhSachHD.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDanhSachHD.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblDanhSachHD.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblDanhSachHD.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblDanhSachHD.getColumnModel().getColumn(6).setPreferredWidth(70);
        }

        javax.swing.GroupLayout pnlDanhSachHDLayout = new javax.swing.GroupLayout(pnlDanhSachHD);
        pnlDanhSachHD.setLayout(pnlDanhSachHDLayout);
        pnlDanhSachHDLayout.setHorizontalGroup(
            pnlDanhSachHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        pnlDanhSachHDLayout.setVerticalGroup(
            pnlDanhSachHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pnlThongTinHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        pnlThongTinHD.setPreferredSize(new java.awt.Dimension(650, 600));

        lbMaHD.setText("Mã hóa đơn: ");

        lbNgayLap.setText("Ngày lập: ");

        lbTenNV.setText("Nhân viên bán hàng: ");

        lbTenKH.setText("Khách hàng:");

        lbTongSL.setText("Tổng số lượng:");

        lbTongThanhTien.setText("Tổng thành tiền");
        
        pnlCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn"));

        modeltblCTHD = new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"
                }
            );
        
        tblCTHD = new JTable(modeltblCTHD){	
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
		
		tblCTHD.getTableHeader().setReorderingAllowed(false);
		
        jScrollPane2.setViewportView(tblCTHD);
        if (tblCTHD.getColumnModel().getColumnCount() > 0) {
            tblCTHD.getColumnModel().getColumn(0).setMinWidth(5);
            tblCTHD.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblCTHD.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblCTHD.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblCTHD.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblCTHD.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblCTHD.getColumnModel().getColumn(5).setPreferredWidth(20);
            tblCTHD.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        javax.swing.GroupLayout pnlCTHDLayout = new javax.swing.GroupLayout(pnlCTHD);
        pnlCTHD.setLayout(pnlCTHDLayout);
        pnlCTHDLayout.setHorizontalGroup(
            pnlCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        pnlCTHDLayout.setVerticalGroup(
            pnlCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        btnXuatHoaDon.setText("Xuất hóa đơn");

        javax.swing.GroupLayout pnlThongTinHDLayout = new javax.swing.GroupLayout(pnlThongTinHD);
        pnlThongTinHD.setLayout(pnlThongTinHDLayout);
        pnlThongTinHDLayout.setHorizontalGroup(
            pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHDLayout.createSequentialGroup()
                .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinHDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlThongTinHDLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTongSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtTenNV)
                            .addComponent(txtTongSL, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTongThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinHDLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        pnlThongTinHDLayout.setVerticalGroup(
            pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTongSL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongSL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbTitle.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lbTitle.setForeground(java.awt.Color.red);
        lbTitle.setText("DANH SÁCH HÓA ĐƠN");

        btnTimKiem.setText("Tìm kiếm hóa đơn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlDanhSachHD, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlThongTinHD, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addGap(560, 560, 560))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(560, 560, 560)))
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1480, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDanhSachHD, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                            .addComponent(pnlThongTinHD, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }
    
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbNgayLap;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTongSL;
    private javax.swing.JLabel lbTongThanhTien;
    private javax.swing.JPanel pnlCTHD;
    private javax.swing.JPanel pnlDanhSachHD;
    private javax.swing.JPanel pnlThongTinHD;
    private javax.swing.JTable tblCTHD;
    private DefaultTableModel modeltblCTHD;
    private javax.swing.JTable tblDanhSachHD;
    private DefaultTableModel modeltblDanhSachHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTongSL;
    private javax.swing.JTextField txtTongThanhTien;
    
    private ArrayList<HoaDon> dsHoaDon;
    private DAOHoaDon daoHoaDon;
    // End of variables declaration                   
}
