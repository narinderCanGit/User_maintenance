/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.UserBean;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ManageProfileServices {
    
    public static UserBean getUserById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster where userid=?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
           UserBean objbean = new UserBean();

            while (rs.next()) {

                objbean.setPassword(rs.getString("password"));
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setContactno(rs.getString("contactno"));

                objbean.setDob(rs.getString("dob"));
                objbean.setAddress(rs.getString("address"));
                
            }
            return objbean;

        } catch (Exception e) {
            System.out.println("getUserById : "+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getUserById : "+e);
            }
        }
        return null;
    }
    
     public static boolean updateById(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update usermaster set password=?,name=?,contactno=?,emailid=?,address=? where userid=?");
            pstmt.setString(1, objbean.getPassword());
            pstmt.setString(2, objbean.getName());
            pstmt.setString(3, objbean.getContactno());
            pstmt.setString(4, objbean.getEmailid());
            pstmt.setString(5, objbean.getAddress());
            pstmt.setInt(6, objbean.getUserid());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Manage Profile updateById : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Manage Profile updateById : " + e);
            }
        }
        return false;
    }
}
