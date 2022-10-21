/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiQuanLy;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import dao.DAODonDatHang;
import entity.ChiTietDonDatHang;
import entity.DonDatHang;
import entity.NhanVien;
import uiMenu.GUIMenuQuanLy;

/**
 *
 * @author DuyBui
 */
public class GUIDanhSachDonDatHang extends javax.swing.JPanel {

    public GUIDanhSachDonDatHang(JFrame parent) {
    	this.parent = parent;
    	init();
        loadDSDDH();
    }
    
    public void init() {
    	initComponents();
    	formatForm();
    	daoDonDatHang = new DAODonDatHang();
    	dsDonDatHang = new ArrayList<DonDatHang>();
    	tableClickAction();
    }

                       
    private void initComponents() { 	
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(50, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(50, 32767));
        pnlDanhSachDDH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachDDH = new javax.swing.JTable();
        lblFilterTrangThai = new javax.swing.JLabel();
        cboFilterTrangThai = new javax.swing.JComboBox<>();
        pnlThongTinDDH = new javax.swing.JPanel();
        lblMaDDH = new javax.swing.JLabel();
        txtMaDDH = new javax.swing.JTextField();
        lblNgayLap = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblTongSL = new javax.swing.JLabel();
        lblTongThanhTien = new javax.swing.JLabel();
        txtTongSL = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        txtTongThanhTien = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        pnlCTDDH = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        

        pnlDanhSachDDH.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách đơn đặt hàng"));
        pnlDanhSachDDH.setPreferredSize(new java.awt.Dimension(740, 638));

        
        modelTblDSDDH = new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                    "STT", "Mã đơn hàng", "Tên khách hàng", "Ngày đặt", "Số lượng", "Thành tiền", "Trạng thái"
                }
            );
        tblDanhSachDDH = new JTable(modelTblDSDDH){	
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
        jScrollPane1.setViewportView(tblDanhSachDDH);
        if (tblDanhSachDDH.getColumnModel().getColumnCount() > 0) {
            tblDanhSachDDH.getColumnModel().getColumn(0).setMinWidth(5);
            tblDanhSachDDH.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblDanhSachDDH.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblDanhSachDDH.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDanhSachDDH.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblDanhSachDDH.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblDanhSachDDH.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        lblFilterTrangThai.setText("Trạng thái: ");

        cboFilterTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thanh toán", "Đã thanh toán", "Bị hủy" }));

        javax.swing.GroupLayout pnlDanhSachDDHLayout = new javax.swing.GroupLayout(pnlDanhSachDDH);
        pnlDanhSachDDH.setLayout(pnlDanhSachDDHLayout);
        pnlDanhSachDDHLayout.setHorizontalGroup(
            pnlDanhSachDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachDDHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFilterTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboFilterTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDanhSachDDHLayout.setVerticalGroup(
            pnlDanhSachDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachDDHLayout.createSequentialGroup()
                .addGroup(pnlDanhSachDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilterTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboFilterTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlThongTinDDH.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin đơn đặt hàng"));
        pnlThongTinDDH.setPreferredSize(new java.awt.Dimension(650, 600));

        lblMaDDH.setText("Mã đơn hàng: ");

        lblNgayLap.setText("Ngày lập: ");

        lblTenKH.setText("Khách hàng:");

        lblTongSL.setText("Tổng số lượng:");

        lblTongThanhTien.setText("Tổng thành tiền");

        pnlCTDDH.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết đơn đặt hàng"));

        modelTblCTDDH = new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"
                }
            );
        tblCTHD = new JTable(modelTblCTDDH){	
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

        javax.swing.GroupLayout pnlCTDDHLayout = new javax.swing.GroupLayout(pnlCTDDH);
        pnlCTDDH.setLayout(pnlCTDDHLayout);
        pnlCTDDHLayout.setHorizontalGroup(
            pnlCTDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        pnlCTDDHLayout.setVerticalGroup(
            pnlCTDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        lblTrangThai.setText("Trạng thái:");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thanh toán", "Đã thanh toán", "Bị hủy" }));

        javax.swing.GroupLayout pnlThongTinDDHLayout = new javax.swing.GroupLayout(pnlThongTinDDH);
        pnlThongTinDDH.setLayout(pnlThongTinDDHLayout);
        pnlThongTinDDHLayout.setHorizontalGroup(
            pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinDDHLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinDDHLayout.createSequentialGroup()
                .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlThongTinDDHLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlCTDDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlThongTinDDHLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblMaDDH, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(lblNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTongThanhTien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaDDH, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtNgayLap)
                            .addComponent(txtTongThanhTien))
                        .addGap(29, 29, 29)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTongSL, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTrangThai, 0, 183, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
        );
        pnlThongTinDDHLayout.setVerticalGroup(
            pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinDDHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaDDH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDDH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinDDHLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinDDHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinDDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongSL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongSL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)))
                .addComponent(pnlCTDDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblTitle.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblTitle.setForeground(java.awt.Color.red);
        lblTitle.setText("DANH SÁCH ĐƠN ĐẶT HÀNG");

        btnTimKiem.setText("Tìm kiếm đơn đặt hàng");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlDanhSachDDH, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlThongTinDDH, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(560, 560, 560))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(503, 503, 503)))
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
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDanhSachDDH, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                            .addComponent(pnlThongTinDDH, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }
    


	private void loadDSDDH() {
    	dsDonDatHang = daoDonDatHang.getDSDonDatHang();
    	for (DonDatHang donDatHang : dsDonDatHang) {
			Object row[] = {tblDanhSachDDH.getRowCount()+1, donDatHang.getMaDDH(), donDatHang.getKhachHang().getTenKH(),
					donDatHang.getNgayDat().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), donDatHang.getTongSoLuong(), donDatHang.getTongThanhTien(),
					donDatHang.getTrangThaiDonHang()};
			modelTblDSDDH.addRow(row);
		}
    }
    
    public void tableClickAction() {
    	tblDanhSachDDH.addMouseListener(new MouseListener() {
			
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
				clearTblCTDDH();
				int row = tblDanhSachDDH.getSelectedRow();
				DonDatHang donDatHang = dsDonDatHang.get(row);
				txtMaDDH.setText(donDatHang.getMaDDH());
				txtTenKH.setText(donDatHang.getKhachHang().getTenKH());
				txtNgayLap.setText(donDatHang.getNgayDat().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				txtTongSL.setText(donDatHang.getTongSoLuong()+"");
				txtTongThanhTien.setText(donDatHang.getTongThanhTien()+"");
				
				int trangThai = donDatHang.getTrangThaiDonHang();
				if (trangThai == 0) {
					cboTrangThai.setSelectedIndex(0);
				}else if (trangThai == 1) {
					cboTrangThai.setSelectedIndex(1);
				}else {
					cboTrangThai.setSelectedIndex(2);
				}
				
				
				ArrayList<ChiTietDonDatHang> dsCTDonDatHang = donDatHang.getdSCTDonDatHang();
				for (ChiTietDonDatHang chiTietDonDatHang : dsCTDonDatHang) {
					Object r[] = {tblCTHD.getRowCount(), chiTietDonDatHang.getSanPham().getMaSP(),
							chiTietDonDatHang.getSanPham().getTenSP(), chiTietDonDatHang.getSanPham().getLoaiSP().getTenLoai(),
							chiTietDonDatHang.getDonGia(), chiTietDonDatHang.getSoLuong(), 
							chiTietDonDatHang.getThanhTien()};
					modelTblCTDDH.addRow(r);
				}
				
			}
		});
    }
    
    public void clearTblCTDDH() {
    	txtMaDDH.setText("");
    	txtNgayLap.setText("");
    	txtTenKH.setText("");
    	txtTongSL.setText("");
    	txtTongThanhTien.setText("");
    	cboTrangThai.setSelectedItem("null");
    	modelTblCTDDH.setRowCount(0);
    }
    
    public void formatForm() {
    	txtMaDDH.setEditable(false);
    	txtNgayLap.setEditable(false);
    	txtTenKH.setEditable(false);
    	txtTongSL.setEditable(false);
    	txtTongThanhTien.setEditable(false);
    	cboTrangThai.setEnabled(false);
    	cboTrangThai.setSelectedItem("null");
    }
    
    
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }         
    private void btnThanhToanActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	int row = tblDanhSachDDH.getSelectedRow();
    	if (row == -1) {
    		JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn hàng cần thanh toán");
    		return;
    	}
    	
		DonDatHang donDatHang = dsDonDatHang.get(row);
		GUIMenuQuanLy.showPanel(new GUILapHoaDon(GUIMenuQuanLy.getNhanVien(), donDatHang));
		
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cboFilterTrangThai;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFilterTrangThai;
    private javax.swing.JLabel lblMaDDH;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTongSL;
    private javax.swing.JLabel lblTongThanhTien;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlCTDDH;
    private javax.swing.JPanel pnlDanhSachDDH;
    private javax.swing.JPanel pnlThongTinDDH;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblDanhSachDDH;
    private javax.swing.JTextField txtMaDDH;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTongSL;
    private javax.swing.JTextField txtTongThanhTien;
    private DefaultTableModel modelTblDSDDH;
    private DefaultTableModel modelTblCTDDH;
    private ArrayList<DonDatHang> dsDonDatHang;
    private DAODonDatHang daoDonDatHang;
    private JFrame parent;
}
