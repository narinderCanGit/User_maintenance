/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.UserBean;
import db.DBConnection;
import forgot_password.SendSMTP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class LoginServices {

    public static UserBean authenticateUsers(String un, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select userid,userstatus,usertype,password from usermaster where username=?");
            pstmt.setString(1, un);
            rs = pstmt.executeQuery();  //for select
            if (rs.next()) {
                if (pwd.equals(rs.getString("password"))) {     //password is from database and pwd is from login window
                    UserBean objbean = new UserBean();
                    objbean.setUserid(rs.getInt("userid"));
                    objbean.setUserstatus(rs.getBoolean("userstatus"));
                    objbean.setUsertype(rs.getString("usertype"));
                    return objbean;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in authenticateUsers : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in authenticateUsers : " + e);
            }

        }
        return null;
    }
    
      public static boolean forgotPassword(String un) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select password,emailid from usermaster where username=?");
            pstmt.setString(1, un);
            rs = pstmt.executeQuery();  //for select
            if (rs.next()) {
                String email=rs.getString("emailid");
                String pwd=rs.getString("password");
                String str= SendSMTP.sendMail(email , "your password is= "+pwd , "Password Recovery");
                if(str.equalsIgnoreCase("sent"))
                {
                return true;
                }
                
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception in authenticateUsers : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in authenticateUsers : " + e);
            }

        }
        return false;
    }
}
