package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import database.ConnectDB;
import entity.ChucVu;
import entity.DonViTinh;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.NhaSanXuat;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import entity.TacGia;
import entity.VanPhongPham;

public class DAOSanPham {
	public ArrayList<SanPham> getDanhSachSach(){
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, \r\n"
					+ "		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, tg.maTG, tg.tenTG,\r\n"
					+ "		sp.soTrang, sp.namXuatBan, nxb.maNXB, nxb.tenNXB\r\n"
					+ "from SanPham sp \r\n"
					+ "	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
					+ "	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
					+ "	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "	inner join TacGia tg on sp.maTG = tg.maTG\r\n"
					+ "	inner join NhaXuatBan nxb on sp.maNXB = nxb.maNXB where tenSP is not null";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsSanPham.add(new Sach(rs.getString(1), rs.getString(2), 
						new LoaiSanPham(rs.getString(3), rs.getString(4)), 
						new DonViTinh(rs.getInt(5), rs.getString(6)), 
						rs.getDouble(7), rs.getDouble(8), rs.getInt(9), 
						new NhaCungCap(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)), 
						new TacGia(rs.getInt(15), rs.getString(16)), rs.getInt(17), rs.getInt(18), 
						new NhaXuatBan(rs.getInt(19), rs.getString(20)))
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSanPham;
	}
	
