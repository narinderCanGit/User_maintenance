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
public class UserActivityReportsServices {
   public static ArrayList<UserBean> getAllActivity() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select username,usertype,name,logintime,logouttime from  usermaster inner join useractivitymaster where usermaster.userid=useractivitymaster.userid order by logintime;");
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
               
                objbean.setUsername(rs.getString("username"));
                
                objbean.setUsertype(rs.getString("usertype"));
                
                objbean.setName(rs.getString("name"));
                
                objbean.setLogintime(rs.getString("logintime"));
                
                objbean.setLogouttime(rs.getString("logouttime"));
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllActivity :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllActivity :"+e);
            }
        }
        return null;

    } 
}
