/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.patient;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author vikas
 */
public class dList extends HttpServlet {
   
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
            if( (users==null) && (pass==null)){
                response.sendRedirect("plogin.jsp");
            }


          
            doctordaos ds=new doctordaos();




            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dList</title>");
             out.println("<link href=\"Design/default.css\" rel=\"stylesheet\" type=\"text/css\" />");
         //<!-- JavaScript -->
            out.println("</head>");
            out.println("<body>");
            RequestDispatcher rdse=request.getRequestDispatcher("/Design/header.jsp");
            rdse.include(request, response);
             patientbean bean=new patientbean();
            patientdao dao=new patientdao();
             bean=dao.authenticate(users, pass);

          out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bean.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"plogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");
         
             RequestDispatcher rds=request.getRequestDispatcher("Design/page.jsp");
            rds.include(request, response);

 out.println("<center><font  color=orange size=12><b><i>Doctor  List</i></b></font></center>");


             out.println("<table align=\"center\" border=\"5\" width=800>");
                    out.println("<tr bgcolor=\"brown\"><th>Name</th><th>Specialization</th><th>Contact number</th><th>Address</th></tr>");

                   ArrayList<doctorbean> ud=ds.findAll();
        for(doctorbean c: ud)
        {


                       out.println("<tr><td align=center bgcolor=\"green\">Dr. "+c.getName()+"</td>"
                            + "<td align=center bgcolor=\"purple\">"+c.getSpecilization()+"</td>"
                            + "<td align=center bgcolor=\"blue\">"+c.getMobile()+"</td>"
                            + "<td align=center bgcolor=\"green\">"+c.getAddress()+"</td>");

                }
                     out.println("</table>");




            
           
           

            out.println("</body>");
              RequestDispatcher rps=request.getRequestDispatcher("/Design/footer.jsp");
          rps.include(request, response);
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
