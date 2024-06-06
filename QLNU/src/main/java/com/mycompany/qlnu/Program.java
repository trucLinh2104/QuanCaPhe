package com.mycompany.qlnu;

import java.awt.EventQueue;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import SqlServer.DataConnection;
import DTO.nhanVien;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAO.nhanVienDAO;

import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.management.loading.PrivateClassLoader;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Program extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtChucVu;
	private JTable tableNhanVien;
	private JTextField txtCheck;
        private Image resizeImg;
        private ImageIcon resizedIcon;
        private ImageIcon Icon;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program frame1 = new Program();
					frame1.setVisible(true);
					frame1.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Program() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 900);

		Color coffeColor = new Color(51, 20, 1, 207);
		JPanel backGround = new JPanel() {
			private ImageIcon backGroundImage = new ImageIcon("src/main/java/image/backGround.jpg");;
			private Image resizeImg = backGroundImage.getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(resizeImg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backGround.setBounds(0, 0, 1400, 900);
        

        
		// TẠO CONTERNTPANE CHỨA NỘI DUNG CÁC COMPONENT
		contentPane = new JLayeredPane();
		contentPane.setBackground(new Color(0,0,0,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(backGround,JLayeredPane.DEFAULT_LAYER);
		
		
		// TẠO CÁC COMPONENET
		

		JLabel lblNhanVien = new JLabel("Nhân Viên");
		backGround.add(lblNhanVien);
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNhanVien.setForeground(Color.white);
		setContentPane(contentPane);
		LineBorder border = new LineBorder(coffeColor, 5,true);
		
		JButton lblHome = new JButton("Home");
		lblHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null,"Bạn muốn quay về trang chủ","Xác nhận",JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					dispose();
					MenuFr.main(null);
				}
					
			}
		});
		lblHome.setBounds(10,20, 70, 50);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHome.setForeground(Color.WHITE);
                Icon = new ImageIcon("src/main/java/image/iconHome.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                lblHome.setIcon(resizedIcon);
//		lblHome.setIcon(new ImageIcon(getClass().getResource("/image/iconHome.png")));
		contentPane.add(lblHome,JLayeredPane.PALETTE_LAYER);

		JLabel lblHoTen = new JLabel("Họ và Tên");
		lblHoTen.setBounds(10, 130, 151, 32);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoTen.setForeground(Color.WHITE);
		contentPane.add(lblHoTen,JLayeredPane.PALETTE_LAYER);

		JLabel lblMaNV = new JLabel("Mã Nhân Viên");
		lblMaNV.setBounds(10, 70, 151, 38);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setForeground(Color.WHITE);
		contentPane.add(lblMaNV,JLayeredPane.PALETTE_LAYER);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setBounds(10, 190, 151, 32);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setForeground(Color.WHITE);
		contentPane.add(lblNgaySinh,JLayeredPane.PALETTE_LAYER);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(10, 250, 151, 32);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setForeground(Color.WHITE);
		contentPane.add(lblGioiTinh,JLayeredPane.PALETTE_LAYER);

		JLabel lblSdt = new JLabel("SĐT");
		lblSdt.setBounds(10, 310, 151, 32);
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSdt.setForeground(Color.WHITE);
		contentPane.add(lblSdt,JLayeredPane.PALETTE_LAYER);

		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setBounds(10, 370, 151, 32);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setForeground(Color.white);
		contentPane.add(lblDiaChi,JLayeredPane.PALETTE_LAYER);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setBounds(10, 440, 151, 32);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChucVu.setForeground(Color.WHITE);
		contentPane.add(lblChucVu,JLayeredPane.PALETTE_LAYER);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(171, 70, 499, 32);
		txtMaNV.setForeground(SystemColor.activeCaption);
		txtMaNV.setBorder(border);
		contentPane.add(txtMaNV,JLayeredPane.PALETTE_LAYER);
		txtMaNV.setColumns(10);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(171, 130, 499, 32);
		txtHoTen.setColumns(10);
		txtHoTen.setBorder(border);
		contentPane.add(txtHoTen,JLayeredPane.PALETTE_LAYER);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(171, 190, 499, 32);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBorder(border);
		contentPane.add(txtNgaySinh,JLayeredPane.PALETTE_LAYER);

		JRadioButton rdbNam = new JRadioButton("Nam");
		rdbNam.setBounds(216, 241, 140, 50);
		rdbNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
                Icon = new ImageIcon("src/main/java/image/iconBoy.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                rdbNam.setIcon(resizedIcon);
//		rdbNam.setIcon(new ImageIcon(getClass().getResource("/image/iconBoy.png")));
		contentPane.add(rdbNam,JLayeredPane.PALETTE_LAYER);
		
		JRadioButton rdbNu = new JRadioButton("Nữ");
		rdbNu.setBounds(417, 240, 140, 50);
		rdbNu.setFont(new Font("Arial", Font.PLAIN, 18));
                Icon = new ImageIcon("src/main/java/image/iconGirl.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                rdbNu.setIcon(resizedIcon);
//		rdbNu.setIcon(new ImageIcon(getClass().getResource("/image/iconGirl.png")));
		contentPane.add(rdbNu,JLayeredPane.PALETTE_LAYER);

		ButtonGroup malebuttonGroup = new ButtonGroup();
		malebuttonGroup.add(rdbNam);
		malebuttonGroup.add(rdbNu);

		txtSDT = new JTextField();
		txtSDT.setBounds(171, 310, 499, 32);
		txtSDT.setColumns(10);
		txtSDT.setBorder(border);
		contentPane.add(txtSDT,JLayeredPane.PALETTE_LAYER);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(171, 370, 499, 32);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(border);
		contentPane.add(txtDiaChi,JLayeredPane.PALETTE_LAYER);

		txtChucVu = new JTextField();
		txtChucVu.setBounds(171, 430, 499, 32);
		txtChucVu.setColumns(10);
		txtChucVu.setBorder(border);
		contentPane.add(txtChucVu,JLayeredPane.PALETTE_LAYER);
		
		
		JButton btnHienThi = new JButton("List");
		btnHienThi.setBounds(1185, 137, 178, 75);
		btnHienThi.setFont(new Font("Tahoma", Font.ITALIC, 24));
                Icon = new ImageIcon("src/main/java/image/iconList.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                btnHienThi.setIcon(resizedIcon);
//		btnHienThi.setIcon(new ImageIcon(getClass().getResource("/image/iconList.png")));
		contentPane.add(btnHienThi,JLayeredPane.PALETTE_LAYER);
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<nhanVien> list = nhanVienDAO.getInstance().selectAll();
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Mã Nhân Viên");
				model.addColumn("Tên Nhân Viên");
				model.addColumn("Ngày Sinh");
				model.addColumn("Giới Tính");
				model.addColumn("SĐT");
				model.addColumn("Địa Chỉ");
				model.addColumn("Tài Khoản");
				model.addColumn("Mật Khẩu");
				model.addColumn("Chức Vụ");
				for (nhanVien row : list) {

					model.addRow(new Object[] { row.getMaNV(), row.getHoVaTen(), row.getNgaySinh(), row.getGioiTinh(),
							row.getSdt(), row.getDiaChi(), row.getTaiKhoan(), row.getMatKhau(), row.getChucVu() });

					tableNhanVien.setModel(model);
				}

			}
		});
		


		JButton btnThem = new JButton("Insert");
		btnThem.setBounds(840, 43, 180, 75);
                Icon = new ImageIcon("src/main/java/image/addPeople.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                btnThem.setIcon(resizedIcon);
//		btnThem.setIcon(new ImageIcon(getClass().getResource("/image/addPeople.png") ));
		btnThem.setFont(new Font("Tahoma", 0, 24));
		contentPane.add(btnThem,JLayeredPane.PALETTE_LAYER);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String male = "";
				if (rdbNam.isSelected()) {
					male = "NAM";
				}
				if (rdbNu.isSelected()) {
					male = "NỮ";
				}

				if (checkFill() == true) {
					nhanVien nv1 = new nhanVien(txtMaNV.getText(), txtHoTen.getText(), txtNgaySinh.getText(), male,
							txtSDT.getText(), txtDiaChi.getText(), "NV", "123", txtChucVu.getText());
					nhanVienDAO.getInstance().Insert(nv1);
					refesh();	
					btnHienThi.doClick();
				} else
					JOptionPane.showMessageDialog(null, "Chưa nhập đủ dữ liệu ! Try again");		
				
			}
		});


		JButton btnXoa = new JButton("Delete");
		btnXoa.setBounds(1185, 43, 178, 75);
                Icon = new ImageIcon("src/main/java/image/iconDelete.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                btnXoa.setIcon(resizedIcon);
//		btnXoa.setIcon(new ImageIcon(getClass().getResource("/image/iconDelete.png")));
		btnXoa.setFont(new Font("Tahoma", Font.ITALIC, 24));
		contentPane.add(btnXoa,JLayeredPane.PALETTE_LAYER);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String male = "";
				if (rdbNam.isSelected()) {
					male = "NAM";
				}
				if (rdbNu.isSelected()) {
					male = "NỮ";
				}

				nhanVien nv1 = new nhanVien(txtMaNV.getText(), txtHoTen.getText(), txtNgaySinh.getText(), male,
						txtSDT.getText(), txtDiaChi.getText(), "NV", "123", txtChucVu.getText());
				nhanVienDAO.getInstance().Delete(nv1);
				refesh();	
				btnHienThi.doClick();
				JOptionPane.showMessageDialog(btnXoa, "Xóa ");

			}
		});


		JButton btnSua = new JButton("Update");
		btnSua.setBounds(842, 137, 178, 75);
		btnSua.setFont(new Font("Tahoma", Font.ITALIC, 24));
                Icon = new ImageIcon("src/main/java/image/iconUpdate.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                btnSua.setIcon(resizedIcon);
//		btnSua.setIcon(new ImageIcon(getClass().getResource("/image/iconUpdate.png")));
		contentPane.add(btnSua,JLayeredPane.PALETTE_LAYER);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String male = "";
				if (rdbNam.isSelected()) {
					male = "NAM";
				}
				if (rdbNu.isSelected()) {
					male = "NỮ";
				}
				nhanVien nv1 = new nhanVien(txtMaNV.getText(), txtHoTen.getText(), txtNgaySinh.getText(), male,
						txtSDT.getText(), txtDiaChi.getText(), "NV", "123", txtChucVu.getText());

				try {
					nhanVienDAO.getInstance().update(nv1);
					refesh();
					btnHienThi.doClick();
					
					JOptionPane.showMessageDialog(null, "Cật nhập thành công");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// TODO Auto-generated catch block

			}
		});


		JButton btnTimKiem = new JButton("Search ID");
		btnTimKiem.setBounds(800, 373, 200, 75);
		btnTimKiem.setFont(new Font("Tahoma", Font.ITALIC, 20));
                Icon = new ImageIcon("src/main/java/image/iconSearch.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                btnTimKiem.setIcon(resizedIcon);
//		btnTimKiem.setIcon(new ImageIcon(getClass().getResource("/image/iconSearch.png")));
		contentPane.add(btnTimKiem,JLayeredPane.PALETTE_LAYER);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String check = txtCheck.getText().toUpperCase();
				nhanVien nv1 = nhanVienDAO.getInstance().selectById(check);
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Mã Nhân Viên");
				model.addColumn("Tên Nhân Viên");
				model.addColumn("Ngày Sinh");
				model.addColumn("Giới Tính");
				model.addColumn("SĐT");
				model.addColumn("Địa Chỉ");
				model.addColumn("Tài Khoản");
				model.addColumn("Mật Khẩu");
				model.addColumn("Chức Vụ");

				model.addRow(new Object[] { nv1.getMaNV(), nv1.getHoVaTen(), nv1.getNgaySinh(), nv1.getGioiTinh(),
						nv1.getSdt(), nv1.getDiaChi(), nv1.getTaiKhoan(), nv1.getMatKhau(), nv1.getChucVu() });

				tableNhanVien.setModel(model);
				
			}
		});




		JButton btnReset = new JButton("ReSet");
		btnReset.setBounds(1020, 267, 178, 75);
		btnReset.setFont(new Font("Tahoma", Font.ITALIC, 28));
                Icon = new ImageIcon("src/main/java/image/iconReset.png");
                resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                resizedIcon = new ImageIcon(resizeImg);
                btnReset.setIcon(resizedIcon);
