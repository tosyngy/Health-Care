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

/**
 *
 * @author vikas
 */
public class Reject extends HttpServlet {
   
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
            String id=request.getParameter("id");
            int id1=Integer.parseInt(id);
            Pappointment b=new Pappointment();
            Pappointmentdao d=new Pappointmentdao();

           b=d.find(id1);
             out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Accept1</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet Accept1 at " +b.getEmail()+b.getMobile()+"</h1>");
         //   out.println("<form action=\"sms\">"
             //       + "<table><tr><th>Number</th><td><input type=\"text\" name=\"mobile\" value="+b.getMobile()+"></td></tr>"
               //     + "<tr><th>message</th><td><input type=\"textarea\" name=\"msg\"/>");
            String num=b.getMobile();
            String msg="Sorry There is no Appointment At present";
 MainMailAndSms mail=new   MainMailAndSms();
 String email=b.getEmail();
//out.println("mail="+email);
         mail.sendMail(email,"Appointment Comformation",msg);
            sendsms sms=new sendsms();
            sms.sendSms(num, msg);

         d.remove(id1);
          response.sendRedirect("Dappointment?msg2=vikas");


            // out.println("<tr><td><input type=\"submit\" value=\"Send\"/></td></tr></table>");
            out.println("</body>");
            out.println("</html>");

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
