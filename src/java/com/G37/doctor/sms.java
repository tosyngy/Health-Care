/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.doctor;

import com.G37.pappointment.Pappointment;
import com.G37.pappointment.Pappointmentdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vikas
 */
public class sms extends HttpServlet {
   
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
        try {
             HttpSession session=request.getSession();

            String users=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
           Integer id=(Integer)session.getAttribute("id");

             doctorbean bean1=new doctorbean();
            doctordaos dao=new doctordaos();
             bean1=dao.authenticate(users, pass);

             sendsms sms=new sendsms();
           String msg=request.getParameter("msg");
           String mobile=request.getParameter("mobile");
            String email=request.getParameter("email");
         //out.println("msg="+msg);
       //   out.println("mobile="+mobile);
          String id3=request.getParameter("id");
          int id1=Integer.parseInt(id3);
          //  out.println("id="+id1);
          String msg1="your Appointment Request with Dr."+bean1.getName()+" Has been Accepted on "+msg+".ThankYou For Using Healthcare Web Portal.";
         sms.sendSms(mobile, msg1);
         MainMailAndSms mail=new   MainMailAndSms();
         mail.sendMail(email,"Appointment Comformation",msg1);
            Pappointment b=new Pappointment();
            Pappointmentdao d=new Pappointmentdao();
          d.remove(id1);
       response.sendRedirect("Dappointment?msg=vikas");

        } finally { 
            out.close();
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
