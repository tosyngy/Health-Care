/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.users;

import com.G37.doctor.doctorbean;
import com.G37.doctor.doctordaos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vikas
 */
public class search extends HttpServlet {
   
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
      String input=request.getParameter("searchinput");
        try { 
              out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet search</title>");

            out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");

            out.println("</head>");
            out.println("<body>");
                RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
            rd.include(request, response);
          
          RequestDispatcher rpzs=request.getRequestDispatcher("/Design/menu.jsp");
          rpzs.include(request, response);
            RequestDispatcher rps=request.getRequestDispatcher("Design/page.jsp");
          rps.include(request, response);

   out.println("<center><font  color=orange size=12><b><i>Search Result</i></b></font></center>");
      //out.println(input);
   //   doctorbean bn=new doctorbean();
      doctordaos d=new doctordaos();
      String m=null;
      ArrayList<doctorbean> al = d.findAll();
      for(doctorbean bn:al){
if(input.equals(bn.getName()))
{
    out.println("<table align=\"center\"><tr><td>");
    out.println("<b>Name:Dr.<b><i>"+bn.getName()+"</i>");
    out.println("</td></tr><tr><td><b>Specialization:</b><i>"+bn.getSpecilization()+"</i>");
      out.println("</td></tr><tr><td><b>Address:</b><i>"+bn.getAddress()+"</i>");
    out.println("</td></tr><tr><td><b>Contact:</b><i>"+bn.getMobile()+"</i>");
    out.println("</td></tr><tr><td><b>Mail id:</b><i>"+bn.getEmail()+"</i></td></tr><br><br></table>");
 m="vikas";
}
 else if(input.equals(bn.getSpecilization()))
{
    out.println("<table align=\"center\"><tr><td>");
    out.println("<b>Name:Dr.<b><i>"+bn.getName()+"</i>");
    out.println("</td></tr><tr><td><b>Specialization:</b><i>"+bn.getSpecilization()+"</i>");
      out.println("</td></tr><tr><td><b>Address:</b><i>"+bn.getAddress()+"</i>");
    out.println("</td></tr><tr><td><b>Contact:</b><i>"+bn.getMobile()+"</i>");
    out.println("</td></tr><tr><td><b>Mail id:</b><i>"+bn.getEmail()+"</i></td></tr><br><br></table>");
 m="vikas";
 }
 else if(input.equals(bn.getAddress()))
{
     out.println("<table align=\"center\"><tr><td>");
    out.println("<b>Name:Dr.<b><i>"+bn.getName()+"</i>");
    out.println("</td></tr><tr><td><b>Specialization:</b><i>"+bn.getSpecilization()+"</i>");
      out.println("</td></tr><tr><td><b>Address:</b><i>"+bn.getAddress()+"</i>");
    out.println("</td></tr><tr><td><b>Contact:</b><i>"+bn.getMobile()+"</i>");
    out.println("</td></tr><tr><td><b>Mail id:</b><i>"+bn.getEmail()+"</i></td></tr><br><br></table>");
 m="vikas";
 }

 }
      if(m==null)
      {
      out.println("<center><font  color=blue size=5><b><i>Search Not Found</i></b></font></center>");
      }
       
           
            out.println("</body>");
            RequestDispatcher r=request.getRequestDispatcher("/Design/footer.jsp");
         r.include(request, response);
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