	public boolean themSach(Sach sach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into SanPham (maSP, tenSP, maLoai, maDVT, giaNhap, giaBan, soLuongCon, maNCC, maTG, soTrang, namXuatBan, maNXB) values\n"
				+ "(dbo.auto_SanPhamID(1), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setNString(1 ,sach.getTenSP());
			stmt.setString(2,sach.getLoaiSP().getMaLoai());
			stmt.setInt(3,sach.getDonViTinh().getMaDVT());
			stmt.setDouble(4,sach.getGiaNhap());
			stmt.setDouble(5,sach.getGiaBan());
			stmt.setInt(6,sach.getSoLuongCon());
			stmt.setString(7,sach.getNhaCungCap().getMaNCC());
			stmt.setInt(8,sach.getTacGia().getMaTG());
			stmt.setInt(9,sach.getSoTrang());
			stmt.setInt(10,sach.getNamXuatBan());
			stmt.setInt(11,sach.getNhaXuatBan().getMaNXB());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public void xoaSP(String maSach) throws SQLException{
		ConnectDB.getInstance();
		Connection connection= ConnectDB.getConnection();
		PreparedStatement statement= null;
		
		try {
			String sql= "\n"
					+ " update SanPham set tenSP=null,maLoai=null,maDVT=null,giaNhap=null,"
					+ "giaBan=null,soLuongCon=null,maNCC=null,maNSX=null,maTG=null,soTrang=null,"
					+ "namXuatBan=null,maNXB=null where maSP='"+ maSach+"'";
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			statement.close();
		}
	}
	
	public boolean chinhSuaSach(Sach sach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "update SanPham set tenSP=?,maLoai=?,maDVT=?, giaNhap=?, giaBan=?, \n"
				+ "soLuongCon=?, maNCC=?, maTG=?, soTrang=?, namXuatBan=?, maNXB=?\n"
				+ "where maSP=?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setNString(1 ,sach.getTenSP());
			stmt.setString(2,sach.getLoaiSP().getMaLoai());
			stmt.setInt(3,sach.getDonViTinh().getMaDVT());
			stmt.setDouble(4,sach.getGiaNhap());
			stmt.setDouble(5,sach.getGiaBan());
			stmt.setInt(6,sach.getSoLuongCon());
			stmt.setString(7,sach.getNhaCungCap().getMaNCC());
			stmt.setInt(8,sach.getTacGia().getMaTG());
			stmt.setInt(9,sach.getSoTrang());
			stmt.setInt(10,sach.getNamXuatBan());
			stmt.setInt(11,sach.getNhaXuatBan().getMaNXB());
			stmt.setString(12,sach.getMaSP());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public boolean chinhSuaVpp(VanPhongPham vpp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "update SanPham set tenSP=?,maLoai=?,maDVT=?, giaNhap=?, giaBan=?, \n"
				+ "soLuongCon=?, maNCC=?, maNSX=?\n"
				+ "where maSP=?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setNString(1 ,vpp.getTenSP());
			stmt.setString(2,vpp.getLoaiSP().getMaLoai());
			stmt.setInt(3,vpp.getDonViTinh().getMaDVT());
			stmt.setDouble(4,vpp.getGiaNhap());
			stmt.setDouble(5,vpp.getGiaBan());
			stmt.setInt(6,vpp.getSoLuongCon());
			stmt.setString(7,vpp.getNhaCungCap().getMaNCC());
			stmt.setInt(8,vpp.getNhaSanXuat().getMaNSX());
			stmt.setString(9, vpp.getMaSP());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public boolean themVpp(VanPhongPham vpp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into SanPham (maSP, tenSP, maLoai, maDVT, giaNhap, giaBan, soLuongCon, maNCC, maNSX) values\n"
				+ "(dbo.auto_SanPhamID(2), ?, ?, ?, ?, ?, ?, ?, ?)" ;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setNString(1 ,vpp.getTenSP());
			stmt.setString(2,vpp.getLoaiSP().getMaLoai());
			stmt.setInt(3,vpp.getDonViTinh().getMaDVT());
			stmt.setDouble(4,vpp.getGiaNhap());
			stmt.setDouble(5,vpp.getGiaBan());
			stmt.setInt(6,vpp.getSoLuongCon());
			stmt.setString(7,vpp.getNhaCungCap().getMaNCC());
			stmt.setInt(8,vpp.getNhaSanXuat().getMaNSX());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	public ArrayList<SanPham> getDanhSachVPP(){
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, \r\n"
					+ "		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, nsx.maNSX, nsx.tenNSX\r\n"
					+ "from SanPham sp \r\n"
					+ "	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
					+ "	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
					+ "	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "	inner join NhaSanXuat nsx on sp.maNSX = nsx.maNSX where tenSP is not null";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsSanPham.add(new VanPhongPham(rs.getString(1), rs.getString(2), 
						new LoaiSanPham(rs.getString(3), rs.getString(4)), 
						new DonViTinh(rs.getInt(5), rs.getString(6)), 
						rs.getDouble(7), rs.getDouble(8), rs.getInt(9), 
						new NhaCungCap(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)), 
						new NhaSanXuat(rs.getInt(15), rs.getString(16)))
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSanPham;
	}
	
	public ArrayList<SanPham> getDanhsachSanPham(){
		ArrayList<SanPham> dsSach = getDanhSachSach();
		ArrayList<SanPham> dsVPP = getDanhSachVPP();
		dsSach.addAll(dsVPP);
		return dsSach;
	}
	
	public ArrayList<LoaiSanPham> getLoaiSanPhams(int loai){
		ArrayList<LoaiSanPham> dsLoaiSanPham = new ArrayList<LoaiSanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from LoaiSanPham where maLoai like '"+loai+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				dsLoaiSanPham.add(new LoaiSanPham(rs.getString(1),rs.getString(2)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiSanPham;
	
	}
	//DVT,NCC,NXB,TG,NSX
	public ArrayList<DonViTinh> getDonViTinhs(){
		ArrayList<DonViTinh> dsDonViTinh = new ArrayList<DonViTinh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from DonViTinh";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				dsDonViTinh.add(new DonViTinh(rs.getInt(1),rs.getString(2)));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsDonViTinh;
	}
	public ArrayList<NhaCungCap> getNhaCungCaps(){
		ArrayList<NhaCungCap> dsNhaCungCap = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				dsNhaCungCap.add(new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNhaCungCap;
	}
	public ArrayList<NhaXuatBan> getNhaXuatBans(){
		ArrayList<NhaXuatBan> dsNhaXuatBan = new ArrayList<NhaXuatBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from NhaXuatBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				dsNhaXuatBan.add(new NhaXuatBan(rs.getInt(1),rs.getString(2)));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNhaXuatBan;
	}
	
	public ArrayList<NhaSanXuat> getNhaSanXuats(){
		ArrayList<NhaSanXuat> dsNhaSanXuat = new ArrayList<NhaSanXuat>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from NhaSanXuat";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				dsNhaSanXuat.add(new NhaSanXuat(rs.getInt(1),rs.getString(2)));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNhaSanXuat;
	}
	
	public ArrayList<TacGia> getTacGias(){
		ArrayList<TacGia> dsTacGia = new ArrayList<TacGia>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from TacGia";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				dsTacGia.add(new TacGia(rs.getInt(1),rs.getString(2)));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTacGia;
	}
	
	public String getmaSPMoi(int maLoai) {
		String maSPMoi = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select dbo.auto_SanPhamID("+maLoai+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				maSPMoi = rs.getString(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return maSPMoi;
	}
/*	public void themSanPham(SanPham sanPham) throws SQLException{
		ConnectDB.getInstance();
		Connection connection= ConnectDB.getConnection();
		PreparedStatement statement= null;
		try {
			String sql = "insert into SanPham values (?,?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(parameterIndex:1, sanPham.getMaSP());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

	public ArrayList<SanPham> timKiemSach(String maSach,String tenSach,String tenTG,String namXB,String maLoai){
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, \r\n"
					+ "		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, tg.maTG, tg.tenTG,\r\n"
					+ "		sp.soTrang, sp.namXuatBan, nxb.maNXB, nxb.tenNXB\r\n"
					+ "from SanPham sp \r\n"
					+ "	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
					+ "	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
					+ "	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "	inner join TacGia tg on sp.maTG = tg.maTG\r\n"
					+ "	inner join NhaXuatBan nxb on sp.maNXB = nxb.maNXB where sp.tenSP is not null"
					+ " and sp.maSP like '%"+maSach+"%' and sp.tenSP like '%"+tenSach+"%' "
					+ "and tg.tenTG like '%"+tenTG+"%' and sp.namXuatBan like '%"+namXB+"%' and lsp.maLoai like '%"+maLoai+"%'"  ;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsSanPham.add(new Sach(rs.getString(1), rs.getString(2), 
						new LoaiSanPham(rs.getString(3), rs.getString(4)), 
						new DonViTinh(rs.getInt(5), rs.getString(6)), 
						rs.getDouble(7), rs.getDouble(8), rs.getInt(9), 
						new NhaCungCap(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)), 
						new TacGia(rs.getInt(15), rs.getString(16)), rs.getInt(17), rs.getInt(18), 
						new NhaXuatBan(rs.getInt(19), rs.getString(20)))
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSanPham;
	}

	public ArrayList<SanPham> timKiemVPP(String maVPP,String tenVPP,String NSX,String maLoai){
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, \r\n"
					+ "		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, nsx.maNSX, nsx.tenNSX\r\n"
					+ "from SanPham sp \r\n"
					+ "	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
					+ "	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
					+ "	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "	inner join NhaSanXuat nsx on sp.maNSX = nsx.maNSX\r\n"
					+ " where sp.tenSP is not null"
					+ " and sp.maSP like '%"+maVPP+"%' and sp.tenSP like '%"+tenVPP+"%' "
					+ "and nsx.maNSX like '%"+NSX+"%' and lsp.maLoai like '%"+maLoai+"%'"  ;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsSanPham.add(new VanPhongPham(rs.getString(1), rs.getString(2), 
						new LoaiSanPham(rs.getString(3), rs.getString(4)), 
						new DonViTinh(rs.getInt(5), rs.getString(6)), 
						rs.getDouble(7), rs.getDouble(8), rs.getInt(9), 
						new NhaCungCap(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)), 
						new NhaSanXuat(rs.getInt(15), rs.getString(16)))
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSanPham;
	}
	
	
	
	
}
