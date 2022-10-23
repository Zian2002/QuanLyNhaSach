
package uiQuanLy;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import database.ConnectDB;
import dao.DAOKhachHang;
import entity.KhachHang;
import entity.NhanVien;
import uiMenu.GUIMenuQuanLy;
import uiTimKiem.FormTimKiemKhachHang;

public class GUIQuanLyKhachHang extends javax.swing.JPanel  {
	

    /**
     * Creates new form QLKH
   
     */
    public GUIQuanLyKhachHang() {
    	
        initComponents();
        loadTable();
    }
                         
    private void initComponents() {

        lblTTKH = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblNgaySinh = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        btnLenDon = new javax.swing.JButton();
        btnLHD = new javax.swing.JButton();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jdcNgaySinh.setDateFormatString("yyyy-MM-dd");
        ((JTextComponent)jdcNgaySinh.getDateEditor().getUiComponent()).setEditable(false);
        txtMaKH.setEditable(false);
        
        setPreferredSize(new java.awt.Dimension(1536, 650));

        lblTTKH.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblTTKH.setForeground(java.awt.Color.red);
        lblTTKH.setText("QUẢN LÝ KHÁCH HÀNG");

        lblMaKH.setLabelFor(txtMaKH);
        lblMaKH.setText("Mã khách hàng:");
        lblMaKH.setToolTipText("");

        lblNgaySinh.setText("Ngày sinh:");

        lblGioiTinh.setText("Giới tính:");

        lblDiaChi.setLabelFor(txtDiaChi);
        lblDiaChi.setText("Địa chỉ:");
        lblDiaChi.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                lblDiaChiAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        lblTenKH.setLabelFor(txtTenKH);
        lblTenKH.setText("Tên khách hàng:");

        lblSDT.setLabelFor(txtSDT);
        lblSDT.setText("Số điện thoại:");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        modeltblKH = new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    
                },
                new String [] {
                    "STT", "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "SDT", "Địa chỉ"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            };
        tblKhachHang.setModel(modeltblKH);
        tblKhachHang.addMouseListener(new MouseListener() {
			
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
				if (!btnThem.getText().equals("Thêm"))
					return;
				else {
					int row = tblKhachHang.getSelectedRow();
					loadTbltoForm(row);
				}
				
			}
		});
    	
