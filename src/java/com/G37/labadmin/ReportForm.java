/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

import com.G37.doctor.doctorbean;
import com.G37.doctor.doctordaos;
import com.G37.patient.patientbean;
import com.G37.patient.patientdao;
import com.G37.utilities.ConnectionPool;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javazoom.upload.*;

/**
 *
 * @author vikas
 */
//@WebServlet(name="Form1", urlPatterns={"/Form1"})
public class ReportForm extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

                  RequestDispatcher dispatcher = null;
        HttpSession httpSession = request.getSession();

        ConnectionPool conn = ConnectionPool.getInstance();
        String str = conn.getPath();
      out.println("str="+str);
        //System.out.println("str=" + str);


        record p = new record();
        recorddaos pd = new recorddaos();

          if (MultipartFormDataRequest.isMultipartFormData(request)) {

                MultipartFormDataRequest mrequest;
                try {
          // System.out.println("hjhj");
      //     out.println("str");
                    UploadBean upBean = new UploadBean();
                    upBean.setFolderstore(str);
                    upBean.setParser(MultipartFormDataRequest.CFUPARSER);
                    //  upBean.setParsertmpdir(str);
                    mrequest = new MultipartFormDataRequest(request);
    //                System.out.println("jjj");
  //                 out.println("jjj");
                    String opn = request.getParameter("opn");
                   // System.out.println("opn" + opn);
//out.println("opn="+opn);

                     if (opn != null) {
                        String todo = null;
                        if (mrequest != null) {
                            todo = mrequest.getParameter("todo");
                        }
                        if ((todo != null) && (todo.equalsIgnoreCase("upload"))) {
                            Hashtable files = mrequest.getFiles();
                            if ((files != null) && (!files.isEmpty())) {
                                UploadFile file = (UploadFile) files.get("uploadfile");
                                upBean.store(mrequest, "uploadfile");

                                String aid=mrequest.getParameter("aid");
                              
                                String mobile =mrequest.getParameter("mobile");
                                 String pid = mrequest.getParameter("pid");
                                 String did = mrequest.getParameter("did");
                                 int id3=Integer.parseInt(did);
                                  int id2=Integer.parseInt(pid);
                           String sex=new String();
                                   Enumeration e=mrequest.getParameterNames();
            while(e.hasMoreElements()){
                String pname=(String)e.nextElement();
                String pvalues[]=mrequest.getParameterValues(pname);
                 if (pname.equals("sex")) {
                    sex = pvalues[0];
                }}
                                String age = mrequest.getParameter("age");
                              //  String sex = mrequest.getParameter("sex");
                                String test = mrequest.getParameter("test");
                               // String report = mrequest.getParameter("report");
                                String date = mrequest.getParameter("date");
                                String remark = mrequest.getParameter("remark");

                      

                             //   out.println("age"+age);
                               // out.println("sex"+sex);
                                //out.println("mobile"+mobile);
                            
                                //out.println("test"+test);
                                //out.println("dAte="+date);
                               // out.println("Aid="+aid);
                                //out.println("did="+did);
                               // out.println("pid="+pid);
                                //out.println("remark="+remark);
                                doctorbean bn=new doctorbean();
                                doctordaos  ds=new doctordaos();
                                bn=ds.find(id3);

  String doctor = bn.getName();
   patientbean bn1=new patientbean();
                                patientdao  d2=new patientdao();
                                bn1=d2.find(id2);

  String name=bn1.getName();
    //out.println("name="+name);
    //out.println("doctor="+doctor);

if ( (name != null) && (age != null) && (sex != null) && (test != null) && (date != null) && (remark != null) && (mobile!=null) && (doctor!=null) &&(aid!=null)) {
                                //  out.println("in if COndition");
                                 //   p.setPid(Integer.parseInt(pid));
                                  //  p.setDid(Integer.parseInt(did));
                                   p.setDid(Integer.parseInt(did));
                                  p.setPid(Integer.parseInt(pid));
                                  p.setName(name);
                                  
                                    p.setAge(Integer.parseInt(age));
                                      p.setSex(sex);
                                   p.setTest(test);
                                    p.setDate(date);
                                    p.setRemark(remark);
                                    p.setAid(Integer.parseInt(aid));
                                   // p.setAid(Integer.parseInt(aid));
 // out.println("After aid");
                                    p.setDoctor(doctor);
                         out.println("After doctot");
                                    p.setMobile(mobile);
                                     out.println("After mobile");
                                  }

out.println("out from if");

                                if (opn.equals("Add")) {
                                    out.println("in Addddd");
                                  //  File imgfile = new File(str + "//" + file.getFileName());
                                  // FileInputStream fin = new FileInputStream(imgfile);
                                    out.println("photo="+file.getFileName());
                                    p.setReport(file.getFileName());
                                    pd.create(p);
                                  //  out.println("out");


             //  p = pd.find(10);
               // httpSession.setAttribute("pro", p);
              //request.setAttribute("path", str);
              //  dispatcher = request.getRequestDispatcher("rhome.jsp");
            response.sendRedirect("rhome?msg1=vikas");
                                }
//

                            }}
        } }
 catch (UploadException ex) {
                }
        finally {
            out.close();
        }


        }

        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
