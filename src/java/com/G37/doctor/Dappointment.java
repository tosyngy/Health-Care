/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.doctor;

import com.G37.pappointment.Pappointment;
import com.G37.pappointment.Pappointmentdao;
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
public class Dappointment extends HttpServlet {
   
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

       Pappointment p=new Pappointment();
       Pappointmentdao d=new Pappointmentdao();
        
      
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dappointment</title>");
            out.println("<link href=\"Design/default.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            
           

RequestDispatcher rd=request.getRequestDispatcher("Design/header.jsp");
            rd.include(request, response);
                doctorbean bean1=new doctorbean();
            doctordaos dao=new doctordaos();
             bean1=dao.authenticate(users, pass);


            out.println("<div id=\"menu\"><ul><li><a>Welcome\t Dr. "+bean1.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"dlogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");
             RequestDispatcher rds=request.getRequestDispatcher("Design/page.jsp");
            rds.include(request, response);
               String m1=request.getParameter("msg");
            if(m1!=null)
               {
                out.println("<center>  <i> <font size=\"5\" color=\"blue\"><b>!Appointment Accepted SuccessFully!</b></font></i></center>");
            }
                  String m2=request.getParameter("msg2");
            if(m2!=null)
               {
                out.println("<center>  <i> <font size=\"5\" color=\"blue\"><b>!Appointment Rejected SuccessFully!</b></font></i></center>");
            }

                       out.println("<center><font  color=orange size=12><b><i>Appointment List</i></b></font></center>");
                     
               out.println("<table align=\"center\" border=\"5\" width=800>");

                    out.println("<tr bgcolor=\"brown\"><th>Name</th><th>Contact Number</th><th>Address</th><th>Date</th><th>Accept</th><th>Reject</th></tr>");

ArrayList<Pappointment> al=d.findAllPatient(id);
       for(Pappointment c: al)
        {


                       out.println("<tr><td align=left bgcolor=\"green\">&nbsp;&nbsp;&nbsp;"+c.getName()+"</td>"

                            + "<td align=center bgcolor=\"blue\">"+c.getMobile()+"</td>"
                            + "<td align=center bgcolor=\"green\">"+c.getAddress()+"</td>"
                            + "<td align=center bgcolor=\"green\">"+c.getDate()+"</td>"
                            + "<td bgcolor=\"green\"><a href=\"Accept1?id="+c.getId()+"\">Accept</a></td>"
                            + "<td bgcolor=\"purple\"><a href=\"Reject?id="+c.getId()+"\">Reject</a></td></tr>");


                }
                     out.println("</table>");




            out.println("</body>");
             RequestDispatcher ra=request.getRequestDispatcher("/Design/footer.jsp");
          ra.include(request, response);
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
