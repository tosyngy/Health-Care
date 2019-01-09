/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.patient;

import com.G37.utilities.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vikas
 */
public class patientdao {

      public void create(patientbean bean)
       {
   ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection con=c.getConnection();
       try{
           String sql="insert into patient(username,password,name,address,mobile,email)values(?,?,?,?,?,?)";

           PreparedStatement pstmt=con.prepareStatement(sql);
           pstmt.setString(1,bean.getUsername());
           pstmt.setString(2,bean.getPassword());
           pstmt.setString(3,bean.getName());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());

           pstmt.executeUpdate();
            }
       catch(Exception e){
          System.out.println("i am in Create");
       }
       finally{
           c.putConnection(con);
       }
    }

   public void edit(patientbean bean){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="update patient set username=?,password=?,name=?,address=?,mobile=?,email=? where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1,bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3,bean.getName());
            pstmt.setString(4,bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setInt(7, bean.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }

    }


    public void remove(int id){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="delete from patient where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }

    }

    public patientbean find(int id){
         patientbean ub=new patientbean();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from patient where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){

               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setId(rs.getInt("id"));

   }


        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
    }
        return ub;
    }


    public ArrayList<patientbean> findAll(){
        ArrayList<patientbean> al=new ArrayList<patientbean>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from patient";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                patientbean ub=new patientbean();
               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setId(rs.getInt("id"));

 al.add(ub);
            }


        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }
        return al;
    }


     public patientbean authenticate(String username,String password){
         patientbean ub=new patientbean();
         ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{

            String sql="select * from patient where username=? && password=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){

               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setId(rs.getInt("id"));

   }


        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }
  return ub;
     }

    public static void main(String[] args) {
        patientdao ud=new patientdao();

      /* patientbean ub=new patientbean("vikky","5334631234","vikky","sonagiri","3299692396","vikky0506@gmail.com");
        ud.create(ub);
      /* patientbean ub=new patientbean(1,"vikkxcy010615","76348365","vikas pati","sonagiri","99079","vikky0106@gmail.com");
     ud.edit(ub);*/

         ud.remove(2);
         /*

      patientbean c= ud.find(1);
      System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());

*/
     /*  ArrayList<patientbean> ub=ud.findAll();
        for(patientbean c: ub)
            System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());
*/

   patientbean ub=ud.authenticate("vikky", "5334631234");
    System.out.println("Uid="+ub.getId()+"\nUsername="+ub.getUsername()+"\n password="+ub.getPassword()+"\n Name="+ub.getName()+"\n Mobile="+ub.getMobile()+"\n Address="+ub.getAddress()+"\n Email="+ub.getEmail());
    }

}

        // TODO code application logic here
