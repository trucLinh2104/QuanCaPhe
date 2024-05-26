/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlnu;

import DAO.NuocUongDAO;
import DTO.NuocUong;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author linh
 */
public class mainView {

    public RoundedPanel getDrinkTable() {
        return drinkTable;
    }

    public void setDrinkTable(RoundedPanel drinkTable) {
        this.drinkTable = drinkTable;
    }
    private JLayeredPane layeredPane;
    private JPanel headerPane;
    private JPanel titlePanel;
    private JPanel subTitlePanel;
    private JLabel titleLabel;
    private JLabel subTitleLabel;
    private JLabel imageLabel;
    private ImageIcon icon;
    private Image rzImage;
    private ImageIcon rzIcon;
    private JLabel labelIconBack;
    private JPanel panel;
    private JPanel content;
    private JButton searchBtn;
    private JButton saveBtn;
    private JButton editBtn;
    private JButton deleteBtn;
    private JButton addBtn;
    private JButton reloadBtn;
    private JTextField[] fields;
    private RoundedJTextField search;
    private JLabel label;
    private DefaultTableModel model; 
    private boolean isEditMode = false;
    private boolean  isDeleteMode = false;
    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
    boolean click = false;
    public JLabel getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(JLabel trangthai) {
        this.trangthai = trangthai;
    }
    private JLabel trangthai;

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    private JTable table;
    private JScrollPane scrollPane;
    private RoundedPanel drinkTable;
    
    
    
    
    public mainView (){
        JFrame frame = new JFrame("Image Resize Example");
        frame.setMinimumSize(new Dimension(500,300));
        frame.setMaximumSize(new Dimension(1000, 600));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        
        // Tạo một JLayeredPane để chứa các thành phần
        layeredPane = new JLayeredPane();
        headerPane = new JPanel();
        Color coffeColor = new Color(51, 20, 1, 207);

        
        //
        headerPane.setLayout(new BorderLayout());
        titlePanel = new JPanel();
        subTitlePanel = new JPanel();
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 0, 10, 0);
        Border emptyBorderSb = BorderFactory.createEmptyBorder(5, 0, 5, 0);
        titlePanel.setBorder(emptyBorder);
        subTitlePanel.setBorder(emptyBorderSb);
        
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new JLabel("Great coffee, great taste");
        titleLabel.setOpaque(false); // Cho phép vẽ nền
        titlePanel.setBackground(coffeColor);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        
        
        subTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        subTitleLabel = new JLabel("Energy to start the day");
        subTitlePanel.setFont(new Font("Arial", Font.BOLD, 18));
        subTitleLabel.setOpaque(false); // Cho phép vẽ nền
        subTitleLabel.setForeground(Color.WHITE);
        subTitlePanel.add(subTitleLabel);
        subTitlePanel.setBackground(coffeColor);
        
        headerPane.add(titlePanel, BorderLayout.CENTER);
        headerPane.add(subTitlePanel, BorderLayout.SOUTH);

        // Thiết lập kích thước và vị trí của layeredPane trong frame
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.add(layeredPane);

