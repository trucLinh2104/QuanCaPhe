/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlnu;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author linh
 */
public class test {
    public test(){
        JFrame frame = new JFrame("Example Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tạo JButton
            JButton button = new JButton("Click me!");
            button.setOpaque(true);
            button.setBackground(Color.BLUE); 
            // Thêm JButton vào JFrame
            frame.getContentPane().add(button);

            // Thiết lập kích thước của JFrame
            frame.setSize(300, 200); // Kích thước rộng x cao
            frame.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
            frame.setVisible(true); 
        }
}
