package com.mycompany.qlnu;

import SqlServer.DataConnection;
import java.awt.AlphaComposite;
import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class loginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel loginPanel;
    private JTextField textUserName;
    private JPasswordField passwordField;
    private ImageIcon Icon;
    private Image resizeImg;
    private ImageIcon resizedIcon;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginForm frame = new loginForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public loginForm() {
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 659, 577);

        loginPanel = new JPanel() {
            private ImageIcon backGroundImage = new ImageIcon("src/main/java/image/login.png");
            ;
                    private Image resizeImg = backGroundImage.getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Đặt độ mờ
                float opacity = 0.3f; // Độ mờ từ 0.0 (hoàn toàn trong suốt) đến 1.0 (hoàn toàn mờ)
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(resizeImg, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        };

        loginPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));

        setContentPane(loginPanel);
        loginPanel.setLayout(null);
        Icon = new ImageIcon("src/main/java/image/Filter-List-icon.png");
        resizeImg = Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizeImg);

        JLabel labelLogin = new JLabel("LOGIN");
        labelLogin.setBounds(10, 50, 641, 29);
        labelLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
        labelLogin.setForeground(new Color(51, 20, 1, 207));
        labelLogin.setHorizontalTextPosition(SwingConstants.CENTER);
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(labelLogin);

        JLabel labelUserName = new JLabel("UserName:");
        labelUserName.setFont(new Font("Tahoma", Font.PLAIN, 24));
        labelUserName.setBounds(49, 150, 157, 42);
        labelUserName.setForeground(new Color(51, 20, 1, 207));
        loginPanel.add(labelUserName);

        JLabel labelPassWord = new JLabel("PassWord:");
        labelPassWord.setFont(new Font("Tahoma", Font.PLAIN, 24));
        labelPassWord.setForeground(new Color(51, 20, 1, 207));
        labelPassWord.setBounds(49, 250, 157, 42);
        loginPanel.add(labelPassWord);

        textUserName = new JTextField();
        textUserName.setBounds(234, 150, 355, 37);
        loginPanel.add(textUserName);
        textUserName.setColumns(10);

        JCheckBox checkBoxRememberMe = new JCheckBox("Remember me");
        checkBoxRememberMe.setForeground(new Color(51, 20, 1, 207));
        checkBoxRememberMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
        checkBoxRememberMe.setBounds(234, 330, 157, 23);
        loginPanel.add(checkBoxRememberMe);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textUserName.getText();
                String password = new String(passwordField.getPassword());
                System.out.println(username);
                System.out.println(password);
                StringBuilder sb = new StringBuilder();
                if (username.equals("")) {
                    sb.append("User is empty \n");

                }
                if (password.equals("")) {
                    sb.append("passWord is empty \n");

                }
                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(loginPanel, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);

                }

                if (sb.length() == 0) {
                    try {
                        Statement statement = null;
                        DataConnection con = new DataConnection();
                        try {
                            con.Open();

                            String query = "Select * from QLNV WHERE taiKhoan='" + username + "' AND matKhau='" + password + "'";
                            ResultSet rs = con.executeQuery(query);
                            System.out.println(rs.toString());
                            if (rs.next()) {
                                JOptionPane.showMessageDialog(loginPanel, sb.toString(), "Đã đăng nhập thành công", JOptionPane.INFORMATION_MESSAGE);
                                loginPanel.setVisible(false);
                                new MenuFr().main(null);
                                con.Close();
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(loginPanel, sb.toString(), "Sai thông tin đăng nhập", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        // Thiết kế nút button
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLogin.setBounds(234, 400, 157, 60);
        loginPanel.add(btnLogin);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textUserName.setText("");
                passwordField.setText("");

            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCancel.setBounds(432, 400, 157, 60);
        loginPanel.add(btnCancel);

        passwordField = new JPasswordField();
        passwordField.setBounds(232, 250, 357, 37);
        loginPanel.add(passwordField);
    }
}
