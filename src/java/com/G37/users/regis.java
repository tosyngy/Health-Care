/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.users;

import com.G37.doctor.doctorbean;
import com.G37.doctor.doctordaos;
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
public class regis extends HttpServlet {
   
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
        String uname=request.getParameter("username");
        String pass=request.getParameter("password");
        String name=request.getParameter("Name");
        String address=request.getParameter("address");
        String mobile= request.getParameter("Mobile");
       String email=request.getParameter("Email");
       String specilization=request.getParameter("specilization");
       out.println(uname);
 

          doctorbean bean= new doctorbean();
           doctordaos dao=new doctordaos();
           if(uname!=null && pass!=null && name!=null && address!=null && email!=null && mobile!=null && specilization!=null)
           {
               bean.setUsername(uname);
               bean.setPassword(pass);
               bean.setName(name);
               bean.setAddress(address);
               bean.setMobile(mobile);
               bean.setEmail(email);
               bean.setSpecilization(specilization);
}
        try {

          String opn=request.getParameter("opn");

          if(opn.equals("Add"))
          {
               
             dao.create(bean);
          }
          response.sendRedirect("login.jsp");

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet regis</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet regis at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
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
