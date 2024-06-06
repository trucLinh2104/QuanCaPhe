/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import SqlServer.*;
import DTO.NuocUong;
import com.mycompany.qlnu.*;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author linh
 */
public class NuocUongDAO implements DAOintenface<NuocUong> {
    private static mainView main = new mainView();
    private static DefaultTableModel model = main.getModel();
    private static JScrollPane scrollPane = main.getScrollPane();
    private static DataConnection  con =new DataConnection ();
    
    public static NuocUongDAO getInstance() {
		return new NuocUongDAO();
	}
    
    public static ArrayList<NuocUong> layDS() throws ClassNotFoundException, SQLException{
        ArrayList <NuocUong> ds = new ArrayList<NuocUong>();
        String sql ="SELECT* FROM NUOCUONG";
        con.Open();
        try{
            ResultSet rs = con.executeQuery(sql);
            while(rs.next()){
            NuocUong nu = new NuocUong();
            nu.setMaNuoc(rs.getString("maNuoc"));
            nu.setTenNuoc(rs.getString("tenNuoc"));
            nu.setLoaiNuoc(rs.getString("loaiNuoc"));
            nu.setDonVi(rs.getString("donVi"));
            nu.setGiaBan(rs.getFloat("giaBan"));
            ds.add(nu);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
    public static void loadDS() throws ClassNotFoundException, SQLException{
        ArrayList<NuocUong> ds = layDS();
        model.setRowCount(0);
        
        for (NuocUong item : ds){
           Object[] rowData={
               item.getMaNuoc(),
               item.getLoaiNuoc(),
               item.getTenNuoc(),
               item.getGiaBan()
           };
           model.addRow(rowData);
        }
        scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBackground(new Color(50, 20, 1, 70));
        main.setScrollPane(scrollPane);
        main.setModel(model);
        
    }
    
 
   
    
    public static NuocUong layNuocUongTheoTen(ArrayList<NuocUong>ds,String ma){
        for (NuocUong nuocUong : ds) {
            if (nuocUong.getMaNuoc().equalsIgnoreCase(ma)) {
                return nuocUong;
            }
        }
        // Trả về null nếu không tìm thấy sản phẩm với tên tương ứng
        return null;
    }
        
    public static void themNuocUong(ArrayList<NuocUong>ds,NuocUong nu)throws ClassNotFoundException, SQLException{
        for (NuocUong nuocUong : ds) {
            if (nuocUong.getMaNuoc().equalsIgnoreCase(nu.getMaNuoc())) {
                System.out.println("Mã đã tồn tại!");
            }else {
                ds.add(nu);
                con.Open();
                String sql="INSERT INTO NUOCUONG (maNuoc,loaiNuoc,tenNuoc,giaBan,donVi,soLuong) VALUES (N'"+nu.getMaNuoc()+"',N'"+nu.getLoaiNuoc()+"',N'"+nu.getTenNuoc()+"',N'"+nu.getGiaBan()+"',N'"+nu.getDonVi()+"',"+nu.getSoLuong()+")";
                
                try {
                    int rs=con.executeUpdate(sql);
                    if(rs>0)System.out.println("Đã cập nhật thành công");
                    loadDS();
                    main.getTable().setEnabled(false);
                    con.Close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
     
        }
        // Trả về null nếu không tìm thấy sản phẩm với tên tương ứng
    }
    public static void xoaNuocUong(String ma) throws ClassNotFoundException, SQLException{
       
        con.Open();
            
        if(ma.isBlank()) {
            System.out.println("Chưa chọn dữ liệu để xoá");
        }else {
            String sql="DELETE FROM NUOCUONG WHERE maNuoc = '"+ma+"'";
            
            try {
                int rs=con.executeUpdate(sql);
                if(rs>0)System.out.println("Đã cập nhật thành công");
               
             
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        con.Close();
    }
       
    
    public static void suaNuocUong(NuocUong nu) throws ClassNotFoundException, SQLException{
       
        con.Open();
        if(nu.getMaNuoc().isBlank()) {
            System.out.println("Chưa chọn dữ liệu để xoá");
        }else {
            String sql="UPDATE NUOCUONG SET loaiNuoc=N'"+nu.getLoaiNuoc()+"', tenNuoc=N'"+nu.getTenNuoc()+"', giaBan='"+nu.getGiaBan()+"', donVi='"+nu.getDonVi()+"' WHERE maNuoc='"+nu.getMaNuoc()+"'";
            
            try {
                int rs=con.executeUpdate(sql);
                if(rs>0){
                    System.out.println("Đã cập nhật thành công");
                }else System.out.println("thất bại");
                loadDS();
                main.getTable().setEnabled(false);
               
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
                 
        }
         con.Close();
    }
    public static void timNuocUong(String text) throws ClassNotFoundException, SQLException{
        
        con.Open();
        if (text.isBlank()){
            System.out.println("Chưa điền thông tin");
        }else{
            String sql = "Select * from NUOCUONG where tenNuoc like N'%" + text +"%'";
            try{
                JTable table =  main.getTable();
                
                model.setRowCount(0);
                ResultSet rs = con.executeQuery(sql);
                while(rs.next()){
                    Object[] rowData={
                    rs.getString("maNuoc"),
                    rs.getString("loaiNuoc"),
                    rs.getString("tenNuoc"),
                    rs.getString("giaBan")
                    };
                    model.addRow(rowData);
                };
                table.setModel(model);
                main.setTable(table);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            con.Close();
            
        }
    }    

    @Override
    public int Insert(NuocUong t) {
        	try {
			
			con.getConnection();
			
			Statement s = con.getConnection().createStatement();
			String sql ="INSERT INTO NUOCUONG(maNuoc,loaiNuoc,tenNuoc,giaBan,donVi,soLuong)"+
			"VALUES ('"+t.getMaNuoc()+"','"+t.getLoaiNuoc()+"','"+t.getTenNuoc()+"','"+t.getGiaBan()+"','"+t.getDonVi()+"','"+t.getSoLuong()+"');";
			int resultSet=s.executeUpdate(sql);
			System.out.println("Có"+ resultSet+" bị thay đổi");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		con.Close();
		return 0;
    }

    @Override
    public int Delete(NuocUong t) throws SQLException {
        try {
			
			Statement s = con.getConnection().createStatement();
			String sql= "Delete from NUOCUONG where maNuoc='"+t.getMaNuoc()+"';";
			int resultSet=s.executeUpdate(sql);
			con.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                con.Close();
		return 0;
    }

    @Override
    public int update(NuocUong t) throws SQLException {
       return 0;
    }

    @Override
    public ArrayList<NuocUong> selectAll() {
      	ArrayList<NuocUong> danhSach = new ArrayList<NuocUong>();
		try {
			
			String sql = "SELECT * FROM NUOCUONG";
			PreparedStatement statement=con.getConnection().prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				NuocUong nv1 = new NuocUong(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getInt(6));
				danhSach.add(nv1);
			}
			
			
			con.Close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return danhSach;
    }

    @Override
    public NuocUong selectById(NuocUong t) {
      return null;
    }

    @Override
    public NuocUong selectById(String t) {
       	NuocUong nuoc=null;
		
		try {
			
			String sql = "SELECT * FROM NUOCUONG WHERE tenNuoc=?";
			PreparedStatement statement=con.getConnection().prepareStatement(sql);
			statement.setString(1, t);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				 nuoc = new NuocUong(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6));
			}
			
			con.Close();
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		return nuoc;
    }

    @Override
    public ArrayList<NuocUong> selectByCondition(String t) {
        return null;
    }
}
