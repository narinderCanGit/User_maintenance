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
public class ManageUserServices {

    public static ArrayList<UserBean> getAllUsers() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster");
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                objbean.setUserid(rs.getInt("userid"));
                objbean.setUsername(rs.getString("username"));
                objbean.setPassword(rs.getString("password"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                objbean.setName(rs.getString("name"));
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                objbean.setDob(rs.getString("dob"));
                objbean.setAddress(rs.getString("address"));
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;

    }

    public static boolean addUser(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into usermaster(userid,username,password,usertype,userstatus,name,contactno,emailid,dob,address) values(?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, objbean.getUserid());
            pstmt.setString(2, objbean.getUsername());
            pstmt.setString(3, objbean.getPassword());
            pstmt.setString(4, objbean.getUsertype());
            pstmt.setBoolean(5, objbean.isUserstatus());
            pstmt.setString(6, objbean.getName());
            pstmt.setString(7, objbean.getContactno());
            pstmt.setString(8, objbean.getEmailid());
            pstmt.setString(9, objbean.getDob());
            pstmt.setString(10, objbean.getAddress());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("add user : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("add user : " + e);
            }
        }
        return false;
    }

    public static boolean updateById(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update usermaster set username=?,password=?,usertype=?,userstatus=?,name=?,contactno=?,emailid=?,dob=?,address=? where userid=?");

            pstmt.setString(1, objbean.getUsername());
            pstmt.setString(2, objbean.getPassword());
            pstmt.setString(3, objbean.getUsertype());
            pstmt.setBoolean(4, objbean.isUserstatus());
            pstmt.setString(5, objbean.getName());
            pstmt.setString(6, objbean.getContactno());
            pstmt.setString(7, objbean.getEmailid());
            pstmt.setString(8, objbean.getDob());
            pstmt.setString(9, objbean.getAddress());
            pstmt.setInt(10, objbean.getUserid());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("updateById : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("updateById : " + e);
            }
        }
        return false;
    }
    
    public static boolean checkAvailibility(String uname) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
          
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster where username=?");
            pstmt.setString(1,uname);
            rs= pstmt.executeQuery();  
            if (rs.next()) {
                
                    return false;
                }
            else{
            return true;
                    }
            
        } catch (Exception e) {
            System.out.println("Exception in check Availibility : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in check Availibility : " + e);
            }

        }
        return true;
    }

}
