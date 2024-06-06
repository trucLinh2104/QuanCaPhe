/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this templat
 */
package com.mycompany.qlnu;

import DAO.NuocUongDAO;
import static DAO.NuocUongDAO.layDS;
import DTO.NuocUong;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author linh
 */
public class QLNU {
    public QLNU() throws ClassNotFoundException, SQLException {
        new NuocUongDAO().loadDS();

    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new NuocUongDAO().loadDS();

    }
}
