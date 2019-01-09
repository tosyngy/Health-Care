/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

import com.G37.utilities.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vikas
 */
public class labdios {
public void create(labbean  bean){
   ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection con=c.getConnection();
       try{
           String sql="insert into labadmin(username,password,name,address,mobile,email,pid,did)values(?,?,?,?,?,?,?,?)";

           PreparedStatement pstmt=con.prepareStatement(sql);
           pstmt.setString(1,bean.getUsername());
           pstmt.setString(2,bean.getPassword());
           pstmt.setString(3,bean.getName());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());
           pstmt.setInt(7,bean.getPid());
           pstmt.setInt(8,bean.getDid());

           pstmt.executeUpdate();
            }
       catch(Exception e){
          System.out.println("i am in Create");
       }
       finally{
           c.putConnection(con);
       }
}

    public void edit(labbean bean){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="update labadmin set username=?,password=?,name=?,address=?,mobile=?,email=?,pid=?,did=? where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1,bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3,bean.getName());
            pstmt.setString(4,bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setInt(7,bean.getPid());
           pstmt.setInt(8,bean.getDid());
            pstmt.setInt(9, bean.getId());
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
            String sql="delete from labadmin where id=?";
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

    public labbean find(int id){
         labbean ub=new labbean();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from labadmin where id=?";
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
               ub.setId(rs.getInt("pid"));
               ub.setId(rs.getInt("did"));
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


    public ArrayList<labbean> findAll(){
        ArrayList<labbean> al=new ArrayList<labbean>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from labadmin";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                labbean ub=new labbean();
               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setId(rs.getInt("pid"));
               ub.setId(rs.getInt("did"));
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


     public labbean authenticate(String username,String password){
         labbean ub=new labbean();
         ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{

            String sql="select * from labadmin where username=? && password=?";
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
               ub.setId(rs.getInt("pid"));
               ub.setId(rs.getInt("did"));
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
        labdios ud=new labdios();

       labbean ub=new labbean("vikky0601","5334631234","vikky","sonagiri","3299692396","vikky0506@gmail.com",2,1);
        ud.create(ub);
          ub=new labbean(1,"vikky010615","76348365","vikas pati","sonagiri","99079","vikky0106@gmail.com",1,2);
     ud.edit(ub);
       
       

       //    ud.remove(1);  ud.remove(3);

    /*  labbean c= ud.find(3);
      System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());

*/

   /*    ArrayList<labbean> ub=ud.findAll();
        for(labbean c: ub)
            System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());
*/

   //labbean ub=ud.authenticate("vikky010615", "76348365");
    //System.out.println("Uid="+ub.getId()+"\nUsername="+ub.getUsername()+"\n password="+ub.getPassword()+"\n Name="+ub.getName()+"\n Mobile="+ub.getMobile()+"\n Address="+ub.getAddress()+"\n Email="+ub.getEmail());
    }

}

