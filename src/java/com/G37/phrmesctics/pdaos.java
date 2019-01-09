/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.phrmesctics;

import com.G37.utilities.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vikas
 */
public class pdaos {

    public void create(pbean bean)
       {
   ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection con=c.getConnection();
       try{
           String sql="insert into phar(username,password,name,address,mobile,email,did)values(?,?,?,?,?,?,?)";

           PreparedStatement pstmt=con.prepareStatement(sql);
           pstmt.setString(1,bean.getUsername());
           pstmt.setString(2,bean.getPassword());
           pstmt.setString(3,bean.getName());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());
           pstmt.setInt(7,bean.getDid());

           pstmt.executeUpdate();
            }
       catch(Exception e){
          System.out.println("i am in Create");
       }
       finally{
           c.putConnection(con);
       }
    }

   public void edit(pbean bean){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="update phar set username=?,password=?,name=?,address=?,mobile=?,email=?,did=? where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1,bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3,bean.getName());
            pstmt.setString(4,bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setInt(7, bean.getDid());
            pstmt.setInt(8, bean.getId());
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
            String sql="delete from phar where id=?";
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

    public pbean find(int id){
         pbean ub=new pbean();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from phar where id=?";
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
               ub.setDid(rs.getInt("did"));
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


    public ArrayList<pbean> findAll(){
        ArrayList<pbean> al=new ArrayList<pbean>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from phar";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                pbean ub=new pbean();
               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDid(rs.getInt("did"));
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


     public pbean authenticate(String username,String password){
         pbean ub=new pbean();
         ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{

            String sql="select * from phar where username=? && password=?";
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
               ub.setDid(rs.getInt("did"));
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
        pdaos ud=new pdaos();

      // pbean ub=new pbean("vikky","5334631234","vikky","sonagiri","3299692396","vikky0506@gmail.com",2);
      //  ud.create(ub);
        
        
    //   pbean ub=new pbean(1,"vikkxcy010615","76348365","vikas pati","sonagiri","99079","vikky0106@gmail.com");
    // ud.edit(ub);

//ud.remove(3);ud.remove(4);

     /* pbean c= ud.find(1);
      System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());
*/

      /* ArrayList<pbean> ub=ud.findAll();
        for(pbean c: ub)
            System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());
*/
   pbean ub=ud.authenticate("vikky", "5334631234");
    System.out.println("Uid="+ub.getId()+"\nUsername="+ub.getUsername()+"\n password="+ub.getPassword()+"\n Name="+ub.getName()+"\n Mobile="+ub.getMobile()+"\n Address="+ub.getAddress()+"\n Email="+ub.getEmail());
   
    }

                        }
