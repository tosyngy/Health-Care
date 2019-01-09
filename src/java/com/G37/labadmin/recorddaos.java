/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

import com.G37.utilities.ConnectionPool;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vikas
 */
public class recorddaos {

     ConnectionPool c = null;
    Connection conn = null;

    public void create(record bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into record(pid,did,name,age,sex,test,report,date,remark,aid,doctor,mobile) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            //System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getPid());
            pstmt.setInt(2, bean.getDid());
            pstmt.setString(3, bean.getName());
            pstmt.setInt(4, bean.getAge());
            pstmt.setString(5, bean.getSex());
            pstmt.setString(6, bean.getTest());
            pstmt.setString(7, bean.getReport());
            pstmt.setString(8, bean.getDate());
            pstmt.setString(9, bean.getRemark());
            pstmt.setInt(10,bean.getAid());
            pstmt.setString(11, bean.getDoctor());
            pstmt.setString(12, bean.getMobile());

            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(record bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update record set pid=?,did=?,name=?,age=?,sex=?,test=?,report=?,date=?,remark=?,aid=?,doctor=?,mobile=? where id = ?";
           PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getPid());
            pstmt.setInt(2, bean.getDid());
            pstmt.setString(3, bean.getName());
            pstmt.setInt(4, bean.getAge());
            pstmt.setString(5, bean.getSex());
            pstmt.setString(6, bean.getTest());
            pstmt.setString(7, bean.getReport());
            pstmt.setString(8, bean.getDate());
            pstmt.setString(9, bean.getRemark());
            pstmt.setInt(10,bean.getAid());
            pstmt.setString(11, bean.getDoctor());
            pstmt.setString(12, bean.getMobile());
            pstmt.setInt(12, bean.getId());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

public void remove(int id){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="delete from record where id=?";
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

    public record find(int id){
         record ub=new record();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from record where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){

               ub.setPid(rs.getInt("pid"));
               ub.setDid(rs.getInt("did"));
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getInt("age"));
               ub.setSex(rs.getString("sex"));
               ub.setTest(rs.getString("test"));
               ub.setReport(rs.getString("report"));
               ub.setDate(rs.getString("date"));
               ub.setRemark(rs.getString("remark"));
               ub.setAid(rs.getInt("aid"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setMobile(rs.getString("mobile"));
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


    public ArrayList<record> findAll(){
        ArrayList<record> al=new ArrayList<record>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from record";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                record ub=new record();
               ub.setPid(rs.getInt("pid"));
               ub.setDid(rs.getInt("did"));
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getInt("age"));
               ub.setSex(rs.getString("sex"));
               ub.setTest(rs.getString("test"));
               ub.setReport(rs.getString("report"));
               ub.setDate(rs.getString("date"));
               ub.setRemark(rs.getString("remark"));
               ub.setAid(rs.getInt("aid"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setMobile(rs.getString("mobile"));
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

public ArrayList<record> findAllRecordpwise(int pid){
        ArrayList<record> al=new ArrayList<record>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from record where pid="+pid;
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                record ub=new record();
               ub.setPid(rs.getInt("pid"));
               ub.setDid(rs.getInt("did"));
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getInt("age"));
               ub.setSex(rs.getString("sex"));
               ub.setTest(rs.getString("test"));
               ub.setReport(rs.getString("report"));
               ub.setDate(rs.getString("date"));
               ub.setRemark(rs.getString("remark"));
               ub.setAid(rs.getInt("aid"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setMobile(rs.getString("mobile"));
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


public ArrayList<record> findAllRecordDwise(int did){
        ArrayList<record> al=new ArrayList<record>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from record where did="+did;
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                record ub=new record();
               ub.setPid(rs.getInt("pid"));
               ub.setDid(rs.getInt("did"));
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getInt("age"));
               ub.setSex(rs.getString("sex"));
               ub.setTest(rs.getString("test"));
               ub.setReport(rs.getString("report"));
               ub.setDate(rs.getString("date"));
               ub.setRemark(rs.getString("remark"));
               ub.setAid(rs.getInt("aid"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setMobile(rs.getString("mobile"));
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

public ArrayList<record> findAllRecordadwise(int aid){
        ArrayList<record> al=new ArrayList<record>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from record where aid="+aid;
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                record ub=new record();
               ub.setPid(rs.getInt("pid"));
               ub.setDid(rs.getInt("did"));
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getInt("age"));
               ub.setSex(rs.getString("sex"));
               ub.setTest(rs.getString("test"));
               ub.setReport(rs.getString("report"));
               ub.setDate(rs.getString("date"));
               ub.setRemark(rs.getString("remark"));
               ub.setAid(rs.getInt("aid"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setMobile(rs.getString("mobile"));
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



    public static void main(String[] args) {
        recorddaos ud=new recorddaos();

     record ub=new record("vvv",13,"pta nhi","test","a.png","2012-12-12","raju bhai",1,"raj","9887664");
 //   ud.create(ub);
 //    ub=new record(1,2,2,"raj",13,"male","test","rportr.png","2012-12-12","kaml");
  // ud.edit(ub);

  ud.remove(25); ud.remove(26);
  
   

         

     // record c= ud.find(14);
    //  System.out.println("name="+c.getName()+"age="+c.getAge()+"record="+c.getReport()+"id="+c.getId());


//       ArrayList<record> ub=ud.findAllRecordDwise(0);
  //      for(record c: ub)
    //        System.out.println("Username="+c.getAge()+"\npassword="+c.getSex()+"\nname="+c.getRemark()+"\naddress="+c.getName()+"\n mobile="+c.getDate()+"\n Email="+c.getDoctor()+"\nuid="+c.getId());


   //patientbean ub=ud.authenticate("vikky", "5334631234");
    //System.out.println("Uid="+ub.getId()+"\nUsername="+ub.getUsername()+"\n password="+ub.getPassword()+"\n Name="+ub.getName()+"\n Mobile="+ub.getMobile()+"\n Address="+ub.getAddress()+"\n Email="+ub.getEmail());
    }

}
