/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import SqlServer.ConnectDB;
import DTO.NuocUong;
import com.mycompany.qlnu.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author linh
 */
public class NuocUongDAO {
    public static ArrayList<NuocUong> layDS() throws ClassNotFoundException, SQLException{
        ArrayList <NuocUong> ds = new ArrayList<NuocUong>();
        String sql ="SELECT* FROM NUOCUONG";
        ConnectDB con = new ConnectDB();
        con.Open();
        try{
            ResultSet rs = con.executeQuery(sql);
            while(rs.next()){
            NuocUong nu = new NuocUong();
            nu.setMa(rs.getString("maNuoc"));
            nu.setTen(rs.getString("tenNuoc"));
            nu.setLoai(rs.getString("loaiNuoc"));
            nu.setDvt(rs.getString("donVi"));
            nu.setGia(rs.getFloat("giaBan"));
            ds.add(nu);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
    public static void loadDS() throws ClassNotFoundException, SQLException{
        ArrayList<NuocUong> ds = layDS();
        mainView main = new mainView();
        JLabel trangthai = main.getTrangthai();
        JTable table =  main.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (NuocUong item : ds){
           Object[] rowData={
               item.getMa(),
               item.getLoai(),
               item.getTen(),
               item.getGia()
           };
           model.addRow(rowData);
        }
        
        table.setModel(model);
        main.setTable(table);
    }
    public static void loadDS(String mgs) throws ClassNotFoundException, SQLException{
        ArrayList<NuocUong> ds = layDS();
        mainView main = new mainView();
        JTable table =  main.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (NuocUong item : ds){
           Object[] rowData={
               item.getMa(),
               item.getLoai(),
               item.getTen(),
               item.getGia()
           };
           model.addRow(rowData);
        }
        
        table.setModel(model);
        main.setTable(table);
        JLabel trangthai = main.getTrangthai();
        trangthai.setText(mgs);
    }
    
    public static NuocUong layNuocUongTheoTen(ArrayList<NuocUong>ds,String ma){
        for (NuocUong nuocUong : ds) {
            if (nuocUong.getMa().equalsIgnoreCase(ma)) {
                return nuocUong;
            }
        }
        // Trả về null nếu không tìm thấy sản phẩm với tên tương ứng
        return null;
    }
        
    public static void themNuocUong(ArrayList<NuocUong>ds,NuocUong nu) throws ClassNotFoundException, SQLException{
        for (NuocUong nuocUong : ds) {
            if (nuocUong.getMa().equalsIgnoreCase(nu.getMa())) {
                System.out.println("Mã đã tồn tại!");
            }else {
                ds.add(nu);
                ConnectDB con = new ConnectDB();
                con.Open();
                String sql="INSERT INTO NUOCUONG (maNuoc,loaiNuoc,tenNuoc,giaBan,donVi,soLuong) VALUES (N'"+nu.getMa()+"',N'"+nu.getLoai()+"',N'"+nu.getTen()+"',N'"+nu.getGia().toString()+"',N'"+nu.getDvt()+"',"+nu.getSoluong()+")";
                JLabel a = new mainView().getTrangthai();
                a.setText("Thành công");
                try {
                    int rs=con.executeUpdate(sql);
                    if(rs>0)System.out.println("Đã cập nhật thành công");
                    loadDS();
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
        ConnectDB con = new ConnectDB();
        con.Open();
            
        if(ma.isBlank()) {
            System.out.println("Chưa chọn dữ liệu để xoá");
        }else {
            String sql="DELETE FROM NUOCUONG WHERE maNuoc = '"+ma+"'";
            
            try {
                int rs=con.executeUpdate(sql);
                if(rs>0)System.out.println("Đã cập nhật thành công");
                loadDS("Thao tác thành công");
                con.Close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
       
    
    public static void suaNuocUong(NuocUong nu) throws ClassNotFoundException, SQLException{
        ConnectDB con = new ConnectDB();
        con.Open();
        if(nu.getMa().isBlank()) {
            System.out.println("Chưa chọn dữ liệu để xoá");
        }else {
            String sql="UPDATE NUOCUONG SET loaiNuoc=N'"+nu.getLoai()+"', tenNuoc=N'"+nu.getTen()+"', giaBan='"+nu.getGia().toString()+"', donVi='"+nu.getDvt()+"' WHERE maNuoc='"+nu.getMa()+"'";
            
            try {
                int rs=con.executeUpdate(sql);
                JLabel a = new mainView().getTrangthai();
                a.setText("Thành công");
                if(rs>0){
                    System.out.println("Đã cập nhật thành công");
                }else System.out.println("thất bại");
                loadDS();
                con.Close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
                 
        }
    }
    public static void timNuocUong(String text) throws ClassNotFoundException, SQLException{
        ConnectDB con = new ConnectDB();
        con.Open();
        if (text.isBlank()){
            System.out.println("Chưa điền thông tin");
        }else{
            String sql = "Select * from NUOCUONG where tenNuoc like N'%" + text +"%'";
            try{
                mainView main = new mainView();
                JTable table =  main.getTable();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
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
 
            
        }
    }    
}