        // Tạo một JLabel cho hình ảnh
        imageLabel = new JLabel();
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER); // Thêm imageLabel vào layer mặc định

        // Tạo một JLabel cho tiêu đề
        layeredPane.add(headerPane, JLayeredPane.PALETTE_LAYER); // Thêm headerPane vào layer PALETTE để đặt phía trên hình ảnh

        // Thiết lập kích thước và vị trí của các thành phần
        imageLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        headerPane.setBounds(0, 0, frame.getWidth(), 60);
         
        //Tạo icon back
        // Tạo một ImageIcon từ một tập tin hình ảnh
        icon = new ImageIcon("src/main/java/image/arrow-left-solid.png");
        rzImage = icon.getImage().getScaledInstance(20, 30, Image.SCALE_SMOOTH);
        rzIcon = new ImageIcon(rzImage);
        
        
        // Tạo một JLabel và đặt biểu tượng cho nó
        labelIconBack = new JLabel();
        labelIconBack.setBorder(new EmptyBorder(10, 0, 10, 0));
        labelIconBack.setIcon(rzIcon);
        labelIconBack.setOpaque(false);

        // Tạo một JPanel để chứa JLabel có biểu tượng
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        panel.setBounds(0, 0, 30, 40);
        panel.add(labelIconBack);
        panel.setBackground(coffeColor);
        headerPane.add(panel, BorderLayout.LINE_START);
        // tạo panel content
        content = new JPanel();
        content.setLayout(new FlowLayout());
        content.setOpaque(false);
        content.setBounds(0, 0, frame.getWidth(), 660); // Đặt kích thước panel
        content.setLayout(null);
        layeredPane.add(content,JLayeredPane.PALETTE_LAYER);
        
        //tạo  input search
        search = new RoundedJTextField(10);
        
        // Thiết lập kích thước cho text field (width, height)
        int searchWidth = frame.getWidth()/2;
        search.setSize(searchWidth,40);

        // Thiết lập Border Shadow (đổ bóng)    
        Border shadow = BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(coffeColor, 3),
                            BorderFactory.createEmptyBorder(0, 0, 0, 0)
                        );
     
        
        
        search.setLocation(20, 100);
        
        content.add(search);
        
        // panel nut
       
        searchBtn = new JButton();
        searchBtn.setBackground(new Color(255,228,212));
        searchBtn.setBounds(430, 100, 40, 40);
        JLabel searchBtnLabel = new JLabel();
        searchBtnLabel.setOpaque(false);
        ImageIcon searchbtn = new ImageIcon("src/main/java/image/search.png");
        Image resizesearchbtn = searchbtn.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizesearchbtn);
        searchBtnLabel.setIcon(resizedIcon);
        searchBtn.add(searchBtnLabel);
        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a = search.getText();
                try {
                    new NuocUongDAO().timNuocUong(a);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.add(searchBtn);
        
      
        
        String[] columnNames = {"Mã nước uống", "Loại thức uống", "Tên nước uống", "Giá bán"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
 
        table.setGridColor(coffeColor); // Đặt màu đường lưới
        table.setBorder(BorderFactory.createLineBorder(coffeColor)); // Đặt viền màu xanh

        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        table.setEnabled(false);
        //header
        JTableHeader header = table.getTableHeader();
        header.setFont(header.getFont().deriveFont(Font.BOLD, 12)); // Đặt độ lớn và độ đậm cho ch
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(255,228,212));
        //tạo màu cho row
        // Tạo một TableCellRenderer tùy chỉnh để đặt màu cho các dòng
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                component.setForeground(Color.BLACK); // Đặt màu chữ cho tiêu đề các cột
                // Đặt màu nền cho các dòng chẵn là màu xám nhạt
                if (row % 2 == 0) {
                    component.setBackground(new Color(255,228,212));
                } else {
                    component.setBackground(Color.WHITE); // Đặt màu nền cho các dòng lẻ là màu trắng
                }
                if (isSelected) {
                component.setBackground(Color.GRAY); // Màu nền khi hover
                component.setForeground(Color.WHITE); // Màu chữ khi hover
                } else {
                    
                }
                
                return component;
            }
        };
        
//        renderer.setHorizontalAlignment(JLabel.CENTER); // Căn giữa cho dòng

        // Áp dụng TableCellRenderer tùy chỉnh cho tất cả các cột của bảng
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
      
        
        // Đổ bóng cho bảng
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(coffeColor), // Viền màu xanh
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Khoảng cách bên trong
        );
        table.setBorder(border);
        table.setRowHeight(30);
        
        // đặt sự kiện cho table 
        
        
        // Đặt kích thước và vị trí của bảng trong frame
        scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(50, 20, 1, 70)); // Màu trong suốt (RGBA: 0, 0, 0, 0)
        scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0)); 
        Border  borderScr = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(coffeColor,2), // Viền màu xanh
                BorderFactory.createEmptyBorder(2,2,2,2) // Khoảng cách bên trong
        );
        scrollPane.setBorder(borderScr);
        scrollPane.setBounds(20,150, 450, 400);
        content.add(scrollPane);
        //content tiêu đề công cụ
        label = new JLabel();
        label.setOpaque(false); 
        label.setText("THÔNG TIN NƯỚC UỐNG");
        label.setBounds(530, 100, 300, 50);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        content.add(label);
        // content bảng thông tin thức uống
        drinkTable = new RoundedPanel(20);
        drinkTable.setLayout(new GridBagLayout());
        drinkTable.setBackground(new Color(255,228,212));
        drinkTable.setBorder(new shadowBorder(1,coffeColor));
        drinkTable.setBounds(485, 145, 300, 400);
        content.add(drinkTable);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridheight = 1; // Chiều cao hàng
        gbc.weightx = 1.0; // Độ dãn ngang
        
        JLabel[] labels = new JLabel[5];
        fields = new JTextField[5];
        String tieude[]= {
            "Mã thức uống",
            "Loại thức uống",
            "Tên thức uống",
            "Đơn vị tính",
            "Đơn giá"
        };

        for (int i=0;i<5;i++){
            labels[i] = new JLabel(tieude[i]);
            labels[i].setFont(new Font("Arial", Font.BOLD, 15));
            labels[i].setForeground(coffeColor);
            gbc.fill= GridBagConstraints.NONE;
            gbc.gridwidth = 1; // Chiều rộng cột (mỗi nhãn chiếm 2 ô)
            gbc.gridx = 0; // Cột 0
            gbc.gridy = i; // Hàng i
            gbc.anchor = GridBagConstraints.WEST; 
            gbc.insets = new Insets(10, 15, 10,0);// Căn chỉnh theo phía Đông
            drinkTable.add(labels[i], gbc);

            // Tạo và thiết lập ô văn bản
            fields[i] = new RoundedJTextField(10);
            
            gbc.fill =GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1; // Cột 1
            gbc.gridy = i; // Hàng i
            gbc.gridwidth = 3; // Chiều rộng cột (mỗi nhãn chiếm 2 ô)
            gbc.insets = new Insets(10, 0, 10, 15);
            gbc.anchor = GridBagConstraints.WEST; // Căn chỉnh theo phía Tây
            drinkTable.add(fields[i], gbc);
        }       
        
        //label trạng thái
        trangthai = new JLabel("Trạng thái: ");
        trangthai.setFont(new Font("Arial", Font.BOLD, 16));
        trangthai.setForeground(coffeColor);
          gbc.fill= GridBagConstraints.NONE;
          gbc.gridx = 0; // Cột 0
          gbc.gridy = 6; // Hàng i
          gbc.anchor = GridBagConstraints.WEST; 
          gbc.insets = new Insets(10, 15, 10,0);// Căn chỉnh theo phía Đông
          drinkTable.add(trangthai, gbc);
        