//		btnReset.setIcon(new ImageIcon(getClass().getResource("/image/iconReset.png")));
		contentPane.add(btnReset,JLayeredPane.PALETTE_LAYER);

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loaddata();
				txtMaNV.setText("");
				txtHoTen.setText("");

				txtNgaySinh.setText("");
				txtSDT.setText("");
				txtDiaChi.setText("");

			}
		});
		btnReset.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				txtMaNV.setText("");
				txtHoTen.setText("");

				txtNgaySinh.setText("");
				txtSDT.setText("");
				txtDiaChi.setText("");

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 501, 1358, 266);
		
		contentPane.add(scrollPane,JLayeredPane.PALETTE_LAYER);

		tableNhanVien = new JTable();
		

		
		// phương thức select là điền fill
		tableNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() ==1) {
					int selectedRows = tableNhanVien.getSelectedRow();
					if (selectedRows != -1) {
						String maNV = String.valueOf(tableNhanVien.getValueAt(selectedRows, 0)).trim();
						String hoTen = String.valueOf(tableNhanVien.getValueAt(selectedRows, 1)).trim();
						String ngaySinh = String.valueOf(tableNhanVien.getValueAt(selectedRows, 2)).trim();
						String sdt = String.valueOf(tableNhanVien.getValueAt(selectedRows, 4)).trim();

						String diaChi = String.valueOf(tableNhanVien.getValueAt(selectedRows, 5)).trim();
						String chucVu = String.valueOf(tableNhanVien.getValueAt(selectedRows, 8)).trim();
						txtMaNV.setText(maNV);
						txtHoTen.setText(hoTen);
						txtNgaySinh.setText(ngaySinh);
						txtSDT.setText(sdt);
						if (String.valueOf(tableNhanVien.getValueAt(selectedRows, 3)).equals( "Nam")) {
							rdbNam.setSelected(true);
						} else
							rdbNu.setSelected(true);
						txtDiaChi.setText(diaChi);
						txtChucVu.setText(chucVu);
						
					}

				}

			}
		});
		scrollPane.setViewportView(tableNhanVien);
		

		txtCheck = new JTextField();
		txtCheck.setBounds(1033, 380, 361, 51);
		txtCheck.setColumns(10);
		txtCheck.setBorder(border);
		contentPane.add(txtCheck,JLayeredPane.PALETTE_LAYER);
		loaddata();
	}

	private void loaddata() {
		DefaultTableModel model = new DefaultTableModel();
		
		
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Tên Nhân Viên");
		model.addColumn("Ngày Sinh");
		model.addColumn("Giới Tính");
		model.addColumn("SĐT");
		model.addColumn("Địa Chỉ");
		model.addColumn("Tài Khoản");
		model.addColumn("Mật Khẩu");
		model.addColumn("Chức Vụ");
		tableNhanVien.setModel(model);

		

	}

	// kiểm tra đã điền đủ form chưa
	private boolean checkFill() {
		if (txtMaNV.getText().isBlank() || txtHoTen.getText().isBlank() || txtNgaySinh.getText().isBlank()
				|| txtDiaChi.getText().isBlank() || txtChucVu.getText().isBlank()) {
			return false;
		} else
			return true;
	}

	private void refesh() {
		txtMaNV.setText("");
		txtHoTen.setText("");
		txtNgaySinh.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtChucVu.setText("");

	}
}
