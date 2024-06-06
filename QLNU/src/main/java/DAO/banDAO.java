package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Ban;
import SqlServer.*;
import DTO.nhanVien;

public class banDAO implements DAOintenface<Ban> {
	
	public static banDAO getInstance() {
		return new banDAO();
	}

	@Override
	public int Insert(Ban t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(Ban t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Ban t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Ban> selectAll() {
		ArrayList<Ban> danhSach= new ArrayList<Ban>();
		try {
			DataConnection c = new DataConnection();
			String sql = "SELECT * FROM Ban";
			PreparedStatement statement=c.getConnection().prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				Ban ban1 = new Ban(rs.getString(1),rs.getString(2),rs.getInt(3));
				danhSach.add(ban1);
			}
			
			c.getConnection().close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return danhSach;
	}

	@Override
	public Ban selectById(Ban t) {
		
		return null;
	}



	@Override
	public Ban selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ban> selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}




}
