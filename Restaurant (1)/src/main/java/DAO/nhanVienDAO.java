package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.lang.model.element.PackageElement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import SqlServer.DataConnection;
import DTO.nhanVien;

public class nhanVienDAO implements DAOintenface<nhanVien> {
	
	public static nhanVienDAO getInstance() {
		return new nhanVienDAO();
	}

	@Override
	public int Insert(nhanVien t) {
		try {
			DataConnection c = new DataConnection();
			
			Statement s = c.getConnection().createStatement();
			String sql ="INSERT INTO QLNV(maNV,tenNV,ngaySinh,gioiTinh,sdt,diaChi,taiKhoan,matKhau,ChucVu)"+
			"VALUES ('"+t.getMaNV()+"','"+t.getHoVaTen()+"','"+t.getNgaySinh()+"','"+t.getGioiTinh()+"','"+t.getSdt()+"','"+t.getDiaChi()+"','admin','123','"+t.getChucVu()+"');";
			int resultSet=s.executeUpdate(sql);
			System.out.println("Có"+ resultSet+" bị thay đổi");
			JOptionPane.showMessageDialog(null, "Nhập Thành Công");
			c.getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int Delete(nhanVien t) {

			try {
				DataConnection c = new DataConnection();
				String sql ="DELETE FROM QLNV WHERE maNV = ? ";
				PreparedStatement statement=c.getConnection().prepareStatement(sql);
				statement.setString(1, t.getMaNV());
				int resultSet=statement.executeUpdate();
				c.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return 0;
	}

	@Override
	public ArrayList<nhanVien> selectAll() {
		ArrayList<nhanVien> danhSach= new ArrayList<nhanVien>();
		try {
			DataConnection c = new DataConnection();
			String sql = "SELECT * FROM QLNV";
			PreparedStatement statement=c.getConnection().prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				nhanVien nv1 = new nhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				danhSach.add(nv1);
			}
			
			c.getConnection().close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return danhSach;
	}

	@Override
	public  nhanVien selectById(String t) {
		nhanVien nv1=null;
		
		try {
			DataConnection c = new DataConnection();
			String sql = "SELECT * FROM QLNV WHERE maNV=?";
			PreparedStatement statement=c.getConnection().prepareStatement(sql);
			statement.setString(1, t);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				nv1 = new nhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			}
			
			c.getConnection().close();
		}
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "KHÔNG CÓ MÃ SỐ NHÂN VIÊN NÀY VUI LÒNG THỬ LẠI");
		}
		return nv1;
}


	@Override
	public int update(nhanVien t) throws SQLException {
		try {
			DataConnection c = new DataConnection();
			
			

			String sql = "UPDATE QLNV SET tenNV=?,ngaySinh=?,gioiTinh=?,sdt=?,diaChi=?, chucVu=? WHERE maNV=?;";
			PreparedStatement s = c.getConnection().prepareStatement(sql);
			
			s.setString(1, t.getHoVaTen());
			s.setString(2, t.getNgaySinh());
			s.setString(3, t.getGioiTinh());
			s.setString(4, t.getSdt());
			s.setString(5, t.getDiaChi());
			s.setString(6, t.getChucVu());
			s.setString(7, t.getMaNV().toUpperCase());
			s.executeUpdate();
			
			
			
			c.getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public nhanVien selectById(nhanVien t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<nhanVien> selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
