package DAO;
import java.sql.SQLException;
import java.util.*;

import DTO.nhanVien;

public interface DAOintenface<T> {
	public int Insert(T t) ;
	public int Delete(T t) throws SQLException; 
	public int update(T t) throws SQLException;
	public ArrayList<T> selectAll();
	public T selectById(T t);
	public T selectById(String t);
	public ArrayList<T> selectByCondition(String t);

}