//        button
       
        ImageIcon saveBtnImage = new ImageIcon("src/main/java/image/save.png");
        Image resizeSaveBtn = saveBtnImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon saveBtn_ = new ImageIcon(resizeSaveBtn);
        gbc.fill= GridBagConstraints.NONE;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST; 
        gbc.fill =GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 45, 0, 0);
        saveBtn = new JButton();
        saveBtn.setForeground(coffeColor);
        saveBtn.setPreferredSize(new Dimension(60, 80));
        saveBtn.setIcon(saveBtn_);
        drinkTable.add(saveBtn, gbc);
        
        
        ImageIcon addBtnImage = new ImageIcon("src/main/java/image/add.png");
        Image resizeAddBtn = addBtnImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon addBtn_ = new ImageIcon(resizeAddBtn);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth =1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST; 
        gbc.insets = new Insets(5, 0, 5, 0);
        addBtn = new JButton();
        addBtn.setPreferredSize(new Dimension(60, 40));
        addBtn.setForeground(coffeColor);
        addBtn.setIcon(addBtn_);
        drinkTable.add(addBtn, gbc);
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               NuocUong nu = new NuocUong();
               nu.setMa(fields[0].getText());
               nu.setLoai(fields[1].getText());
               nu.setTen(fields[2].getText());
               nu.setGia(fields[4].getText());
               nu.setDvt(fields[3].getText());  
               
               ArrayList<NuocUong>ds;
                try {
                    fields[0].setText("");
                    fields[1].setText("");
                    fields[2].setText(""); 
                    fields[3].setText(""); 
                    fields[4].setText("");
                    ds = new NuocUongDAO().layDS();
                    new NuocUongDAO().themNuocUong(ds,nu);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEditMode) {
                    System.out.println("edit");
                    isEditMode = false; // Tắt chế độ chỉnh sửa sau khi hoàn thành
                    table.setEnabled(true);
                    Object value = table.getValueAt(table.getSelectedRow(), 0);
                            System.out.println(value.toString());
                            fields[0].setText(table.getValueAt(table.getSelectedRow(), 0).toString());
                            fields[0].setEnabled(false);
                            fields[1].setText(table.getValueAt(table.getSelectedRow(), 1).toString());
                            fields[2].setText(table.getValueAt(table.getSelectedRow(), 2).toString()); 
                            
                            fields[4].setText(table.getValueAt(table.getSelectedRow(), 3).toString());
                            
                            saveBtn.setEnabled(true);
                            saveBtn.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    NuocUong nu = new NuocUong();
                                    nu.setMa(value.toString());
                                    nu.setLoai(fields[1].getText());
                                    nu.setTen(fields[2].getText());
                                    nu.setGia(fields[4].getText());
                                    nu.setDvt(fields[3].getText()); 
                                    fields[0].setEnabled(true);
                                    try {
                                         fields[0].setText("");
                                         fields[1].setText("");
                                         fields[2].setText(""); 
                                         fields[3].setText(""); 
                                         fields[4].setText("");
                                        new NuocUongDAO().suaNuocUong(nu);
                                        table.clearSelection();
                                        table.setEnabled(false);
                                    } catch (Exception ex){
                                        ex.printStackTrace();
                                    }
                               
                                }
                            });
                } else if (isDeleteMode) {
                    System.out.println("delete");
                    int selectedRow = table.getSelectedRow();
                    String val = table.getValueAt(selectedRow, 0).toString();
                    System.out.println(val);
                    model.removeRow(selectedRow);
                    if (selectedRow != -1) {
                        try {
                            NuocUongDAO.xoaNuocUong(val);
                         
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        table.clearSelection();
                        table.repaint();
                    }
                    isDeleteMode = false; // Tắt chế độ xóa sau khi hoàn thành
                    table.setEnabled(false);
                }
            }
        });
        ImageIcon editBtnImage = new ImageIcon("src/main/java/image/edit.png");
        Image resizeEditBtn = editBtnImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon editBtn_ = new ImageIcon(resizeEditBtn);
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth =1;
        gbc.anchor = GridBagConstraints.WEST; 
        editBtn = new JButton();
        editBtn.setPreferredSize(new Dimension(60, 40));
        editBtn.setForeground(coffeColor);
        editBtn.setIcon(editBtn_);
        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isEditMode = true;
                isDeleteMode = false;
                table.setEnabled(true);
            }
        });
        drinkTable.add(editBtn, gbc);
        
        ImageIcon deleteBtnImage = new ImageIcon("src/main/java/image/delete.png");
        Image resizeDeleteBtn = deleteBtnImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon deleteBtn_ = new ImageIcon(resizeDeleteBtn);
        gbc.gridx = 1;
        gbc.gridy = 8;
        deleteBtn = new JButton();
        deleteBtn.setForeground(coffeColor);
        deleteBtn.setPreferredSize(new Dimension(60, 40));
        deleteBtn.setIcon(deleteBtn_);
        drinkTable.add(deleteBtn, gbc);
        deleteBtn.addActionListener(new ActionListener() {
            
             public void actionPerformed(ActionEvent e) {
                isEditMode = false;
                isDeleteMode = true;
                table.setEnabled(true);
            }
                
        });
        
        ImageIcon loadBtnImage = new ImageIcon("src/main/java/image/load.png");
        Image resizeLoadBtn = loadBtnImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon loadBtn_ = new ImageIcon(resizeLoadBtn);
        gbc.gridx = 2;
        gbc.gridy = 8;
        reloadBtn = new JButton();
        reloadBtn.setForeground(coffeColor);
        reloadBtn.setPreferredSize(new Dimension(60, 40));
        reloadBtn.setIcon(loadBtn_);
        drinkTable.add(reloadBtn, gbc);
        reloadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    NuocUongDAO.loadDS();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // Lắng nghe sự kiện khi kích thước của frame thay đổi
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = frame.getWidth();
                int height = frame.getHeight();

                // Điều chỉnh kích thước của hình ảnh
                ImageIcon originalIcon = new ImageIcon("src/main/java/image/bg.png");
                Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                imageLabel.setIcon(resizedIcon);

                // Cập nhật kích thước và vị trí của các thành phần
                imageLabel.setBounds(0, 0, width, height);
                headerPane.setBounds(0, 0, frame.getWidth(), 80);
                
                content.setBounds(0, 0, frame.getWidth(), frame.getHeight());
//                search.setSize(frame.getWidth()/2,40);
//                searchBtn.setBounds(frame.getWidth()/2+40, 105, 30, 30);
//                scrollPane.setBounds(20,150, frame.getWidth()/2+50, frame.getHeight()-200);
                // 
                drinkTable.setBounds(frame.getWidth()/2+85, 150, 300, 400);
                label.setBounds(drinkTable.getX()+45,100, 300, 50);
                if(drinkTable.getX()< 380){
                    drinkTable.setVisible(false);
                    label.setVisible(false);
                }else {
                    drinkTable.setVisible(true);
                    label.setVisible(true);
                }
                
            }
        });

          frame.setVisible(true);
    }

    public JPanel getContent() {
        return content;
    }

    public void setContent(JPanel content) {
        this.content = content;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    
}
