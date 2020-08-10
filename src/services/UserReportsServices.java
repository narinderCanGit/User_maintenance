/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.UserBean;
import db.DBConnection;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class UserReportsServices {

    public static int addLoginTime(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into useractivitymaster(userid,logintime) values(?,?)");
            pstmt.setInt(1, userid);
            pstmt.setString(2, getCurrentTime());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                pstmt = conn.prepareStatement("Select max(activityid) as activityid from useractivitymaster where userid=?");
                pstmt.setInt(1, userid);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt("activityid");
                }
                else {
                return 0;
            }
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("addLoginTime : " + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("addLoginTime : " + e);
            }
        }
        return 0;
    }

    private static String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String str = sdf.format(d);
        return str;
    }

    public static boolean updateLogoutTime(int activityid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update useractivitymaster set logouttime=? where activityid=?");

            pstmt.setString(1, getCurrentTime());

            pstmt.setInt(2, activityid);

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("updateLogoutTime : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("updateLogoutTime : " + e);
            }
        }
        return false;
    }
    
     public static ArrayList<UserBean> getAllUsersByNameTypeAndStatus(String n,String ut,String us) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            if(us.equalsIgnoreCase("active")){
                 type=1;
            }
            else
            {
                type=0;
            }
            pstmt = conn.prepareStatement("select * from usermaster where name=? and usertype=? and userstatus=? ");
            pstmt.setString(1,n);
             pstmt.setString(2,ut);
              pstmt.setInt(3,type);
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByNameTypeAndStatus :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersByNameTypeAndStatus :"+e);
            }
        }
        return null;

    } 
     
      public static ArrayList<UserBean> getAllUsersByTypeAndStatus(String ut,String us) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            if(us.equalsIgnoreCase("active")){
                 type=1;
            }
            else
            {
                type=0;
            }
            pstmt = conn.prepareStatement("select * from usermaster where usertype=? and userstatus=? ");
            
             pstmt.setString(1,ut);
              pstmt.setInt(2,type);
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByTypeAndStatus :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersTypeAndStatus :"+e);
            }
        }
        return null;

    } 
       public static ArrayList<UserBean> getAllUsersByNameAndStatus(String n,String us) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            if(us.equalsIgnoreCase("active")){
                 type=1;
            }
            else
            {
                type=0;
            }
            pstmt = conn.prepareStatement("select * from usermaster where name=? and userstatus=? ");
            pstmt.setString(1,n);
             
              pstmt.setInt(2,type);
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByNameAndStatus :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersByNameAndStatus :"+e);
            }
        }
        return null;

    } 
       
        public static ArrayList<UserBean> getAllUsersByNameAndType(String n,String ut) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            
            pstmt = conn.prepareStatement("select * from usermaster where name=? and usertype=? ");
            pstmt.setString(1,n);
             pstmt.setString(2,ut);
           
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByNameAndType :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersByNameAndType :"+e);
            }
        }
        return null;

    } 
        
         public static ArrayList<UserBean> getAllUsersByStatus(String us) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            if(us.equalsIgnoreCase("active")){
                 type=1;
            }
            else
            {
                type=0;
            }
            pstmt = conn.prepareStatement("select * from usermaster where userstatus=? ");
             
              pstmt.setInt(1,type);
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByStatus :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersByStatus :"+e);
            }
        }
        return null;

    }
         public static ArrayList<UserBean> getAllUsersByType(String ut) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            
            pstmt = conn.prepareStatement("select * from usermaster where usertype=? ");
            
             pstmt.setString(1,ut);
           
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByType :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersByType :"+e);
            }
        }
        return null;

    } 
public static ArrayList<UserBean> getAllUsersByName(String n) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int type;
        try {
            conn = DBConnection.connect();
            
            pstmt = conn.prepareStatement("select * from usermaster where name=?");
            pstmt.setString(1,n);
            
           
            rs = pstmt.executeQuery();
            ArrayList<UserBean> al = null;
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                
                objbean.setUsername(rs.getString("username"));
                objbean.setName(rs.getString("name"));
                objbean.setUsertype(rs.getString("usertype"));
                objbean.setUserstatus(rs.getBoolean("userstatus"));
                
                objbean.setContactno(rs.getString("contactno"));
                objbean.setEmailid(rs.getString("emailid"));
                
                al.add(objbean);
            }
            return al;

        } catch (Exception e) {
            System.out.println("getAllUsersByName :"+e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUsersByName :"+e);
            }
        }
        return null;

    } 
}