        jScrollPane1.setViewportView(tblKhachHang);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
            
        });

        btnLenDon.setText("Lên đơn đặt hàng");

        btnLHD.setText("Lập hóa đơn");

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMaKH)
                                            .addComponent(lblNgaySinh))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(81, 81, 81)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTenKH)
                                            .addComponent(lblSDT))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                            .addComponent(txtSDT))
                                        .addGap(128, 128, 128)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDiaChi)
                                            .addComponent(lblGioiTinh))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnLenDon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnLHD, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTTKH)
                .addGap(584, 584, 584))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaKH)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgaySinh)
                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenKH)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSDT)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGioiTinh)
                            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaChi)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLenDon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(152, 152, 152))
          
        );
        setEditableForm(false);
    }// </editor-fold>    
    
    private void loadTable(ArrayList<KhachHang> dsKH) {
    	modeltblKH.setRowCount(0);
    	this.dsKH = dsKH;
    		for (KhachHang khachHang : dsKH) {
				Object row[] = {
						tblKhachHang.getRowCount(), 
						khachHang.getMaKH(), 
						khachHang.getTenKH(), 
						khachHang.getNgaySinh(),
						khachHang.isGioiTinh()==true? "Nam":"Nữ",
						khachHang.getsDT(),
						khachHang.getDiaChi()};
				
						modeltblKH.addRow(row);
						
    		}
    	}
    private void loadTable() {
    	modeltblKH.setRowCount(0);
    	dsKH = daoKhachHang.getDanhsachKhachHang();
    		for (KhachHang khachHang : dsKH) {
				Object row[] = {
						tblKhachHang.getRowCount(), 
						khachHang.getMaKH(), 
						khachHang.getTenKH(), 
						khachHang.getNgaySinh(),
						khachHang.isGioiTinh()==true? "Nam":"Nữ",
						khachHang.getsDT(),
						khachHang.getDiaChi()};
						
						modeltblKH.addRow(row);
			}
			
		}
    
    public void loadTbltoForm(int row) {
    	KhachHang khachHang = dsKH.get(row);
 		txtMaKH.setText(khachHang.getMaKH());
 		txtTenKH.setText(khachHang.getTenKH());
 		((JTextField)jdcNgaySinh.getDateEditor().getUiComponent())
 		.setText(khachHang.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
 		cboGioiTinh.setSelectedItem(khachHang.isGioiTinh()?"Nam":"Nữ");
 		txtSDT.setText(khachHang.getsDT());
 		txtDiaChi.setText(khachHang.getDiaChi());
 	}
    public void setEditableForm(boolean st) {
	
		txtTenKH.setEditable(st);
		cboGioiTinh.setEnabled(st);
		txtSDT.setEditable(st);
		jdcNgaySinh.setEnabled(st);
		txtDiaChi.setEditable(st);
		
	}

    
 
    
    
    private void timKiemKH() {
    	FormTimKiemKhachHang formTimKiemKhachHang = new FormTimKiemKhachHang();
    	int result = JOptionPane.showConfirmDialog(null, formTimKiemKhachHang, "Tìm kiếm khách hàng",
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			String tenKH = "";
			String sDT = "";
			String ngaySinh = "";
			tenKH = formTimKiemKhachHang.getTxtTenKH().getText();
			sDT = formTimKiemKhachHang.getTxtSDT().getText();
			ngaySinh = ((JTextField)jdcNgaySinh.getDateEditor().getUiComponent()).getText();
			boolean gioiTinh = formTimKiemKhachHang.getJrdNam().isSelected();
			
			DAOKhachHang daoKhachHang = new DAOKhachHang();
			ArrayList<KhachHang> dsKH =  daoKhachHang.timKiemKhachHang(tenKH, sDT, ngaySinh, gioiTinh);
			
			loadTable(dsKH);
		}			
    }
    private void lamMoi() {
    	txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		((JTextField)jdcNgaySinh.getDateEditor().getUiComponent()).setText("");
		cboGioiTinh.setSelectedIndex(0);
		txtDiaChi.setText("");
		
		loadTable();
		btnThem.setText("Thêm");
    	btnXoa.setEnabled(true);
		btnSua.setEnabled(true);
		setEditableForm(false);
    }
    
    
    
    private void themKH(){
    	
    	String maKH = daoKhachHang.getMaKH();
    	if(btnThem.getText().equals("Thêm")) {
    		lamMoi();
    		btnThem.setText("Xác nhận");   		
	    	txtMaKH.setText(maKH);
    		setEditableForm(true);
    		btnXoa.setEnabled(false);
    		btnSua.setEnabled(false);
    	} else  {
    		if(validData()) {
	    	String tenKH = txtTenKH.getText();
	    	String ngaySinh = ((JTextField)jdcNgaySinh.getDateEditor().getUiComponent()).getText();
	    	String gioiTinh = cboGioiTinh.getSelectedItem().toString();
	    	String sDT = txtSDT.getText();
	    	String diaChi = txtDiaChi.getText();
	    	
	    	KhachHang khachHang = new KhachHang(maKH, tenKH, sDT,
	    			LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
	    			gioiTinh.equals("Nam")?true:false, diaChi);
	    	try {
	    		daoKhachHang.them_KH(khachHang);
	    		modeltblKH.addRow(new Object[] {tblKhachHang.getRowCount(),  khachHang.getMaKH(), 
	    				khachHang.getTenKH(), 
	    				khachHang.getsDT(),
	    				khachHang.getNgaySinh(),
	    				khachHang.isGioiTinh(),
	    				khachHang.getDiaChi()	
	    		});
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		}
		    	btnThem.setText("Thêm");
		    	btnXoa.setEnabled(true);
				btnSua.setEnabled(true);
				lamMoi();
		    	loadTable();
    		}
	    	
	    }
    	
	    	
    	
    }
    
    /**
     * 
     */

    public void xoaKH() {
    	int row = tblKhachHang.getSelectedRow();
    	if (row ==-1) {
    		JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
    		return;
    	}
    	if (JOptionPane.showConfirmDialog(null,"Xác nhận xóa")==JOptionPane.YES_OPTION){
    		try {
				daoKhachHang.xoa_KH(tblKhachHang.getValueAt(row, 1).toString());
				JOptionPane.showMessageDialog(this, "Xóa thành công");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    		loadTable();
    	}
    }
    public void capNhatKH() {
	   String maKH = txtMaKH.getText();
	   if(btnSua.getText().equals("Sửa")) {
   		btnSua.setText("Xác nhận"); 
   		btnLamMoi.setText("Hủy");
	    	
   		setEditableForm(true);
   		btnThem.setEnabled(false);
   		btnXoa.setEnabled(false);
	  } else {
		
	
	   
	   	if(validData()) {
	   	String tenKH = txtTenKH.getText();
	   	String ngaySinh = ((JTextField)jdcNgaySinh.getDateEditor().getUiComponent()).getText();
	   	String gioiTinh = cboGioiTinh.getSelectedItem().toString();
	   	String sDT = txtSDT.getText();
	   	String diaChi = txtDiaChi.getText();
	   	
	   	KhachHang khachHang = new KhachHang(maKH, tenKH, sDT,
    			LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
    			gioiTinh.equals("Nam")?true:false, diaChi);
	   	try {
	   		daoKhachHang.capNhat(khachHang);
    		loadTable();
	
	   	} catch (Exception e) {
			// TODO: handle exception
		}
	   	btnSua.setText("Sửa");
   		btnLamMoi.setText("Làm mới");
    	btnThem.setEnabled(true);
		btnXoa.setEnabled(true);
		lamMoi(); 
	   	}
	  } 		
   }
   private boolean validData() {
	   
	   String tenKH = txtTenKH.getText().trim();
	   String sDT = txtSDT.getText().trim();
	   String diaChi = txtDiaChi.getText().trim();
	   String ngaySinh = ((JTextField)jdcNgaySinh.getDateEditor().getUiComponent()).getText();
	   
	   if(!(tenKH.length() > 0 && tenKH.matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)+"))) {
		   JOptionPane.showMessageDialog(this, "Error: Tên khách hàng phải viết hoa chữ cái đầu mỗi từ và có ít nhất 2 từ !");
		   txtTenKH.requestFocus();
		   return false;
	   }
	   if(LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("yyyy-MM-dd")).isAfter(LocalDate.now())) {
		   JOptionPane.showMessageDialog(this, "Error:Ngày sinh không được sau ngày hiện tại !");
		   jdcNgaySinh.requestFocus();
		   return false;
	   }
	   if(!(sDT.length() > 0 && sDT.matches("[0]\\d{9}"))) {
		   JOptionPane.showMessageDialog(this, "Error: SDT bắt đầu bằng 0 và có 10 chữ số");
		   txtSDT.requestFocus();
		   return false;
	   }
	   if(!(diaChi.length() > 0 )) {
		   JOptionPane.showMessageDialog(this, "Error: Địa chỉ không được để trống !");
		   txtDiaChi.requestFocus();
		   return false;
	   }
	return true;   
   }
   private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {                                          
       // TODO add your handling code here:
   }                                         

   private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {                                       
   }                                      

   private void lblDiaChiAncestorMoved(java.awt.event.HierarchyEvent evt) { 
                               
       // TODO add your handling code here:
   }  
   private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
   	
   	themKH();
   }
   private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {                                       
       // TODO add your handling code here:
   	capNhatKH();
   }    
   public void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {

  		lamMoi();
   }

   private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {                                           
       // TODO add your handling code here:
   	timKiemKH();

   }                                          

   private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {                                           
       // TODO add your handling code here:
   }  
   private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {                                       
       // TODO add your handling code here:
   	Object o = evt.getSource();
   	
   	if (o.equals(btnXoa))
   		xoaKH();
   }  
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnLHD;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLenDon;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaKH;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTTKH;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JTable tblKhachHang;
    private DefaultTableModel modeltblKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    
    
    
    private DAOKhachHang daoKhachHang = new DAOKhachHang();
    private ArrayList<KhachHang> dsKH;

    // End of variables declaration                   
}
